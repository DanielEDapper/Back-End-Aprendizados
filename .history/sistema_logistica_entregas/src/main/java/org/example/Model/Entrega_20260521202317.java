package org.example.Model;

import java.time.LocalDateTime;

import org.example.Enum.StatusEntrega;

public class Entrega 
{
    private int id;
    private int pedidoId;
    private int motoristaId;
    private LocalDateTime dataSaida;
    private LocalDateTime dataEntrega;
    private StatusEntrega statusEntrega;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPedidoId() {
        return pedidoId;
    }
    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }
    public int getMotoristaId() {
        return motoristaId;
    }
    public void setMotoristaId(int motoristaId) {
        this.motoristaId = motoristaId;
    }
    public LocalDateTime getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }
    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    public StatusEntrega getStatusEntrega() {
        return statusEntrega;
    }
    public void setStatusEntrega(StatusEntrega statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    
}
