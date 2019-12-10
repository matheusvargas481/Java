package com.matheussoilegra.coreengineering.tema8.Negócio;

import com.matheussoilegra.coreengineering.tema8.Exceptions.*;
import com.matheussoilegra.coreengineering.tema8.Entidades.Emprestimo;
import com.matheussoilegra.coreengineering.tema8.Entidades.Livro;
import com.matheussoilegra.coreengineering.tema8.Entidades.Usuario;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {

    public List<Livro> livros = new ArrayList<>();
    public List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private final int VALOR_DIA_ATRASO = 5;
    private final int QUANTIDADE_MAXIMA_EMPRESTIMOS = 5;
    private final int PRAZO_ENTREGA = 7;
    private final int QUANTIDADE_TOP_LOCADORES = 10;

    public Biblioteca() {
        lerArquivoLivros();
        lerArquivoUsuarios();
        lerArquivoEmprestimos();
        escreverArquivoLivros();
        escreverArquivoUsuarios();
        escreverArquivoEmprestimos();
    }

    public void cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public Usuario buscarNomeUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        throw new UsuarioNaoEncontradoException();
    }

    public void cadastrarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public Livro buscarLivro(String tituloOuAutor) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(tituloOuAutor) || livro.getAutor().equals(tituloOuAutor)) {
                return livro;
            }
        }
        throw new LivroNaoEncontradoException();
    }

    public Livro buscarLivroId(int idLivro) {
        for (Livro livro : livros) {
            if (livro.getId() == idLivro) {
                return livro;
            }
        }
        throw new LivroNaoEncontradoException();
    }

    public void excluirLivro(int idLivro) {
        Livro livro = buscarLivroId(idLivro);
        if (livro != null && !livro.getEmprestado()) {
            livros.remove(livro);
        }  else  {
            throw new LivroJaEmprestadoException();
        }
    }

    public void fazerEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getEmprestado()) {
            throw new LivroJaEmprestadoException();
        }

        if (usuario.getLivrosEmprestados() >= QUANTIDADE_MAXIMA_EMPRESTIMOS) {
            throw new UsuarioComLimiteEmprestimosException();
        }

        emprestimos.add(new Emprestimo(usuario, livro));
        usuario.livrosEmprestimo();
        livro.setEmprestado(true);
    }

    public int calcularDiasAtraso(int idEmprestimo) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getIdEmprestimo() == idEmprestimo) {
               return (int) ChronoUnit.DAYS.between(emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao());
            }
        }
        throw new EmprestimoNaoEncontradoException();
    }

    public int calcularValorMulta(int idEmprestimo) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getIdEmprestimo() == idEmprestimo) {
                final int valorMulta = calcularDiasAtraso(idEmprestimo)*VALOR_DIA_ATRASO;
                return valorMulta;
            }
        }
        throw new EmprestimoNaoEncontradoException();
    }

    public void fazerRenovacao(int idEmprestimo) {
        for (Emprestimo emprestimo : emprestimos) {
            if (calcularDiasAtraso(idEmprestimo) > PRAZO_ENTREGA) {
                throw new UsuarioComLimiteDiasAtrasoException();
            }

            if (emprestimo.getIdEmprestimo() == idEmprestimo) {
                emprestimo.setDataRenovacao(emprestimo.getDataEmprestimo().plusDays(PRAZO_ENTREGA));
            }
        }
    }

    public void fazerDevolucao(Usuario usuario, Livro livro) {
        Emprestimo emprestimo = (emprestimos.stream().filter(emprestimoFiltro -> emprestimoFiltro.getLivro().getId() == livro.getId() && emprestimoFiltro.getUsuario().getNome().equals(usuario.getNome())).findAny().orElse(null));
        if (calcularDiasAtraso(emprestimo.getIdEmprestimo()) > PRAZO_ENTREGA) {
            livro.setEmprestado(false);
            emprestimos.remove(emprestimo);
            usuario.adicionarUsuarioAtrasadoLista(livro, calcularDiasAtraso(emprestimo.getIdEmprestimo()));
            System.out.println("Usuário possui multa de " + calcularValorMulta(emprestimo.getIdEmprestimo()) + " reais devido a um atraso de " + calcularDiasAtraso(emprestimo.getIdEmprestimo()) + " dias!");
        } else {
            livro.setEmprestado(false);
            emprestimos.remove(emprestimo);
        }
    }

    public List<Usuario> topDezUsuariosLocadores() {
        return this.usuarios.stream().limit(QUANTIDADE_TOP_LOCADORES).sorted(Comparator.comparing(Usuario::getQuantidadeLivrosEmprestados).reversed()).collect(Collectors.toList());
    }

    public void livrosAtrasados() {
        for (Usuario u : usuarios) {
            Map<Livro, Integer> listaAtrasados = u.getEmprestimosAtrasados();

            if (!listaAtrasados.isEmpty()) {
                System.out.println("\n" + u.getNome() + ":");
                listaAtrasados.forEach((key, value) -> System.out.println("Livro: " + key + "; - Dias de atraso: " + value));
            }
        }
    }

    public void listaLivrosEmprestados() {
        if (!emprestimos.isEmpty()) {
            emprestimos.stream().forEach(emprestimo -> {
                System.out.println("Id livro : " + emprestimo.getLivro().getId() + "; Título do livro: " + emprestimo.getLivro().getTitulo() + "; Usuário: " + emprestimo.getUsuario().getNome());
            });
        } else {
            System.out.println("Sem livros emprestados.");
        }
    }

    public void limparListas() {
        livros.clear();
        usuarios.clear();
        emprestimos.clear();
    }

    public void lerArquivoUsuarios() {
        usuarios = BaseArquivos.lerArquivoUsuarios();
    }

    public void escreverArquivoUsuarios() {
        BaseArquivos.escreverArquivoUsuarios(usuarios);
    }

    public void lerArquivoLivros() {
        livros = BaseArquivos.lerArquivoLivros();
    }

    public void escreverArquivoLivros() {
        BaseArquivos.escreverArquivoLivros(livros);
    }

    public void lerArquivoEmprestimos() {
        emprestimos = BaseArquivos.lerArquivoEmprestimos();
    }

    public void escreverArquivoEmprestimos() {
        BaseArquivos.escreverArquivoEmprestimos(emprestimos);
    }

}

