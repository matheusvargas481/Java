package com.matheussoilegra.coreengineering.tema5;

import org.junit.Assert;
import org.junit.Test;

public class LustreTest {

    @Test
    public void verificarSeTemLustre(){
        Led led = new Led();
        Lustre lustre = new Lustre(led);

        Assert.assertNotNull(lustre);
    }

    @Test
    public void testarSwitchComFluorescenteLigada() {
        Fluorescente fluorescente = new Fluorescente();
        Led led = new Led();
        Lustre lustre = new Lustre(led);

        fluorescente.on();
        lustre = new Lustre(fluorescente);
        lustre.acionarSwitch();
        Assert.assertEquals(false, fluorescente.isOn());
    }

    @Test
    public void testarSwitchComFluorescenteDesligada() {
        Fluorescente fluorescente = new Fluorescente();
        Led led = new Led();
        Lustre lustre = new Lustre(led);

        fluorescente.off();
        lustre = new Lustre(fluorescente);
        lustre.acionarSwitch();
        Assert.assertEquals(true, fluorescente.isOn());
    }

    @Test
    public void testarSwitchComLedLigada() {
        Led led = new Led();
        Lustre lustre = new Lustre(led);
        lustre = new Lustre(led);

        led.on();
        lustre.acionarSwitch();
        Assert.assertEquals(false, led.isOn());
    }

    @Test
    public void testarSwitchComLedDesligada() {
        Led led = new Led();
        Lustre lustre = new Lustre(led);
        lustre = new Lustre(led);

        led.off();
        lustre.acionarSwitch();
        Assert.assertEquals(true, led.isOn());
    }

}


