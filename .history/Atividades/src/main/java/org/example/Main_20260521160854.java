package org.example;

import java.util.Scanner;

public class Main {
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
    }
}