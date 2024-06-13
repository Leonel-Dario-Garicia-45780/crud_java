package com.example.funciones_separadas;

//xpackage com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class editar {
    private static final String url = "jdbc:mysql://localhost:3306/base_de_java_mañana";
    private static final String user = "root";
    private static final String password = "";

    // Método para editar un producto por su ID
    public static void editarProducto(int id, String nuevoNombre, double nuevoPrecio, String nuevaDescripcion) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, descripcion = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nuevoNombre);
            stmt.setDouble(2, nuevoPrecio);
            stmt.setString(3, nuevaDescripcion);
            stmt.setInt(4, id);

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Producto editado exitosamente.");
            } else {
                System.out.println("No se pudo editar el producto.");
            }
        } catch (SQLException e) {
            System.out.println("Error al editar el producto: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        editarProducto(1, "Nuevo nombre", 15.99, "Nueva descripción");
    }
}
