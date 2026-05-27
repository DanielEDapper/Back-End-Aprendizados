package com.example.Enum;

public class StatusPedido
{
    PENDENTE(1)
    ENTREGUE(2)
    CANCELADO(3)

    private int id;

    StatusPedido(int id)
    {
        this.id = id;
    }
}
