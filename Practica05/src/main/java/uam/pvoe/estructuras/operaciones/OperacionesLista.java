package uam.pvoe.estructuras.operaciones;

/**
 *
 * @author Equipo04
 */
import java.util.LinkedList;
import uam.pvoe.estructuras.clases.Alumno;

public class OperacionesLista {

    public LinkedList<Alumno> insertarAlumno(LinkedList<Alumno> listaAlumnos, Alumno alumno){
        listaAlumnos.add(alumno);
        return listaAlumnos;
    }

    public void imprimirLista(LinkedList<Alumno> lista){
        for(int i = 0; i < lista.size(); i++){
            Alumno al = (Alumno) lista.get(i);
            System.out.println(al.toString());
        }
    }

    public Alumno regresaAlumno(LinkedList<Alumno> lista, int posicion){
        Alumno alumno = (Alumno) lista.get(posicion);
        return alumno;
    }

    public int buscarAlumno(LinkedList<Alumno> lista, String matricula){
        int posicion = -1;
        for(int i = 0; i < lista.size(); i++){
            Alumno al = (Alumno) lista.get(i);
            if(al.getMatricula().compareTo(matricula) == 0){
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public LinkedList<Alumno> borrarAlumno(LinkedList<Alumno> lista, int posicion){
        lista.remove(posicion);
        return lista;
    }
}
