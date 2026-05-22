package org.example.Enum;

public enum StatusEntrega {
    EM_ROTA(1),
    ENTREGUE,
    ATRASADA;

    private int id;

    StatusEntrega(int id)
    {
        this.id = id;
    }
}
