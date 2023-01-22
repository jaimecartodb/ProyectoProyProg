/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Rubro;
import modelo.Gastos;
import modelo.Servicio;

/**
 *
 * @author jaime
 */
public class contGastos {
    Conexion   conex=new Conexion();
    java.sql.Connection canal=null;
    java.sql.Statement  orden=null;
    ResultSet  resul=null;
    String       sql=null;  

    public int insertarGasto(Gastos gasto) throws SQLException{
        int id_gasto =  0;
        try{
            boolean ins = false;
            canal = conex.abrirURL();
            sql = "INSERT INTO gastos(importe, fecha_registro, fecha_pago, numero_telefono_prov, email_prov, direccion_prov, nombre_prov) VALUES ('"+gasto.getImporte()+"','"+gasto.getFecha_registro()+"','"+gasto.getFecha_pago()+"','"+gasto.getNumero_telefono()+"','"+gasto.getEmail_prov()+"','"+gasto.getDireccion_prov()+"','"+gasto.getNombre_prov()+"')";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return id_gasto;
    } 
    
    public int insertarRubroServicio(String identificador_rubro, String identificador_servicio){
        int id_gasto =  0;
        try{
            boolean ins = false;
            canal = conex.abrirURL();
            sql = "INSERT INTO rubro_servicio(identificador_rubro, identificador_servicio) VALUES ('"+identificador_rubro+"','"+identificador_servicio+"')";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return id_gasto;        
    }
    public boolean modificarGasto(int id_gasto, int importe, String fecha_registro, String fecha_pago, String numero_telefono, String email_prov, String direccion_prov, String nombre_prov){
        boolean ins = false;
        try{
            canal = conex.abrirURL();
            sql = "UPDATE gastos set importe="+importe+", fecha_registro= '"+fecha_registro+"', fecha_pago='"+fecha_pago+"', numero_telefono_prov='"+numero_telefono+"', email_prov='"+email_prov+"', direccion_prov='"+direccion_prov+"', nombre_prov='"+nombre_prov+"' where id_gasto="+id_gasto;
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return ins;
    }
    
    public boolean eliminarGasto(String identificador){
        boolean ins = false;
        try{
            canal = conex.abrirURL();
            sql = "DELETE FROM gastos where id_gasto = "+identificador;
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        } 
        return ins;
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
    public boolean insertarGastoRubro(int id_rubro) throws SQLException{
        boolean ins = false;
        int id_gasto = -1;
        try{
            canal = conex.abrirURL();
            sql = "SELECT MAX(id_gasto) as id_gasto FROM gastos";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql); 
            if(resul.next()){
                id_gasto = resul.getInt(1);
            }           
            sql = "INSERT INTO gasto_rubro(identificador_rubro, id_gasto) VALUES ("+id_rubro+","+id_gasto+")";
            ins=conex.generarTransaccion(canal, sql);
            conex.cerrarURL(canal);   
        }   
        catch(Exception e){
            System.out.println("Se ha encontrado un error que es: "+e.getMessage());
        }
        return ins;
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
    public ArrayList<Gastos> obtenerGastos(){
        ArrayList<Gastos> lista=new ArrayList<>();
        try {
            canal = conex.abrirURL();
            sql = "select * from gastos";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql); 
            while(resul.next()){
                Gastos g = new Gastos(resul.getInt(2),resul.getString(3),resul.getString(4),resul.getString(5),resul.getString(6),resul.getString(7),resul.getString(8));
                g.setId_gasto(resul.getInt(1));
                lista.add(g);
            }
        } catch (Exception e) {
           System.out.println("Error en captura multiple :"+e.getMessage()); 
        }
        return lista;        
    }  
}
