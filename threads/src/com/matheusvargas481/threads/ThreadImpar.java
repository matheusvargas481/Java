package com.matheussoilegra.coreengineering.tema4;

import java.util.Random;

public class ThreadImpar implements Runnable{

    private Random gerador = new Random();

    @Override
    public void run() {

        do {
            System.out.println("ThreadImpar: " + numeroGeradoImpar());

            try {

                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (true);
    }

    private int numeroGeradoImpar() {

        return gerador.nextInt(100)*2-1;
    }
}


