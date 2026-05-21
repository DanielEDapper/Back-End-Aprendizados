package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main 
{
    static ContatoDao contatoDao = new ContatoDao();
    static Scanner RD = new Scanner(System.in);
    public static void main(String[] args)
    {
        boolean continuar = true;

        while(continuar)
        {
            int opcao = 0;
            System.out.println("""
                Selecione uma opção: 
                1 - Cadastrar contato
                2 - Atualizar contato
                3 - Buscar contatos
                4 - Buscar contato por nome
                5 - Deletar contato
                0 - Sair
                    """);
            opcao = RD.nextInt();
            RD.nextLine();

            switch (opcao) {
                case 1 -> cadastrarContato();
                case 2 -> atualizarContato();
                case 3 -> buscarContatos();
                case 4 -> buscarContatoPorNome();
                case 5 -> deletarContato();
                case 0 -> {
                    continuar = false;
                    sair();
                } 
            }
        }
        
    }

    public static void cadastrarContato()
    {
        System.out.println("Digite o nome do contato: ");
        String nome = RD.nextLine();

        System.out.println("Digite o número do contato: ");
        String numero = RD.nextLine();

        var contato = new Contato(nome, numero);

        try{
            contatoDao.criarContato(contato);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void atualizarContato()
    {
        buscarContatos();

        System.out.println("Digite seu ID: ");
        int id = RD.nextInt();

        System.out.println("   ");
        System.out.println("""
                Deseja atualizar: 
                1 - Nome
                2 - Número
                """);

            int op = RD.nextInt();
            RD.nextLine();

            switch (op) 
            {
                case 1 ->
                {
                    System.out.println("Digite o novo nome: ");
                    String novoNome = RD.nextLine();

                    try{
                        contatoDao.atualizarContatoNome(id, novoNome);
                    }
                    catch(SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
                case 2 ->
                {
                    System.out.println("Digite o seu nome: ");
                    String nome = RD.nextLine();
                    System.out.println("Digite o novo número: ");
                    String novoNumero = RD.nextLine();
                    try{
                        contatoDao.atualizarContatoNumero(id, nome, novoNumero);
                    }
                    catch(SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    public static void buscarContatos()
    {
        System.out.println("============================");
        System.out.println("========  CONTATOS  ========");
        System.out.println("============================");

        try{
            List<Contato> contatos = contatoDao.buscarContatos();

            for(Contato contato : contatos)
            {
                System.out.println("                    ");
                System.out.println("ID: "+contato.getId());
                System.out.println("NOME: "+contato.getNome());
                System.out.println("NÚMERO: "+contato.getNumero());
                System.out.println("                     ");
                System.out.println("============================");
            }                            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }

    public static void buscarContatoPorNome()
    {
        System.out.println("Digite o nome: ");
        String nome = RD.nextLine();

        try{
            var Contato = contatoDao.buscarContatoPorNome(nome);
            System.out.println("============================");
            System.out.println("ID: "+Contato.getId());
            System.out.println("NOME: "+Contato.getNome());
            System.out.println("NUMERO: "+Contato.getNumero());
            System.out.println("============================");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void deletarContato()
    {
        System.out.println("Digite o nome para deletar: ");
        String nome = RD.nextLine();

        try{
            String mensagem = contatoDao.deletarContato(nome);
            System.out.println(mensagem);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void sair()
    {
        System.out.println("FIm");
    }
}