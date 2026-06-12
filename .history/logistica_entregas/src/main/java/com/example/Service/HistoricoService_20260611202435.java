package com.example.Service;

import com.example.Model.Entrega;
import com.example.Model.HistoricoEntrega;

public class HistoricoService 
{
    public static void cadastrarHistorico(Entrega entrega, String descricao)
    {
        HistoricoEntrega historicoEntrega = new HistoricoEntrega(entrega.getIdEntrega(), entrega.getDataEntrega(), null);
    }   

    
}
