package com.matheussoilegra.coreengineering.tema8.Entidades;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private boolean emprestado;
    private static int aux = 1;

    public Livro(String titulo, String autor) {
        this.id = aux++;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public static void aux(int valor) {
        aux = valor;
    }

    public int getId() {
        return id;
    }

    public static int getAux() {
        return aux;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public String toString() {
        return "Id: " + id + "; Livro: " + titulo + "; Autor: " + autor + "; Livro emprestado: " + emprestado;
    }


}
