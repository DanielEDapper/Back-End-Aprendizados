package com.example.View;

import com.example.Util.Ferramentas;
import com.example.View.Admin.MenuAdmin;
import com.example.View.Cliente.MenuCliente;
import com.example.View.Motorista.MenuMotorista;

public class InicioSistema 
{
    public static void inicio()
    {
        boolean continuar = true;

        while(continuar)
        {
            System.out.println("1 - Cliente");
            System.out.println("2 - Motorista");
            System.out.println("3 - Admin");
            System.out.println("0 - Encerrar Sessão");
            System.out.println("Escolha: ");
            int opcao = Ferramentas.lInteiro();

            switch(opcao)
            {
                case 1 -> MenuCliente.menuClienteInicio();
                case 2 -> MenuMotorista.menuMotoristaInicio();
                case 3 -> MenuAdmin.menuAdminInicio();
                case 0 -> continuar
            }
        }
        
    }
}