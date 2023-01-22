/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;

public class Conexion {
    String API="com.mysql.jdbc.Driver";
    java.sql.Connection canal=null;
    Statement  orden=null;
    public Conexion() {}
    public java.sql.Connection abrirURL()
    {  try {//publicar API
          Class.forName(API);
          canal=DriverManager.getConnection("jdbc:mysql://database-1.cz5ftoafk12s.us-east-1.rds.amazonaws.com/proyecto?characterEncoding=utf8","admin","proyectoprogramacion1");
          orden=canal.createStatement();
        } catch (Exception e) {
          System.out.println("ERROR de apertura de URL...:"+e.getMessage());  
       }
       return canal;
    }
    public void cerrarURL(java.sql.Connection canal)
    { try {
          canal.close();
        } catch (Exception e) {
          System.out.println("ERROR de cierre de URL...:"+e.getMessage());  
        }
    } 
    public boolean generarTransaccion(java.sql.Connection canal,String sql)
    {  boolean ok=false;
        try {//Analisis de Trama
            orden=canal.prepareStatement(sql);//INSERT/UPDATE/DELETE
            try {//Comprometer transaccion en el espacio fisico
                orden.execute(sql);
                ok=true;
            } catch (Exception e) {
              System.out.println("Error En Compromiso de Datos :"+e.getMessage());  
            }            
        } catch (Exception e) {
          System.out.println("Error En Construccion de Trama de Datos :"+e.getMessage());  
        }
       return ok;
    }
}
