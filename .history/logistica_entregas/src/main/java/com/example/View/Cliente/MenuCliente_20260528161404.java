package com.example.View.Cliente;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.List;

import com.example.Model.Cliente;
import com.example.Model.Pedido;
import com.example.Service.ClienteService;
import com.example.Service.PedidoService;
import com.example.Util.Ferramentas;

public class MenuCliente 
{

    static ClienteService clienteService = new ClienteService();
    static PedidoService pedidoService = new PedidoService();

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

            for(Cliente cliente : clientes)
            {
                System.out.println("==========================");
                System.out.println("==  ID: "+cliente.getIdCliente());
                System.out.println("==  NOME: "+cliente.getNome());
                System.out.println("==  CPF/CNPJ: "+cliente.getCpfCnpj());
                System.out.println("==  ENDEREÇO: "+cliente.getEndereco());
                System.out.println("==  CIDADE: "+cliente.getCidade());
                System.out.println("==  ESTADO: "+cliente.getEstado());
                System.out.println("==========================");
            }

            System.out.println("Digite o ID do cliente: ");
            int idCliente = Ferramentas.lInteiro();
            System.out.println("Digite o volume do pedido: ");
            double volume = Ferramentas.lDouble();
            System.out.println("Digite o peso do pedido: ");
            double peso = Ferramentas.lDouble();

            Pedido pedido = new Pedido(idCliente, volume, peso);
            pedidoService.cadastrarPedido(pedido);

            System.out.println("=========================");
            System.out.println("==       ENTREGAS      ==");
            System.out.println("=========================");

            System.out.println("1 - Desejo entrega");
            System.out.println("2 - Não quero entrega");
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }

    public static void 
}
