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
            System.out.println("2 - Cadastrar Motorista");
            System.out.println("3 - Atribuir Pedido a Motorista (Gerar Entrega)");
            System.out.println("0 - Sair");
            int opcao = Ferramentas.lInteiro();
            
            switch(opcao)
            {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarMotorista();
                case 3 -> gerarEntrega();
                case 0 -> continuar = false;
            }
        }
    }    
}
