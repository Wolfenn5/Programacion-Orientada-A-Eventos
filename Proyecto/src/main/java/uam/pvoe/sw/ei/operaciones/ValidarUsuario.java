/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.sw.ei.operaciones;
import uam.pvoe.sw.ei.modelo.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 *
 * @author btosk
 */
public class ValidarUsuario {
    public boolean validarUsuario(Usuario usr) {
        boolean acceso = false;
        
        
        
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            

            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ","); // , como separador
                
                
                if (st.countTokens() >= 2) { // tokens
                    String usuarioArchivo = st.nextToken();
                    String passwordArchivo = st.nextToken();
                    
                    
                    if (usr.getLogin().equals(usuarioArchivo) && usr.getPassword().equals(passwordArchivo)) {
                        acceso = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo txt de usuarios: " + e.getMessage());
        }
        
        return acceso;
    }
}
