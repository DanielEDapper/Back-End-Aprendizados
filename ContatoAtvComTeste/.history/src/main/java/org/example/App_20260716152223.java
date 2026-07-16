package org.example;

import java.sql.SQLException;

import org.example.Models.Contato;
import org.example.Service.ContatoService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ContatoService contatoService = new ContatoService();
        /*CRIAÇÃO DE CONTATO*/
        // Contato contato = new Contato(
        //     (long)7,
        //     "Jorginho", 
        //     "47 9 9290-4564");

        Contato contato = new Contato("Pedrinho", null)


        /*            TESTE PARA SALVAR CONTATO NOVO            */
        

        try{
            contatoService.criarContato(contato);
        }catch(SQLException e){
            e.printStackTrace();
        }



        /*            TESTE PARA ATUALIZAR UM NOVO CONTATO            */
        // try{
        //     contatoService.atualizarContato(contato);
        // }catch(SQLException e)
        // {
        //     e.printStackTrace();
        // }



        /*            TESTE PARA DELETAR UM CONTATO NOVO            */
        // try{
        //     contatoService.deletarContato(contato.getId());
        // }catch(SQLException e)
        // {
        //     e.printStackTrace();
        // }



        /*            TESTE PARA BUSCAR UM CONTATO - POR NOME            */
        // try{
        //     Contato con = contatoService.buscarContatoPorNome(contato.getNome());

        //     System.out.println("Nome: "+con.getNome());
        //     System.out.println("ID: "+con.getId());
        //     System.out.println("Numero: "+con.getNumero());
        // }catch(SQLException e)
        // {
        //     e.printStackTrace();
        // }



        /*            TESTE PARA BUSCAR TODOS OS CONTATOS            */
        // try{
        //     contatoService.buscarTodosContatos();
        // }catch(SQLException e)
        // {
        //     e.printStackTrace();
        // }


    }

}