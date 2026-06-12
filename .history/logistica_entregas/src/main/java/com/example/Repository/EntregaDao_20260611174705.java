package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.DTO.EntregaResponse;
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
            stmt.setObject(4, entrega.getDataEntrega());
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
                UPDATE entrega SET pedido_id = ?, motorista_id = ?, data_saida = ?, data_entrega = ?, status = ? WHERE id = ?
                """;

                try(Connection conn = ConnectionFactory.conectar();
                    PreparedStatement stmt = conn.prepareStatement(sql))
                {
                    stmt.setInt(1, entrega.getIdPedido());
                    stmt.setInt(2, entrega.getIdMotorista());
                    stmt.setObject(3, entrega.getDataSaida());
                    stmt.setObject(4, entrega.getDataEntrega());
                    stmt.setString(5, entrega.getStatusEntrega().name());
                    stmt.setInt(6, entrega.getIdEntrega());

                    stmt.executeUpdate();

                }
    }

    public static Entrega buscarEntrega(int idEntrega) throws SQLException
    {
        String sql = """
                SELECT id, pedido_id, motorista_id, data_saida, data_entrega, status FROM entrega WHERE id = ?
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, idEntrega);
            ResultSet rs = stmt.executeQuery();

            if(!rs.next())
            {
                return null;
            }
            return new Entrega(rs.getInt("id"), rs.getInt("pedido_id"), rs.getInt("motorista_id"), rs.getObject("data_saida", LocalDateTime.class), rs.getObject("data_entrega", LocalDateTime.class), StatusEntrega.valueOf(rs.getString("status")));
        }
    }

    public static List<EntregaResponse> relatorioEntregasPorClienteEMotorista() throws SQLException
    {
        List<EntregaResponse> entregas = new ArrayList<>();

        String sql = """
                SELECT 
                    e.id AS idEntrega,
                    c.nome AS nomeCliente,
                    m.nome AS nomeMotorista,
                    e.data_saida AS dataSaida,
                    e.data_entrega AS dataEntrega,
                    e.status AS statusEntrega
                FROM entrega e
                LEFT JOIN motorista m ON e.motorista_id = m.id
                LEFT JOIN pedido p ON e.pedido_id = p.id
                LEFT JOIN cliente c ON p.cliente_id = c.id;
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();

                while(rs.next())
                {
                    int id = rs.getInt("idEntrega");
                    String nomeCliente = rs.getString("nomeCliente");
                    String nomeMotorista = rs.getString("nomeMotorista");

                    LocalDateTime data_saida = rs.getObject("data_saida", LocalDateTime.class);
                    LocalDateTime data_entrega = rs.getObject("data_entrega", LocalDateTime.class);
                    StatusEntrega status = StatusEntrega.valueOf(rs.getString("status"));

                    EntregaResponse entregaResponse = new EntregaResponse(id, nomeCliente, nomeMotorista, data_saida, data_entrega, status);
                    entregas.add(entregaResponse);
                }
            }
        return entregas;
    }

    public HashMap<String, Integer> relatorioEntregaPorMotorista() throws SQLException
    {
        HashMap<String, Integer> entregas = new HashMap<>();

        String sql = """
                SELECT
                    m.nome AS nomeMotorista,
                    COUNT(e.id) AS totalEntrega
                FROM motorista m
                LEFT JOIN entrega e ON m.id = e.motorista_id
                GROUP BY m.id, e.nome;
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();

                while(rs.next())
                {
                    String nomeMotorista = rs.getString("nomeMotorista");
                    int totalEntrega = rs.getInt("totalEntrega");

                    entregas.put(nomeMotorista, totalEntrega);
                }
            }

        return entregas;
    }

    public HashMap<String, Integer> relatorioEntregaAtrasadaPorCidade() throws SQLException
    {
        HashMap<String, Integer> entregas = new HashMap<>();

        String sql = """
                SELECT 
                    c.cidade AS cidade,
                    COUNT(e.id) AS totalEntrega
                FROM entrega e
                JOIN pedido p ON e.pedido_id = p.id
                JOIN cliente c ON p.cliente_id = c.id
                WHERE e.status = 'ATRASADA';
                GROUP BY c.cidade
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
            {
                ResultSet rs = stmt.executeQuery();

                while(rs.next())
                {
                    String cidade = rs.get
                }
            }
    }
}
