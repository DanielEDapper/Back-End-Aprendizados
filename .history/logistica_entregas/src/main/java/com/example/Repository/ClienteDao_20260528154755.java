package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Model.Cliente;
import com.example.Util.ConnectionFactory;

public class ClienteDao 
{
    public static void cadastrarCliente(Cliente cliente) throws SQLException
    {
        String sql = """
                INSERT INTO cliente(nome, cpf_cnpj, endereco, cidade, estado) VALUES (?, ?, ?, ?, ?)
                """;
        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpfCnpj());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, cliente.getEstado());

            stmt.executeUpdate();
        }
    }
    public static List<Cliente> listarClientes() throws SQLException
    {
        List<Cliente> clientes = new ArrayList<>();

        String sql = """
                SELECT id
                       ,nome
                       ,cpf_cnpj
                       ,cidade
                FROM cliente
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf_cnpj = rs.getString("cpf_cnpj");
                String cidade = rs.getString("cidade");

                
            }
        }
    }
}
