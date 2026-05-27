package com.example.Model;

import java.time.LocalDateTime;

public class HistoricoEntrega 
{
    private int idHistoricoEntrega;
    private int idEntrega;
    private LocalDateTime dataEvento;
    private String descricao;

    public HistoricoEntrega(int idEntrega, LocalDateTime dataEvento, String descricao) {
        this.idEntrega = idEntrega;
        this.dataEvento = dataEvento;
        this.descricao = descricao;
    }
    public HistoricoEntrega(int idHistoricoEntrega, int idEntrega, LocalDateTime dataEvento, String descricao) {
        this.idHistoricoEntrega = idHistoricoEntrega;
        this.idEntrega = idEntrega;
        this.dataEvento = dataEvento;
        this.descricao = descricao;
    }
    public int getIdHistoricoEntrega() {
        return idHistoricoEntrega;
    }
    public void setIdHistoricoEntrega(int idHistoricoEntrega) {
        this.idHistoricoEntrega = idHistoricoEntrega;
    }
    public int getIdEntrega() {
        return idEntrega;
    }
    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }
    public LocalDateTime getDataEvento() {
        return dataEvento;
    }
    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}