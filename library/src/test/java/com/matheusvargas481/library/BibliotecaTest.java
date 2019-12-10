package com.matheussoilegra.coreengineering.tema8;

import com.matheussoilegra.coreengineering.tema8.Entidades.Livro;
import com.matheussoilegra.coreengineering.tema8.Entidades.Usuario;
import com.matheussoilegra.coreengineering.tema8.Exceptions.*;
import com.matheussoilegra.coreengineering.tema8.Negócio.Biblioteca;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class BibliotecaTest {

    private Biblioteca biblioteca = new Biblioteca();
    private Livro livro = new Livro("Harry Potter", "JK");
    private Usuario usuario = new Usuario("Matheus Oliveira");
    private final int DIAS_ENTREGA = 7;
    private final int VALOR_MULTA_UMA_SEMANA_ATRASO = 35;

    @Before
    public void before() {
        biblioteca.limparListas();
    }

    @After
    public void after() {
        biblioteca.limparListas();
    }

    @Test
    public void cadastrarUsuarioTest() {
        biblioteca.cadastrarUsuario(usuario);
        Assert.assertEquals(1, biblioteca.listarUsuarios().size());
    }

    @Test
    public void cadastrarLivroTest() {
        biblioteca.cadastrarLivro(livro);
        Assert.assertEquals(1, biblioteca.listarLivros().size());
    }

    @Test
    public void listarUsuariosTest() {
        biblioteca.cadastrarUsuario(usuario);
        biblioteca.cadastrarUsuario(new Usuario("Carla Diaz"));
        Assert.assertEquals(2, biblioteca.listarUsuarios().size());
    }

    @Test
    public void listarLivrosTest() {
        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarLivro(new Livro("Ponto de Impacto","Dan Bronw"));
        Assert.assertEquals(2, biblioteca.listarLivros().size());
    }

    @Test
    public void excluirLivroTest() {
        biblioteca.cadastrarLivro(livro);
        Assert.assertEquals(1, biblioteca.listarLivros().size());
        biblioteca.excluirLivro(1);
        Assert.assertEquals(0, biblioteca.listarLivros().size());
    }

    @Test(expected = LivroJaEmprestadoException.class)
    public void excluirLivroJaEmprestadoTest() {
        biblioteca.cadastrarUsuario(usuario);
        biblioteca.cadastrarLivro(livro);
        biblioteca.fazerEmprestimo(usuario,livro);
        biblioteca.excluirLivro(1);
    }

    @Test
    public void buscarUsuarioNomeTest() {
        biblioteca.cadastrarUsuario(usuario);
        Assert.assertEquals(usuario, biblioteca.buscarNomeUsuario("Matheus Oliveira"));
    }

    @Test(expected = UsuarioNaoEncontradoException.class)
    public void buscarUsuarioNomeInexistenteTest() {
        biblioteca.cadastrarUsuario(usuario);
        biblioteca.buscarNomeUsuario("Silvio Santos");
    }

    @Test
    public void buscarLivroIdTest() {
        biblioteca.cadastrarLivro(livro);
        Assert.assertEquals(livro, biblioteca.buscarLivroId(1));
    }

    @Test(expected = LivroNaoEncontradoException.class)
    public void buscarLivroIdInexistenteTest() {
        biblioteca.cadastrarLivro(livro);
        biblioteca.buscarLivroId(8);
    }

    @Test
    public void buscarLivroTituloOuAutorTest() {
        biblioteca.cadastrarLivro(livro);
        Assert.assertEquals(livro, biblioteca.buscarLivro("Harry Potter"));
        Assert.assertEquals(livro, biblioteca.buscarLivro("JK"));
    }

    @Test(expected = LivroNaoEncontradoException.class)
    public void buscarLivroTituloOuAutorInexistenteTest() {
        biblioteca.cadastrarLivro(livro);
        biblioteca.buscarLivro("Fortaleza Digital");
        biblioteca.buscarLivro("Dan Brown");
    }

    @Test
    public void fazerEmprestimoTest() {
        biblioteca.fazerEmprestimo(usuario, livro);
        Assert.assertEquals(1, biblioteca.listarEmprestimos().size());
    }

    @Test(expected = LivroJaEmprestadoException.class)
    public void fazerEmprestimoLivroJaEmprestadoTest() {
        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarUsuario(usuario);
        biblioteca.fazerEmprestimo(usuario, livro);
        biblioteca.fazerEmprestimo(usuario, livro);
    }

    @Test(expected = UsuarioComLimiteEmprestimosException.class)
    public void fazerEmprestimoLivroUsuarioest() {
        biblioteca.cadastrarUsuario(usuario);
        biblioteca.cadastrarLivro(livro);
        biblioteca.fazerEmprestimo(usuario, livro);

        biblioteca.cadastrarLivro(new Livro("Livro2", "Autor2"));
        biblioteca.fazerEmprestimo(usuario, new Livro("Livro2", "Autor2"));

        biblioteca.cadastrarLivro(new Livro("Livro3", "Autor3"));
        biblioteca.fazerEmprestimo(usuario, new Livro("Livro3", "Autor3"));

        biblioteca.cadastrarLivro(new Livro("Livro4", "Autor4"));
        biblioteca.fazerEmprestimo(usuario, new Livro("Livro4", "Autor4"));

        biblioteca.cadastrarLivro(new Livro("Livro5", "Autor5"));
        biblioteca.fazerEmprestimo(usuario, new Livro("Livro5", "Autor5"));

        biblioteca.cadastrarLivro(new Livro("Livro6", "Autor6"));
        biblioteca.fazerEmprestimo(usuario, new Livro("Livro6", "Autor6"));
    }

    @Test
    public void fazerRenovacaoTest() {
        biblioteca.fazerEmprestimo(usuario, livro);
        biblioteca.fazerRenovacao(1);
        Assert.assertEquals(LocalDate.now().plusDays(DIAS_ENTREGA), biblioteca.listarEmprestimos().get(0).getDataRenovacao());
    }

    @Test(expected = UsuarioComLimiteDiasAtrasoException.class)
    public void fazerRenovacaoAtrasadaTest() {
        biblioteca.fazerEmprestimo(usuario, livro);
        biblioteca.listarEmprestimos().get(0).setDataEmprestimo(LocalDate.now().minusDays(30));
        biblioteca.listarEmprestimos().get(0).setDataDevolucao(LocalDate.now());
        biblioteca.fazerRenovacao(1);
    }

    @Test
    public void fazerDevolucaoTest() {
        biblioteca.fazerEmprestimo(usuario, livro);
        Assert.assertEquals(1, biblioteca.listarEmprestimos().size());
        biblioteca.fazerDevolucao(usuario, livro);
        Assert.assertEquals(0, biblioteca.listarEmprestimos().size());
    }

    @Test
    public void calcularDiasAtrasoTest() {
        biblioteca.fazerEmprestimo(usuario, livro);
        biblioteca.calcularDiasAtraso(1);
        Assert.assertEquals(DIAS_ENTREGA, biblioteca.calcularDiasAtraso(1));
    }

    @Test(expected = EmprestimoNaoEncontradoException.class)
    public void calcularDiasAtrasoEmprestimoInexistente() {
        biblioteca.fazerEmprestimo(usuario, livro);
        biblioteca.calcularDiasAtraso(5);
    }

    @Test
    public void calcularValorMultaTest() {
        biblioteca.fazerEmprestimo(usuario, livro);
        biblioteca.calcularValorMulta(1);
        Assert.assertEquals(VALOR_MULTA_UMA_SEMANA_ATRASO, biblioteca.calcularValorMulta(1));
    }

    @Test(expected = EmprestimoNaoEncontradoException.class)
    public void calcularValorEmprestimoInexistente() {
        biblioteca.fazerEmprestimo(usuario, livro);
        biblioteca.calcularValorMulta(5);
    }
}
