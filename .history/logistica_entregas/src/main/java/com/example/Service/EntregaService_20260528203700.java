package com.example.Service;

import java.sql.SQLException;
import java.util.List;

import com.example.Model.Entrega;
import com.example.Model.HistoricoEntrega;
import com.example.Repository.EntregaDao;
import com.example.Repository.HistoricoDao;

public class EntregaService 
{
    static EntregaDao entregaDao = new EntregaDao();
    static HistoricoDao historicoDao = new HistoricoDao();
    public static void cadastrarEntrega(Entrega entrega) throws SQLException
    {
        entregaDao.cadastrarEntrega(entrega);
    }

    public static List<Entrega> listarEntregas() throws SQLException
    {
        return entregaDao.listarEntregas();
    }

    public static void atualizarEntrega(int idEntrega, String descricao) throws SQLException
    {
        // VALIDAR SE JÁ ESTÁ ENVIADO OU NN, PERMITIR EXCLUSIVAMENTE SE 


        Entrega entrega = entregaDao.buscarEntrega(idEntrega);

        entrega.entregar();

        entregaDao.atualizarEntrega(entrega);

        HistoricoEntrega historicoEntrega = new HistoricoEntrega(entrega.getIdEntrega(), entrega.getDataEntrega(), descricao);
        historicoDao.cadastrarHistórico(historicoEntrega);
        
    }
}
