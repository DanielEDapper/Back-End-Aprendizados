package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LivroDao 
{
    public static void cadastrarLivro(Livro livro) throws SQLException
    {
        String sql = """
                insert into livro(titulo, autor, isbn, categoria, quantidade, disponivel) values(?, ?, ?, ?, ?, ?)
                """;
        try(Connection conn = ConnectionFactory.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getIsbn());
            stmt.setString(4, livro.getCategoria());
            stmt.setInt(5, livro.getQuantidade());
            stmt.setBoolean(6, livro.isDisponivel());

            stmt.executeUpdate();
        }
    } 
    
    public static List<Livro> listarLivros() throws SQLException
    {
        List<Livro> livros;

        String sql = "SELECT id, titulo, autor, isbn, categoria, quantidade, disponivel from livro";

        try(Connection conn = ConnectionFactory.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = 
        }

        return livros;
    }
}
