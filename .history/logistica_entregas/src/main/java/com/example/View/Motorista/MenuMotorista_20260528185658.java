package com.example.View.Motorista;

import com.example.Util.Ferramentas;

public class MenuMotorista 
{
    public static void menuMotoristaInicio()
    {
        boolean continuar = true;

        while(continuar)
        {
            System.out.println("1 - Realizar Entrega");
            System.out.println("0 - Sair");
            int opcao = Ferramentas.lInteiro();
            
            switch(opcao)
            {
                case 1 -> menuRealizarEntrega();
                case 0 -> continuar = false;
            }
        }
    }    

    public static void menuRealizarEntrega()
    {
        System.out.println("=========================");
        System.out.println("==     CRIAR PEDIDO    ==");
        System.out.println("=========================");
    }
}
