package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.Enum.StatusEntrega;
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
            stmt.setInt(2, entrega.getIdMotorista());
            stmt.setObject(3, entrega.getDataSaida());
            stmt.setObject(4, entrega.getIdEntrega());
            stmt.setString(5, entrega.getStatusEntrega().name());

            stmt.executeUpdate();
        }
    }    

    public static List<Entrega> listarEntregas() throws SQLException
    {
        List<Entrega> entregas = new ArrayList<>();

        String sql = """
                SELECT id, pedido_id, motorista_id, data_saida, data_entrega, status FROM entrega
                """;
        
        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                int id = rs.getInt("id");
                int pedido_id = rs.getInt("pedido_id");
                int motorista_id = rs.getInt("motorista_id");
                LocalDateTime data_saida = rs.getObject("data_saida", LocalDateTime.class);
                LocalDateTime data_entrega = rs.getObject("data_entrega", LocalDateTime.class);
                StatusEntrega status = StatusEntrega.valueOf(rs.getString("status"));

                Entrega entrega = new Entrega(id, pedido_id, motorista_id, data_saida, data_entrega, status);
                entregas.add(entrega);
            }
        }
        return entregas;
    }

    public static void atualizarEntrega(Entrega entrega) throws SQLException
    {
        String sql = """
                UPDATE entrega SET id = ?
                                    ,pedido_id = ?
                                    ,motorista_id = ?
                                    ,data_saida = ?
                                    ,d

                """;
    }
}
