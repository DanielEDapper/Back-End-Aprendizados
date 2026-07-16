package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.example.Models.Contato;
import org.example.Service.ContatoService;
import org.example.db.ConnectionFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
{
    private static String DROP_TABLE = "DROP TABLE IF EXISTS contato;";

    private static String TRUNCATE_TABLE = "TRUNCATE TABLE contato;";

    private static String CREATE_TABLE = """
            CREATE TABLE contato (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(100) NOT NULL,
                    numero VARCHAR(100) NOT NULL
            );
            """;

    private ContatoService contatoService;

    @BeforeAll
    static void setupBancoDados() {
        try (Connection conn = ConnectionFactory.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(DROP_TABLE);
            System.out.println("Tabela excluida com sucesso");

            stmt.execute(CREATE_TABLE);
            System.out.println("Tabela criada com sucesso");

        } catch (Exception e) {
            System.err.println("Erro ao configurar o banco de testes");
            e.printStackTrace();
        }
    }

    @AfterAll
    static void finalizarBancoDados() {
        try (Connection conn = ConnectionFactory.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(DROP_TABLE);
            System.out.println("Tabela excluida com sucesso");

        } catch (Exception e) {
            System.err.println("Erro ao limpar o banco de testes");
            e.printStackTrace();
        }
    }

    @BeforeEach
    void setupTeste() {
        try (Connection conn = ConnectionFactory.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(TRUNCATE_TABLE);
            System.out.println("Tabela limpa com sucesso");

        } catch (Exception e) {
            System.err.println("Erro ao limpar a tabela de testes");
            e.printStackTrace();
        }

        contatoService = new ContatoService();
    }

    @Test
    @DisplayName("Deve cadastrar um contato no banco")
    void testCadastrarContato() throws Exception {

        // ARRANGE
        Contato contato = new Contato("Daniel Dapper", "47 9 9290-4564");

        // ACT
        Contato contatoSalvo = contatoService.criarContato(contato);

        // ASSERT
        assertNotNull(contatoSalvo);
        assertTrue(contatoSalvo.getId() > 0, "Id não foi gerado pelo banco");
        assertEquals(contato.getNome(), contatoSalvo.getNome());

        // ASSERT
        try (Connection conn = ConnectionFactory.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM contato WHERE id = " + contatoSalvo.getId())) {

            assertTrue(rs.next(), "Contato não foi salvo pelo banco");
            assertEquals("Daniel Dapper", rs.getString("nome"));
            assertEquals("47 9 9290-4564", rs.getString("numero"));

            System.out.println("Fim do assert");
        }
    }

    @Test
    @DisplayName("Deve buscar um contato no banco")
    void testBuscarContato() throws SQLException {

        // ARRANGE
        contatoService.criarContato(new Contato("Daniel Dapper", "47 9 9290-4564"));
        contatoService.criarContato(new Contato("Isadora", "47 9 9101-3191"));

        // ACT
        Contato contatoBuscado =
                contatoService.buscarContatoPorNome("Isadora");

        // ASSERT
        assertNotNull(contatoBuscado);
        assertEquals("Isadora", contatoBuscado.getNome());
    }

    @Test
    @DisplayName("Deve buscar todos os contatos do Banco")
    void testBuscarTodosContatos() throws SQLException {

        // ARRANGE
        contatoService.criarContato(
                new Contato("Daniel Dapper", "47 9 9290-4564"));

        contatoService.criarContato(
                new Contato("Isadora", "47 9 9101-3191"));

        // ACT
        List<Contato> contatosBuscados =
                contatoService.buscarTodosContatos();

        // ASSERT
        assertNotNull(contatosBuscados);
        assertEquals(2, contatosBuscados.size());
    }

        @Test
    @DisplayName("Deve atualizar um contato")
    void testAtualizarContato_Sucesso() throws SQLException
    {
        //ARRANGE
        Contato contatoBuscado = contatoService.criarContato(
                new Contato("Daniel Dapper", "47 9 9290-4564"));

        long idContato = contatoBuscado.getId();

        Contato contatoAtualizado = contatoService.criarContato(
                new Contato(idContato, "Daniel Dapper", "47 9 9290-4565"));

        //ACT
        contatoService.atualizarContato(contatoAtualizado);

        //ASSERT
        try (Connection conn = ConnectionFactory.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM contato WHERE id = " + idContato))
        {
            assertTrue(rs.next());
            assertEquals("Daniel Dapper", rs.getString("nome"));
            assertEquals("47 9 9290-4565", rs.getString("numero"));
        }
    }

    @Test
    @DisplayName("Não deve atualizar o contato - não há nada para atualizar")
    void testAtualizarContato_NadaAlterado() throws SQLException
    {
        //ARRANGE
        Contato contatoBuscado = contatoService.criarContato(
                new Contato("Daniel Dapper", "47 9 9290-4564"));

        long idContato = contatoBuscado.getId();

        Contato contatoAtualizado = contatoService.criarContato(
                new Contato(idContato, "Daniel Dapper", "47 9 9290-4564"));

        // ACT & ASSERT
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    contatoService.atualizarContato(contatoAtualizado);
                },
                "Contato não validou a inexistencia de alteração"
        );

        assertEquals(
                "Não há nada para atualizar",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Deve deletar um contato do banco pelo id")
    void testDeletarContato() throws SQLException
    {
        //ARRANGE
        Contato contatoBuscado = contatoService.criarContato(
                new Contato("Daniel Dapper", "47 9 9290-4564"));

        long idContato = contatoBuscado.getId();

        //ACT
        boolean resultado = contatoService.deletarContato(idContato);

        //ASSERT
        assertTrue(resultado,
                "Método de exclusão deveria retornar True");

        //ASSERT
        Contato contatoAposExclusao =
                contatoService.buscarContatoPorNome("Daniel Dapper");

        assertNull(
                contatoAposExclusao,
                "Contato não foi excluido do banco de dados"
        );
    }
}
}
