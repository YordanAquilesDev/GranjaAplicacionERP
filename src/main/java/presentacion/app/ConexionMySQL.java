/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class ConexionMySQL {
  
    public static Connection getConexion() {
        Connection conexion = null;
        try {
            // 1. CORREGIDO: Clase del driver correcta para MySQL moderno
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/granjadb";
            conexion = DriverManager.getConnection(url, "root", "root");

        } catch (ClassNotFoundException e) {
            System.err.println("¡Error! No se encontró el driver de MySQL en el proyecto.");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.err.println("¡Error! No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        
        return conexion;
    }
    
}
