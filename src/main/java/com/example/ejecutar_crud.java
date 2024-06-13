package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ejecutar_crud {
    private static final String url = "jdbc:mysql://localhost:3306/base_de_java_mañana";
    private static final String user = "root";
    private static final String password = "";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Ejecutar el CRUD completo
            ejecutarCRUD(conn);
        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos: " + e.getMessage());
        }
    }

    // Método para ejecutar el CRUD completo sobre la tabla productos
    public static void ejecutarCRUD(Connection conn) {
        try {
            // Insertar un nuevo producto
            CRUD.insertarProducto(conn, "Producto A", 19.99, "Descripción del Producto A");
            // Obtener todos los productos
            System.out.println("---- Productos actuales ----");
            CRUD.obtenerProductos(conn);
            // Actualizar un producto
            CRUD.actualizarProducto(conn, "Producto A", 29.99);
            // Obtener todos los productos después de la actualización
            System.out.println("---- Productos después de actualizar ----");
            CRUD.obtenerProductos(conn);
            // Eliminar un producto
            CRUD.eliminarProducto(conn, "Producto A");
            // Obtener todos los productos después de la eliminación
            System.out.println("---- Productos después de eliminar ----");
            CRUD.obtenerProductos(conn);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el CRUD: " + e.getMessage());
        }
    }
}
