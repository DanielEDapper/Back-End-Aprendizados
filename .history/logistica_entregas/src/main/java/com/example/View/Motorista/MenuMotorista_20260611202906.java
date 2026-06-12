package com.example.View.Motorista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.Model.Entrega;
import com.example.Service.EntregaService;
import com.example.Service.HistoricoService;
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
                System.out.println("==========================");
                System.out.println("==  ID: "+entrega.getIdEntrega());
                System.out.println("==  PEDIDO ID: "+entrega.getIdPedido());
                System.out.println("==  MOTORISTA ID: "+entrega.getIdMotorista());
                System.out.println("==  DATA SAIDA: "+entrega.getDataSaida());
                System.out.println("==  DATA ENTREGA: "+entrega.getDataEntrega());
                System.out.println("==  STATUS: "+entrega.getStatusEntrega());
                System.out.println("==========================");
            }

            System.out.println("Digite o ID da entrega: ");
            int idEntrega = Ferramentas.lInteiro();

            System.out.println("Digite a descrição da entrega: ");
            String descricao = Ferramentas.lString();

            entregaService.atualizarEntrega(idEntrega, descricao);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        Ferramentas.limpaTerminal();
    }

    public static void menuAtualizarEntrega() {
    System.out.println("--- Atualizar Entrega para ENTREGUE ---");
    System.out.print("Digite o ID da Entrega: ");
    int id = Ferramentas.lInteiro();
    scanner.nextLine(); // Limpar o buffer do Scanner [2]

    System.out.print("Digite uma descrição para o histórico (ex: Entregue para o porteiro): ");
    String descricao = scanner.nextLine();

    try {
        // A View chama a Service, que por sua vez usa a Model e o DAO
        EntregaService.atualizarEntrega(id, descricao);
        System.out.println("Sucesso: Entrega atualizada e histórico registrado!");
    } catch (SQLException e) {
        System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
    } catch (Exception e) {
        System.err.println("Erro na operação: " + e.getMessage());
    }
}
}
