/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.sw.buttons.modelo;

import java.util.LinkedList;
import javax.swing.JCheckBox;

public class RegistroSelecciones {

    public String registrarAlumnos(String genero, String division) {
        String textoRP;
        textoRP = "El género es: " + genero + "\n";
        textoRP = "La división es: " + division + "\n";
        return textoRP;
    }

    public String registrarActividades(LinkedList<JCheckBox> lista) {
        LinkedList<String> listaActividades = new LinkedList();
        String textoRA;
        for (int i = 0; i < lista.size(); i++) {
            JCheckBox aux = lista.get(i);
            if (aux.isSelected()) {
                listaActividades.add(aux.getText());
            }
        }
        if (listaActividades.isEmpty()) {
            textoRA = "\nLas actividades seleccionadas son: NINGUNA.";
        } else {
            textoRA = "\nLas actividades seleccionadas son: ";
            for (int i = 0; i < listaActividades.size(); i++) {
                textoRA += listaActividades.get(i);
                if (i != (listaActividades.size() - 1)) {
                    textoRA += ", ";
                } else {
                    textoRA += ".";
                }
            }
        }
        return textoRA;
    }
}
