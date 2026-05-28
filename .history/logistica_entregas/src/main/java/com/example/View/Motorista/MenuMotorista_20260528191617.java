package com.example.View.Motorista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Model.Entrega;
import com.example.Service.EntregaService;
import com.example.Util.Ferramentas;

public class MenuMotorista 
{

    static EntregaService entregaService = new EntregaService();
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
        System.out.println("==  REGISTRAR ENTREGA  ==");
        System.out.println("=========================");

        List<Entrega> entregas = new ArrayList<>();
        try{
            entregas = entregaService.listarEntregas();

            for(Entrega entrega : entregas)
            {
                System.out.println("ID: "+entrega.getIdEntrega());
                System.out.println("PEDIDO ID: ");
                System.out.println("MOTORISTA ID: ");
                System.out.println("DATA SAIDA: ");
                System.out.println("DATA ENTREGA: ");
                System.out.println();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
