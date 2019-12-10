package com.matheussoilegra.coreengineering.tema5;

import org.junit.Assert;
import org.junit.Test;

public class LedTest {

    @Test
    public void testarLedLigada() {
        Led led = new Led();
        led.on();
        Assert.assertEquals(true, led.isOn());
    }

    @Test
    public void testarLedDesligada() {
        Led led = new Led();
        led.off();
        Assert.assertEquals(false, led.isOn());
    }

}
