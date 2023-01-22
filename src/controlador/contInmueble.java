/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Inmueble;
import modelo.usuarioInmueble;

/**
 *
 * @author jaime
 */
public class contInmueble {
    Conexion   conex=new Conexion();
    java.sql.Connection canal=null;
    java.sql.Statement  orden=null;
    ResultSet  resul=null;
    String       sql=null;  

    public void insertarInmueble(Inmueble inm) throws SQLException{
        try{
            boolean ins = false;
            canal = conex.abrirURL();
            sql = "INSERT INTO inmuebles(identificador, nombre) VALUES ('"+inm.getIdentificador()+"','"+inm.getNombre()+"')";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
    } 

    public boolean eliminarInmueble(String identificador){
        boolean ins = false;
        try{
            canal = conex.abrirURL();
            sql = "DELETE FROM usuario_inmueble where identificador_inmueble='"+identificador+"'";
            conex.generarTransaccion(canal, sql);
            sql = "DELETE FROM inmuebles where identificador='"+identificador+"'";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return ins;
    }
    
    public boolean modificarInmueble(String identificador, String nombre){
        boolean ins = false;
        try{
            canal = conex.abrirURL();
            sql = "UPDATE inmuebles set nombre='"+nombre+"' where identificador='"+identificador+"'";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return ins;
    }
    public void insertarUsuarioInmueble(usuarioInmueble uinm) throws SQLException{
        try{
            boolean ins = false;
            canal = conex.abrirURL();
            sql = "INSERT INTO usuario_inmueble(identificador_usuario, identificador_inmueble) VALUES ('"+uinm.getIdentificador_usuario()+"','"+uinm.getIdentificador_inmueble()+"')";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
    } 
    public ArrayList<Inmueble> obtenerInmuebles(){
        ArrayList <Inmueble> inmuebles = new ArrayList<>();
        try{
            canal = conex.abrirURL();
            sql = "SELECT i.identificador, i.nombre, ui.identificador_usuario FROM inmuebles i join usuario_inmueble ui on i.identificador = ui.identificador_inmueble";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql);          
            while(resul.next()){
                Inmueble i = new Inmueble(resul.getString("identificador"), resul.getString("nombre"));
                i.setUsuario(resul.getString("identificador_usuario"));
                inmuebles.add(i);
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
        return inmuebles;
    }
    public ArrayList<String> obtenerUsuarios(){
        ArrayList <String> identificadores = new ArrayList<String>();
        try{
            canal = conex.abrirURL();
            sql = "SELECT * FROM usuarios";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql);          
            while(resul.next()){
                identificadores.add(resul.getString("identificador"));
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
        return identificadores;
    }
    
}
