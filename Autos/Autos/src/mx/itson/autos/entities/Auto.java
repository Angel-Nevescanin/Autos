/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.autos.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itson.autos.persistence.MySQLConnection;

/**
 *
 * @author angel
 */
public class Auto {
    private int idAuto;
    private String Marca;
    private String Modelo;
    private int año;
    private double Precio;
    private String Descripcion;

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public static List<Auto> getAll(String filtro) {
        List<Auto> auto = new ArrayList<>();
        try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM auto WHERE marca LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Auto o = new Auto();
                o.setIdAuto(resultSet.getInt(1));
                o.setMarca(resultSet.getString(2));
                o.setModelo(resultSet.getString(3));
                o.setAño(resultSet.getByte(4));
                o.setPrecio(resultSet.getDouble(5));
                o.setDescripcion(resultSet.getString(6));
                auto.add(o);
            }
        } catch (SQLException ex) {

        }
        return auto;
    }

    //Metodo para guardar un nuevo cliente
    public boolean save(String marca, String modelo, int año, double precio, String descripcion) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO auto (marca, modelo, año, precio, descripcion) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, marca);
            statement.setString(2, modelo);
            statement.setInt(3, año);
            statement.setDouble(4, precio);
            statement.setString(5, descripcion);
            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());

        }
        return result;
    }

    //Metodo para actualizar o editar un cliente existenten
    public boolean update(int id, String marca, String modelo, int año, double precio, String descripcion) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE auto SET marca = ?, modelo = ?, año = ?, precio = ?, descripcion = ? WHERE idauto = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, marca);
            statement.setString(2, modelo);
            statement.setInt(3, año);
            statement.setDouble(4, precio);
            statement.setString(5, descripcion);
            statement.setInt(6, id);
            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());

        }
        return result;
    }

    //Metodo para eliminar un administrador ya existenten.
    public boolean delete(int id) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "DELETE FROM auto WHERE idauto = ?";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setInt(1, id);
            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());

        }
        return result;
    }    
}
