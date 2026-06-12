package com.example.Service;

import java.sql.SQLException;
import java.util.List;

import com.example.Model.Motorista;
import com.example.Repository.MotoristaDao;

public class MotoristaService 
{
    static MotoristaDao motoristaDao = new MotoristaDao();
    public static String cadastrarMotorista(Motorista motorista) throws SQLException
    {
        motoristaDao.cadastrarMotorista(motorista);
        String mensagem = "";
        return mensagem;
    }    

    public static List<Motorista> listarMotoristas() throws SQLException
    {
        return motoristaDao.listarMotoristas();
    }

    public static void deletarMotorista(int idMotorista) throws SQLException
    {
        int quantidade = 0;
        quantidade = motoristaDao.buscarId(idMotorista);

        if(quantidade == 0)
        {
            motoristaDao.removerMotorista(idMotorista);
        }
        else{
            System.out.println("Não é possivel ");
        }
    }
}
