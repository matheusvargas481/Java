package com.matheusvargas481.cloudnative.tema2.petstore.model;

import com.matheusvargas481.cloudnative.tema2.petstore.exception.PetNaoEncontradoException;
import com.matheusvargas481.cloudnative.tema2.petstore.service.Servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pet {
    private int id, idade;
    private String nome, raca;
    private List<Servico> listaServicoPet = new ArrayList<>();

    public Pet(int id, String nome, String raca, int idade) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void adicionarNovoServico(Servico servico){
        listaServicoPet.add(servico);
    }

    public Double getValorTotalDeServicos() {
        Optional<Double> OptionalPet = Optional.ofNullable(listaServicoPet.stream().mapToDouble(pet -> pet.fazerServico()).sum());
        if (OptionalPet.isPresent()) {
            return OptionalPet.get();
        }
        throw new PetNaoEncontradoException("Lista de valores do id " + this.id + " não encontrado");
    }

    @Override
    public String toString() {
        return "Pet: " + "\n" + "ID: " + id + "\n" + "Nome:" + nome + "\n" + "Raca: " + raca + "\n" + "Idade: " + idade + "\n" + getValorTotalDeServicos() + "\n";
    }
}