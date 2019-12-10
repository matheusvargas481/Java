package com.matheussoilegra.coreengineering.tema10;

public class Contato {

    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Contato(int id) {
        this.id = id;
    }

    public Contato(String nome) {
        this.nome = nome;
    }

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Contato(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Id: " + id + "; Nome: " + nome + "; Telefone: " + telefone + "; E-mail: " + email + "\n";
    }
}
