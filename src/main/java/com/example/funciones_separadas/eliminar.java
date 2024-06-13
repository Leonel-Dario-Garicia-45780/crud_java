package com.example.funciones_separadas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class eliminar {
    private static final String url = "jdbc:mysql://localhost:3306/base_de_java_mañana";
    private static final String user = "root";
    private static final String password = "";

    // Método para eliminar un producto por su ID
    public static void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Producto eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un producto con el ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        eliminarProducto(1); // Llama al método para eliminar el producto con ID 1
        //!    tener en cuenta que el id en la bas de datos "base_de_java_mañana" es autoincrementable
    }
}

