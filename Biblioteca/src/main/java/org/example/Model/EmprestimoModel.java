package org.example.Model;

import java.time.LocalDate;

public class EmprestimoModel {
    private int id;
    private int usuario_id;
    private int livro_id;
    private LocalDate data_emprestimo;
    private LocalDate data_devolucao;

    public EmprestimoModel(int id, int usuario_id, int livro_id, LocalDate data_emprestimo, LocalDate data_devolucao) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.livro_id = livro_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public EmprestimoModel(int usuario_id, int livro_id, LocalDate data_emprestimo, LocalDate data_devolucao) {
        this.usuario_id = usuario_id;
        this.livro_id = livro_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    public int getLivro_id() {
        return livro_id;
    }
    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }
    public LocalDate getData_emprestimo() {
        return data_emprestimo;
    }
    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }
    public LocalDate getData_devolucao() {
        return data_devolucao;
    }
    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    
}
