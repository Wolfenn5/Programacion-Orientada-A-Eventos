package uam.pvoe.practica.operaciones;

import uam.pvoe.practica.modelo.*;
import java.io.*;
import java.util.*;

public class Archivos {


public static List<Estado> leerEstados(String ruta){
    List<Estado> out = new ArrayList<>();
    try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
        String l;
        while((l = br.readLine()) != null){
            l = l.trim(); if (l.isEmpty() || l.startsWith("#")) continue;
            String[] p = l.split("\\s*,\\s*");
            if (p.length >= 2){
                String nombre = p[0].trim();
                String clave  = p[1].trim();
                out.add(new Estado(nombre, clave)); 
            }
        }
    } catch(IOException e){ System.out.println("Estados: " + e.getMessage()); }
    return out;
}

public static List<Atractivo> leerAtractivos(String ruta){
    List<Atractivo> out = new ArrayList<>();
    try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
        String l;
        while((l = br.readLine()) != null){
            l = l.trim(); if (l.isEmpty() || l.startsWith("#")) continue;
            String[] p = l.split("\\s*,\\s*");
            if (p.length >= 3){
                String claveAtr   = p[0].trim();
                String nombreAtr  = p[1].trim();
                String claveEstado= p[2].trim();
                out.add(new Atractivo(nombreAtr, claveAtr, claveEstado));
            }
        }
    } catch(IOException e){ System.out.println("Atractivos: " + e.getMessage()); }
    return out;
}


}