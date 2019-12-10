package com.matheussoilegra.coreengineering.tema7;

public class Conversor {

    public static final int[] inteiros = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    public static final String[] romanos = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public static String converteInteiroParaRomano(int inteiro) {
        String romano = "";


        if (inteiro <1 || inteiro > 20) {
            throw new IllegalArgumentException("Inválido: o número inteiro deve ser de 1 a 20.");
        }

        while (inteiro > 0) {
            int numeroEncontrado = 0;
            for (int numero = 0; numero < inteiros.length; numero++) {
                if (inteiro >= inteiros[numero]) {
                    numeroEncontrado = numero;
                }
            }
            romano += romanos[numeroEncontrado];
            inteiro -= inteiros[numeroEncontrado];
        }

        return romano;
    }

    public static int converteRomanoParaInteiro(String romano) {
        int inteiro = 0;

        for (int numero = 0; numero < romanos.length; numero++) {
            if (romano.indexOf(romanos[numero]) == 0) {
                inteiro = inteiros[numero] + converteRomanoParaInteiro((romano.substring(romanos[numero].length())));
            }
        }

        if (inteiro > 20) {
            throw new IllegalArgumentException("Inválido: o número romano deve ser de I a XX.");
        }

        return inteiro;

    }

}
