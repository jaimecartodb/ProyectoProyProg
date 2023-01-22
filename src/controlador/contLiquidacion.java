/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Liquidacion;

/**
 *
 * @author jaime
 */
public class contLiquidacion {
    Conexion   conex=new Conexion();
    java.sql.Connection canal=null;
    java.sql.Statement  orden=null;
    ResultSet  resul=null;
    String       sql=null; 
    public ArrayList<Liquidacion> obtenerLiquidaciones(String usuario, String fecha_inicio, String fecha_fin){
        ArrayList<Liquidacion> lista=new ArrayList<>();
        try {
            canal = conex.abrirURL();
            sql = "select s.actividades as servicio,\n" +
                "s.costo as costo, g.importe as importe, g.nombre_prov as proveedor,\n" +
                "g.email_prov, g.direccion_prov, r.nombre \n" +
                "from servicios s \n" +
                "left join rubro_servicio rs on rs.identificador_servicio = s.identificador \n" +
                "left join rubro r on r.identificador_rubro = rs.identificador_rubro \n" +
                "left join gasto_rubro gr on gr.identificador_rubro = rs.identificador_rubro \n" +
                "left join gastos g on g.id_gasto = gr.id_gasto \n" +
                "left join cuenta c on c.identificador_servicio = s.identificador \n" +
                "where g.fecha_registro >= '"+fecha_inicio+"' and g.fecha_registro <='"+fecha_fin+"' and c.identificador_usuarios ='"+usuario+"'";
            orden=conex.abrirURL().createStatement();
            resul=orden.executeQuery(sql); 
            while(resul.next()){
                Liquidacion l = new Liquidacion(resul.getString(1),resul.getInt(2),resul.getInt(3),resul.getString(4),resul.getString(5),resul.getString(6),resul.getString(7));
                lista.add(l);
            }
        } catch (Exception e) {
           System.out.println("Error en captura multiple :"+e.getMessage()); 
        }
        return lista;          
    }
}
