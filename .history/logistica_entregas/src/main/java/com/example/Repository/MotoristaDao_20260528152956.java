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
            
        }
    }    
}
