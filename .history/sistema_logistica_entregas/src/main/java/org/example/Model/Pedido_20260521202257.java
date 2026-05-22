package org.example.Model;

import java.time.LocalDate;

import org.example.Enum.StatusPedido;

public class Pedido
{
    private int id;
    private int clienteId;
    private LocalDate dataPedido;
    private double volumeM3;
    private double pesoKg;
    private StatusPedido statusPedido;

    public Pedido(int clienteId, LocalDate dataPedido, double volumeM3, double pesoKg, StatusPedido statusPedido) {
        this.clienteId = clienteId;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKg = pesoKg;
        this.statusPedido = statusPedido;
    }
    public Pedido(int id, int clienteId, LocalDate dataPedido, double volumeM3, double pesoKg, StatusPedido statusPedido) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKg = pesoKg;
        this.statusPedido = statusPedido;
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
    public StatusPedido getStatusPedido() {
        return statusPedido;
    }
    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    
}
