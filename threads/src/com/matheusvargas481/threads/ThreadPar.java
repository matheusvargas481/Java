package com.matheussoilegra.coreengineering.tema4;

import java.util.Random;

public class ThreadPar implements Runnable {

    private Random gerador = new Random();

    @Override
    public void run() {

        do {
            System.out.println("ThreadPar: " + numeroGeradoPar());

            try {

                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (true);
    }

    private int numeroGeradoPar() {

        return gerador.nextInt(100)*2;
    }
}

