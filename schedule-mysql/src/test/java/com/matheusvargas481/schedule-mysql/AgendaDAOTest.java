package com.matheussoilegra.coreengineering.tema10;

import com.matheussoilegra.coreengineering.tema10.com.matheussoilegra.coreengineering.tema10.exceptions.ContatoNaoEncontradoException;
import com.matheussoilegra.coreengineering.tema10.com.matheussoilegra.coreengineering.tema10.exceptions.ErroAdicionarContatoException;
import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AgendaDAOTest {

    private AgendaDAO agendaDAO = new AgendaDAO();
    private Contato contato = new Contato(1,"Fernanda", "999999999", "fernanda@contato.com");

    @Before
    public void before() {
        agendaDAO.limparTabela();
    }

    @After
    public void after() {
        agendaDAO.limparTabela();
    }

    @Test
    public void testarAdicionarContato() {
        int quantidadeContatosAntes = agendaDAO.listarContatosOrdenadosId().size();
        agendaDAO.adicionarContato(contato);
        int quantidadesContatosDepois = agendaDAO.listarContatosOrdenadosId().size();

        Assert.assertEquals(quantidadeContatosAntes + 1, quantidadesContatosDepois);
    }

    @Test (expected = ErroAdicionarContatoException.class)
    public void testarAdicionarContatoInvalido() {
        contato = new Contato("Matheus");
        agendaDAO.adicionarContato(contato);
    }

    @Test
    public void testarRemoverContato() {
        agendaDAO.adicionarContato(contato);
        int quantidadeContatosAntes = agendaDAO.listarContatosOrdenadosId().size();

        agendaDAO.removerContato(1);
        int quantidadesContatosDepois = agendaDAO.listarContatosOrdenadosId().size();
        Assert.assertEquals(quantidadeContatosAntes -1, quantidadesContatosDepois);
    }

    @Test (expected = ContatoNaoEncontradoException.class)
    public void testarRemoverContatoInexistente() {
        agendaDAO.removerContato(1);
    }

    @Test
    public void testarBuscarContatoId() {
        agendaDAO.adicionarContato(contato);
        Optional<Contato> contatoExistente = agendaDAO.buscarContatoId(1);

        Assert.assertNotNull(contatoExistente);
        Assert.assertTrue(contatoExistente.isPresent());
        Assert.assertEquals(contato.getId(), contatoExistente.get().getId());
    }

    @Test
    public void testarBuscarContatoIdInexistente() {
        Assert.assertEquals(false, agendaDAO.buscarContatoId(1).isPresent());
    }

    @Test
    public void testarBuscarContatoNome() {
        agendaDAO.adicionarContato(contato);
        Optional<Contato> contatoExistente = agendaDAO.buscarContatoNome("Fernanda");

        Assert.assertNotNull(contatoExistente);
        Assert.assertTrue(contatoExistente.isPresent());
        Assert.assertEquals(contato.getNome(), contatoExistente.get().getNome());
    }

    @Test
    public void testarBuscarContatoNomeInexistente() {
        Assert.assertEquals(false, agendaDAO.buscarContatoNome("João").isPresent());
    }
    
    @Test
    public void testarListarContatosOrdenadosNome() {
        agendaDAO.adicionarContato(new Contato(1, "Fernanda", "999999999", "fernanda@contato.com"));
        agendaDAO.adicionarContato(new Contato(2, "Michel", "999999998", "michel@contato.com"));
        agendaDAO.adicionarContato(new Contato(3, "Ana", "999999997", "ana@contato.com"));

        List<String> ordemAlfabetica = Arrays.asList("Ana", "Fernanda", "Michel");
        List<String> ordemRealizada = agendaDAO.listarContatosOrdenadosNome()
                .stream()
                .map(Contato::getNome)
                .collect(Collectors.toList());

        Assert.assertEquals(ordemAlfabetica, ordemRealizada);
    }

    @Test
    public void testaListaVaziaNomesContatos() {
        Assert.assertEquals(true, agendaDAO.listarContatosOrdenadosNome().stream().map(Contato::getNome).collect(Collectors.toList()).isEmpty());
    }

    @Test
    public void testarListarContatosOrdenadosId() {
        agendaDAO.adicionarContato(new Contato(1, "Fernanda", "999999999", "fernanda@contato.com"));
        agendaDAO.adicionarContato(new Contato(2, "Michel", "999999998", "michel@contato.com"));
        agendaDAO.adicionarContato(new Contato(3, "Ana", "999999997", "ana@contato.com"));

        List<Integer> ordemNumerica = Arrays.asList(1, 2, 3);
        List<Integer> ordemRealizada = agendaDAO.listarContatosOrdenadosId()
                .stream().map(Contato::getId)
                .collect(Collectors.toList());

        Assert.assertEquals(ordemNumerica, ordemRealizada);
    }

    @Test
    public void testaListaVaziaIdsContatos() {
        Assert.assertEquals(true, agendaDAO.listarContatosOrdenadosId().stream().map(Contato::getNome).collect(Collectors.toList()).isEmpty());
    }
}