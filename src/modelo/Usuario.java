/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Usuario {
    private String identificador;
    private String clave;
    private String tipo_usuario;
    private String telefono;
    private String email;
    private boolean baja;
    
    public Usuario(String identificador, String clave, String tipo_usuario, String telefono, String email, boolean baja) {
        this.identificador = identificador;
        this.clave = clave;
        this.tipo_usuario = tipo_usuario;
        this.telefono = telefono;
        this.email = email;
        this.baja = baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getClave() {
        return clave;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    
}
