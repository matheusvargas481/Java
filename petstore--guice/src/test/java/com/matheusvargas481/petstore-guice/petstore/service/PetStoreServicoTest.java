package com.matheusvargas481.cloudnative.tema2.petstore.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.matheusvargas481.cloudnative.tema2.petstore.exception.PetNaoEncontradoException;
import com.matheusvargas481.cloudnative.tema2.petstore.model.Pet;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetStoreServicoTest {
    private Injector injector = Guice.createInjector();
    private PetStoreServico petStoreServico = injector.getInstance(PetStoreServico.class);

    @Test
    public void testAdicionarNovoPet() {
        petStoreServico.adicionarPet(new Pet(1, "Sasha", "Pitbull", 5));
        assertEquals("Sasha", petStoreServico.listarPets().get(0).getNome());
    }

    @Test
    public void testRemoverPet() {
        petStoreServico.adicionarPet(new Pet(1, "Chicho", "Persa", 3));
        petStoreServico.deletarPet(1);
        assertTrue(petStoreServico.listarPets().isEmpty());
    }

    @Test
    public void testBuscarPetPorId() {
        petStoreServico.adicionarPet(new Pet(1, "Bob", "Pitbull", 5));
        Pet pet = petStoreServico.buscarPetPorId(1);
        assertEquals(pet, petStoreServico.buscarPetPorId(1));
    }

    @Test
    public void testBuscarPetPorIdade() {
        petStoreServico.adicionarPet(new Pet(1, "Bob", "Pitbull", 5));
        Pet pet = petStoreServico.buscarPetPorId(1);
        assertTrue(petStoreServico.buscarPorIdade(5).contains(pet));
    }

    @Test(expected = PetNaoEncontradoException.class)
    public void testExceptionPetNaoEncontrado() {
        petStoreServico.buscarPetPorId(9);
        petStoreServico.buscarPorIdade(59);
    }

    @Test
    public void listarDezPetsQueMaisGastaramOrdenandoIdDescrescente() {
        CorteCabeloLongo corteCabeloLongo = injector.getInstance(CorteCabeloLongo.class);
        CorteCabeloCurto corteCabeloCurto = injector.getInstance(CorteCabeloCurto.class);
        BanhoComAguaESemPerfume banhoComAguaESemPerfume = injector.getInstance(BanhoComAguaESemPerfume.class);
        BanhoComAguaEComPerfume banhoComAguaEComPerfume = injector.getInstance(BanhoComAguaEComPerfume.class);
        BanhoSecoESemPerfume banhoSecoESemPerfume = injector.getInstance(BanhoSecoESemPerfume.class);
        BanhoSecoEComPerfume banhoSecoEComPerfume = injector.getInstance(BanhoSecoEComPerfume.class);

        petStoreServico.adicionarPet(new Pet(1, "Sasha", "Pitbull", 5));
        Pet pet1 = petStoreServico.buscarPetPorId(1);
        pet1.adicionarNovoServico(corteCabeloCurto);
        pet1.adicionarNovoServico(banhoComAguaESemPerfume);
        pet1.adicionarNovoServico(corteCabeloLongo);
        pet1.adicionarNovoServico(banhoComAguaESemPerfume);
        pet1.adicionarNovoServico(corteCabeloLongo);

        petStoreServico.adicionarPet(new Pet(2, "Chico", "Persa", 4));
        Pet pet2 = petStoreServico.buscarPetPorId(2);
        pet2.adicionarNovoServico(corteCabeloCurto);
        pet2.adicionarNovoServico(corteCabeloLongo);
        pet2.adicionarNovoServico(banhoComAguaEComPerfume);
        pet2.adicionarNovoServico(banhoComAguaEComPerfume);
        pet2.adicionarNovoServico(banhoComAguaEComPerfume);
        pet2.adicionarNovoServico(banhoSecoESemPerfume);

        petStoreServico.adicionarPet(new Pet(3, "Beethoven", "Pug", 3));
        Pet pet3 = petStoreServico.buscarPetPorId(3);
        pet3.adicionarNovoServico(corteCabeloCurto);

        petStoreServico.adicionarPet(new Pet(4, "Abelhinha", "Maltês", 6));
        Pet pet4 = petStoreServico.buscarPetPorId(4);
        pet4.adicionarNovoServico(corteCabeloCurto);

        petStoreServico.adicionarPet(new Pet(5, "Afrodite", "Shih-Tzu", 8));
        Pet pet5 = petStoreServico.buscarPetPorId(5);
        pet5.adicionarNovoServico(corteCabeloCurto);
        pet5.adicionarNovoServico(banhoSecoESemPerfume);

        petStoreServico.adicionarPet(new Pet(6, "Bart", "Yorkshire", 2));
        Pet pet6 = petStoreServico.buscarPetPorId(6);
        pet6.adicionarNovoServico(corteCabeloCurto);
        pet6.adicionarNovoServico(corteCabeloLongo);

        petStoreServico.adicionarPet(new Pet(7, "Pelé", "Labrador", 1));
        Pet pet7 = petStoreServico.buscarPetPorId(7);
        pet7.adicionarNovoServico(corteCabeloCurto);
        pet7.adicionarNovoServico(banhoSecoESemPerfume);
        pet7.adicionarNovoServico(corteCabeloLongo);

        petStoreServico.adicionarPet(new Pet(8, "Abelhinha", "Golden Retriever", 5));
        Pet pet8 = petStoreServico.buscarPetPorId(8);
        pet8.adicionarNovoServico(corteCabeloLongo);
        pet8.adicionarNovoServico(corteCabeloLongo);
        pet8.adicionarNovoServico(banhoSecoEComPerfume);
        pet8.adicionarNovoServico(corteCabeloLongo);

        petStoreServico.adicionarPet(new Pet(9, "Bidu", "Poodle", 8));
        Pet pet9 = petStoreServico.buscarPetPorId(9);
        pet9.adicionarNovoServico(banhoSecoEComPerfume);
        pet9.adicionarNovoServico(corteCabeloLongo);
        pet9.adicionarNovoServico(banhoSecoEComPerfume);
        pet9.adicionarNovoServico(corteCabeloLongo);
        pet9.adicionarNovoServico(corteCabeloLongo);

        petStoreServico.adicionarPet(new Pet(10, "Baronesa", "Pug", 10));
        Pet pet10 = petStoreServico.buscarPetPorId(10);
        pet10.adicionarNovoServico(corteCabeloLongo);
        pet10.adicionarNovoServico(banhoSecoEComPerfume);
        pet10.adicionarNovoServico(corteCabeloLongo);
        pet10.adicionarNovoServico(banhoSecoEComPerfume);
        pet10.adicionarNovoServico(banhoSecoEComPerfume);
        pet10.adicionarNovoServico(banhoSecoEComPerfume);

        petStoreServico.adicionarPet(new Pet(11, "Jasmine", "Vira-Lata", 13));
        Pet pet11 = petStoreServico.buscarPetPorId(11);
        pet11.adicionarNovoServico(corteCabeloLongo);
        pet11.adicionarNovoServico(banhoComAguaESemPerfume);
        pet11.adicionarNovoServico(banhoComAguaEComPerfume);
        pet11.adicionarNovoServico(banhoSecoESemPerfume);
        pet11.adicionarNovoServico(corteCabeloLongo);
        pet11.adicionarNovoServico(banhoSecoESemPerfume);
        pet11.adicionarNovoServico(corteCabeloCurto);

        List<Pet> testDezPetsQueMaisGastaram = petStoreServico.dezPetsQueMaisGastaram();
        assertEquals(10, testDezPetsQueMaisGastaram.get(0).getId());
        assertEquals(11, testDezPetsQueMaisGastaram.get(1).getId());
        assertEquals(2, testDezPetsQueMaisGastaram.get(2).getId());
        assertEquals(9, testDezPetsQueMaisGastaram.get(3).getId());
        assertEquals(8, testDezPetsQueMaisGastaram.get(4).getId());
        assertEquals(1, testDezPetsQueMaisGastaram.get(5).getId());
        assertEquals(7, testDezPetsQueMaisGastaram.get(6).getId());
        assertEquals(5, testDezPetsQueMaisGastaram.get(7).getId());
        assertEquals(6, testDezPetsQueMaisGastaram.get(8).getId());
        assertEquals(3, testDezPetsQueMaisGastaram.get(9).getId());
    }
}