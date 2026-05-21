package org.example;

public class LivroDao 
{
    public static void cadastrarLivro(Livro livro)
    {
        String sql = """
                insert into livro(nome, autor, isbn, categoria, quantidade, disponivel) values(?, ?, ?, ?, ?, ?)
                """;
        try()
    }    
}
