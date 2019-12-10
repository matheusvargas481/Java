package com.matheussoilegra.coreengineering.tema4;

import java.util.Random;

public class Main {

    public static void main(String args[]) {

        Thread threadPar = new Thread(new ThreadPar());
        threadPar.start();

        Thread threadImpar = new Thread(new ThreadImpar());
        threadImpar.start();

    }
}
