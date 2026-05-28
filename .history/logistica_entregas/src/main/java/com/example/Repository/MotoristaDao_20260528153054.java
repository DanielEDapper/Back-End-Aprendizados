package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.Model.Motorista;
import com.example.Util.ConnectionFactory;

public class MotoristaDao 
{
    public static void cadastrarMotorista(Motorista motorista) throws SQLException
    {
        String sql = """
                INSERT INTO motorista(nome, cnh, veiculo, cidade_base) VALUES(?, ?, ?, ?)
                """;
        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, motorista.getNome());
            stmt.setString(2, motorista.getCnh());
            stmt.setString(3, motorista.getVeiculo());
            stmt.setString(4, motorista.getCidadeBase());
        }
    }    
}
