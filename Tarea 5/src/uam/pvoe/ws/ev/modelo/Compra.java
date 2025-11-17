/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.ws.ev.modelo;

public class Compra {
      private int idCliente;
    private int idProducto;
    private int cantidad;

    public int getIdCliente() { 
        return idCliente; 
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente; 
    }

    public int getIdProducto() { 
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad; 
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad; 
    }
}
