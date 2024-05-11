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
public class Administrador {
    private int idAdministador;
    private String UsuarioAdm;
    private String ContraseñaAdm;

    public int getIdAdministador() {
        return idAdministador;
    }

    public void setIdAdministador(int idAdministador) {
        this.idAdministador = idAdministador;
    }

    public String getUsuarioAdm() {
        return UsuarioAdm;
    }

    public void setUsuarioAdm(String UsuarioAdm) {
        this.UsuarioAdm = UsuarioAdm;
    }

    public String getContraseñaAdm() {
        return ContraseñaAdm;
    }

    public void setContraseñaAdm(String ContraseñaAdm) {
        this.ContraseñaAdm = ContraseñaAdm;
    }
    
public static List<Administrador> getAll(String filtro) {
        List<Administrador> administrador = new ArrayList<>();
        try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM administrador WHERE usuario LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Administrador o = new Administrador();
                o.setIdAdministador(resultSet.getInt(1));
                o.setContraseñaAdm(resultSet.getString(2));
                administrador.add(o);
            }
        } catch (SQLException ex) {

        }
        return administrador;
    }

    //Metodo para guardar un nuevo cliente
    public boolean save(String usuario, String contraseña) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO administrador (usuario, contraseña) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, contraseña);
            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());

        }
        return result;
    }

    //Metodo para actualizar o editar un cliente existenten
    public boolean update(int id, String usuario, String contraseña) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE administrador SET usuario = ?, contraseña = ?, WHERE idadministrador = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, contraseña);
            statement.setInt(3, id);
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
            String query = "DELETE FROM administrador WHERE idadministrador = ?";
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
