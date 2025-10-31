package uam.pvoe.sw.botones.modelo;

public class DatosPersona 
{
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String RFC;
    private String direccion;
    public DatosPersona (String n, String pA, String sA, String rfc, String dir)
    {
        nombre = n;
        primerApellido = pA;
        segundoApellido = sA;
        RFC = rfc.toUpperCase();
        direccion = dir;
    }
    
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPrimerApellido() {
        return primerApellido;
    }
    
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    
    public String getRFC() {
        return RFC;
    }
    
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString(){
        String cadena = "";
        cadena = nombre + " " + primerApellido + " " + segundoApellido + " " + RFC + " " + direccion;
        return cadena;
    }
}
