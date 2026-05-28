package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.Model.Cliente;
import com.example.Util.ConnectionFactory;

public class ClienteDao 
{
    public static void cadastrarCliente(Cliente cliente)
    {
        String sql = """
                INSERT INTO cliente(nome, cpf_cnpj, endereco, cidade, estado) VALUES (?, ?, ?, ?, ?)
                """;
        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
    }    
}
