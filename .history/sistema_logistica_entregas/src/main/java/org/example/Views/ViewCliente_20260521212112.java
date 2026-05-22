package org.example.Views;

import java.time.LocalDate;

import org.example.Dao.ClienteDao;
import org.example.Dao.PedidoDao;
import org.example.Enum.StatusPedido;
import org.example.Model.Pedido;
import org.example.Util.Ler;

public class ViewCliente 
{
    static PedidoDao pedidoDao = new PedidoDao();
    public static void criarPedido()
    {
        System.out.println("==================================================");
        System.out.println("===                CRIAR PEDIDO                ===");
        System.out.println("==================================================");
        try{

        }
        
    }
    public static void cancelarPedido()
    {
        System.out.println("==================================================");
        System.out.println("===               CANCELAR PEDIDO              ===");
        System.out.println("==================================================");

        System.out.println("Digite o ID do pedido:");
        int idPedido = Ler.lerInt();

        boolean cancelado = pedidoDao.cancelarPedido(idPedido);

        if(cancelado)
        {
            System.out.println("\nPedido cancelado com sucesso!");
        }
        else
        {
            System.out.println("\nPedido não encontrado!");
        }
    }
    
}
