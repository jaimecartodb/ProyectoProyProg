/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.*;
import modelo.Conexion;

/**
 *
 * @author jaime
 */
public class contSesion {
    Conexion   conex=new Conexion();
    java.sql.Connection canal=null;
    java.sql.Statement  orden=null;
    ResultSet  resul=null;
    String       sql=null;
    
    public boolean inicioSesion(String usuario, String contra){
        boolean res = false;
        try{
            canal = conex.abrirURL();
            sql = "SELECT * FROM usuarios where identificador='"+usuario+"' and clave='"+contra+"'";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql);          
            if(resul.next() == false){
                res = false;
            }else{
                res = true;
            }
            conex.cerrarURL(canal);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error de mysql");
        }
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return res;
    }  
    
    public String obtenerTipoUsuario(String usuario, String contra){
        String tipo = "";
        try{
            canal = conex.abrirURL();
            sql = "SELECT * FROM usuarios where identificador='"+usuario+"' and clave='"+contra+"'";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql);          
            while(resul.next())
             {  
                 tipo = resul.getString(3);            
             }
            conex.cerrarURL(canal);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error de mysql");
        }
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        }        
        return tipo;
    }
}
