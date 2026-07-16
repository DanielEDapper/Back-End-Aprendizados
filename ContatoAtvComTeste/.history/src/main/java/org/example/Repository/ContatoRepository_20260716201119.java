package org.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.Models.Contato;
import org.example.db.ConnectionFactory;

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

    public Contato buscarContatoPorId(Long id) throws SQLException {

    String sql = "SELECT * FROM contato WHERE id = ?";

    try (Connection conn = ConnectionFactory.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setLong(1, id);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return new Contato(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("numero")
                );
            }
        }
    }

    return null;
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

    public String existePorNomeRetornaString(String nome) throws SQLException {

        String sql = """
                    SELECT nome 
                    FROM contato
                    WHERE nome = ?
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                return rs.getString("nome");
            }
        }
        return null;
    }

    public String existePorNumero(String numero) throws SQLException {

        String sql = """
                    SELECT numero 
                    FROM contato
                    WHERE numero = ?
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, numero);
            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                return rs.getString("numero");
            }
        }
        return null;
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

    public String deletarContato(Long id) throws SQLException {

    String sql = "DELETE FROM contato WHERE id = ?";

    try (Connection conn = ConnectionFactory.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setLong(1, id);

        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas > 0) {
            return "Contato deletado com sucesso";
        } else {
            return "Contato não encontrado";
        }
    }
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
