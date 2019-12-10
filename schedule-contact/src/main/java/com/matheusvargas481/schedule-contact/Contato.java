package com.matheussoilegra.coreengineering.tema6;

public class Contato{

    public String nome;
    public int id;

    public Contato(int id, String nome){
        this.nome = nome;
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + " ; Nome: " + getNome() + "\n";
    }
}


