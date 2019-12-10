package com.matheussoilegra.coreengineering.tema10;

import java.util.Scanner;

public class Menu {

    private Scanner teclado = new Scanner(System.in);
    private AgendaDAO agendaDAO = new AgendaDAO();

    public Menu() {
    }

    public void inicializador() {
        String novaAcao = "S";
        while (novaAcao.equals("S") || (novaAcao.equals("s"))) {
            System.out.println("Bem-vindo(a) a Agenda.");
            System.out.println("Escolha uma opção abaixo:");
            System.out.println("1 - Adicionar um contato.");
            System.out.println("2 - Remover um contato.");
            System.out.println("3 - Buscar um contato pelo id.");
            System.out.println("4 - Buscar um contato pelo nome.");
            System.out.println("5 - Listar contatos ordenados pelo id.");
            System.out.println("6 - Listar contatos ordenados pelo nome.");
            System.out.println("7 - Sair.");
            String dadoDigitado = teclado.nextLine().toUpperCase();
            switch (dadoDigitado) {
                case "1":
                    adicionarContato();
                    break;
                case "2":
                    removerContato();
                    break;
                case "3":
                    buscarContatoId();
                    break;
                case "4":
                    buscarContatoNome();
                    break;
                case "5":
                    listarContatoId();
                    break;
                case "6":
                    listarContatoNome();
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente uma nova opção.");
            }
            System.out.println("Deseja realizar uma nova ação? [S/N]");
            novaAcao = teclado.nextLine().toUpperCase();
        }
    }

    private void adicionarContato() {
        System.out.println("Informe o nome do contato:");
        String nomeDigitado = teclado.nextLine();

        System.out.println("Informe o telefone do contato:");
        String telefoneDigitado = teclado.nextLine();

        System.out.println("Informe o e-mail do contato:");
        String emailDigitado = teclado.nextLine();

        agendaDAO.adicionarContato(new Contato(nomeDigitado, telefoneDigitado, emailDigitado));
    }

    private void removerContato() {
        listarContatoId();
        System.out.println("Informe o id do contato:");
        int idDigitado = teclado.nextInt();
        agendaDAO.removerContato(idDigitado);
    }

    private void buscarContatoId() {
        System.out.println("Informe o id do contato:");
        int idBuscadoDigitado = teclado.nextInt();
        System.out.println(agendaDAO.buscarContatoId(idBuscadoDigitado));
    }

    private void buscarContatoNome() {
        System.out.println("Informe o nome do contato:");
        String nomeBuscadoDigitado = teclado.nextLine();
        System.out.println(agendaDAO.buscarContatoNome(nomeBuscadoDigitado));
    }

    private void listarContatoId() {
        System.out.println(agendaDAO.listarContatosOrdenadosId());
    }

    private void listarContatoNome() {
        System.out.println(agendaDAO.listarContatosOrdenadosNome());
    }
}
