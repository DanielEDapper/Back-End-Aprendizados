package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) 
    {
        System.out.println("INICIANDO O SISTEMA");
        menuPrincipal();
    }
    public static void menuPrincipal()
    {
        System.out.println("ESCOLHA:");
        System.out.println("1 - Cadastrar Livro ");
        System.out.println("2 - Listar Livro ");
        System.out.println("3 - Cadastrar Livro ");
        System.out.println("4 - Cadastrar Livro ");
        int opcao = SC.nextInt();

        switch (opcao) {
            case 1 -> cadastrarLivro();
            case 2 -> listarLivros();
        }
    }
    public static void cadastrarLivro()
    {
        System.out.println("Digite o nome do livro: ");
        String nome = SC.nextLine();
        System.out.println("Digite o autor do livro: ");
        String autor = SC.nextLine();
        System.out.println("Digite o ISBN do livro: ");
        String isbn = SC.nextLine();
        System.out.println("Digite a categoria do livro: ");
        String categoria = SC.nextLine();
        System.out.println("Digite a quantidade do livro: ");
        int quantidade = SC.nextInt();

        var livroDao = new LivroDao();
        var livro = new Livro(nome, autor, isbn, categoria, quantidade, true);
        try{
            livroDao.cadastrarLivro(livro);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void listarLivros()
    {
        var livroDao = new LivroDao();
        List<Livro> livros = new ArrayList<>();

        try{
            livros = livroDao.listarLivros();

            for(Livro livro : livros)
            {
                System.out.println("Id: "+livro.getId());
                System.out.println("Titulo: "+livro.());
                System.out.println("Autor: ");
                System.out.println("ISBN: " );
                System.out.println("Categoria: ");
                System.out.println("Quantidade: ");
                System.out.println("Disponivel: ");
            }
        }
    }
}