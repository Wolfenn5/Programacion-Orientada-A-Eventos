package uam.pvoe.sw.botones.modelo;

public class AdministrarPersona 
{
    public boolean validarRFC(String rfc){
        if(rfc.length() == 10)
            return true;
            else
            return false;
        }
        public void registrarPersona(DatosPersona persona){
            System.out.println("Los Datos de la Persona registrada son: ");
            System.out.println(persona.toString());
        }
}
