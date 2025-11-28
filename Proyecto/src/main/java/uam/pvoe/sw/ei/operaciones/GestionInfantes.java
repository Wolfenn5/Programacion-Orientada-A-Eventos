/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.sw.ei.operaciones;

import java.util.LinkedList; // para el txt
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author rober
 */
public class GestionInfantes {
    
    
    public DefaultTableModel llenarTablaInicial(DefaultTableModel modelo) {
        
        modelo.setRowCount(0); // limpiar tabla
        
        
        
        modelo.addRow(new Object[]{"Juanito", "Pérez López", "Lactantes", "$2800.0"});
        modelo.addRow(new Object[]{"María", "González R.", "Maternal", "$2500.0"});
        modelo.addRow(new Object[]{"Pedrito", "Sánchez", "Preescolar", "$2200.0"});
        return modelo;
    }
    
    
    

    public double calcularNuevaCuota(String nivel, boolean dietaEspecial) {
        double costoBase = 0.0;
        double costoExtra = 0.0;
        
        
        if (nivel.contains("Lactantes")){
            costoBase = 2800.0;
        }
        else if (nivel.contains("Maternal")){
            costoBase = 2500.0;
        }
        else if (nivel.contains("Preescolar")){
            costoBase = 2200.0;
        }
        
        
        if (dietaEspecial) {
            costoExtra = 600.0;
        }
        
        
        
        return costoBase + costoExtra;
    }
    
    // Método para procesar la baja (Futuro: Reescribir TXT sin este registro)
    public boolean procesarBaja(String nombre, String razon) {
        // ponder despues la logica del archivo 

        
        System.out.println("LOG: Eliminando a " + nombre + " por motivo: " + razon);
        return true;
    }
}
