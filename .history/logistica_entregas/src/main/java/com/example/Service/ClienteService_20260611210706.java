package com.example.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

import com.example.Model.Cliente;
import com.example.Repository.ClienteDao;
import com.example.Util.Ferramentas;

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

    public static void excluirCliente(int id) throws SQLException
    {
        int quantidade = 0;
        quantidade = motoristaDao.buscarId(idMotorista);

        if(quantidade == 0)
        {
            motoristaDao.removerMotorista(idMotorista);
        }
        else{
            System.out.println(Ferramentas.BORDEAUX+"==  Não é possivel remover esse motorista");
            System.out.println("O motorista em questão possui atividade em determinada Entrega"+Ferramentas.RESET);
        }
        clienteDao.excluirCliente(id);
    } 

    public static HashMap<String, Double> relatorioMaiorVolume() throws SQLException
    {
        return clienteDao.relatorioMaiorVolumeEntregue();
    }
}
