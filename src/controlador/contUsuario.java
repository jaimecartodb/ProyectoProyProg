/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Usuario;

public class contUsuario {
    Conexion   conex=new Conexion();
    java.sql.Connection canal=null;
    java.sql.Statement  orden=null;
    ResultSet  resul=null;
    String       sql=null;
    
    public void insertarUsuario(Usuario user) throws SQLException{
        try{
            boolean ins = false;
            canal = conex.abrirURL();
            sql = "INSERT INTO usuarios(identificador, clave, tipo_usuario, telefono, email, baja) VALUES ('"+user.getIdentificador()+"','"+user.getClave()+"','"+user.getTipo_usuario()+"','"+user.getTelefono()+"','"+user.getEmail()+"',0)";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
    } 

    public ArrayList<Usuario> obtenerUsuarios(){
        ArrayList<Usuario> lista=new ArrayList<>();
        try {
            canal = conex.abrirURL();
            sql = "select * from usuarios";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql); 
             while(resul.next())
             {  lista.add(new Usuario(resul.getString(1),resul.getString(2),
                     resul.getString(3),resul.getString(4),resul.getString(5), resul.getBoolean(6)));            
             }
        } catch (Exception e) {
           System.out.println("Error en captura multiple :"+e.getMessage()); 
        }
        return lista;        
    }
    
    public boolean modificarUsuario(String identificador, String clave, String telefono, String email, int baja){
        boolean ins = false;
        try{
            canal = conex.abrirURL();
            sql = "UPDATE usuarios set clave='"+clave+"', telefono = '"+telefono+"', email='"+email+"', baja="+baja+" where identificador='"+identificador+"'";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return ins;
    }
    
    public boolean eliminarUsuario(String identificador){
        boolean ins = false;
        try{
            canal = conex.abrirURL();
            sql = "DELETE FROM usuarios where identificador = '"+identificador+"'";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return ins;
    }
}
