package com.matheussoilegra.coreengineering.tema8.Negócio;

import com.matheussoilegra.coreengineering.tema8.Entidades.Emprestimo;
import com.matheussoilegra.coreengineering.tema8.Entidades.Livro;
import com.matheussoilegra.coreengineering.tema8.Entidades.Usuario;

import java.util.Scanner;

public class Menu {

    private Biblioteca biblioteca = new Biblioteca();

    public Menu() {
        biblioteca.lerArquivoEmprestimos();
        biblioteca.lerArquivoLivros();
        biblioteca.lerArquivoUsuarios();
        if (!biblioteca.listarLivros().isEmpty()) {
            Livro.aux(1 + biblioteca.listarLivros().get(biblioteca.listarLivros().size()-1).getId());
        }
        if (!biblioteca.listarEmprestimos().isEmpty()) {
            Emprestimo.aux(1 + biblioteca.listarEmprestimos().get(biblioteca.listarEmprestimos().size() - 1).getIdEmprestimo());
        }

    }

    Scanner teclado = new Scanner(System.in);

    public void inicializador() {
        String novaAcao = "S";

        while (novaAcao.equals("S")) {
            System.out.println("Bem-vindo(a) a Biblioteca.");
            System.out.println("Escolha uma opção abaixo:");
            System.out.println("1 - Cadastrar um(a) usuário(a).");
            System.out.println("2 - Cadastrar um livro.");
            System.out.println("3 - Listar usuários(as).");
            System.out.println("4 - Listar livros.");
            System.out.println("5 - Buscar usuário(a) por nome.");
            System.out.println("6 - Buscar livro por título ou autor(a).");
            System.out.println("7 - Excluir livro.");
            System.out.println("8 - Listar empréstimos.");
            System.out.println("9 - Fazer empréstimo.");
            System.out.println("10 - Renovar empréstimo.");
            System.out.println("11 - Devolver livros.");
            System.out.println("12 - Exibir livros atrasados.");
            System.out.println("13 - Exibir livros emprestados.");
            System.out.println("14 - Exibir top 10 usuários(as) locadores(as).");
            System.out.println("15 - Sair.");
            Scanner teclado = new Scanner(System.in);
            String inserirTeclado = teclado.nextLine().toUpperCase();

            switch (inserirTeclado) {
                case "1":
                    cadastrarUsuario();
                    salvarDados();
                    break;
                case "2":
                    cadastrarLivro();
                    salvarDados();
                    break;
                case "3":
                    listarUsuarios();
                    break;
                case "4":
                    listarLivros();
                    break;
                case "5":
                    buscarUsuarioNome();
                    break;
                case "6":
                    buscarLivroTituloAutor();
                    break;
                case "7":
                    excluirLivro();
                    salvarDados();
                    break;
                case "8":
                    listarEmprestimos();
                    break;
                case "9":
                    fazerEmprestimo();
                    salvarDados();
                    break;
                case "10":
                    renovarEmprestimo();
                    salvarDados();
                    break;
                case "11":
                    devolverLivros();
                    salvarDados();
                    break;
                case "12":
                    exibirLivrosAtrasados();
                    break;
                case "13":
                    exibirLivrosEmprestados();
                    break;
                case "14":
                    exibirTopDezUsuariosLocadores();
                    break;
                case "15":
                    System.exit(0);
                default:
                    throw new IllegalArgumentException("Opção inválida.");
            }
            System.out.println("\nDeseja realizar uma nova ação? [S/N]");
            novaAcao = teclado.next().toUpperCase();
        }
    }

    public void cadastrarUsuario() {
        System.out.println("Informe o nome do(a) usuário(a):\n ");
        String inserirNome = teclado.nextLine();
        biblioteca.cadastrarUsuario(new Usuario(inserirNome));
    }

    public void cadastrarLivro() {
        System.out.println("Informe o título do livro:\n ");
        String inserirTitulo = teclado.next().toUpperCase();

        System.out.println("Informe o(a) autor(a) do livro:\n ");
        Scanner tecladoAutor = new Scanner(System.in);
        String inserirAutor = tecladoAutor.nextLine().toUpperCase();
        biblioteca.cadastrarLivro(new Livro(inserirTitulo, inserirAutor));
    }

    public void listarUsuarios() {
        if (biblioteca.listarUsuarios().isEmpty()) {
            System.out.println("Lista vazia. Adicione novos(as) usuários(as).");
        }
        for (Usuario usuario : biblioteca.listarUsuarios()) {
            System.out.println(usuario.toString());
        }
    }

    public void listarLivros() {
        if (biblioteca.listarLivros().isEmpty()) {
            System.out.println("Lista vazia. Adicione novos livros.");
        }
        for (Livro livro : biblioteca.listarLivros()) {
            System.out.println(livro.toString());
        }
    }

    public void buscarUsuarioNome() {
        System.out.println("Informe o nome do(a) usuário(a): ");
        String inserirNome = teclado.next();
        System.out.println(biblioteca.buscarNomeUsuario(inserirNome));
    }

    public void buscarLivroTituloAutor() {
        System.out.println("Informe o título ou autor(a) do livro: ");
        String inserirTituloAutor = teclado.next();
        System.out.println(biblioteca.buscarLivro(inserirTituloAutor));
    }

    private void excluirLivro() {
        listarLivros();
        System.out.println("Informe o id do livro: ");
        int inserirId = teclado.nextInt();
        biblioteca.excluirLivro(inserirId);
    }

    public void listarEmprestimos() {
        for (Emprestimo emprestimo : biblioteca.listarEmprestimos()) {
            System.out.println(emprestimo.toString());
        }
        if (biblioteca.listarEmprestimos().isEmpty()) {
            System.out.println("Lista vazia. Adicione novos empréstimos");
        }
    }

    public void fazerEmprestimo() {
        Usuario usuario;
        Livro livro;

        listarLivros();
        System.out.println("Informe o id do livro");
        int inserirId = teclado.nextInt();
        livro = biblioteca.buscarLivroId(inserirId);

        listarUsuarios();
        System.out.println("Informe o nome do(a) usuário(a)");
        Scanner tecladoNome = new Scanner(System.in);
        String inserirNome = tecladoNome.nextLine();
        usuario = biblioteca.buscarNomeUsuario(inserirNome);

        biblioteca.fazerEmprestimo(usuario, livro);
    }

    public void renovarEmprestimo() {
        biblioteca.listaLivrosEmprestados();
        System.out.println("Informe o id do livro");
        int inserirId = teclado.nextInt();
        biblioteca.fazerRenovacao(inserirId);
    }

    public void devolverLivros() {
        biblioteca.listaLivrosEmprestados();
        System.out.println("Informe o nome do(a) usuário(a): ");
        String inserirNome = teclado.next();
        System.out.println("Informe o id do livro: ");
        int inserirLivro = teclado.nextInt();
        biblioteca.fazerDevolucao(biblioteca.buscarNomeUsuario(inserirNome), biblioteca.buscarLivroId(inserirLivro));
    }

    public void exibirLivrosEmprestados() {
        biblioteca.listaLivrosEmprestados();
    }

    public void exibirTopDezUsuariosLocadores() {
        biblioteca.topDezUsuariosLocadores().forEach(usuario->System.out.println(usuario.getNome() + " ; quantidade de livros alugados: " + usuario.getQuantidadeLivrosEmprestados()));
    }

    public void exibirLivrosAtrasados() {
        biblioteca.livrosAtrasados();
    }

    private void salvarDados() {
        biblioteca.escreverArquivoLivros();
        biblioteca.escreverArquivoUsuarios();
        biblioteca.escreverArquivoEmprestimos();
    }

}