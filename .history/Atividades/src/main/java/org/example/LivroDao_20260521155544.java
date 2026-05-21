package main.java.org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDao 
{
    public static void cadastrarLivro(Livro livro) throws SQLException
    {
        String sql = "INSERT INTO livro(titulo, autor, isbn, categoria, quantidade, disponivel) VALUES(?, ?, ?, ?, ?, ?)";

        try(Connection conn = ConnectionFactory.conectar(); 
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
        }
    }
}