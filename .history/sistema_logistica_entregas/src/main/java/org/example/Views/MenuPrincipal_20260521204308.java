package org.example.Views;

import org.example.Util.ViewUtil;

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
        int opcao = ViewUtil.lerInt();

        switch(opcao)
        {
            case 1 -> menuCliente();
            case 2 -> menuMotorista();
        }
    }
    public static void menuCliente()
    {
        System.out.println("==================================================");
        System.out.println("===               MENU PRINCIPAL               ===");
        System.out.println("==================================================");
        System.out.println("===     1 - CLIENTE                            ===");
        System.out.println("===     2 - MOTORISTA                          ===");
        System.out.println("==================================================");
    }   
    public static void menuMotorista()
    {

    } 
}
