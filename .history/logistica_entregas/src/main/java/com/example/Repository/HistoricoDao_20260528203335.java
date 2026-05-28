package com.example.Repository;

import java.sql.Connection;

import com.example.Model.HistoricoEntrega;
import com.example.Util.ConnectionFactory;

public class HistoricoDao 
{
    public static void cadastrarHistórico(HistoricoEntrega historicoEntrega)
    {
        String sql = """
                INSERT INTO historico_entrega(entrega_id, data_evento, descricao) VALUES(?, ?, ?)
                """;

        try(Connection conn = ConnectionFactory.conectar();
            )
    }   
}
