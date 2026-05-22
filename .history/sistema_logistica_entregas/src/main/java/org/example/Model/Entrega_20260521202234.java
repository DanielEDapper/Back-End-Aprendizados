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
}
