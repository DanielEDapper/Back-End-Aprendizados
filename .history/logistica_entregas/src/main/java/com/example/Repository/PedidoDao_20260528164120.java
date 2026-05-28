package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.Model.Pedido;
import com.example.Util.ConnectionFactory;

public class PedidoDao 
{
    public static void cadastrarPedido(Pedido pedido) throws SQLException
    {
        String sql = """
                INSERT INTO pedido (cliente_id, data_pedido, volume_m3, peso_kg, status) VALUES (?, ?, ?, ?, ?)
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.
        }
    }    
}
