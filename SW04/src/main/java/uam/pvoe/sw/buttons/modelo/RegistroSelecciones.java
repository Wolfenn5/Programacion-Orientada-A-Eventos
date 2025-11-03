package uam.pvoe.sw.buttons.modelo;

import java.util.LinkedList;
import javax.swing.JCheckBox;


public class RegistroSelecciones {
    
    
    public void registrarPersonales(String genero, String nacionalidad, String civil){
        System.out.println("El Género es: " + genero);
        System.out.println("La Nacionalidad es: " + nacionalidad);
        System.out.println("El Estado Civil es: " + civil);
    }
    
    
    public void registrarIdiomas(LinkedList <JCheckBox> lista){
        LinkedList <String> listaIdiomas = new LinkedList();
        for(int i=0;i<lista.size();i++){
            JCheckBox aux = lista.get(i);
            if(aux.isSelected())
                listaIdiomas.add(aux.getText());
        }

        System.out.println("Los Idiomas seleccionados son: ");
        for(int i= 0; i<listaIdiomas.size();i++){
            System.out.println(listaIdiomas.get(i));
        }
    }
    
    
    
    public void registrarLenguajes(LinkedList <JCheckBox> lista, String otros){
        LinkedList <String> listaLenguajes = new LinkedList();
        for(int i=0;i<lista.size();i++){
            JCheckBox aux = lista.get(i);
            if(aux.isSelected())
                listaLenguajes.add(aux.getText());
        }
        System.out.println("Los Lenguajes seleccionados son: ");
        for(int i= 0; i<listaLenguajes.size();i++){
            System.out.println(listaLenguajes.get(i));
        }
        if(otros.length()>0){
            System.out.println("Otros que manejas son: " + otros);
        }
    }
}

