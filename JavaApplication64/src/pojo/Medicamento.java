/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author FD314
 */
public class Medicamento {
    private int id;
    private String nombre;
    private String categoria;
    private String descripcion;
    private float cantidad;
    private float costo;
    private String unidad;

    public Medicamento(int id, String nombre, String categoria, String descripcion, float cantidad, float costo, String unidad) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costo = costo;
        this.unidad = unidad;
    }

    public Medicamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
     public Object[] toArray(){
        Object[] object = new Object[7];
        
        object[0] = this.getId();
        object[1] = this.getNombre();
        object[2] = this.getCategoria();
        object[3] = this.getDescripcion();
        object[4] = this.getCantidad();
        object[5] = this.getCosto();
        object[6] = this.getUnidad();
        return object;
        
    }

   
}
