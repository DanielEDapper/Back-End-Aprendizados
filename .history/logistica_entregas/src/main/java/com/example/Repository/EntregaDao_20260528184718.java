package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.Model.Entrega;
import com.example.Util.ConnectionFactory;

public class EntregaDao 
{
    public static void cadastrarEntrega(Entrega entrega)
    {
        String sql = """
                INSERT INTO entrega(pedido_id, motorista_id, data_saida, data_entrega, status) VALUES (?, ?, ?, ?, ?)
                """;
        
        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            
        }
    }    
}
