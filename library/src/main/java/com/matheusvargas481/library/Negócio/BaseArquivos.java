package com.matheussoilegra.coreengineering.tema8.Negócio;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.matheussoilegra.coreengineering.tema8.Entidades.Emprestimo;
import com.matheussoilegra.coreengineering.tema8.Entidades.Livro;
import com.matheussoilegra.coreengineering.tema8.Entidades.Usuario;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BaseArquivos {

    private static String caminhoLivros = "Livros.json";
    public static String caminhoUsuarios = "Usuarios.json";
    public static String caminhoEmprestimos = "Emprestimos.json";

    public static void criarArquivoLivros() {
        Path livrosPath = Paths.get(caminhoLivros);

        if (!Files.exists(livrosPath)) {
            try {
                Files.createFile(livrosPath);
            } catch (IOException e) {
                System.out.println("Arquivo de livros já criado." + e);
            }
        }
    }
    
    public static void criarArquivoUsuarios() {
        Path usuariosPath = Paths.get(caminhoUsuarios);

        if (!Files.exists(usuariosPath)) {
            try {
                Files.createFile(usuariosPath);
            } catch (IOException e) {
                System.out.println("Arquivo de usuários já criado." + e);
            }
        }
    }

    public static void criarArquivoEmprestimos() {
        Path emprestimosPath = Paths.get(caminhoEmprestimos);

        if (!Files.exists(emprestimosPath)) {
            try {
                Files.createFile(emprestimosPath);
            } catch (IOException e) {
                System.out.println("Arquivo de empréstimos já criado." + e);
            }
        }
    }

    public static void escreverArquivoLivros(List<Livro> livros) {
        Gson gson = new Gson();
        String json = gson.toJson(livros);
        Path livrosPath = Paths.get(caminhoLivros);

        if (Files.exists(livrosPath)) {
            try (FileWriter writer = new FileWriter(caminhoLivros)) {
                writer.write(json);
            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo de livros. " + e);
            }
        }
    }

    public static void escreverArquivoUsuarios(List<Usuario> usuarios) {
        Gson gson = new Gson();
        String json = gson.toJson(usuarios);
        Path usuariosPath = Paths.get(caminhoUsuarios);

        if (Files.exists(usuariosPath)) {
            try (FileWriter writer = new FileWriter(caminhoUsuarios)) {
                writer.write(json);
            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo de usuários. " + e);
            }
        }
    }

    public static void escreverArquivoEmprestimos(List<Emprestimo> emprestimos) {
        Gson gson = new Gson();
        String json = gson.toJson(emprestimos);
        Path emprestimosPath = Paths.get(caminhoEmprestimos);

        if (Files.exists(emprestimosPath)) {
            try (FileWriter writer = new FileWriter(caminhoEmprestimos)) {
                writer.write(json);
            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo de empréstimos. " + e);
            }
        }
    }

    public static List<Livro> lerArquivoLivros() {
        Type typeFound = new TypeToken<ArrayList<Livro>>() {
        }.getType();
        Path livrosPath = Paths.get(caminhoLivros);

        if (!Files.exists(livrosPath)) {
            criarArquivoLivros();
        } else {
            try (BufferedReader jsonReader = new BufferedReader(new FileReader(caminhoLivros))) {
                List<Livro> listaLivros = new Gson().fromJson(jsonReader, typeFound);
                return listaLivros;
            } catch (IOException e) {
                System.out.println("Erro ao ler arquivo de livros. " + e);
            }
        }
        return new ArrayList<>();
    }

    public static List<Usuario> lerArquivoUsuarios() {
        Type typeFound = new TypeToken<ArrayList<Usuario>>() {
        }.getType();
        Path usuariosPath = Paths.get(caminhoUsuarios);

        if (!Files.exists(usuariosPath)) {
            criarArquivoUsuarios();
        } else {
            try (BufferedReader jsonReader = new BufferedReader(new FileReader(caminhoUsuarios))) {
                List<Usuario> listaUsuarios = new Gson().fromJson(jsonReader, typeFound);
                return listaUsuarios;
            } catch (IOException e) {
                System.out.println("Erro ao ler arquivo de usuários. " + e);
            }
        }
        return new ArrayList<>();
    }

    public static List<Emprestimo> lerArquivoEmprestimos() {
        Type typeFound = new TypeToken<ArrayList<Emprestimo>>() {
        }.getType();
        Path emprestimosPath = Paths.get(caminhoEmprestimos);

        if (!Files.exists(emprestimosPath)) {
            criarArquivoEmprestimos();
        } else {
            try (BufferedReader jsonReader = new BufferedReader(new FileReader(caminhoEmprestimos))) {
                List<Emprestimo> listaEmprestimos = new Gson().fromJson(jsonReader, typeFound);
                return listaEmprestimos;
            } catch (IOException e) {
                System.out.println("Erro ao ler arquivo de empréstimos. " + e);
            }
        }
        return new ArrayList<>();
    }
}