package com.example.Enum;

public enum StatusEntrega 
{
    EM_ROTA(1),
    ENTREGUE(2),
    ATRASADA(3);
    
    private int id;

    StatusEntrega(int id)
    {
        this.id = id;
    }
}
