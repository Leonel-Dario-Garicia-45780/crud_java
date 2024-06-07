package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static void main(String[] args) {
        // URL de conexión, nombre de usuario y contraseña
        String url = "jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos";
        String user = "nombre_de_usuario";
        String password = "contraseña";

        Connection connection = null;

        try {
            // Establecer la conexión
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexión establecida exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
