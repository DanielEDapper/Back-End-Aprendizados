package com.example.DTO;

import java.time.LocalDateTime;

import com.example.Enum.StatusEntrega;

public class EntregaResponse {
    private int idEntrega;
    private String nomeCliente;
    private String nomeMotorista;

    private LocalDateTime dataSaida;
    private LocalDateTime dataEntrega;
    private StatusEntrega statusEntrega;

    public EntregaResponse(String nomeCliente, String nomeMotorista, LocalDateTime dataSaida, LocalDateTime dataEntrega,
            StatusEntrega statusEntrega) {
        this.nomeCliente = nomeCliente;
        this.nomeMotorista = nomeMotorista;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.statusEntrega = statusEntrega;
    }
    
    public EntregaResponse(int idEntrega, String nomeCliente, String nomeMotorista, LocalDateTime dataSaida,
            LocalDateTime dataEntrega, StatusEntrega statusEntrega) {
        this.idEntrega = idEntrega;
        this.nomeCliente = nomeCliente;
        this.nomeMotorista = nomeMotorista;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.statusEntrega = statusEntrega;
    }
    public int getIdEntrega() {
        return idEntrega;
    }
    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getNomeMotorista() {
        return nomeMotorista;
    }
    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
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
