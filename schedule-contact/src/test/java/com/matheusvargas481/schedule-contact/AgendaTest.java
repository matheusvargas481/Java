package com.matheussoilegra.coreengineering.tema6;

import org.junit.Assert;
import org.junit.Test;

public class AgendaTest {

    private Agenda agenda = new Agenda();

    @Test
    public void testaAdicionarContato() {
        agenda.adicionarContato("Matheus Santos", 1);
        Assert.assertEquals(agenda.listarContatos().size(), 1);
    }

    @Test
    public void testaRemoverContato() {
        agenda.adicionarContato("Matheus Santos", 1);
        agenda.removerContato(1);
        Assert.assertEquals(agenda.listarContatos().size(), 0);
    }

    @Test
    public void testaListarContatos() {
        Assert.assertNotNull(agenda.listarContatos());
    }

    @Test
    public void testaPesquisarIdExistente() {
        agenda.adicionarContato("Matheus Santos", 1);
        Assert.assertNotNull(agenda.pesquisarId(1));
    }

    @Test
    public void testaPesquisarNomeExistente() {
        agenda.adicionarContato("Matheus Santos", 1);
        Assert.assertNotNull(agenda.pesquisarNome("Matheus Santos"));
    }

    @Test(expected = ContatoNaoEncontradoException.class)
    public void testaPesquisarIdInexistente() {
        agenda.adicionarContato("John Snow", 1);
        agenda.adicionarContato("Arya Stark", 2);
        agenda.pesquisarId(3);
    }

    @Test(expected = ContatoNaoEncontradoException.class)
    public void testaPesquisarNomeInexistente() {
        agenda.adicionarContato("John Snow", 1);
        agenda.adicionarContato("Arya Stark", 2);
        agenda.pesquisarNome("Cersei Lannister");
    }

}



