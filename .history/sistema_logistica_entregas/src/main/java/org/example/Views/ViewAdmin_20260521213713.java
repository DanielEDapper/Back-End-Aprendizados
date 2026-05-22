package org.example.Views;

import org.example.Dao.ClienteDao;
import org.example.Model.Cliente;
import org.example.Util.Ler;

public class ViewAdmin 
{
    static ClienteDao clienteDao = new ClienteDao();
    public static void criarCliente()
    {
        System.out.println("==================================================");
        System.out.println("===                CRIAR CLIENTE               ===");
        System.out.println("==================================================");
        
        System.out.println("Digite o nome: ");
        String nome = Ler.lerString();
        System.out.println("Digite o CPF/CNPJ: ");
        String cpf_cnpj = Ler.lerString();
        System.out.println("Digite o endereço: ");
        String endereco = Ler.lerString();
        System.out.println("Digite a cidade: ");
        String cidade = Ler.lerString();
        System.out.println("Digite o estado: ");
        String estado = Ler.lerString();

        Cliente cliente = new Cliente(nome, cpf_cnpj, endereco, cidade, estado);
        clienteDao.criarCliente(cliente);
    }
    public static void criarMotorista()
    {

    }
    public static void relatorioEntregasPorMotorista()
    {

    }
    public static void relatorioClienteMaiorVolume()
    {

    }
    public static void pedidoPendentePorEstado()
    {

    }
    public static void entregasAtrasadasCidade()
    {

    }
    public static void listarEntregasClienteMotorista()
    {

    }
    public static void excluirMotorista()
    {

    }
    public static void excluirCliente()
    {

    }
}
