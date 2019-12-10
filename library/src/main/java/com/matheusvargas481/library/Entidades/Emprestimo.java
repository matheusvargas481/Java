package com.matheussoilegra.coreengineering.tema8.Entidades;

import java.time.LocalDate;

public class Emprestimo {

    private int idEmprestimo;
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataRenovacao;
    private LocalDate dataDevolucao;
    private final int DIAS_ENTREGA = 7;
    public static int aux = 1;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.idEmprestimo = aux++;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataRenovacao = dataEmprestimo.plusDays(DIAS_ENTREGA);
        this.dataDevolucao = dataEmprestimo.plusDays(DIAS_ENTREGA);
    }

    public static void aux(int valor) {
        aux = valor;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public LocalDate getDataRenovacao() {
        return dataRenovacao;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataRenovacao(LocalDate dataRenovacao) {
        this.dataRenovacao = dataRenovacao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public static int getAux() {
        return aux;
    }

    public int getDiasEntrega() {
        return DIAS_ENTREGA;
    }

    public String toString() {
        return "Id Empréstimo: " + idEmprestimo + "; Livro " + livro + "; " + usuario;
    }
}
