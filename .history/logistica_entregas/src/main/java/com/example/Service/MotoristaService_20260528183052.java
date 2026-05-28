package com.example.Service;

import java.sql.SQLException;

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
        
    }
}
