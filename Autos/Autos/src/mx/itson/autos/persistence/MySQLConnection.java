/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.autos.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author angel
 */
public class MySQLConnection {
       //Conexion para la Base Datos
    public static Connection get(){
    Connection connection = null;
    //PreparedStatement stmt = null;
    String user="root";
    String password="root";

    try {
        // Utiliza el formato correcto para la URL de conexión
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/ventaautos","root","root");
    }catch(Exception ex){
        System.err.print("Error: " + ex.getMessage());
        
    }

    return connection;
} 
}
