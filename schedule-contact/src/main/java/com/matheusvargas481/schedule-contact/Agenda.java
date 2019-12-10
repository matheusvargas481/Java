package com.matheussoilegra.coreengineering.tema6;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    public List<Contato> contatos = new ArrayList<>();

    public void adicionarContato(String nome, int id) {
        Contato contato = new Contato(id, nome);
        contatos.add(contato);
    }

    public void removerContato(int id) {
        Contato contatoRemover = pesquisarId(id);
            contatos.remove(contatoRemover);
    }

    public List<Contato> listarContatos() {
        return contatos;
    }

    public Contato pesquisarNome(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        throw new ContatoNaoEncontradoException();
    }

    public Contato pesquisarId(int id) {
        for (Contato contato : contatos) {
            if (contato.getId() == id)
                return contato;
        }
        throw new ContatoNaoEncontradoException();
    }

}
