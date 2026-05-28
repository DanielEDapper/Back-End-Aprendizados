package com.example.Repository;

import java.sql.SQLException;

import com.example.Util.ConnectionFactory;

public class PedidoDao 
{
    public static void cadastrarPedido() throws SQLException
    {
        String sql = """
                INSERT INTO pedido (cliente_id, data_pedido, volume_m3, peso_kg, status) VALUES (?, ?, ?, ?, ?)
                """;

        try(Connection conn = ConnectionFactory.conectar();
            Pre)
    }    
}
