package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/trabalho";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "3382";

    private static Connection connection;

    private DatabaseManager() {
    }

    public static Connection getConnection(){
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao conectar no Banco de Dados!");
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            	connection = null;
            }
        }
    }

    public static void setConnection(Connection connection2) {
        connection = connection2;
    }
}
