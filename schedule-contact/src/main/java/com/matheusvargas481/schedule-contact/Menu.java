package com.matheussoilegra.coreengineering.tema6;

import java.util.Scanner;

public class Menu {

    Scanner teclado = new Scanner(System.in);
    private Agenda agenda;
    public Menu() {
        agenda = new Agenda();
    }

    public void inicializador() {
        String novaAcao = "S";

        while (novaAcao.equals("S")) {
            System.out.println("Bem-vindo(a) a Agenda.");
            System.out.println("Escolha uma opção abaixo:");
            System.out.println("1 - Adicionar um contato.");
            System.out.println("2 - Remover um contato.");
            System.out.println("3 - Listar os contatos.");
            System.out.println("4 - Buscar por um contato pelo nome");
            System.out.println("5 - Buscar por um contato pelo id");
            System.out.println("6 - Sair");
            Scanner teclado = new Scanner(System.in);
            String inserirTeclado = teclado.nextLine().toUpperCase();

            switch (inserirTeclado) {
                case "1":
                    adicionarContato();
                    break;
                case "2":
                    removerContato();
                    break;
                case "3":
                    listarContatos();
                    break;
                case "4":
                    pesquisarNome();
                    break;
                case "5":
                    pesquisarId();
                    break;
                case "6":
                    System.exit(0);
                default:
                    throw new IllegalArgumentException("Opção inválida.");
            }
            System.out.println("\nDeseja realizar uma nova ação? [S/N]");
            novaAcao = teclado.next().toUpperCase();
        }
    }

    public void adicionarContato(){
        System.out.println("Informe um id de contato para adicionar:\n ");
        int inserirId = teclado.nextInt();

        System.out.println("Informe um nome de contato para adicionar:\n ");
        String inserirNome = teclado.next();
        agenda.adicionarContato(inserirNome, inserirId);
    }

    public void removerContato() {
        System.out.println("Informe um id de contato para remover:\n ");
        int inserirId = teclado.nextInt();
        agenda.removerContato(inserirId);
    }

    public void listarContatos() {
        if (agenda.listarContatos().isEmpty()) {
            System.out.println("Lista vazia. Adicione novos contatos.");
        }
        for (Contato c : agenda.listarContatos()) {
            System.out.println(c.toString());
        }
    }

    public void pesquisarId() {
        System.out.println("Informe o id do contato:\n ");
        int inserirId = teclado.nextInt();
        System.out.println(agenda.pesquisarId(inserirId));
    }

    public void pesquisarNome() {
        System.out.println("Informe o nome do contato:\n ");
        String inserirNome = teclado.next();
        System.out.println(agenda.pesquisarNome(inserirNome));
    }

}
