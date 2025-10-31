/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.sw.buttons.modelo;

public class AdministrarAlumno {

    public boolean validarMatricula(String matricula) {
        if (matricula.length() == 10) {
            return true;
        } else {
            return false;
        }
    }
}
