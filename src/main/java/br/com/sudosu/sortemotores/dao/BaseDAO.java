package br.com.sudosu.sortemotores.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vinicius Vianna
 */
public class BaseDAO {

    public BaseDAO() {

        try {
//            Necessário para utilizar o driver JDBC do MySQL
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
//            Erro de driver JDBC(adicione o driver .jar do MySQL em /WEB-INF/lib)
                e.printStackTrace();
        }//fecha catch
    }//fecha construtor
    protected Connection getConnection() throws SQLException{
//        URL de conexão com o banco de dados
          String url = "jdbc:mysql://localhost:3306/sortemotores";
          String usuario = "root";
          String senha = "password";
//          Conecta utilizando a URL, usuário e senha
          Connection conn = DriverManager.getConnection(url, usuario, senha);
          return conn;
    }
}//fecha classe
