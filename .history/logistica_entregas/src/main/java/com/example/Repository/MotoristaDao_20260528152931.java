package com.example.Repository;

import java.sql.Connection;

import com.example.Model.Motorista;
import com.example.Util.ConnectionFactory;

public class MotoristaDao 
{
    public static void cadastrarMotorista(Motorista motorista)
    {
        String sql = """
                INSERT INTO motorista(nome, cnh, veiculo, cidade_base) VALUES(?, ?, ?, ?)
                """;
        try(Connection conn = ConnectionFactory.conectar())
    }    
}
