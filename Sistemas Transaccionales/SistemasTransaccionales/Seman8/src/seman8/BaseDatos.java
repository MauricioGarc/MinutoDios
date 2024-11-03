/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seman8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BaseDatos {
    
    private static BaseDatos instancia;
    private Connection conectar= null;
    String user="root";
    String password="ANma4550.*";
    String bd="semana6";
    String ip="localhost";
    String puerto="3306";
    
    String Cadena="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public BaseDatos(){
        try{
            conectar = DriverManager.getConnection(Cadena, user, password);
        }catch(Exception e){
            System.out.println("No se encontro la base de datos,error: " + e);
        }
    }
    
    public static BaseDatos getIntancia(){
        if(instancia==null){
            instancia = new BaseDatos();
        }
        return instancia;
    }
    
    public Connection getConexion(){
        return conectar;
    }
}
