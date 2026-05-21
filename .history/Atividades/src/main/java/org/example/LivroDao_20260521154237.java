package main.java.org.example;

public class LivroDao 
{
    public static void cadastrarLivro(Livro livro) throws SQ
    {
        String sql = """
                INSERT INTO livro(titulo, autor, isbn, categoria, quantidade, disponivel) VALUES (?, ?, ?, ?, ?, ?)
                """;
    }
}
