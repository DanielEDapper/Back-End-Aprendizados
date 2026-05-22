package org.example.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.Model.Pedido;
import org.example.Util.ConnectionFactory;

public class PedidoDao 
{
    public static void criarPedido(Pedido pedido) throws SQLException
    {
        String sql = """
        INSERT INTO pedido
        (cliente_id, data_pedido, volume_m3, peso_kg, status)
        VALUES (?, ?, ?, ?, ?)
        """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, pedido.getClienteId());

            stmt.setDate(2,
                Date.valueOf(pedido.getDataPedido()));

            stmt.setDouble(3, pedido.getVolumeM3());

            stmt.setDouble(4, pedido.getPesoKg());

            stmt.setString(5,
                pedido.getStatusPedido().name());

            stmt.executeUpdate();

            System.out.println("Pedido criado com sucesso!");

        }
        catch(SQLException e)
        {
            System.out.println("Erro ao criar pedido: "
                + e.getMessage());
        }
    } 
    public static boolean cancelarPedido(int idPedido)
    {
        String sql = """
        UPDATE pedido
        SET status = 'CANCELADO'
        WHERE id = ?
        """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idPedido);

            return stmt.executeUpdate() > 0;
        }
        catch(SQLException e)
        {
            System.out.println("Erro ao cancelar pedido: "
                + e.getMessage());

            return false;
        } 
    }
}
