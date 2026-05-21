package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LivroDao 
{
    public static void cadastrarLivro(Livro livro)
    {
        String sql = """
                insert into livro(nome, autor, isbn, categoria, quantidade, disponivel) values(?, ?, ?, ?, ?, ?)
                """;
        try(Connection conn = ConnectionFactory.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql))
    }    
}
