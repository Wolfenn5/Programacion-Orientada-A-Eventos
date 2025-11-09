/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.practica.modelo;

/**
 *
 * @author
 */
public class Estado {
    
    private String nombre;
    private String claveEstado;

    public String getNombre() {
        return nombre;
    }

    public Estado(String nombre, String claveEstado) {
        this.nombre = nombre;
        this.claveEstado = claveEstado;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClaveEstado() {
        return claveEstado;
    }

    public void setClaveEstado(String claveEstado) {
        this.claveEstado = claveEstado;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
    
    
    
}
