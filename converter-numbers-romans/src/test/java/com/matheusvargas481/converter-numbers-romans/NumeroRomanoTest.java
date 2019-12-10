package com.matheussoilegra.coreengineering.tema7;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumeroRomanoTest {

    @Test
    public void testaConversaoInteiroParaRomanoNumero1() {
        assertEquals("I", Conversor.converteInteiroParaRomano(1));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero2() {
        assertEquals("II", Conversor.converteInteiroParaRomano(2));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero3() {
        assertEquals("III", Conversor.converteInteiroParaRomano(3));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero4() {
        assertEquals("IV", Conversor.converteInteiroParaRomano(4));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero5() {
        assertEquals("V", Conversor.converteInteiroParaRomano(5));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero6() {
        assertEquals("VI", Conversor.converteInteiroParaRomano(6));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero7() {
        assertEquals("VII", Conversor.converteInteiroParaRomano(7));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero8() {
        assertEquals("VIII", Conversor.converteInteiroParaRomano(8));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero9() {
        assertEquals("IX", Conversor.converteInteiroParaRomano(9));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero10() {
        assertEquals("X", Conversor.converteInteiroParaRomano(10));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero11() {
        assertEquals("XI", Conversor.converteInteiroParaRomano(11));
    }


    @Test
    public void testaConversaoInteiroParaRomanoNumero12() {
        assertEquals("XII", Conversor.converteInteiroParaRomano(12));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero13() {
        assertEquals("XIII", Conversor.converteInteiroParaRomano(13));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero14() {
        assertEquals("XIV", Conversor.converteInteiroParaRomano(14));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero15() {
        assertEquals("XV", Conversor.converteInteiroParaRomano(15));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero16() {
        assertEquals("XVI", Conversor.converteInteiroParaRomano(16));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero17() {
        assertEquals("XVII", Conversor.converteInteiroParaRomano(17));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero18() {
        assertEquals("XVIII", Conversor.converteInteiroParaRomano(18));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero19() {
        assertEquals("XIX", Conversor.converteInteiroParaRomano(19));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero20() {
        assertEquals("XX", Conversor.converteInteiroParaRomano(20));
    }

    @Test
    public void testaConversaoInteiroParaRomanoNumero21() {
        assertEquals("XXI", Conversor.converteInteiroParaRomano(21));
    }

}
