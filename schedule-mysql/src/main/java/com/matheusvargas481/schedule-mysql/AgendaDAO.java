package com.matheussoilegra.coreengineering.tema10;

import com.matheussoilegra.coreengineering.tema10.com.matheussoilegra.coreengineering.tema10.exceptions.ContatoNaoEncontradoException;
import com.matheussoilegra.coreengineering.tema10.com.matheussoilegra.coreengineering.tema10.exceptions.ErroAdicionarContatoException;
import com.matheussoilegra.coreengineering.tema10.com.matheussoilegra.coreengineering.tema10.exceptions.ErroConexaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgendaDAO {

    public void adicionarContato(Contato contato) {
        try (
                Connection conexao = ConexaoFactory.abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement("INSERT INTO contato (id, nome, telefone, email) VALUES(?, ?,?,?)");
                ) {
                    preparedStatement.setInt(1, contato.getId());
                    preparedStatement.setString(2, contato.getNome());
                    preparedStatement.setString(3, contato.getTelefone());
                    preparedStatement.setString(4, contato.getEmail());
                    preparedStatement.execute();
                    System.out.println("Contato adicionado.");
                } catch (SQLException e) {
            throw new ErroAdicionarContatoException("Erro ao adicionar: contato inválido.");
        }
    }

    public void removerContato(int id) {
        try (
                Connection conexao = ConexaoFactory.abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM contato WHERE id = ?");
                ) {
                    if (buscarContatoId(id).isPresent()) {
                        preparedStatement.setInt(1, id);
                        preparedStatement.execute();
                        System.out.println("Contato removido.");
                    } else {
                        throw new ContatoNaoEncontradoException("Erro ao remover: contato não encontrado.");
                    }
                } catch (SQLException e) {
            throw new ContatoNaoEncontradoException("Erro ao remover: contato não encontrado.");
        }
    }

    public Optional<Contato> buscarContatoId(int id) {
        try (
                Connection conexao = ConexaoFactory.abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM contato WHERE id = " + id);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            if (resultSet.next()) {
                return Optional.of(new Contato(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("telefone"), resultSet.getString("email")));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new ContatoNaoEncontradoException("Erro ao buscar: contato não encontrado.");
        }
    }

    public Optional<Contato> buscarContatoNome(String nome) {
        try (
                Connection conexao = ConexaoFactory.abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM contato WHERE nome LIKE '%" + nome + "%'");
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            if (resultSet.next()) {
                return Optional.of(new Contato(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("telefone"), resultSet.getString("email")));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new ContatoNaoEncontradoException("Erro ao buscar: contato não encontrado.");
        }
    }

    public List<Contato> listarContatosOrdenadosId() {
        try (
                Connection conexao = ConexaoFactory.abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM contato ORDER BY id");
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            List<Contato> contatos = new ArrayList<>();
            while (resultSet.next()) {
                contatos.add(new Contato(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("telefone"), resultSet.getString("email")));
            }
            return contatos;
        } catch (SQLException e) {
            throw new ContatoNaoEncontradoException("Erro ao listar: contatos não encontrados.");
        }
    }

    public List<Contato> listarContatosOrdenadosNome() {
        try (
                Connection conexao = ConexaoFactory.abrirConexao();
                PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM contato ORDER BY nome");
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            List<Contato> contatos = new ArrayList<>();
            while (resultSet.next()) {
                contatos.add(new Contato(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("telefone"), resultSet.getString("email")));
            }
            return contatos;
        } catch (SQLException e) {
            throw new ContatoNaoEncontradoException("Erro ao listar: contatos não encontrados.");
        }
    }

    public void limparTabela() {
        try (
                Connection conexao = ConexaoFactory.abrirConexao();
                PreparedStatement preparedStatementDeleteContact = conexao.prepareStatement("DELETE FROM contato");
                PreparedStatement preparedStatementAutoIncrement = conexao.prepareStatement("ALTER TABLE contato AUTO_INCREMENT = 1");
        ) {
            preparedStatementDeleteContact.executeUpdate();
            preparedStatementAutoIncrement.executeUpdate();
        } catch (Exception e) {
            throw new ErroConexaoException("Erro na conexão");
        }
    }
}