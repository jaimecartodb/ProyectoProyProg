/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Cuenta {
    private String identificador_inmueble;
    private String identificador_usuarios;
    private String identificador_servicio;
    
    public Cuenta (String identificador_inmueble, String identificador_usuarios, String identificador_servicio) {
        this.identificador_inmueble = identificador_inmueble;
        this.identificador_usuarios = identificador_usuarios;
        this.identificador_servicio = identificador_servicio;
    }

    public void setIdentificador_servicio(String identificador_servicio) {
        this.identificador_servicio = identificador_servicio;
    }


    public void setIdentificador_inmueble(String identificador_inmueble) {
        this.identificador_inmueble = identificador_inmueble;
    }

    public void setIdentificador_usuarios(String identificador_usuarios) {
        this.identificador_usuarios = identificador_usuarios;
    }

    public String getIdentificador_servicio() {
        return identificador_servicio;
    }


    public String getIdentificador_inmueble() {
        return identificador_inmueble;
    }

    public String getIdentificador_usuarios() {
        return identificador_usuarios;
    }
    
}
