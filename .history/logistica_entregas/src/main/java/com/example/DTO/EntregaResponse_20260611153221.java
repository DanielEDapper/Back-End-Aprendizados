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
}
