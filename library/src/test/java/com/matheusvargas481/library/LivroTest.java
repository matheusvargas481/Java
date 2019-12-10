package com.matheussoilegra.coreengineering.tema8;

import com.matheussoilegra.coreengineering.tema8.Entidades.Livro;
import com.matheussoilegra.coreengineering.tema8.Negócio.Biblioteca;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LivroTest {

    private Biblioteca biblioteca = new Biblioteca();
    private Livro livro = new Livro("Harry Potter", "JK");

    @Before
    public void before() {
    biblioteca.limparListas();
    }

    @After
    public void after() {
        biblioteca.limparListas();
    }

    @Test
    public void getIdTest() {
        Assert.assertEquals(1, livro.getId());
    }

    @Test
    public void getTituloTest() {
        Assert.assertEquals("Harry Potter", livro.getTitulo());
    }

    @Test
    public void getAutorTest() {
        Assert.assertEquals("JK", livro.getAutor());
    }

    @Test
    public void getStatusDisponivelTest() {
        livro.setEmprestado(true);
        Assert.assertEquals("true", livro.getEmprestado(),true);
    }

    @Test
    public void getStatusAlugadoTest() {
        livro.setEmprestado(false);
        Assert.assertEquals("false", livro.getEmprestado(),false);
    }
}


