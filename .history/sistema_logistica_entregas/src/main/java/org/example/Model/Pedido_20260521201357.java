package org.example.Model;

import java.time.LocalDate;

public class Pedido
{
    private int id;
    private int clienteId;
    private LocalDate dataPedido;
    private double volumeM3;
    private double pesoKg;

    
    public Pedido(int clienteId, LocalDate dataPedido, double volumeM3, double pesoKg) {
        this.clienteId = clienteId;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKg = pesoKg;
    }
    public Pedido(int id, int clienteId, LocalDate dataPedido, double volumeM3, double pesoKg) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKg = pesoKg;
    }
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
