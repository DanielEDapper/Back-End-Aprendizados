package com.example.View.Admin;

import java.sql.SQLException;

import com.example.Model.Cliente;
import com.example.Service.ClienteService;
import com.example.Util.Ferramentas;

public class MenuAdmin 
{
    static ClienteService clienteService = new ClienteService();
    public static void menuAdminInicio()
    {
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Motorista");
    }   
    public static void cadastrarCliente()
    {
        System.out.println("=========================");
        System.out.println("==  CADASTRAR CLIENTE  ==");
        System.out.println("=========================");

        System.out.println("Digite o Nome: ");
        String nome = Ferramentas.lString();
        System.out.println("Digite o CPF/CNPJ: ");
        String cpfCnpj = Ferramentas.lString();
        System.out.println("Digite o endereço: ");
        String endereco = Ferramentas.lString();
        System.out.println("Digite a cidade: ");
        String cidade = Ferramentas.lString();
        System.out.println("Digite o estado: ");
        String estado = Ferramentas.lString();

        Cliente cliente = new Cliente(nome, cpfCnpj, endereco, cidade, estado);

        try{
            String mensagem = clienteService.cadastroCliente(cliente);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }    
    
    public static void cadastrarMotorista()
    {
        System.out.println("=========================");
        System.out.println("== CADASTRAR MOTORISTA ==");
        System.out.println("=========================");

        System.out.println("Digite o nome: ");
        String nome = Ferramentas.lString();
        System.out.println("Digite a CNH: ");
        String cnh = Ferramentas.lString();
        System.out.println("Digite o veículo: ");
        String nome = Ferramentas.lString();
        System.out.println("Digite a cidade base: ");
        String nome = Ferramentas.lString();

    }
}
