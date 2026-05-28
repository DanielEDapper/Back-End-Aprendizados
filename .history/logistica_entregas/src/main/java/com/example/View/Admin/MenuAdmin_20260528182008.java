package com.example.View.Admin;

import java.sql.SQLException;

import com.example.Model.Cliente;
import com.example.Model.Motorista;
import com.example.Service.ClienteService;
import com.example.Service.MotoristaService;
import com.example.Util.Ferramentas;

public class MenuAdmin 
{
    static ClienteService clienteService = new ClienteService();
    static MotoristaService motoristaService = new MotoristaService();

    public static void menuAdminInicio()
    {
        boolean continuar = true;

        while(continuar)
        {
            System.out.println("1 - Cadastrar Cliente");
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
        String veiculo = Ferramentas.lString();
        System.out.println("Digite a cidade base: ");
        String cidadeBase = Ferramentas.lString();

        Motorista motorista = new Motorista(nome, cnh, veiculo, cidadeBase);

        try{
            String mensagem = motoristaService.cadastrarMotorista(motorista);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void gerarEntrega()
    {
        System.out.println("=========================");
        System.out.println("==    GERAR ENTREGA    ==");
        System.out.println("=========================");

        List<Pedido> pedidos = new A
    }
}
