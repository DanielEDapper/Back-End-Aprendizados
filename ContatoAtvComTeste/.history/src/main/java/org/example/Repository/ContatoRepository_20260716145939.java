package org.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.Models.Contato;

public class ContatoRepository {
    public Contato salvar(Contato contato) throws SQLException {
        String sql = """
                    INSERT INTO contato
                    (nome, numero)
                    VALUES
                    (?,?)
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

                stmt.setString(1, contato.getNome());
                stmt.setString(2, contato.getNumero());
                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();

                if(rs.next()){
                    contato.setId(rs.getLong(1));
                    return contato;
                }
            }
        throw new RuntimeException("Erro ao salvar no banco de dados!");
    }

    public boolean existePorNome(String nome) throws SQLException {

        String sql = """
                    SELECT nome 
                    FROM contato
                    WHERE nome = ?
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            return rs.next();
        }
            
    }

    public Contato atualizarContato(Contato contato) throws SQLException
    {
        String sql = """
                UPDATE contato SET nome = ?, 
                                   numero = ?
                WHERE id = ?
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                stmt.setString(1, contato.getNome());
                stmt.setString(2, contato.getNumero());
                stmt.setLong(3, contato.getId());

                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()){
                    contato.setId(rs.getLong(1));
                    return contato;
                }
            }
        
            return contato;
    }

    public String deletarContato(Long id) throws SQLException
    {
        String mensagem = " ";
        String sql = """
                DELETE FROM contato WHERE id = ?
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setLong(1, id);
                stmt.executeUpdate();
                mensagem = "Contato deletado com sucesso";
            }
        return mensagem;
    }

    public Contato buscarContatoPorNome(String nome) throws SQLException
    {
        String novoNome = "";
        String novoNumero = "";
        Long id = null;

        String sql = """
                SELECT nome, 
                       numero,
                       id
                FROM contato
                WHERE nome LIKE ?
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, "%"+nome+"%");

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                id = rs.getLong("id");
                novoNome = rs.getString("nome");
                novoNumero = rs.getString("numero");
            }
        }

        Contato contato = new Contato(id, novoNome, novoNumero);
        return contato;
    }

    public List<Contato> buscarTodosContato() throws SQLException
    {
        List<Contato> contatos = new ArrayList<>();

        String sql = """
                SELECT nome,
                       numero,
                       id
                FROM contato
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();

                while(rs.next())
                {
                    Long id = rs.getLong("id");
                    String nome = rs.getString("nome");
                    String numero = rs.getString("numero");

                    Contato contato = new Contato(id, nome, numero);
                    contatos.add(contato);
                }
            }

        return contatos;
    }

}
