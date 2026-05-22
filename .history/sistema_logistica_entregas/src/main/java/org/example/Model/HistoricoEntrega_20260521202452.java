package org.example.Model;

import java.time.LocalDateTime;

public class HistoricoEntrega {
    private int id;
    private int entregaId;
    private LocalDateTime dataEvento;
    private String descricao;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getEntregaId() {
        return entregaId;
    }
    public void setEntregaId(int entregaId) {
        this.entregaId = entregaId;
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
