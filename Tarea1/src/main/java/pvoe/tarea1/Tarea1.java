package pvoe.tarea1;


import java.util.Scanner;

public class Tarea1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaAlumnos lista = new ListaAlumnos();
        lista.cargarDesdeArchivo("alumnos.dat");

        int opcion;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Buscar alumno por matricula");
            System.out.println("2. Buscar alumnos por licenciatura");
            System.out.println("3. Buscar alumnos por genero");
            System.out.println("4. Borrar alumno por matricula");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Matricula: ");
                    String m = sc.nextLine();
                    Alumno a = lista.buscarPorMatricula(m);
                    if (a != null) System.out.println(a);
                    else System.out.println("No existe alumno con esa matricula.");
                    break;
                case 2:
                    System.out.print("Licenciatura: ");
                    String l = sc.nextLine();
                    lista.buscarPorLicenciatura(l);
                    break;
                case 3:
                    System.out.print("Genero (M/F): ");
                    String g = sc.nextLine();
                    lista.buscarPorGenero(g);
                    break;
                case 4:
                    System.out.print("Matricula a eliminar: ");
                    String e = sc.nextLine();
                    lista.borrarPorMatricula(e);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}

