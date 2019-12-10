package com.matheussoilegra.coreengineering.tema8;

import com.matheussoilegra.coreengineering.tema8.Entidades.Emprestimo;
import com.matheussoilegra.coreengineering.tema8.Entidades.Livro;
import com.matheussoilegra.coreengineering.tema8.Entidades.Usuario;
import com.matheussoilegra.coreengineering.tema8.Negócio.Biblioteca;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class EmprestimoTest {

    private Biblioteca biblioteca = new Biblioteca();
    private Livro livro = new Livro("Harry Potter", "JK");
    private Usuario usuario = new Usuario("Matheus Oliveira");
    private Emprestimo emprestimo = new Emprestimo(usuario, livro);
    private final int DIAS_ENTREGA = 7;

    @Before
    public void before() {
        biblioteca.limparListas();
    }

    @After
    public void after() {
        biblioteca.limparListas();
    }

    @Test
    public void getUsuarioEmprestimoTest() {
        Assert.assertEquals(usuario, emprestimo.getUsuario());
    }

    @Test
    public void getLivroEmprestimoTest() {
        Assert.assertEquals(livro, emprestimo.getLivro());
    }

    @Test
    public void getEmprestimoIdTest() {
        Assert.assertEquals(1, emprestimo.getIdEmprestimo());
    }

    @Test
    public void getDataEmprestimoTest() {
        Assert.assertEquals(LocalDate.now(), emprestimo.getDataEmprestimo());
    }

    @Test
    public void getDataRenovacaoTest() {
        emprestimo.setDataRenovacao(LocalDate.now().plusDays(DIAS_ENTREGA));
        Assert.assertEquals(LocalDate.now().plusDays(DIAS_ENTREGA), emprestimo.getDataRenovacao());
    }

    @Test
    public void getDataDevolucaoTest() {
        emprestimo.setDataDevolucao(LocalDate.now().plusDays(DIAS_ENTREGA));
        Assert.assertEquals(LocalDate.now().plusDays(DIAS_ENTREGA), emprestimo.getDataDevolucao());
    }
}
