package org.example;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private String categoria;
    private int quantidade;
    private boolean disponivel;

    public Livro(String titulo,
                 String autor,
                 String isbn,
                 String categoria,
                 int quantidade,
                 boolean disponivel)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
    }

    public Livro(int id,
                 String titulo,
                 String autor,
                 String isbn,
                 String categoria,
                 int quantidade,
                 boolean disponivel)
    {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
    }

    
}
