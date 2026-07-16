package org.example.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.example.Models.Contato;
import org.example.Repository.ContatoRepository;

public class ContatoService {
    private static ContatoRepository contatoRepository = new ContatoRepository();

    public Contato criarContato(Contato contato) throws SQLException{

        if(contatoRepository.existePorNome(contato.getNome())){
            throw new RuntimeException("O contato já foi cadastrado");
        }

        contatoRepository.salvar(contato);

        return contato;
    }

    public Contato buscarContatoPorNome(String nome) throws SQLException
    {
        if(nome.isBlank())
        {
            throw new RuntimeException("O nome do contato não pode ser branco");
        }

        Contato contato = contatoRepository.buscarContatoPorNome(nome);

        return contato;
    }

    public List<Contato> buscarTodosContatos() throws SQLException
    {
        List<Contato> contatos = new ArrayList<>();

        contatos = contatoRepository.buscarTodosContato();
        return contatos;
    }

    public Contato atualizarContato(Contato contato) throws SQLException
    {
        String numeroAntigo = contatoRepository.existePorNumero(contato.getNumero());
        String nomeAntigo = contatoRepository.existePorNomeRetornaString(contato.getNome());

        boolean nomeIgual = Objects.equals(nomeAntigo, contato.getNome());

        if(nomeAtualizado == nomeAntigo)
        {
            System.out.println("Chegou aqui e o nome é igual");
            if(numeroAtualizado == numeroAntigo)
            {
                throw new RuntimeException("Não há nada para atualizar");
            }
        }

        contatoRepository.atualizarContato(contato);
        return contato;
    }

    public String deletarContato(Long id) throws SQLException
    {
        if(id == null)
        {
            throw new RuntimeException("O id do contato não pode ser nulo");
        }

        String mensagem = contatoRepository.deletarContato(id);
        return mensagem;
    }

}
