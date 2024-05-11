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
import javax.swing.JOptionPane;
import mx.itson.autos.enume.TipoCuenta;
import mx.itson.autos.persistence.MySQLConnection;
import mx.itson.autos.ui.MainAutos;

/**
 *
 * @author angel
 */
public class Clientes {

    private int idCliente;
    private String nombreCliente;
    private String correoCliente;
    private String contraseñaCliente;
    private TipoCuenta tipoCuenta;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getContraseñaCliente() {
        return contraseñaCliente;
    }

    public void setContraseñaCliente(String contraseñaCliente) {
        this.contraseñaCliente = contraseñaCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    //Metodo para poder obtener todos los datos de cliente
    public static List<Clientes> getAll(String filtro) {
        List<Clientes> clientes = new ArrayList<>();
        try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM cliente WHERE nombre LIKE ?");
            statement.setString(1, "%" + filtro + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Clientes o = new Clientes();
                o.setIdCliente(resultSet.getInt(1));
                o.setNombreCliente(resultSet.getString(2));
                o.setCorreoCliente(resultSet.getString(3));
                o.setContraseñaCliente(resultSet.getString(4));
                o.setTipoCuenta(TipoCuenta.cliente);

                clientes.add(o);
            }
        } catch (SQLException ex) {

        }
        return clientes;
    }

    //Metodo para guardar un nuevo cliente
    public boolean save(String nombre, String correo, String contraseña, String tipoCuenta) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO cliente (nombre, correo, password, tipocuenta) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, correo);
            statement.setString(3, contraseña);
            statement.setString(4, tipoCuenta.toString()); // Convertir el tipo de cuenta a String

            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());

        }
        return result;
    }

    //Metodo para actualizar o editar un cliente existenten
    public boolean update(int id, String nombre, String correo, String contraseña, String tipoCuenta) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE cliente SET nombre = ?, correo = ?, password = ?, tipocuenta = ?, WHERE idcliente = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, correo);
            statement.setString(3, contraseña);
            statement.setString(4, tipoCuenta.toString()); // Convertir el tipo de cuenta a String
            statement.setInt(5, id);
            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());

        }
        return result;
    }

    //Metodo para eliminar un cliente ya existenten.
    public boolean delete(int id) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "DELETE FROM cliente WHERE idcliente = ?";
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

    public static String ComprobarUsuario(String nombre, String contraseña) throws SQLException {
        try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM cliente WHERE nombre LIKE ?");
            statement.setString(1, nombre);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // Verificar si hay algún resultado en el ResultSet
                String contraseñaBD = resultSet.getString("password");
                System.out.println("Contraseña obtenida de la base de datos: " + contraseñaBD); // Agregar mensaje de impresión

                int desplazamiento = 3; // Establece el desplazamiento utilizado en el cifrado

                // Verificar si la contraseña obtenida del ResultSet no es null
                if (contraseñaBD != null) {
                    // Descifrar la contraseña almacenada en la base de datos y compararla con la contraseña proporcionada
                    if (CifradoUsuarios.desencriptar(contraseñaBD, desplazamiento).equals(contraseña)) {
                        // Contraseña correcta
                        String tipoCuenta = resultSet.getString("tipoCuenta");
                        // Verificar si la columna "tipoCuenta" no es null
                        if (!resultSet.wasNull()) {
                            if (tipoCuenta.equals(TipoCuenta.cliente.toString())) {
                                // Es un cliente
                                JOptionPane.showMessageDialog(null, "Cliente", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                                // Aquí dirige al usuario al frame MainAutos
                                MainAutos.main(null);
                                return "C";
                            } else if (tipoCuenta.equals(TipoCuenta.administrador.toString())) {
                                // Es un administrador
                                JOptionPane.showMessageDialog(null, "ADMINISTRADOR", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                                // Aquí dirige al usuario al frame MainAutos
                                MainAutos.main(null);
                                return "A";
                            }
                        } else {
                            // La columna "tipoCuenta" es null
                            JOptionPane.showMessageDialog(null, "Tipo de cuenta no especificado", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        // Contraseña incorrecta
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Contraseña es null
                    JOptionPane.showMessageDialog(null, "Contraseña no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // No se encontró ningún usuario con ese nombre
                JOptionPane.showMessageDialog(null, "Usuario incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }

            statement.close(); // Cerrar la consulta
            conexion.close(); // Cerrar la conexión
        } catch (SQLException ex) {
            // Manejar cualquier error de SQL
            System.out.println("Error en la base de datos: " + ex.getMessage());
        }
        return null;

    }
}
