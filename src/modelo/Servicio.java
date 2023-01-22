/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jaime
 */
public class Servicio {
    private String identificador;
    private String actividades;
    private int obligatorio;
    private int costo;

    public Servicio(String identificador, String actividades, int obligatorio, int costo) {
        this.identificador = identificador;
        this.actividades = actividades;
        this.obligatorio = obligatorio;
        this.costo = costo;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public void setObligatorio(int obligatorio) {
        this.obligatorio = obligatorio;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getActividades() {
        return actividades;
    }

    public int getObligatorio() {
        return obligatorio;
    }

    public int getCosto() {
        return costo;
    }
    
}
