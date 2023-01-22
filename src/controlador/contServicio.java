/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Cuenta;
import modelo.Rubro;
import modelo.Servicio;
/**
 *
 * @author jaime
 */
public class contServicio {
    Conexion   conex=new Conexion();
    java.sql.Connection canal=null;
    java.sql.Statement  orden=null;
    ResultSet  resul=null;
    String       sql=null;  
    
    public void insertarServicio(Servicio s){
        try{
            boolean ins = false;
            canal = conex.abrirURL();
            sql = "INSERT INTO servicios(identificador, actividades, obligatorio, costo) VALUES ('"+s.getIdentificador()+"','"+s.getActividades()+"',"+s.getObligatorio()+","+s.getCosto()+")";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        }           
    }

    public boolean eliminarServicio(String identificador){
        boolean ins = false;
        try{
            canal = conex.abrirURL();
            sql = "DELETE FROM servicios where identificador = '"+identificador+"'";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return ins;
    }
    public boolean modificarServicio(String identificador, String actividades, int obligatorio, int costo){
        boolean ins = false;
        try{
            canal = conex.abrirURL();
            sql = "UPDATE servicios set actividades='"+actividades+"', obligatorio = "+obligatorio+", costo="+costo+" where identificador='"+identificador+"'";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return ins;
    }
    public void insertarCuenta(Cuenta c){
        try{
            boolean ins = false;
            canal = conex.abrirURL();
            sql = "INSERT INTO cuenta(identificador_inmueble, identificador_usuarios, identificador_servicio) VALUES ('"+c.getIdentificador_inmueble()+"','"+c.getIdentificador_usuarios()+"','"+c.getIdentificador_servicio()+"')";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        }         
    }
    public ArrayList<Rubro> obtenerRubros(){
        ArrayList<Rubro> lista=new ArrayList<>();
        try {
            canal = conex.abrirURL();
            sql = "select * from rubro";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql); 
             while(resul.next())
             {  lista.add(new Rubro(resul.getInt(1),resul.getString(2)));            
             }
        } catch (Exception e) {
           System.out.println("Error en captura multiple :"+e.getMessage()); 
        }
        return lista;        
    }  

    public void insertarRuborServicio(String identificador, String nombre_rubro){
        boolean ins = false;
        int identificador_rubro  = buscarIdentificadorRubro(nombre_rubro);
        try{
            canal = conex.abrirURL();        
            sql = "INSERT INTO rubro_servicio(identificador_rubro, identificador_servicio) VALUES ("+identificador_rubro+",'"+identificador+"')";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        }        
    }
    public int buscarIdentificadorRubro(String nombre){
        int resultado = 0;
        try {
            canal = conex.abrirURL();
            sql = "select * from rubro where nombre = '"+nombre+"'";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql); 
            if(resul.next()){
                resultado = resul.getInt(1);
            }
        } catch (SQLException e) {
           System.out.println("Error en captura multiple :"+e.getMessage()); 
        }
        return resultado;             
    }    
    public String buscarIDServicio(String nombre){
        String resultado = "";
        try {
            canal = conex.abrirURL();
            sql = "select identificador from servicios where actividades = '"+nombre+"'";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql); 
            if(resul.next()){
                resultado = resul.getString(1);
            }
        } catch (SQLException e) {
           System.out.println("Error en captura multiple :"+e.getMessage()); 
        }
        return resultado;          
    }
    
    public boolean eliminarCuenta(String usuario, String identificador_inmueble, String identificador_servicio){
        boolean ins = false;
        try{
            canal = conex.abrirURL();
            sql = "DELETE FROM cuenta where identificador_inmueble = '"+identificador_inmueble+"' and identificador_usuario= '"+usuario+"' and identificador_servicio='"+identificador_servicio+"'";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return ins;        
    }
    
    public ArrayList<String> obtenerServicios(){
        ArrayList<String> lista=new ArrayList<>();
        try {
            canal = conex.abrirURL();
            sql = "select * from servicios";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql); 
             while(resul.next())
             {  
                 lista.add(resul.getString("actividades"));            
             }
        } catch (Exception e) {
           System.out.println("Error en captura multiple :"+e.getMessage()); 
        }
        return lista;        
    }    
 
    public ArrayList<Servicio> obtenerServiciosTabla(){
        ArrayList<Servicio> lista=new ArrayList<>();
        try {
            canal = conex.abrirURL();
            sql = "select * from servicios";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql); 
             while(resul.next())
             {  
                 Servicio s = new Servicio(resul.getString("identificador"), resul.getString("actividades"), resul.getInt("obligatorio"), resul.getInt("costo"));
                 lista.add(s);            
             }
        } catch (Exception e) {
           System.out.println("Error en captura multiple :"+e.getMessage()); 
        }
        return lista;        
    }  
    public ArrayList<String> obtenerCuenta(String identificador_inmueble, String usuario){
        ArrayList<String> lista=new ArrayList<>();
        try {
            canal = conex.abrirURL();
            sql = "select s.actividades from cuenta c join servicios s on s.identificador = c.identificador_servicio where c.identificador_inmueble='"+identificador_inmueble+"' and c.identificador_usuarios='"+usuario+"'";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql); 
             while(resul.next())
             {  
                 lista.add(resul.getString("actividades"));            
             }
        } catch (Exception e) {
           System.out.println("Error en captura multiple :"+e.getMessage()); 
        }
        return lista;        
    }   
}
