/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uam.pvoe.sw.ei.operaciones;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import uam.pvoe.sw.ei.modelo.Infante;

/**
 *
 * @author btosk
 */
public class FormularioHelper {


    public static String validarCampos(JTextField nombre, JTextField apellidos, JTextField tutor, JTextField tel, JRadioButton rdoMasc, JRadioButton rdoFem, JRadioButton rdoMat, JRadioButton rdoVesp) {
        
        if (nombre.getText().trim().isEmpty() || apellidos.getText().trim().isEmpty() || tutor.getText().trim().isEmpty() || tel.getText().trim().isEmpty()) {
            return "Faltan datos obligatorios. Por favor verifique:\n\n"
                    + "- Nombre y Apellidos del infante\n"
                    + "- Género\n"
                    + "- Nombre del tutor\n"
                    + "- Teléfono\n"
                    + "- Turno";
        }
        if (!rdoMasc.isSelected() && !rdoFem.isSelected()) 
        {
            return "Seleccione género.";
        }
        if (!rdoMat.isSelected() && !rdoVesp.isSelected()) {
            return "Seleccione turno.";
        }
        return null; // todo bien
    }

    
    // datos en un objeto Infante para usar en el "modo" edicion
    public static Infante recolectarDatos(JTextField txtNombre, JTextField txtApellidos, JSpinner spnEdad, JSpinner spnMeses, JRadioButton rdoMasculino, JTextField txtTutor, JTextField txtDireccion,  JTextField txtTel, JTextField txtEmergencia, JComboBox cmbNivel, JComboBox cmbSubNivel, JRadioButton rdoMatutino, JCheckBox chkDieta, JTextArea txtAreaDieta, JLabel lblCostoTotal) {
        
        
        Infante inf = new Infante();
        inf.nombre = txtNombre.getText();
        inf.apellidos = txtApellidos.getText();
        inf.anios = (Integer) spnEdad.getValue();
        inf.meses = (Integer) spnMeses.getValue();
        inf.genero = rdoMasculino.isSelected() ? "Masculino" : "Femenino";
        inf.tutor = txtTutor.getText();
        inf.direccion = txtDireccion.getText();
        inf.tel = txtTel.getText();
        inf.emergencia = txtEmergencia.getText();
        inf.nivel = cmbNivel.getSelectedItem().toString();
        inf.subnivel = cmbSubNivel.getSelectedItem().toString();
        inf.horario = rdoMatutino.isSelected() ? "Matutino" : "Vespertino";
        inf.tieneDieta = chkDieta.isSelected() ? "Si" : "No";
        String dieta = txtAreaDieta.getText().replace("\n", " ").replace(",", ";");
        inf.detalleDieta = dieta.isEmpty() ? "Ninguna" : dieta;
        inf.costoTotal = lblCostoTotal.getText();
        return inf;
    }
}
