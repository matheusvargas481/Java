package com.matheussoilegra.coreengineering.tema5;

import org.junit.Assert;
import org.junit.Test;

public class FluorescenteTest {

    @Test
    public void testarFluorescenteLigada() {
        Fluorescente fluorescente = new Fluorescente();
        fluorescente.on();
        Assert.assertEquals(true, fluorescente.isOn());
    }

    @Test
    public void testarFluorescenteDesligada() {
        Fluorescente fluorescente = new Fluorescente();
        fluorescente.off();
        Assert.assertEquals(false, fluorescente.isOn());
    }

}

