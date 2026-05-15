package org.example;

import java.sql.Connection;
import java.sql.Statement;

public class DataBaseSetup {
    public static void criarTabelas() {

        try {

            Connection conn =
                    ConnectionFactory.conectar();

            Statement stmt =
                    conn.createStatement();

            // LIVROS
            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS livros (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(150),
                        autor VARCHAR(100),
                        ano_publicacao INT,
                        disponivel BOOLEAN
                    )
                    """);

            // USUARIOS
            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS usuarios (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR(100),
                        email VARCHAR(100)
                    )
                    """);

            // EMPRESTIMOS
            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS emprestimos (
                        id INT AUTO_INCREMENT PRIMARY KEY,

                        usuario_id INT,
                        livro_id INT,

                        data_emprestimo DATE,
                        data_devolucao DATE
                    )
                    """);

            System.out.println("Tabelas criadas!");

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
