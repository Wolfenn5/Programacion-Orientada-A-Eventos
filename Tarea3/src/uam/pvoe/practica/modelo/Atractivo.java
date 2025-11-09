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
public class Atractivo {
    
    private String nombre;
    private String atractivo;
    private String claveEstado;

    public String getNombre() {
        return nombre;
    }

    public Atractivo(String nombre, String atractivo, String claveEstado) {
        this.nombre = nombre;
        this.atractivo = atractivo;
        this.claveEstado= claveEstado;
    }
    
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAtractivo() {
        return atractivo;
    }

    public void setAtractivo(String atractivo) {
        this.atractivo = atractivo;
    }
    
    public String getClaveEstado(){ 
        return claveEstado;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
    
}
