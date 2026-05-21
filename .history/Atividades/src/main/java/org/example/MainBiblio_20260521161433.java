package org.example;

import java.nio.file.WatchEvent;
import java.util.Scanner;

import main.java.org.example.Livro;
import main.java.org.example.LivroDao;

public class MainBiblio {
    static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) 
    {
        System.out.println("");

        System.out.println("ESCOLHA:");
        System.out.println("1 - Cadastro de Livro");

        int opcao = SC.nextInt();

        switch(opcao)
        {
            case 1: cadastrarLivro();
        }
    }

    public static void cadastrarLivro()
    {
        System.out.println("Nome: ");
        String nome = SC.nextLine();
        System.out.println("Autor: ");
        String autor = SC.nextLine();
        System.out.println("ISBN");
        String isbn = SC.nextLine();
        System.out.println("Categoria: ");
        String categoria = SC.nextLine();
        System.out.println("Quantidade: ");
        int quantidade = SC.nextInt();

        var livroDao = new LivroDao();
        var livro = new Livro(nome, autor, isbn, categoria, quantidade, disponivel);

        try{
            livroDao.cadastrarLivro(livro);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}