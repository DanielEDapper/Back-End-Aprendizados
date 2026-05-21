package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) 
    {
        System.out.println("INICIANDO O SISTEMA");
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

        }
    }
}