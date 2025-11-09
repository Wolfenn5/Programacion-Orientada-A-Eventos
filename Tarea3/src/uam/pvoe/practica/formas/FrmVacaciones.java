/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uam.pvoe.practica.formas;



import uam.pvoe.practica.modelo.Estado;
import uam.pvoe.practica.modelo.Atractivo;
import uam.pvoe.practica.modelo.MedioTransporte;
import uam.pvoe.practica.modelo.Servicio;
import uam.pvoe.practica.operaciones.Archivos;


/**
 *
 * @author
 */
public class FrmVacaciones extends javax.swing.JFrame {

        private javax.swing.DefaultComboBoxModel<uam.pvoe.practica.modelo.Estado> mEstados =
        new javax.swing.DefaultComboBoxModel<>();
private javax.swing.DefaultComboBoxModel<uam.pvoe.practica.modelo.Atractivo> mAtractivos =
        new javax.swing.DefaultComboBoxModel<>();

private java.util.List<uam.pvoe.practica.modelo.Estado> estados;
private java.util.List<uam.pvoe.practica.modelo.Atractivo> atractivos;

    /**
     * Creates new form FrmVacaciones
     */
    public FrmVacaciones() {
        initComponents();
        postInit();
    }

private void postInit(){
   
cmbEstado.setModel(mEstados);
cmbAtractivo.setModel(mAtractivos);

estados = Archivos.leerEstados("./estados.dat");
atractivos = Archivos.leerAtractivos("./atractivos.dat");

mEstados.removeAllElements();
mEstados.addElement(new Estado("Selecciona Estado", ""));
for(Estado e : estados) 
    mEstados.addElement(e);  

cmbEstado.setSelectedIndex(0);


    
    setZonaDependienteVisible(false);

   
    prepararMedios();
    prepararServicios();

    
    cmbEstado.addActionListener(new java.awt.event.ActionListener() {
        @Override public void actionPerformed(java.awt.event.ActionEvent evt) {
            onEstadoSeleccionado();
        }
    });
    btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
        @Override public void actionPerformed(java.awt.event.ActionEvent evt) {
            onRegistrar();
        }
    });
}

    
    private void setZonaDependienteVisible(boolean v){
    lblSeleccionaAtractivo.setVisible(v);
    cmbAtractivo.setVisible(v);

    lblFormaViaje.setVisible(v);
    btnAutobus.setVisible(v);
    btnAvion.setVisible(v);
    btnAutoPropio.setVisible(v);
    btnAutoRentado.setVisible(v);

    lblServicioAdicional.setVisible(v);
    chkDesayuno.setVisible(v);
    chkTour.setVisible(v);
    chkLavanderia.setVisible(v);
    chkGuarderia.setVisible(v);
    chkCajaFuerte.setVisible(v);
    chkDespertador.setVisible(v);

    btnRegistrar.setVisible(v);
}

    private void prepararMedios(){
    MedioTransporte m1 = new MedioTransporte("Auto",        "AUTO");
    MedioTransporte m2 = new MedioTransporte("Autobús",     "BUS");
    MedioTransporte m3 = new MedioTransporte("Avión",       "AVION");
    MedioTransporte m4 = new MedioTransporte("Auto Rentado","AUTO_R");

    btnAutoPropio.setText(m1.getNombre()); btnAutoPropio.putClientProperty("obj", m1);
    btnAutobus.setText(m2.getNombre());    btnAutobus.putClientProperty("obj", m2);
    btnAvion.setText(m3.getNombre());      btnAvion.putClientProperty("obj", m3);
    btnAutoRentado.setText(m4.getNombre());btnAutoRentado.putClientProperty("obj", m4);

  
}

private void prepararServicios(){
    chkDesayuno.setText("Desayuno");
chkDesayuno.putClientProperty("obj", new Servicio("Desayuno", "DES"));

chkTour.setText("Recorridos");
chkTour.putClientProperty("obj", new Servicio("Recorridos", "REC"));

chkLavanderia.setText("Lavandería");
chkLavanderia.putClientProperty("obj", new Servicio("Lavandería", "LAV"));

chkGuarderia.setText("Guardería");
chkGuarderia.putClientProperty("obj", new Servicio("Guardería", "GUAR"));

chkCajaFuerte.setText("Caja Fuerte");
chkCajaFuerte.putClientProperty("obj", new Servicio("Caja Fuerte", "CAJA"));

chkDespertador.setText("Despertador");
chkDespertador.putClientProperty("obj", new Servicio("Despertador", "DESP"));

}


private void onEstadoSeleccionado(){
    Estado sel = (Estado) cmbEstado.getSelectedItem();
    
    mAtractivos.removeAllElements();
    boolean valido = (sel!= null && sel.getClaveEstado() != null && !sel.getClaveEstado().trim().isEmpty());

    
    if(!valido){
        
        setZonaDependienteVisible(false);
        return;
    }

    setZonaDependienteVisible(true);
    String claveSel = sel.getClaveEstado().trim();
    for (Atractivo a : atractivos) {
        if (claveSel.equals(a.getClaveEstado().trim())) {
            mAtractivos.addElement(a); 
    }
}
}


private void onRegistrar(){
    Estado e = (Estado) cmbEstado.getSelectedItem();
    Atractivo a = (Atractivo) cmbAtractivo.getSelectedItem();

    MedioTransporte medio = null;
    if (btnAutoPropio.isSelected())
        medio = (MedioTransporte) btnAutoPropio.getClientProperty("obj");
    else if (btnAutobus.isSelected())
        medio = (MedioTransporte) btnAutobus.getClientProperty("obj");
    else if (btnAvion.isSelected())
        medio = (MedioTransporte) btnAvion.getClientProperty("obj");
    else if (btnAutoRentado.isSelected())
        medio = (MedioTransporte) btnAutoRentado.getClientProperty("obj");

    java.util.List<Servicio> servs = new java.util.ArrayList<Servicio>();
    for (javax.swing.JCheckBox chk : java.util.Arrays.asList(
            chkDesayuno, chkTour, chkLavanderia, chkGuarderia, chkCajaFuerte, chkDespertador)) {
        if (chk.isSelected())
            servs.add((Servicio) chk.getClientProperty("obj"));
    }

    StringBuilder sb = new StringBuilder();
    sb.append("Selección actual\n");


    sb.append("Estado: ");
    if (e != null && e.getNombre() != null)
        sb.append(e.getNombre()).append(" (").append(e.getClaveEstado()).append(")\n");
    else
        sb.append("(ninguno)\n");


    sb.append("Atractivo: ");
    if (a != null && a.getNombre() != null)
        sb.append(a.getNombre()).append(" (").append(a.getAtractivo()).append(")\n");
    else
        sb.append("(ninguno)\n");


    sb.append("Medio de transporte: ");
    if (medio != null)
        sb.append(medio.getNombre()).append(" (").append(medio.getClaveMedio()).append(")\n");
    else
        sb.append("(ninguno)\n");


    sb.append("Servicios:\n");
    if (servs.isEmpty()) {
        sb.append("  (ninguno)\n");
    } else {
        for (Servicio s : servs) {
            sb.append("  * ").append(s.getNombre())
              .append(" (").append(s.getClave()).append(")\n");
        }
    }

    javax.swing.JOptionPane.showMessageDialog(
        this, sb.toString(), "Información de selección",
        javax.swing.JOptionPane.INFORMATION_MESSAGE);
}





    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        grupoMedios = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbAtractivo = new javax.swing.JComboBox<>();
        lblSeleccionaEstado = new javax.swing.JLabel();
        lblSeleccionaAtractivo = new javax.swing.JLabel();
        lblServicioAdicional = new javax.swing.JLabel();
        spr = new javax.swing.JSeparator();
        btnAutobus = new javax.swing.JRadioButton();
        btnAvion = new javax.swing.JRadioButton();
        btnAutoPropio = new javax.swing.JRadioButton();
        btnAutoRentado = new javax.swing.JRadioButton();
        lblFormaViaje = new javax.swing.JLabel();
        chkDesayuno = new javax.swing.JCheckBox();
        chkTour = new javax.swing.JCheckBox();
        chkLavanderia = new javax.swing.JCheckBox();
        chkGuarderia = new javax.swing.JCheckBox();
        chkCajaFuerte = new javax.swing.JCheckBox();
        chkDespertador = new javax.swing.JCheckBox();
        btnRegistrar = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta para Vacaciones");
        setMinimumSize(new java.awt.Dimension(800, 600));

        lblTitulo.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblTitulo.setText("Selección de Destinos Turísticos");

        lblSeleccionaEstado.setText("Selecciona el Estado");

        lblSeleccionaAtractivo.setText("Selecciona el Atractivo Turístico");

        lblServicioAdicional.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblServicioAdicional.setText("Servicios Adicionales en tu Estancia");

        grupoMedios.add(btnAutobus);

        grupoMedios.add(btnAvion);

        grupoMedios.add(btnAutoPropio);

        grupoMedios.add(btnAutoRentado);

        lblFormaViaje.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblFormaViaje.setText("¿Cómo piensas viajar?");

        chkDesayuno.setText("jCheckBox1");
        chkDesayuno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDesayunoActionPerformed(evt);
            }
        });

        chkTour.setText("jCheckBox2");

        chkLavanderia.setText("jCheckBox3");

        chkGuarderia.setText("jCheckBox4");

        chkCajaFuerte.setText("jCheckBox5");

        chkDespertador.setText("jCheckBox6");

        btnRegistrar.setText("Registrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistrar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(spr, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitulo)
                            .addComponent(cmbEstado, 0, 498, Short.MAX_VALUE)
                            .addComponent(cmbAtractivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(lblSeleccionaEstado)
                        .addComponent(lblSeleccionaAtractivo)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAutobus)
                            .addGap(64, 64, 64)
                            .addComponent(btnAvion)
                            .addGap(69, 69, 69)
                            .addComponent(btnAutoPropio)
                            .addGap(70, 70, 70)
                            .addComponent(btnAutoRentado))
                        .addComponent(lblFormaViaje)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(chkTour)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkGuarderia))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(chkDesayuno)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkLavanderia))
                                .addComponent(lblServicioAdicional, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(72, 72, 72)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(chkCajaFuerte)
                                .addComponent(chkDespertador)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(40, 40, 40)
                .addComponent(lblSeleccionaEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblSeleccionaAtractivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAtractivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(spr, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFormaViaje)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAutobus)
                    .addComponent(btnAvion)
                    .addComponent(btnAutoPropio)
                    .addComponent(btnAutoRentado))
                .addGap(37, 37, 37)
                .addComponent(lblServicioAdicional)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkDesayuno)
                    .addComponent(chkLavanderia)
                    .addComponent(chkCajaFuerte))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkTour)
                    .addComponent(chkGuarderia)
                    .addComponent(chkDespertador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkDesayunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDesayunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkDesayunoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVacaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVacaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVacaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVacaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVacaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnAutoPropio;
    private javax.swing.JRadioButton btnAutoRentado;
    private javax.swing.JRadioButton btnAutobus;
    private javax.swing.JRadioButton btnAvion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JCheckBox chkCajaFuerte;
    private javax.swing.JCheckBox chkDesayuno;
    private javax.swing.JCheckBox chkDespertador;
    private javax.swing.JCheckBox chkGuarderia;
    private javax.swing.JCheckBox chkLavanderia;
    private javax.swing.JCheckBox chkTour;
    private javax.swing.JComboBox<Atractivo> cmbAtractivo;
    private javax.swing.JComboBox<Estado> cmbEstado;
    private javax.swing.ButtonGroup grupoMedios;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel lblFormaViaje;
    private javax.swing.JLabel lblSeleccionaAtractivo;
    private javax.swing.JLabel lblSeleccionaEstado;
    private javax.swing.JLabel lblServicioAdicional;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSeparator spr;
    // End of variables declaration//GEN-END:variables
}
