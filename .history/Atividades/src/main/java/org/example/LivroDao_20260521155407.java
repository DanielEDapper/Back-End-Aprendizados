package main.java.org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDao 
{
    public static void cadastrarLivro(Livro livro) throws SQLException
    {
        String sql = "INSERT INTO livro(titulo, autor, isbn, categoria, quantidade, disponivel) VALUES(?, ?, ?, ?, ?, ?)";

        Strin a = """
                a
                """;

        try(Connection conn = ConnectionFactory.conectar(); 
    PreparedStatement stmt = conn.prepareStatement(sql))
    {

    }
    }
}