/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.sw.ei.operaciones;
import uam.pvoe.sw.ei.modelo.Usuario;


/**
 *
 * @author btosk
 */
public class ValidarUsuario {
    public boolean validarUsuario(Usuario usr) {
        // Simulamos un usuario y contraseña fijos
        if (usr.getLogin().equals("admin") && usr.getPassword().equals("1234")) {
            return true;
        } else {
            return false;
        }
    }
}
