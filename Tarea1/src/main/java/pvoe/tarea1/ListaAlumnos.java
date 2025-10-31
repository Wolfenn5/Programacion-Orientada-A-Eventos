package pvoe.tarea1;


import java.io.*;
import java.util.*;

public class ListaAlumnos {
    private LinkedList<Alumno> lista = new LinkedList<>();

    // Cargar datos desde el archivo
    public void cargarDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    Alumno a = new Alumno(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
                    lista.add(a);
                }
            }
            System.out.println("Datos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Buscar alumno por matricula
    public Alumno buscarPorMatricula(String matricula) {
        for (Alumno a : lista) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    // Buscar alumnos por licenciatura
    public void buscarPorLicenciatura(String licenciatura) {
        boolean encontrado = false;
        for (Alumno a : lista) {
            if (a.getLicenciatura().equalsIgnoreCase(licenciatura)) {
                System.out.println(a);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No hay alumnos con esa licenciatura.");
    }

    // Buscar alumnos por genero
    public void buscarPorGenero(String genero) {
        boolean encontrado = false;
        for (Alumno a : lista) {
            if (a.getGenero().equalsIgnoreCase(genero)) {
                System.out.println(a);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No hay alumnos con ese genero.");
    }

    // Borrar alumno por matricula
    public void borrarPorMatricula(String matricula) {
        Iterator<Alumno> it = lista.iterator();
        boolean borrado = false;
        while (it.hasNext()) {
            Alumno a = it.next();
            if (a.getMatricula().equals(matricula)) {
                it.remove();
                borrado = true;
                System.out.println("Alumno eliminado correctamente.");
                break;
            }
        }
        if (!borrado) System.out.println("No existe alumno con esa matricula.");
    }
}

