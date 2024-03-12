/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author albit
 */
public class Conexion {
    
    
     Conexion() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: exception loading driver class");
        }
    }

    //establecemos la conexion con la base de datos con la url y nombre de usuario mas contraseña
    public static Connection getConnection() throws SQLException{
        Connection conexion = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: exception loading driver class");
        }
        try {
            String url = "jdbc:derby://localhost:1527/java10";
            conexion = DriverManager.getConnection(url, "java10", "java10");
            System.out.println("Se ha conectado exitosamente");

        } catch (SQLException e) {
            System.out.println("Error, no se ha conectado");
        }

        return conexion;
    }
    
    public boolean entrar(String Usuario, String Contrasena) {
        Connection conexion = null;
        PreparedStatement pstatement;
        ResultSet resultSet = null;
        boolean ENTRA = false;
        System.out.println(Usuario);
        System.out.println(Contrasena);
        try {
            conexion = (Connection) getConnection();

            pstatement = conexion.prepareStatement("select idtienda, nomtienda, fecha_apertura, municipio, stockTotal, fototienda from tienda WHERE nomtienda = ? AND contrasena =?");
       
            pstatement.setString(1, Usuario);
            pstatement.setString(2, Contrasena);

            resultSet = pstatement.executeQuery();
           
            if (resultSet.next()) {
                ENTRA = true;
             
            }
           
        } catch (SQLException Ex) {
        } 
        return ENTRA;
    }


    //estos metodos cierran los recursos de resultset, statement y conection
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (Exception ignored) {
        }
    }

    public static void close(Statement stmt){
        try {
            stmt.close();
        } catch (Exception ignored) {
        }
    }

    public static void close(Connection conn){
        try {
            conn.close();
        } catch (Exception ignored) {
        }
    }

    
}
