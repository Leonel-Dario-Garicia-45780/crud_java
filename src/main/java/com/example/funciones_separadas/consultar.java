//package com.example;
package com.example.funciones_separadas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class consultar {
    private static final String url = "jdbc:mysql://localhost:3306/base_de_java_mañana";
    private static final String user = "root";
    private static final String password = "";

    // Método para obtener un producto por su ID
    // public static void obtenerProductoPorId(int id) {
    //     String sql = "SELECT * FROM productos WHERE id = ?";

    //     try (Connection conn = DriverManager.getConnection(url, user, password);
    //          PreparedStatement stmt = conn.prepareStatement(sql)) {
    //         stmt.setInt(1, id);

    //         try (ResultSet rs = stmt.executeQuery()) {
    //             if (rs.next()) {
    //                 String nombre = rs.getString("nombre");
    //                 double precio = rs.getDouble("precio");
    //                 String descripcion = rs.getString("descripcion");

    //                 System.out.printf("ID: %d, Nombre: %s, Precio: %.2f, Descripción: %s%n", id, nombre, precio, descripcion);
    //             } else {
    //                 System.out.println("No se encontró un producto con el ID: " + id);
    //             }
    //         }
    //     } catch (SQLException e) {
    //         System.out.println("Error al obtener el producto: " + e.getMessage());
    //     }
    // }

    public static void obtenerProductos() {
        String sql = "SELECT * FROM productos";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String descripcion = rs.getString("descripcion");

                System.out.printf("ID: %d, Nombre: %s, Precio: %.2f, Descripción: %s%n", id, nombre, precio, descripcion);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los productos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
     //   obtenerProductoPorId(1); // Cambia el ID según sea necesario
        obtenerProductos();
    }
}
