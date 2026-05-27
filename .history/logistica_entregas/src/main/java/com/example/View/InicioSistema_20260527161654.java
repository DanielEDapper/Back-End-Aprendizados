package com.example.View;

import com.example.Util.Ferramentas;
import com.example.View.Cliente.MenuCliente;
import com.example.View.Motorista.MenuMotorista;

public class InicioSistema 
{
    public static void inicio()
    {
        System.out.println("Inicio");

        System.out.println("1 - Cliente");
        System.out.println("2 - Motorista");
        System.out.println("3 - Admin");
        System.out.println("Escolha: ");
        int opcao = Ferramentas.lInteiro();

        switch(opcao)
        {
            case 1 -> MenuCliente.menuClienteInicio();
            case 2 -> MenuMotorista.menuMotoristaInicio();
        }
    }
}