package com.matheussoilegra.coreengineering.tema7;


import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Conversor conversor = new Conversor();

        Scanner teclado = new Scanner(System.in);
        String novaConversao = "S";

        while (novaConversao.equals("S")) {

            System.out.println("Bem-vindo(a) ao Conversor de números");
            System.out.println("Escolha um método de conversão: \n[1 - Conversão de números inteiros para números romanos]\n[2 - Conversão de números romanos para números inteiros]");
            int escolhaConversao = teclado.nextInt();

            switch (escolhaConversao) {
                case (1):
                    System.out.println("Você escolheu conversão de números inteiros para números romanos]");
                    System.out.print("Informe um número inteiro: ");
                    int inteiro = teclado.nextInt();
                    System.out.println("Número romano: " + Conversor.converteInteiroParaRomano(inteiro));
                    break;
                case (2):
                    System.out.println("Você escolheu a conversão de romanos para inteiros:");
                    System.out.print("Informe o número romano: ");
                    teclado.nextLine();
                    String romano = teclado.nextLine();
                    System.out.println("Número inteiro: " + Conversor.converteRomanoParaInteiro(romano));
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida.");

            }
            System.out.println("\nDeseja converter outro número? [S/N]");
            novaConversao = teclado.next().toUpperCase();

        }
    }
}

