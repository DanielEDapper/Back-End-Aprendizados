package com.example.View.Cliente;

import java.sql.SQLException;
import java.util.List;

import com.example.Model.Cliente;
import com.example.Service.ClienteService;

public class MenuCliente {
    static ClienteService clienteService = new ClienteService();
    public static void menuClienteInicio()
    {
        System.out.println("1 - Criar Pedido");
    }

    public static void menuCriarPedido()
    {
        System.out.println("=========================");
        System.out.println("==     CRIAR PEDIDO    ==");
        System.out.println("=========================");

        try{
            List<Cliente> clientes = clienteService.buscarClientes();

            for()
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
}
