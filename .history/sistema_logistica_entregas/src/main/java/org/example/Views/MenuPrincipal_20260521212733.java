package org.example.Views;

import org.example.Util.Ler;
import org.example.Util.Ler;

public class MenuPrincipal 
{
    public static void iniciarSistema()
    {
        System.out.println("==================================================");
        System.out.println("===               MENU PRINCIPAL               ===");
        System.out.println("==================================================");
        System.out.println("===     1 - CLIENTE                            ===");
        System.out.println("===     2 - MOTORISTA                          ===");
        System.out.println("==================================================");
        System.out.println("Escolha: ");
        int opcao = Ler.lerInt();

        switch(opcao)
        {
            case 1 -> menuCliente();
            case 2 -> menuMotorista();
            case 00 -> menuAdmin();
        }
    }
    public static void menuCliente()
    {
        System.out.println("==================================================");
        System.out.println("===               MENU CLIENTE                 ===");
        System.out.println("==================================================");
        System.out.println("===     1 - CRIAR PEDIDO                       ===");
        System.out.println("===     2 - CANCELAR PEDIDO                    ===");
        System.out.println("===     0 - SAIR                               ===");
        System.out.println("==================================================");
        int opcao = Ler.lerInt();

        switch(opcao)
        {
            case 1 -> ViewCliente.criarPedido();
            case 2 -> ViewCliente.cancelarPedido();
            case 3 -> sair();
        }
    }   
    public static void menuMotorista()
    {
        System.out.println("==================================================");
        System.out.println("===               MENU MOTORISTA               ===");
        System.out.println("==================================================");
        System.out.println("===     1 - REGISTRAR EVENTO DE ENTREGA        ===");
        System.out.println("===     2 - ATUALIZAR ESTATUS DE ENTREGA       ===");
        System.out.println("===     3 - BUSCAR POR CPF/CNPJ DO CLIENTE     ===");
        System.out.println("===     4 - ENCLUIR ENTREGA                    ===");
        System.out.println("===     0 - SAIR                               ===");
        System.out.println("==================================================");   
    } 
    public static void menuAdmin()
    {
        System.out.println("==================================================");
        System.out.println("===               MENU ADMIN                   ===");
        System.out.println("==================================================");
        System.out.println("===     1 - CADASTRAR CLIENTE                  ===");
        System.out.println("===     2 - CADASTRAR MOTORISTA                ===");
        System.out.println("===     3 - RELATÓRIO: ENTREGAS POR MOTORISTA  ===");
        System.out.println("===     4 - CLIENTE COM MAIOR VOLUME ENTREGUE  ===");
        System.out.println("===     5 - PEDIDOS PENDENTES POR ESTADO       ===");
        System.out.println("===     6 - ENTREGAS ATRASADAS POR CIDADE      ===");
        System.out.println("===     7 - LISTAR ENTREGAS C/ CLIENTE E MOTO. ===");
        System.out.println("===     8 - EXCLUIR MOTORISTA                  ===");
        System.out.println("===     9 - EXCLUIR CLIENTE                    ===");
        System.out.println("===     0 - SAIR                               ===");
        System.out.println("==================================================");

        int opcao = Ler.lerInt();

        switch(opcao)
        {
            case 1 -> 
            case 2 -> 
            case 3 -> 
            case 1 -> 
            case 2 -> 
            case 3 ->
        }
    }

    public static void sair()
    {
        System.out.println("==================================================");
        System.out.println("===                    SAIR                    ===");
        System.out.println("==================================================");
    }
}
