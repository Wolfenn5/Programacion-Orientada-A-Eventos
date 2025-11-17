/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.ws.ev.modelo;


public class Cliente {
    
    private int idCliente;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    public int getIdCliente() { 
        return idCliente; 
    }
    public void setIdCliente(int idCliente) { 
        this.idCliente = idCliente; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getPrimerApellido() {
        return primerApellido; 
    }
    public void setPrimerApellido(String primerApellido) { 
        this.primerApellido = primerApellido; 
    }

    public String getSegundoApellido() { 
        return segundoApellido; 
    }
    public void setSegundoApellido(String segundoApellido) { 
        this.segundoApellido = segundoApellido; 
    }
}
