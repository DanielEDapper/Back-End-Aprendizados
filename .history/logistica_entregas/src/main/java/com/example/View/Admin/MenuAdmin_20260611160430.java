package com.example.View.Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.DTO.EntregaResponse;
import com.example.Model.Cliente;
import com.example.Model.Entrega;
import com.example.Model.Motorista;
import com.example.Model.Pedido;
import com.example.Service.ClienteService;
import com.example.Service.EntregaService;
import com.example.Service.MotoristaService;
import com.example.Service.PedidoService;
import com.example.Util.Ferramentas;

public class MenuAdmin 
{
    static ClienteService clienteService = new ClienteService();
    static MotoristaService motoristaService = new MotoristaService();
    static PedidoService pedidoService = new PedidoService();
    static EntregaService entregaService = new EntregaService();

    public static void menuAdminInicio()
    {
        boolean continuar = true;

        while(continuar)
        {
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Motorista");
            System.out.println("3 - Atribuir Pedido a Motorista (Gerar Entrega)");
            System.out.println("4 - Excluir Cliente");
            System.out.println("5 - Excluir Motorista");
            System.out.println("0 - Sair");
            int opcao = Ferramentas.lInteiro();
            
            switch(opcao)
            {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarMotorista();
                case 3 -> gerarEntrega();
                case 4 -> excluirCliente();
                case 5 -> excluirMotorista();
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

        List<Pedido> pedidos = new ArrayList<>();
        List<Motorista> motoristas = new ArrayList<>();

        try
        {
            pedidos = pedidoService.buscarPedidos();

            for(Pedido pedido : pedidos)
            {
                System.out.println("==========================");
                System.out.println("==  ID: "+pedido.getIdPedido());
                System.out.println("==  ID CLIENTE: "+pedido.getIdCliente());
                System.out.println("==  DATA PEDIDO: "+pedido.getDataPedido());
                System.out.println("==  VOLUME M3: "+pedido.getVolumeM3());
                System.out.println("==  PESO KG: "+pedido.getPesoKg());
                System.out.println("==  STATUS PEDIDO: "+pedido.getStatusPedido());
                System.out.println("==========================");
            }

            System.out.println("Digite o id do pedido: ");
            int idPedido = Ferramentas.lInteiro();

            motoristas = motoristaService.listarMotoristas();

            for(Motorista motorista : motoristas)
            {
                System.out.println("ID: "+motorista.getIdMotorista());
                System.out.println("NOME: "+motorista.getNome());
                System.out.println("CNH: "+motorista.getCnh());
                System.out.println("VEICULO: "+motorista.getVeiculo());
                System.out.println("CIDADE BASE: "+motorista.getCidadeBase());
            }

            System.out.println("Digite o id do motorista: ");
            int idMotorista = Ferramentas.lInteiro();

            Entrega entrega = new Entrega(idPedido, idMotorista);
            entregaService.cadastrarEntrega(entrega);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }   
    }

    public static void excluirCliente()
    {
        System.out.println("=========================");
        System.out.println("==   EXCLUIR CLIENTE   ==");
        System.out.println("=========================");


        try{
            List<Cliente> clientes = new ArrayList<>();
            clientes = clienteService.buscarClientes();

            for(Cliente cliente : clientes)
            {
                System.out.println("==========================");
                System.out.println("==  ID: "+cliente.getIdCliente());
                System.out.println("==  NOME: "+cliente.getNome());
                System.out.println("==  CPF/CNPJ: "+cliente.getCpfCnpj());
                System.out.println("==  ENDEREÇO: "+cliente.getEndereco());
                System.out.println("==  CIDADE: "+cliente.getCidade());
                System.out.println("==  ESTADO: "+cliente.getEstado());
                System.out.println("==========================");
            }

            System.out.println("Digite o ID do cliente: ");
            int idCliente = Ferramentas.lInteiro();

            clienteService.excluirCliente(idCliente);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void excluirMotorista()
    {

    }

    public static void relatorioEntregas()
    {
        System.out.println("=========================");
        System.out.println("== RELATÓRIO ENTREGAS POR MOTORISTA E CLIENTE ==");
        System.out.println("=========================");

        try{
            List<EntregaResponse> entregas = entregaService.relatorioEntregasPorClienteEMotorista();

            for(EntregaResponse entregasResponse : entregas)
            {
                System.out.println("ID ENTREGA: "+entregasResponse.getIdEntrega());
                System.out.println("NOME CLIENTE: ");
                System.out.println("NOME MOTORISTA: ");
                System.out.println("DATA SAÍDA: ");
                System.out.println("DATA ENTREGA: ");
                System.out.println("STATUS ENTREGA: ");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
