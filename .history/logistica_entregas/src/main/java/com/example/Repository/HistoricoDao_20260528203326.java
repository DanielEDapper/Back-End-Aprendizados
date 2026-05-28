package com.example.Repository;

import com.example.Model.HistoricoEntrega;

public class HistoricoDao 
{
    public static void cadastrarHistórico(HistoricoEntrega historicoEntrega)
    {
        String sql = """
                INSERT INTO historico_entrega(entrega_id, data_evento, descricao) VALUES(?, ?, ?)
                """;

        try(Conn)
    }   
}
