package com.matheusvargas481.cloudnative.tema2.petstore.service;

import com.google.inject.Singleton;
import com.matheusvargas481.cloudnative.tema2.petstore.exception.PetNaoEncontradoException;
import com.matheusvargas481.cloudnative.tema2.petstore.model.Pet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class PetStoreServico {
    private List<Pet> listaDePets = new ArrayList<>();

    public List<Pet> listarPets() {
        return listaDePets;
    }

    public void adicionarPet(Pet pet) {
        listaDePets.add(pet);
    }

    public void deletarPet(int id) {
        listaDePets.remove(buscarPetPorId(id));
    }

    public Pet buscarPetPorId(int id) {
        Optional<Pet> optionalBuscarPorId = Optional.ofNullable(listaDePets.stream().filter(pet -> pet.getId() == id).findAny().orElse(null));
        if (optionalBuscarPorId.isPresent()) {
            return optionalBuscarPorId.get();
        }
        throw new PetNaoEncontradoException("Pet com o " + id + " não foi encontrado.");
    }

    public List<Pet> buscarPorIdade(int idade) {
        Optional<List<Pet>> optionalListaBuscarPorIdade = Optional.ofNullable(listaDePets.stream().filter(pet -> pet.getIdade() == idade).collect(Collectors.toList()));
        if (optionalListaBuscarPorIdade.isPresent()) {
            return optionalListaBuscarPorIdade.get();
        }
        throw new PetNaoEncontradoException("Pet com a " + idade + " não foi encontrado.");
    }

    public List<Pet> dezPetsQueMaisGastaram() {
        return listaDePets.stream().sorted(Comparator.comparingDouble(Pet::getValorTotalDeServicos).reversed()).limit(10).collect(Collectors.toList());
    }
}