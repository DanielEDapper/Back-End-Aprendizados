package com.example.Model;

import java.sql.Date;
import java.time.LocalDateTime;

import com.example.Enum.StatusPedido;

public class Pedido 
{
    private int idPedido;
    private int idCliente;
    private LocalDateTime dataPedido;
    private double volumeM3;
    private double pesoKg;
    private StatusPedido statusPedido;

    public Pedido(int idCliente, double volumeM3, double pesoKg, StatusPedido statusPedido) {
        this.idCliente = idCliente;
        this.dataPedido = LocalDateTime.now();
        this.volumeM3 = volumeM3;
        this.pesoKg = pesoKg;
        this.statusPedido = statusPedido;
    }

    public Pedido(int idPedido, int idCliente, double volumeM3, double pesoKg,
            StatusPedido statusPedido) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.dataPedido = LocalDateTime.now();
        this.volumeM3 = volumeM3;
        this.pesoKg = pesoKg;
        this.statusPedido = statusPedido;
    }
    
    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public Date getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(Date dataPedido) {
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
