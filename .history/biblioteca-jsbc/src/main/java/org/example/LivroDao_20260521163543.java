package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDao 
{
    public static void cadastrarLivro(Livro livro) throws SQLException
    {
        String sql = """
                insert into livro(nome, autor, isbn, categoria, quantidade, disponivel) values(?, ?, ?, ?, ?, ?)
                """;
        try(Connection conn = ConnectionFactory.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql))
        {
            
        }
    }    
}
