/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jaime
 */
public class Inmueble {
    private String identificador;
    private String nombre;
    private String usuario;
    public Inmueble(String identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.usuario = "";
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }
    
}
