package org.example.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.example.Models.Contato;
import org.example.Repository.ContatoRepository;
import org.example.db.ConnectionFactory;

public class ContatoService {

    private static ContatoRepository contatoRepository = new ContatoRepository();

    public Contato criarContato(Contato contato) throws SQLException {

        if (contatoRepository.existePorNome(contato.getNome())) {
            throw new RuntimeException("O contato já foi cadastrado");
        }

        contatoRepository.salvar(contato);

        return contato;
    }

    public Contato buscarContatoPorNome(String nome) throws SQLException {

        if (nome.isBlank()) {
            throw new RuntimeException("O nome do contato não pode ser branco");
        }

        Contato contato = contatoRepository.buscarContatoPorNome(nome);

        return contato;
    }

    public List<Contato> buscarTodosContatos() throws SQLException {

        List<Contato> contatos = new ArrayList<>();

        contatos = contatoRepository.buscarTodosContato();

        return contatos;
    }

    public Contato atualizarContato(Contato contato) throws SQLException {

    Contato contatoAntigo = contatoRepository.buscarContatoPorId(contato.getId());

    if (contatoAntigo == null) {
        throw new RuntimeException("Contato não encontrado");
    }

    boolean nomeIgual = contatoAntigo.getNome().equals(contato.getNome());
    boolean numeroIgual = contatoAntigo.getNumero().equals(contato.getNumero());

    if (nomeIgual && numeroIgual) {
        throw new IllegalArgumentException("Não há nada para atualizar");
    }

    contatoRepository.atualizarContato(contato);

    return contato;
}

    public boolean deletarContato(Long id) throws SQLException {

    if (id == null) {
        throw new IllegalArgumentException("O id do contato não pode ser nulo");
    }

    String mensagem = contatoRepository.deletarContato(id);

    return "Contato deletado com sucesso".equals(mensagem);
}
}