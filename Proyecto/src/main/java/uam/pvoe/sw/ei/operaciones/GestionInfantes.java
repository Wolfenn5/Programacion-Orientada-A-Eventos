/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.sw.ei.operaciones;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author rober
 */
public class GestionInfantes {
    
   private final String NOMBRE_ARCHIVO = "infantes.txt";

    /**
     * MÉTODO 1: REGISTRAR (Alta)
     * Escribe una nueva línea al final del archivo.
     */
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

    /**
     * MÉTODO 2: LEER (Consulta)
     * Lee el archivo y llena la tabla, filtrando si es necesario.
     */
    public DefaultTableModel llenarTablaDesdeArchivo(DefaultTableModel modelo, String filtroNivel) {
        modelo.setRowCount(0); // Limpiar tabla visual

        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // El formato es: Nombre,Apellidos,...,...,...,...,...,...,...,Nivel,...,...,...,...,Costo
                // Indices aprox: 0=Nombre, 1=Apellidos, 9=Nivel, 14=Costo
                String[] datos = linea.split(",");
                
                if (datos.length >= 15) { // Validar que la línea esté completa
                    String nombre = datos[0];
                    String apellidos = datos[1];
                    String nivel = datos[9];
                    String costo = datos[14];

                    // Si no hay filtro (null) o el nivel coincide, lo agregamos
                    if (filtroNivel == null || nivel.contains(filtroNivel)) {
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

    /**
     * MÉTODO 3: ELIMINAR (Baja)
     * Lee todo, omite al que queremos borrar, y reescribe el archivo.
     * Usamos Nombre y Apellidos como "ID" para buscar.
     */
    public boolean eliminarInfante(String nombreBusqueda, String apellidoBusqueda) {
        ArrayList<String> lineasConservar = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                // Si NO coincide con el que borramos, lo guardamos
                if (!(datos[0].equals(nombreBusqueda) && datos[1].equals(apellidoBusqueda))) {
                    lineasConservar.add(linea);
                } else {
                    encontrado = true; // Encontramos al que se va a borrar
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

    
    
    // Método auxiliar privado para guardar la lista completa
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

    // Método de cálculo auxiliar (se queda igual)
    public double calcularNuevaCuota(String nivel, boolean dietaEspecial) {
        double costoBase = 0.0;
        double costoExtra = 0.0;
        if (nivel.contains("Lactantes")) costoBase = 2800.0;
        else if (nivel.contains("Maternal")) costoBase = 2500.0;
        else if (nivel.contains("Preescolar")) costoBase = 2200.0;
        if (dietaEspecial) costoExtra = 600.0;
        return costoBase + costoExtra;
    }
    
    // Recuperar todos los datos de un niño específico para llenarlos en el formulario
    public String[] buscarInfante(String nombre, String apellidos) {
        try (BufferedReader br = new BufferedReader(new FileReader("infantes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                // Si coincide Nombre (indice 0) y Apellidos (indice 1)
                if (datos.length >= 15 && datos[0].equals(nombre) && datos[1].equals(apellidos)) {
                    return datos; // Retornamos todos los datos encontrados
                }
            }
        } catch (IOException e) {
            System.out.println("Error buscando infante: " + e.getMessage());
        }
        return null; // No encontrado
    }
}
