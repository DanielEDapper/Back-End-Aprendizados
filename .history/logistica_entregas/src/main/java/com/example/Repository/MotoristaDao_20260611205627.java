package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            stmt.setString(1, motorista.getNome());
            stmt.setString(2, motorista.getCnh());
            stmt.setString(3, motorista.getVeiculo());
            stmt.setString(4, motorista.getCidadeBase());

            stmt.executeUpdate();
        }
    }    

    public static List<Motorista> listarMotoristas() throws SQLException
    {
        List<Motorista> motoristas = new ArrayList<>();

        String sql = """
                SELECT id, nome, cnh, veiculo, cidade_base FROM motorista
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnh = rs.getString("cnh");
                String veiculo = rs.getString("veiculo");
                String cidade_base = rs.getString("cidade_base");

                Motorista motorista = new Motorista(id, nome, cnh, veiculo, cidade_base);
                motoristas.add(motorista);
            }
        }

        return motoristas;
    }

    public static void removerMotorista(int idMotorista) throws SQLException
    {
        String sql = """
                DELETE FROM motorista WHERE id = ? 
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
            {
                stmt.setInt(1, idMotorista);
                stmt.executeUpdate();
            }
    }

    public static void buscarId()
    {
        String sql = """
                SELECT COUNT(id)
                """;
    }

}
