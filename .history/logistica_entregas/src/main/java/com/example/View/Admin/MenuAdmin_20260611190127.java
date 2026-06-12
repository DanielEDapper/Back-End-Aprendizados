package com.example.View.Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            System.out.println("============================================================");
            System.out.println("==                   MENU ADMINISTRADOR                   ==");
            System.out.println("============================================================");
            System.out.println("==  1 - Cadastrar Cliente");
            System.out.println("==  2 - Cadastrar Motorista");
            System.out.println("==  3 - Atribuir Pedido a Motorista (Gerar Entrega)");
            System.out.println("==  4 - Listar Entregas Com Cliente e Motorista");
            System.out.println("==  5 - Relatório: Total de Entregas por Motorista");
            System.out.println("==  6 - Relatório: Clientes com Maior Volume Entregue");
            System.out.println("==  7 - Relatório: Pedidos Pendentes por Estado");
            System.out.println("==  8 - Relatório: Entregas Atrasadas por Cidade");
            System.out.println("==  9 - Buscar Pedido por CPF/CNPJ do Cliente");
            System.out.println("==  10 - Excluir Cliente");
            System.out.println("==  11 - Excluir Motorista");
            System.out.println("==  0 - Sair");
            System.out.println("============================================================");
            System.out.print("== Digite: ");
            System.out.println("============================================================");
            int opcao = Ferramentas.lInteiro();
            
            switch(opcao)
            {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarMotorista();
                case 3 -> gerarEntrega();
                case 4 -> relatorioEntregas();
                case 5 -> relatorioEntregasPorMotorista();
                case 6 -> relatorioMaiorVolume();
                case 7 -> relatorioPedidosPendentes();
                case 8 -> relatorioEntregasAtrasadas();
                case 9 -> buscarPedidoPorCpfCnpj();
                case 10 -> excluirCliente();
                case 11 -> excluirMotorista();
                case 0 -> continuar = false;
            }
        }
    }   
    public static void cadastrarCliente()
    {
        System.out.println("============================================================");
        System.out.println("==                   CADASTRAR CLIENTE                    ==");
        System.out.println("============================================================");

        System.out.print("== Digite o Nome: ");
        String nome = Ferramentas.lString();
        System.out.print("==  Digite o CPF/CNPJ: ");
        String cpfCnpj = Ferramentas.lString();
        System.out.print("==  Digite o endereço: ");
        String endereco = Ferramentas.lString();
        System.out.print("==  Digite a cidade: ");
        String cidade = Ferramentas.lString();
        System.out.print("==  Digite o estado: ");
        String estado = Ferramentas.lString();

        Cliente cliente = new Cliente(nome, cpfCnpj, endereco, cidade, estado);

        try{
            String mensagem = clienteService.cadastroCliente(cliente);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        Ferramentas.limpaTerminal();
    }    
    
    public static void cadastrarMotorista()
    {
        System.out.println("============================================================");
        System.out.println("==                  CADASTRAR MOTORISTA                   ==");
        System.out.println("============================================================");

        System.out.println("==  Digite o nome: ");
        String nome = Ferramentas.lString();
        System.out.println("==  Digite a CNH: ");
        String cnh = Ferramentas.lString();
        System.out.println("==  Digite o veículo: ");
        String veiculo = Ferramentas.lString();
        System.out.println("==  Digite a cidade base: ");
        String cidadeBase = Ferramentas.lString();

        Motorista motorista = new Motorista(nome, cnh, veiculo, cidadeBase);

        try{
            String mensagem = motoristaService.cadastrarMotorista(motorista);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        Ferramentas.limpaTerminal();
    }

    public static void gerarEntrega()
    {
        System.out.println("============================================================");
        System.out.println("==      ATRIBUIR PEDIDO A MOTORISTA (GERAR ENTREGA)       ==");
        System.out.println("============================================================");

        List<Pedido> pedidos = new ArrayList<>();
        List<Motorista> motoristas = new ArrayList<>();

        try
        {
            pedidos = pedidoService.buscarPedidos();

            for(Pedido pedido : pedidos)
            {
                System.out.println("  ");
                System.out.println("============================================================");
                System.out.println("==  ID: "+pedido.getIdPedido());
                System.out.println("==  ID CLIENTE: "+pedido.getIdCliente());
                System.out.println("==  DATA PEDIDO: "+pedido.getDataPedido());
                System.out.println("==  VOLUME M3: "+pedido.getVolumeM3());
                System.out.println("==  PESO KG: "+pedido.getPesoKg());
                System.out.println("==  STATUS PEDIDO: "+pedido.getStatusPedido());
                System.out.println("============================================================");
                System.out.println("  ");
            }

            System.out.println("==  Digite o id do pedido: ");
            int idPedido = Ferramentas.lInteiro();

            motoristas = motoristaService.listarMotoristas();

            for(Motorista motorista : motoristas)
            {
                System.out.println("  ");
                System.out.println("============================================================");
                System.out.println("==  ID: "+motorista.getIdMotorista());
                System.out.println("==  NOME: "+motorista.getNome());
                System.out.println("==  CNH: "+motorista.getCnh());
                System.out.println("==  VEICULO: "+motorista.getVeiculo());
                System.out.println("==  CIDADE BASE: "+motorista.getCidadeBase());
                System.out.println("============================================================");
                System.out.println("  ");
            }

            System.out.println("==  Digite o id do motorista: ");
            int idMotorista = Ferramentas.lInteiro();

            Entrega entrega = new Entrega(idPedido, idMotorista);
            entregaService.cadastrarEntrega(entrega);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
        Ferramentas.limpaTerminal(); 
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
                System.out.println("  ");
                System.out.println("============================================================");
                System.out.println("==  ID: "+cliente.getIdCliente());
                System.out.println("==  NOME: "+cliente.getNome());
                System.out.println("==  CPF/CNPJ: "+cliente.getCpfCnpj());
                System.out.println("==  ENDEREÇO: "+cliente.getEndereco());
                System.out.println("==  CIDADE: "+cliente.getCidade());
                System.out.println("==  ESTADO: "+cliente.getEstado());
                System.out.println("============================================================");
                System.out.println("  ");
            }

            System.out.println("==  Digite o ID do cliente: ");
            int idCliente = Ferramentas.lInteiro();

            clienteService.excluirCliente(idCliente);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        Ferramentas.limpaTerminal();
    }

    public static void excluirMotorista()
    {

    }

    public static void relatorioEntregas()
    {
        System.out.println("=========================");
        System.out.println("== RELATÓRIO ENTREGAS POR MOTORISTA E CLIENTE ==");
        System.out.println("=========================");

        List<EntregaResponse> entregas = new ArrayList<>();

        try{
            entregas = entregaService.relatorioEntregasPorClienteEMotorista();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        for(EntregaResponse entregasResponse : entregas)
            {
                System.out.println("  ");
                System.out.println("============================================================");
                System.out.println("==  ID ENTREGA: "+entregasResponse.getIdEntrega());
                System.out.println("==  NOME CLIENTE: "+entregasResponse.getNomeCliente());
                System.out.println("==  NOME MOTORISTA: "+entregasResponse.getNomeMotorista());
                System.out.println("==  DATA SAÍDA: "+entregasResponse.getDataSaida());
                System.out.println("==  DATA ENTREGA: "+entregasResponse.getDataEntrega());
                System.out.println("==  STATUS ENTREGA: "+entregasResponse.getStatusEntrega());
                System.out.println("============================================================");
                System.out.println("  ");
            }
        Ferramentas.limpaTerminal();
    }

    public static void relatorioEntregasPorMotorista()
    {
        System.out.println("=========================");
        System.out.println("== RELATÓRIO ENTREGAS POR MOTORISTA ==");
        System.out.println("=========================");

        HashMap<String, Integer> entregas = new HashMap<>();

        try{
            entregas = entregaService.relatorioEntregaPorMotorista();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        for(Map.Entry<String, Integer> entrega : entregas.entrySet())
            {
                System.out.println("  ");
                System.out.println("============================================================");
                System.out.println("==  NOME MOTORISTA: "+entrega.getKey());
                System.out.println("==  QUANTIDADE ENTREGAS: "+entrega.getValue());
                System.out.println("============================================================");
                System.out.println("  ");
            }
        Ferramentas.limpaTerminal();
    }

    public static void relatorioMaiorVolume()
    {
        System.out.println("=========================");
        System.out.println("== RELATÓRIO CLIENTES COM MAIS VOLUME ENTREGUE ==");
        System.out.println("=========================");

        HashMap<String, Double> clientesVolume = new HashMap<>();

        try{
            clientesVolume = clienteService.relatorioMaiorVolume();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        for(Map.Entry<String, Double> clienteVolume : clientesVolume.entrySet())
        {
            System.out.println("  ");
                System.out.println("============================================================");
            System.out.println("==  NOME CLIENTE: "+clienteVolume.getKey());
            System.out.println("==  TOTAL VOLUME ENTREGUE: "+clienteVolume.getValue());
            System.out.println("============================================================");
                System.out.println("  ");
        }
        Ferramentas.limpaTerminal();
    }

    public static void relatorioPedidosPendentes()
    {
        System.out.println("=========================");
        System.out.println("== RELATÓRIO PEDIDOS PENDENTES POR ESTADO ==");
        System.out.println("=========================");

        HashMap<String, Integer> pedidosPendentes = new HashMap<>();

        try{
            pedidosPendentes = pedidoService.relatorioPedidosEstado();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        for(Map.Entry<String, Integer> pedidos : pedidosPendentes.entrySet())
        {
            System.out.println("  ");
                System.out.println("============================================================");
            System.out.println("==  ESTADO: "+pedidos.getKey());
            System.out.println("==  PEDIDOS PENDENTES: "+pedidos.getValue());
            System.out.println("============================================================");
                System.out.println("  ");
        }
        Ferramentas.limpaTerminal();
    }

    public static void relatorioEntregasAtrasadas()
    {
        System.out.println("=========================");
        System.out.println("== RELATÓRIO ENTREGAS ATRASADAS POR CIDADE ==");
        System.out.println("=========================");

        HashMap<String, Integer> entregasPendentes = new HashMap<>();

        try{
            entregasPendentes = entregaService.relatorioEntregaPorCidade();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        for(Map.Entry<String, Integer> entregas : entregasPendentes.entrySet())
        {
            System.out.println("  ");
            System.out.println("============================================================");
            System.out.println("==  CIDADE: "+entregas.getKey());
            System.out.println("==  ENTREGAS ATRASADAS: "+entregas.getValue());
            System.out.println("============================================================");
            System.out.println("  ");
        }
        Ferramentas.limpaTerminal();
    }

    public static void buscarPedidoPorCpfCnpj()
    {
        System.out.println("=========================");
        System.out.println("== BUSCAR PEDIDOS POR CPF/CNPJ ==");
        System.out.println("=========================");

        List<Pedido> pedidosPorCpf = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        try{
        pedidos = pedidoService.buscarPedidos();
        for(Pedido pedido : pedidos)
            {
                System.out.println("  ");
                System.out.println("============================================================");
                System.out.println("==  ID: "+pedido.getIdPedido());
                System.out.println("==  ID CLIENTE: "+pedido.getIdCliente());
                System.out.println("==  DATA PEDIDO: "+pedido.getDataPedido());
                System.out.println("==  VOLUME M3: "+pedido.getVolumeM3());
                System.out.println("==  PESO KG: "+pedido.getPesoKg());
                System.out.println("==  STATUS PEDIDO: "+pedido.getStatusPedido());
                System.out.println("============================================================");
                System.out.println("  ");
            }

        System.out.println("Digite o CPF/CNPJ do cliente: ");
        String cpf = Ferramentas.lString();

        pedidosPorCpf = pedidoService.buscarPorCpf(cpf);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        for(Pedido pedido : pedidosPorCpf)
        {
            System.out.println("  ");
            System.out.println("============================================================");
            System.out.println("==  ID: "+pedido.getIdPedido());
            System.out.println("==  ID CLIENTE: "+pedido.getIdCliente());
            System.out.println("==  DATA PEDIDO: "+pedido.getDataPedido());
            System.out.println("==  VOLUME M3: "+pedido.getVolumeM3());
            System.out.println("==  PESO KG: "+pedido.getPesoKg());
            System.out.println("==  STATUS PEDIDO: "+pedido.getStatusPedido());
            System.out.println("============================================================");
            System.out.println("  ");
        }
        Ferramentas.limpaTerminal();
    }
}
