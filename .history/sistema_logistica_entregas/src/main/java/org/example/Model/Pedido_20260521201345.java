package org.example.Model;

import java.time.LocalDate;

public class Pedido
{
    private int id;
    private int clienteId;
    private LocalDate dataPedido;
    private double volumeM3;
    private double pesoKg;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getClienteId() {
        return clienteId;
    }
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    public LocalDate getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }
    public double getVolumeM3() {
        return volumeM3;
    }
    public void setVolumeM3(double volumeM3) {
        this.volumeM3 = volumeM3;
    }
    public double getPesoKg() {
        return pesoKg;
    }
    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    
    
}
