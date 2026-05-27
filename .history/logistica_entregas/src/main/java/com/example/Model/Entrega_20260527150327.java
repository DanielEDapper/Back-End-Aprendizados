package com.example.Model;

import java.time.LocalDateTime;

import com.example.Enum.StatusEntrega;

public class Entrega 
{
    private int idEntrega;
    private int idPedido;
    private int idMotorista;
    private LocalDateTime dataSaida;
    private LocalDateTime dataEntrega;
    private StatusEntrega statusEntrega;


    
    public int getIdEntrega() {
        return idEntrega;
    }
    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }
    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public int getIdMotorista() {
        return idMotorista;
    }
    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
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
