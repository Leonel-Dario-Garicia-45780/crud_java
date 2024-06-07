package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductManager {
    private static final String url = "jdbc:mysql://localhost:3306/base_de_java_mañana";
    private static final String user = "root";
    private static final String password = "";

    public static void agregarProducto(String nombre, double precio, String descripcion) {
        String sql = "INSERT INTO productos (nombre, precio, descripcion) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setString(3, descripcion);
            
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Producto agregado exitosamente.");
            } else {
                System.out.println("No se pudo agregar el producto.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar el producto: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        agregarProducto("Producto de ejemplo", 10.99, "Descripción del producto de ejemplo");
    }
}
