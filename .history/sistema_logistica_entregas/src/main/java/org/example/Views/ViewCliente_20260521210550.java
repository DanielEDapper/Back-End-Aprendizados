package org.example.Views;

import java.time.LocalDate;

import org.example.Enum.StatusPedido;
import org.example.Util.Ler;

public class ViewCliente 
{
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

        pedido.setDataPedido(LocalDate.now());
        pedido.setStatus(StatusPedido.PENDENTE);

    }
    public static void cancelarPedido()
    {

    }
    
}
