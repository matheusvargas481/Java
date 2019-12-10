package com.matheussoilegra.coreengineering.tema10;

import com.matheussoilegra.coreengineering.tema10.com.matheussoilegra.coreengineering.tema10.exceptions.ErroConexaoException;
import com.matheussoilegra.coreengineering.tema10.com.matheussoilegra.coreengineering.tema10.exceptions.ErroLerArquivoConfiguracaoException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConexaoFactory {

    public static Connection abrirConexao() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new ErroLerArquivoConfiguracaoException("Erro ao ler o arquivo de configuração da conexão.");
        }
        try {
            Class.forName(properties.getProperty("db.driver"));
            return DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.user"), properties.getProperty("db.password"));
        } catch (ClassNotFoundException | SQLException e) {
            throw new ErroConexaoException("Erro na conexão.");
        }
    }
}


