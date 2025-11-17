/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.sw.ev.operaciones;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import uam.pvoe.ws.ev.modelo.Cliente;
import uam.pvoe.ws.ev.modelo.Producto;
import uam.pvoe.ws.ev.modelo.Compra;

public class CargaArchivos {


    public LinkedList<Cliente> listaClientes(){
        LinkedList<Cliente> lista = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("cliente.dat"))){
            String linea;
            while((linea = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(linea, ",");
                Cliente c = new Cliente();
                c.setIdCliente(Integer.parseInt(st.nextToken()));
                c.setNombre(st.nextToken());
                c.setPrimerApellido(st.nextToken());
                c.setSegundoApellido(st.nextToken());
                lista.add(c);
            }
        }catch(Exception e){
            System.out.println("Error leyendo cliente.dat");
        }
        return lista;
    }

    public LinkedList<Producto> listaProductos(){
        LinkedList<Producto> lista = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("productos.dat"))){
            String linea;
            while((linea = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(linea, ",");
                Producto p = new Producto();
                p.setIdProducto(Integer.parseInt(st.nextToken()));
                p.setNombreProducto(st.nextToken());
                lista.add(p);
            }
        }catch(Exception e){
            System.out.println("Error leyendo productos.dat");
        }
        return lista;
    }

    public LinkedList<Compra> listaCompras(){
        LinkedList<Compra> lista = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("compras_cliente_producto.dat"))){
            String linea;
            while((linea = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(linea, ",");
                Compra compra = new Compra();
                compra.setIdCliente(Integer.parseInt(st.nextToken()));
                compra.setIdProducto(Integer.parseInt(st.nextToken()));
                compra.setCantidad(Integer.parseInt(st.nextToken()));
                lista.add(compra);
            }
        }catch(Exception e){
            System.out.println("Error leyendo compras_cliente_producto.dat");
        }
        return lista;
    }
}
