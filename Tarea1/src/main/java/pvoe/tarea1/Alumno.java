
package pvoe.tarea1;


public class Alumno {
    private String matricula;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String licenciatura;
    private String genero;

    public Alumno(String matricula, String nombre, String primerApellido, String segundoApellido, String licenciatura, String genero) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.licenciatura = licenciatura;
        this.genero = genero;
    }

    public String getMatricula() { return matricula; }
    public String getLicenciatura() { return licenciatura; }
    public String getGenero() { return genero; }

    @Override
    public String toString() {
        return matricula + " - " + nombre + " " + primerApellido + " " + segundoApellido + 
               " (" + licenciatura + ", " + genero + ")";
    }
}

