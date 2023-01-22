/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jaime
 */
public class usuarioInmueble {
    private String identificador_usuario;
    private String identificador_inmueble;

    public usuarioInmueble(String identificador_usuario, String identificador_inmueble) {
        this.identificador_usuario = identificador_usuario;
        this.identificador_inmueble = identificador_inmueble;
    }

    public void setIdentificador_usuario(String identificador_usuario) {
        this.identificador_usuario = identificador_usuario;
    }

    public void setIdentificador_inmueble(String identificador_inmueble) {
        this.identificador_inmueble = identificador_inmueble;
    }

    public String getIdentificador_usuario() {
        return identificador_usuario;
    }

    public String getIdentificador_inmueble() {
        return identificador_inmueble;
    }
    
}
