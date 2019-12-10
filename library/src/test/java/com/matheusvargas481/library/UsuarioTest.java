package com.matheussoilegra.coreengineering.tema8;

import com.matheussoilegra.coreengineering.tema8.Entidades.Livro;
import com.matheussoilegra.coreengineering.tema8.Entidades.Usuario;
import com.matheussoilegra.coreengineering.tema8.Negócio.Biblioteca;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

    private Biblioteca biblioteca = new Biblioteca();
    private Livro livro = new Livro("Harry Potter", "JK");
    private Usuario usuario = new Usuario("Matheus Oliveira");

    @Before
    public void before() {
        biblioteca.limparListas();
    }

    @After
    public void after() {
        biblioteca.limparListas();
    }

    @Test
    public void getNomeTest() {
        Assert.assertEquals("Matheus Oliveira", usuario.getNome());
    }

    @Test
    public void getQuantidadeLivrosEmprestadosTest() {
        Assert.assertEquals(0, usuario.getQuantidadeLivrosEmprestados());
        biblioteca.fazerEmprestimo(usuario, livro);
        Assert.assertEquals(1, usuario.getQuantidadeLivrosEmprestados());
    }

    @Test
    public void getEmprestimosAtrasadosTest() {
        Assert.assertEquals(0, usuario.getEmprestimosAtrasados().size());
    }

    @Test
    public void getAdicionarUsuarioAtrasadoListaTest() {
        Assert.assertEquals(usuario.getEmprestimosAtrasados().size(), 0);
        usuario.adicionarUsuarioAtrasadoLista(livro, 21);
        Assert.assertEquals(usuario.getEmprestimosAtrasados().size(), 1);
    }
}
