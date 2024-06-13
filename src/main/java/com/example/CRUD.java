package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {

    // Método para insertar un nuevo producto en la base de datos
    public static void insertarProducto(Connection conexion, String nombre, double precio, String descripcion) throws SQLException {
        String query = "INSERT INTO productos (nombre, precio, descripcion) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, nombre);
            statement.setDouble(2, precio);
            statement.setString(3, descripcion);
            statement.executeUpdate();
            System.out.println("Producto insertado con éxito.");
        }
    }

    // Método para obtener todos los productos de la base de datos
    public static void obtenerProductos(Connection conexion) throws SQLException {
        String query = "SELECT * FROM productos";
        try (PreparedStatement statement = conexion.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                String descripcion = resultSet.getString("descripcion");
                System.out.printf("ID: %d, Nombre: %s, Precio: %.2f, Descripción: %s%n", id, nombre, precio, descripcion);
            }
        }
    }

    // Método para actualizar un producto en la base de datos por su nombre
    public static void actualizarProducto(Connection conexion, String nombre, double nuevoPrecio) throws SQLException {
        String query = "UPDATE productos SET precio = ? WHERE nombre = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setDouble(1, nuevoPrecio);
            statement.setString(2, nombre);
            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Producto actualizado con éxito.");
            } else {
                System.out.println("No se encontró ningún producto con el nombre especificado.");
            }
        }
    }

    // Método para eliminar un producto de la base de datos por su nombre
    public static void eliminarProducto(Connection conexion, String nombre) throws SQLException {
        String query = "DELETE FROM productos WHERE nombre = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, nombre);
            int filasEliminadas = statement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Producto eliminado con éxito.");
            } else {
                System.out.println("No se encontró ningún producto con el nombre especificado.");
            }
        }
    }
}
