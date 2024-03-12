/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulos;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author albit
 */
public class ControladorArticulos {

    private Connection conexion;

    public ControladorArticulos() {
        try {

            conexion = Conexion.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    public BigDecimal calcularStock (int codigo) throws SQLException {

        BigDecimal stockTotal = null;
        ResultSet rs;
        String sql = "select sum(stock) from articulos a, tienda t where a.IDTIENDA = t.IDTIENDA and t.IDTIENDA = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, codigo);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                stockTotal = rs.getBigDecimal(1);
            }

        }

        return stockTotal;

    }

    
    public ArrayList<Articulos> listaArticulos(String nombre) throws SQLException {
        ArrayList<Articulos> listaArticulos = new ArrayList<>();
        ResultSet rs;

        String sql = "SELECT a.IDARTICULO, a.IDTIENDA, a.NOMBRE, a.DESCRIPCION, a.PRECIO, a.STOCK, a.FOTO FROM articulos a, tienda t where a.IDTIENDA = t.IDTIENDA and NOMTIENDA =?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int idArt = rs.getInt("IDARTICULO");
                int idTienda = rs.getInt("IDTIENDA");
                String nomArt = rs.getString("NOMBRE");
                String descArt = rs.getString("DESCRIPCION");
                BigDecimal precio = rs.getBigDecimal("PRECIO");
                int stock = rs.getInt("STOCK");
                String foto = rs.getString("FOTO");

                listaArticulos.add(new Articulos (idArt, idTienda, nomArt, descArt, precio, stock, foto));

            }

        }

        return listaArticulos;

    }
    
     public void insertarArticulo (Articulos art) throws SQLException {
        Articulos articulo = art;
        ResultSet rs = null;

        String sql = "INSERT INTO articulos (IDARTICULO, IDTIENDA, NOMBRE, DESCRIPCION, PRECIO, STOCK, FOTO) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setInt(1, art.getIdarticulo());
        preparedStatement.setInt(2, art.getIdtienda());
        preparedStatement.setString(3, art.getNombre());
        preparedStatement.setString(4, art.getDescripcion());
        preparedStatement.setBigDecimal(5, art.getPrecio());
        preparedStatement.setInt(6, art.getStock());
        preparedStatement.setString(7, art.getFoto());

        preparedStatement.executeUpdate();
            System.out.println("insertado");
    }
        

    }
}
