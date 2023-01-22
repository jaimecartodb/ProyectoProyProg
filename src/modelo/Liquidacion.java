/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jaime
 */
public class Liquidacion {
    private String servicio;
    private int costo_servicio;
    private int importe_gasto;
    private String nombre_proveedor;
    private String email_proveedor;
    private String direccion_proveedor;
    private String rubro;

    public Liquidacion(String servicio, int costo_servicio, int importe_gasto, String nombre_proveedor, String email_proveedor, String direccion_proveedor, String rubro) {
        this.servicio = servicio;
        this.costo_servicio = costo_servicio;
        this.importe_gasto = importe_gasto;
        this.nombre_proveedor = nombre_proveedor;
        this.email_proveedor = email_proveedor;
        this.direccion_proveedor = direccion_proveedor;
        this.rubro = rubro;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setCosto_servicio(int costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public void setImporte_gasto(int importe_gasto) {
        this.importe_gasto = importe_gasto;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getServicio() {
        return servicio;
    }

    public int getCosto_servicio() {
        return costo_servicio;
    }

    public int getImporte_gasto() {
        return importe_gasto;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public String getEmail_proveedor() {
        return email_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public String getRubro() {
        return rubro;
    }
    
}
