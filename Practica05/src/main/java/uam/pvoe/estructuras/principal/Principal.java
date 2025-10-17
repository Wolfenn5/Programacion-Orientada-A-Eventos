package uam.pvoe.estructuras.principal;

/**
 *
 * @author Equipo04
 */
import java.util.LinkedList;
import uam.pvoe.estructuras.clases.Alumno;
import uam.pvoe.estructuras.operaciones.OperacionesLista;

public class Principal {
    private static LinkedList<Alumno> listaAlumnos;
    public static void main(String[] args) {
        listaAlumnos = new LinkedList<Alumno>();
        insertarAlumno();
        imprimirLista();

        buscarAlumno("Matricula 2");
        buscarAlumno("Matricula 8");

        recuperarAlumno("Matricula 2");
        recuperarAlumno("Matricula 8");

        borrarAlumno("Matricula 8");
        borrarAlumno("Matricula 2");
    }

    /* Inserción de un alumno */
    public static void insertarAlumno(){
        OperacionesLista operaciones = new OperacionesLista();
        Alumno alumno;

        for(int i = 0; i < 5; i++){
            alumno = new Alumno();
            alumno.setMatricula("Matricula " + (i+1));
            alumno.setNombre("Nombre " + (i+1));
            alumno.setPrimerApellido("Primer Apellido " + (i+1));
            alumno.setSegundoApellido("Segundo Apellido " + (i+1));
            alumno.setLicenciatura("Licenciatura " + (i+1));
            listaAlumnos = operaciones.insertarAlumno(listaAlumnos, alumno);
        }
    }

    /* Imprimir una lista */
    public static void imprimirLista(){
        OperacionesLista operaciones = new OperacionesLista();
        operaciones.imprimirLista(listaAlumnos);
    }

    /* Buscar un alumno por matrícula */
    public static void buscarAlumno(String matricula){
        OperacionesLista operaciones = new OperacionesLista();
        int posicion = operaciones.buscarAlumno(listaAlumnos, matricula);
        if(posicion < 0){
            System.out.println("El alumno no se encuentra");
        } else {
            System.out.println("El alumno está en la posición " + posicion);
        }
    }

    /* Recuperar un alumno */
    public static void recuperarAlumno(String matricula){
        OperacionesLista operaciones = new OperacionesLista();
        int posicion = operaciones.buscarAlumno(listaAlumnos, matricula);
        if(posicion >= 0){
            Alumno alumno = operaciones.regresaAlumno(listaAlumnos, posicion);
            System.out.println(alumno.toString());
        } else {
            System.out.println("El alumno no se encuentra");
        }
    }

    /* Borrar un alumno */
    public static void borrarAlumno(String matricula){
        OperacionesLista operaciones = new OperacionesLista();
        int posicion = operaciones.buscarAlumno(listaAlumnos, matricula);
        if(posicion >= 0){
            listaAlumnos = operaciones.borrarAlumno(listaAlumnos, posicion);
            imprimirLista();
        } else {
            System.out.println("El alumno no se encuentra");
        }
    }
}