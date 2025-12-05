/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.sw.ei.operaciones;

import java.io.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author rober
 */
public class GestionInfantes {
    
   private final String NOMBRE_ARCHIVO = "infantes.txt";


    public boolean registrarInfante(String registro) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            bw.write(registro);
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
            return false;
        }
    }


    public DefaultTableModel llenarTablaDesdeArchivo(DefaultTableModel modelo, String filtroNivel) {
        modelo.setRowCount(0); // Limpiar tabla visualmente

        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // nombre,apellidos,nivel, xosto ... con indices para el string
                String[] datos = linea.split(",");
                
                
                if (datos.length >= 15) { // datos aprox
                    String nombre = datos[0];
                    String apellidos = datos[1];
                    String nivel = datos[9];
                    String costo = datos[14];

                    
                    if (filtroNivel == null || nivel.contains(filtroNivel)) {// filtro de niveles
                        modelo.addRow(new Object[]{nombre, apellidos, nivel, costo});
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo aún no existe (es normal si es la primera vez).");
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
        return modelo;
    }


    public boolean eliminarInfante(String nombreBusqueda, String apellidoBusqueda) { // ids para saber el infnate
        ArrayList<String> lineasConservar = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (!(datos[0].equals(nombreBusqueda) && datos[1].equals(apellidoBusqueda))) {
                    lineasConservar.add(linea);
                } else {
                    encontrado = true; 
                }
            }
        } catch (IOException e) {
            return false;
        }

        if (encontrado) {
            reescribirArchivo(lineasConservar);
        }
        return encontrado;
    }

    
    
    private void reescribirArchivo(ArrayList<String> lineas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, false))) { // false = sobrescribir
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error reescribiendo: " + e.getMessage());
        }
    }


    
    public double calcularNuevaCuota(String nivel, boolean dietaEspecial) {
        double costoBase = 0.0;
        double costoExtra = 0.0;
        if (nivel.contains("Lactantes")) {
            costoBase = 3000.0;
        }
        else if (nivel.contains("Maternal")) {
            costoBase = 2500.0;
        }
        else if (nivel.contains("Preescolar")) {
            costoBase = 2000.0;
        }
        if (dietaEspecial) {
            costoExtra = 600.0;
        }
        return costoBase + costoExtra;
    }
    
    // recuperar todos los datos para llenarlos en el formulario
    public String[] buscarInfante(String nombre, String apellidos) {
        try (BufferedReader br = new BufferedReader(new FileReader("infantes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");               
           
                if (datos.length >= 15 && datos[0].equals(nombre) && datos[1].equals(apellidos)) { // si coincide nombre (indice 0) y apellidos (indice 1)
                    return datos; 
                }
            }
        } catch (IOException e) {
            System.out.println("Error buscando infante: " + e.getMessage());
        }
        return null; // no encontrado
    }
}
