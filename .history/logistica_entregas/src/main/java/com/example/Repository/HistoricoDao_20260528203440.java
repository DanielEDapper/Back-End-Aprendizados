package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.Model.HistoricoEntrega;
import com.example.Util.ConnectionFactory;

public class HistoricoDao 
{
    public static void cadastrarHistórico(HistoricoEntrega historicoEntrega) throws SQLException
    {
        String sql = """
                INSERT INTO historico_entrega(entrega_id, data_evento, descricao) VALUES(?, ?, ?)
                """;

        try(Connection conn = ConnectionFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, historicoEntrega.getIdEntrega());
            stmt.setO
        }
    }   
}
