package com.example.Service;

import java.sql.SQLException;
import java.util.List;

import com.example.Model.Cliente;
import com.example.Repository.ClienteDao;

public class ClienteService 
{
    static ClienteDao clienteDao = new ClienteDao();
    public static String cadastroCliente(Cliente cliente) throws SQLException
    {
        ClienteDao.cadastrarCliente(cliente);
        String mensagem = "";
        return mensagem;
    } 
    
    public static List<Cliente> buscarClientes() throws SQLException
    {
        return clienteDao.listarClientes();
    }

    public static void excluirCliente(int id)
    {
        // VALIDAÇÕES NECESSARIAS
    } 
}
