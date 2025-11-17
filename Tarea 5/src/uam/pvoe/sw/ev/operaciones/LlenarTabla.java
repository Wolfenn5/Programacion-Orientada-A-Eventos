/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.sw.ev.operaciones;


import java.util.LinkedList;
import java.util.Vector;
import uam.pvoe.ws.ev.modelo.*;

public class LlenarTabla {
      public Vector<String> titulosColumnas(){
        Vector<String> titulos= new Vector<>();
        CargaArchivos cargar= new CargaArchivos();

        titulos.add("Cliente");

        LinkedList<Producto> productos= cargar.listaProductos();
        for(Producto p : productos){
            titulos.add(p.getNombreProducto());
        }

        titulos.add("Faltante");

        return titulos;
    }

    public Vector<Vector<String>> llenarFilas(){
        Vector<Vector<String>> filas= new Vector<>();

        CargaArchivos cargar = new CargaArchivos();
        LinkedList<Cliente> clientes= cargar.listaClientes();
        LinkedList<Producto> productos= cargar.listaProductos();
        LinkedList<Compra> compras= cargar.listaCompras();

        for(Cliente c : clientes){
            Vector<String> fila = new Vector<>();

            String nombre =c.getNombre() + " " +
                           c.getPrimerApellido() + " " +
                           c.getSegundoApellido();
            fila.add(nombre);

            int total =0;

            for(Producto p : productos){
                int cantidad = 0;

                for(Compra compra : compras){
                    if(compra.getIdCliente() ==c.getIdCliente() &&
                       compra.getIdProducto() ==p.getIdProducto()){
                        cantidad = compra.getCantidad();
                    }
                }

                fila.add("" + cantidad);
                total += cantidad;
            }

            int faltante = 10-total;
            if(faltante < 0) faltante = 0;

            fila.add("" +faltante);
            filas.add(fila);
        }

        return filas;
    }
}
