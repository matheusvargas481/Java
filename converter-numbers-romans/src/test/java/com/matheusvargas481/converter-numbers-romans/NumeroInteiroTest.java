package com.matheussoilegra.coreengineering.tema7;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumeroInteiroTest {

    @Test
    public void testaConversaoRomanoParaInteiroNumero1() {
        assertEquals(1, Conversor.converteRomanoParaInteiro("I"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero2() {
        assertEquals(2, Conversor.converteRomanoParaInteiro("II"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero3() {
        assertEquals(3, Conversor.converteRomanoParaInteiro("III"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero4() {
        assertEquals(4, Conversor.converteRomanoParaInteiro("IV"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero5() {
        assertEquals(5, Conversor.converteRomanoParaInteiro("V"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero6() {
        assertEquals(6, Conversor.converteRomanoParaInteiro("VI"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero7() {
        assertEquals(7, Conversor.converteRomanoParaInteiro("VII"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero8() {
        assertEquals(8, Conversor.converteRomanoParaInteiro("VIII"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero9() {
        assertEquals(9, Conversor.converteRomanoParaInteiro("IX"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero10() {
        assertEquals(10, Conversor.converteRomanoParaInteiro("X"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero11() {
        assertEquals(11, Conversor.converteRomanoParaInteiro("XI"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero12() {
        assertEquals(12, Conversor.converteRomanoParaInteiro("XII"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero13() {
        assertEquals(13, Conversor.converteRomanoParaInteiro("XIII"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero14() {
        assertEquals(14, Conversor.converteRomanoParaInteiro("XIV"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero15() {
        assertEquals(15, Conversor.converteRomanoParaInteiro("XV"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero16() {
        assertEquals(16, Conversor.converteRomanoParaInteiro("XVI"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero17() {
        assertEquals(17, Conversor.converteRomanoParaInteiro("XVII"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero18() {
        assertEquals(18, Conversor.converteRomanoParaInteiro("XVIII"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero19() {
        assertEquals(19, Conversor.converteRomanoParaInteiro("XIX"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero20() {
        assertEquals(20, Conversor.converteRomanoParaInteiro("XX"));
    }

    @Test
    public void testaConversaoRomanoParaInteiroNumero21() {
        assertEquals(21, Conversor.converteRomanoParaInteiro("XXI"));
    }
}
