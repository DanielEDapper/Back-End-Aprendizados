package org.example.Enum;

import javax.net.ssl.SSLEngineResult.Status;

public enum StatusPedido {
    PENDENTE(1),
    ENTREGUE(2),
    CANCELADO(3);

    private int id;

    public StatusPedido()
    {
        
    }
}
