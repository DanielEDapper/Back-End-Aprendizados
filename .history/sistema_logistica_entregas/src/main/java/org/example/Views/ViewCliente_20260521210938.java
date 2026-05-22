package org.example.Views;

import java.time.LocalDate;

import org.example.Dao.ClienteDao;
import org.example.Dao.PedidoDao;
import org.example.Enum.StatusPedido;
import org.example.Model.Pedido;
import org.example.Util.Ler;

public class ViewCliente 
{
    static ClienteDao clienteDao = new ClienteDao();
    public static void criarPedido()
    {
        System.out.println("==================================================");
        System.out.println("===                CRIAR PEDIDO                ===");
        System.out.println("==================================================");
        System.out.println("Digite o ID:");
        int idCliente = Ler.lerInt();
        System.out.println("Digite o volume: ");
        double volume = Ler.lerDouble();
        System.out.println("Digite o peso: ");
        int peso = Ler.lerInt();

        Pedido pedido = new Pedido(idCliente, LocalDate.now(), volume, peso, StatusPedido.PENDENTE);
        clienteDao.criarPedido(pedido);
    }
    public static void cancelarPedido()
    {

    }
    
}
