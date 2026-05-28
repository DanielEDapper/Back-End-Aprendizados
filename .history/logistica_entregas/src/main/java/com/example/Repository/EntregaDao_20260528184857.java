package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.Model.Entrega;
import com.example.Util.ConnectionFactory;

public class EntregaDao 
{
    public static void cadastrarEntrega(Entrega entrega) throws SQLException
    {
        String sql = """
                INSERT INTO entrega(pedido_id, motorista_id, data_saida, data_entrega, status) VALUES (?, ?, ?, ?, ?)
                """;
        
        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, entrega.getIdPedido());
            stmt.setInt(2, 0);

        }
    }    
}
