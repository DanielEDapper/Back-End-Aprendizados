package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao
{
    public void criarContato(Contato contato) throws SQLException
    {
        String sql = "INSERT INTO contato(nome, numero) VALUES(?, ?)";
        
        try(Connection conn = ConectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getNumero());

            stmt.executeUpdate();
        }
    }
    public void atualizarContatoNumero(int id, String nome, String novoNumero) throws SQLException
    {
        String sql = "UPDATE contato SET numero = ? WHERE id = ? AND nome = ?";
        try(Connection conn = ConectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, novoNumero);
            stmt.setInt(2, id);
            stmt.setString(3, nome);
            stmt.executeUpdate();
        }
    }
    public void atualizarContatoNome(int id, String novoNome) throws SQLException
    {
        String sql = """
                UPDATE contato SET nome = ? WHERE id = ? 
                """;
        try(Connection conn = ConectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, novoNome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
    public List<Contato> buscarContatos() throws SQLException
    {
        String sql = """
                SELECT id,nome,numero FROM contato
                """;
        List<Contato> contatos = new ArrayList<>();
        try(Connection conn = ConectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        )
        {
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String numero = rs.getString("numero");

                Contato contato = new Contato(id, nome, numero);
                contatos.add(contato);
            }
        }
        return contatos;
    } 
    public Contato buscarContatoPorNome(String nome) throws SQLException
    {
        int id = 0;
        String nomeCompleto = null;
        String numero = null;

        String sql = """
                SELECT id,nome,numero FROM contato WHERE nome LIKE ?
                """;
        try(Connection conn = ConectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, nome + "%");
            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                id = rs.getInt("id");
                nomeCompleto = rs.getString("nome");
                numero = rs.getString("numero");
            }
        }

        return new Contato(id, nomeCompleto, numero);
    }
    public String deletarContato(String nome) throws SQLException
    {
        String mensagem = " ";

        String sql = """
                DELETE FROM contato WHERE nome = ?
                """;
        try(Connection conn = ConectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, nome);
            stmt.executeUpdate();
            mensagem = "Contato deletado com sucesso!";
        }
        return mensagem;
    }
}
