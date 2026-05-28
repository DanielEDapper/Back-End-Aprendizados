package com.example.Service;

import java.sql.SQLException;

import com.example.Model.Pedido;
import com.example.Repository.PedidoDao;

public class PedidoService 
{
    static PedidoDao pedidoDao = new PedidoDao();
    public static void cadastrarPedido(Pedido pedido) throws SQLException
    {
        pedidoDao.cadastrarPedido(pedido);
    }   

    public static List< buscarPedidos() throws SQLException
    {

    }
}
