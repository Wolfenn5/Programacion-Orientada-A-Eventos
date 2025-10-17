package uam.pvoe.estructuras.clases;

/**
 *
 * @author Equipo04
 */
public class Alumno {
    private String matricula;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String licenciatura;

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getPrimerApellido(){
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido){
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido(){
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido){
        this.segundoApellido = segundoApellido;
    }

    public String getLicenciatura(){
        return licenciatura;
    }

    public void setLicenciatura(String licenciatura){
        this.licenciatura = licenciatura;
    }

    public String toString(){
        String mensaje = "";
        mensaje = this.matricula + " " + this.nombre + " " + this.primerApellido + " " + this.segundoApellido + " " + this.licenciatura;
        return mensaje;
    }
}