package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Model.Pedido;
import com.example.Util.ConnectionFactory;

public class PedidoDao 
{
    public static void cadastrarPedido(Pedido pedido) throws SQLException
    {
        String sql = """
                INSERT INTO pedido (cliente_id, 
                                    data_pedido, 
                                    volume_m3, 
                                    peso_kg, 
                                    status) VALUES (?, ?, ?, ?, ?)
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setObject(2, pedido.getDataPedido());
            stmt.setDouble(3, pedido.getVolumeM3());
            stmt.setDouble(4, pedido.getPesoKg());
            stmt.setString(5, pedido.getStatusPedido().name());

            stmt.executeUpdate();
        }
    }   
    
    public static List<Pedido> listarPedidos() throws SQLException
    {
        List<Pedido> pedidos = new ArrayList<>();
        
        String sql = """
                SELECT id, cliente_id, data_pedido, volume_m3, peso_kg, status FROM pedido
                """;
        
        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                int id = rs.getInt("id");
                int cliente_id = rs.getInt("")
            }
        }
        return pedidos;
    }
}
