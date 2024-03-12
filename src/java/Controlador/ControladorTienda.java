/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author albit
 */
public class ControladorTienda {
    static String usuario;
    static ResultSet resultado;

    public ControladorTienda() {

    }

    public static int obtenerTiendaRegistrada(String usuario) {
        int codigoTiendaRegistrada = -1;
        Connection conexion = null;
        PreparedStatement pstatement;
        
        try {
            conexion = (Connection) getConnection();
            pstatement = conexion.prepareStatement("SELECT idtienda FROM tienda WHERE nomtienda = ?");
            pstatement.setString(1, usuario);

            resultado = pstatement.executeQuery();

            if (resultado.next()) {
                codigoTiendaRegistrada = resultado.getInt("idtienda");
            }

            resultado.close();
            pstatement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return codigoTiendaRegistrada;
    }

}
