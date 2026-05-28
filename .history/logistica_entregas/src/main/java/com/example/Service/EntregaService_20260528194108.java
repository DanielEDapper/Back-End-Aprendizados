package com.example.Service;

import java.sql.SQLException;
import java.util.List;

import com.example.Model.Entrega;
import com.example.Repository.EntregaDao;

public class EntregaService 
{
    static EntregaDao entregaDao = new EntregaDao();
    public static void cadastrarEntrega(Entrega entrega) throws SQLException
    {
        entregaDao.cadastrarEntrega(entrega);
    }

    public static List<Entrega> listarEntregas() throws SQLException
    {
        return entregaDao.listarEntregas();
    }

    public static void atualizarEntrega(Entrega entrega) throws SQLException
    {
        Entrega entregaEntregada = entrega.entregar();
        entregaDao.atualizarEntrega(entrega);
    }
}
