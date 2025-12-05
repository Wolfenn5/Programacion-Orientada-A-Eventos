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
    public String nombre, apellidos, genero, tutor, direccion, tel, emergencia, nivel, subnivel, horario, tieneDieta, detalleDieta, costoTotal;
    public int anios, meses;
    
    
    
    public String toCSV() {
        return nombre + "," + apellidos + "," + anios + "," + meses + "," + genero + "," + // datos infante
               tutor + "," + direccion + "," + tel + "," + emergencia + "," + nivel + "," +  // datos tutor
               subnivel + "," + horario + "," + tieneDieta + "," + detalleDieta + "," + costoTotal; // niveles y salud
    }
}
