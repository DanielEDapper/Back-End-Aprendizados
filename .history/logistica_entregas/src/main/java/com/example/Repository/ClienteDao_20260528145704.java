package com.example.Repository;

import com.example.Model.Cliente;

public class ClienteDao 
{
    public static void cadastrarCliente(Cliente cliente)
    {
        String sql = """
                INSERT INTO cliente(nome, cpf_cnpj)
                """;
    }    
}
