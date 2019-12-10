package com.matheussoilegra.coreengineering.tema8.Entidades;

import java.util.HashMap;
import java.util.Map;

public class Usuario implements Comparable <Usuario>{
    
    private String nome;
    private int quantidadeLivrosEmprestados;
    private int totalLivrosEmprestados;
    private Map<Livro, Integer> emprestimosAtrasados = new HashMap<Livro, Integer>();

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeLivrosEmprestados = 0;
        this.totalLivrosEmprestados = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getLivrosEmprestados() {
        return quantidadeLivrosEmprestados;
    }

    public void livrosDevolucao() {
        quantidadeLivrosEmprestados--;
    }

    public void livrosEmprestimo() {
        quantidadeLivrosEmprestados++;
        totalLivrosEmprestados++;
    }

    public int getQuantidadeLivrosEmprestados() {
        return totalLivrosEmprestados;
    }

    public String toString() {
        return "Nome: " + nome;
    }

    @Override
    public int compareTo(Usuario usuario) {
        Integer top = totalLivrosEmprestados;
        return top.compareTo(usuario.getQuantidadeLivrosEmprestados());
    }

    public void adicionarUsuarioAtrasadoLista(Livro livro, int diasAtraso) {
        emprestimosAtrasados.put(livro, diasAtraso);
    }

    public Map<Livro, Integer> getEmprestimosAtrasados() {
        return this.emprestimosAtrasados;
    }
}
