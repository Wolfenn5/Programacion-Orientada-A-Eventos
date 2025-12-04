/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.sw.ei.modelo;

/**
 *
 * @author btosk
 */
public class Infante {
    // Atributos públicos para acceso rápido (o privados con getters/setters si prefieres)
    public String nombre, apellidos, genero, tutor, direccion, tel, emergencia, nivel, subnivel, horario, tieneDieta, detalleDieta, costoTotal;
    public int anios, meses;
    
    // Método auxiliar para convertir a CSV
    public String toCSV() {
        return nombre + "," + apellidos + "," + anios + "," + meses + "," + genero + "," + 
               tutor + "," + direccion + "," + tel + "," + emergencia + "," + nivel + "," + 
               subnivel + "," + horario + "," + tieneDieta + "," + detalleDieta + "," + costoTotal;
    }
}
