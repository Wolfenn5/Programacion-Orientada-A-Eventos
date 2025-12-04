/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uam.pvoe.sw.ei.formas;

/**
 *
 * @author btosk
 */
public class RegistroInfanteFrm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegistroInfanteFrm.class.getName());
    
    // Variables para controlar el modo Edición
    private boolean modoEdicion = false;
    private String nombreOriginal = "";
    private String apellidoOriginal = "";
    
    
    
    /**
     * Creates new form RegistrarInfanteFrm
     */
    public RegistroInfanteFrm() {
        initComponents();
   
        javax.swing.JSpinner.DefaultEditor editorEdad = (javax.swing.JSpinner.DefaultEditor) spnEdad.getEditor();
        editorEdad.getTextField().setEditable(false); // que no se pueda editar el spinner de edad-años
        
        
        javax.swing.JSpinner.DefaultEditor editorMeses = (javax.swing.JSpinner.DefaultEditor) spnMeses.getEditor();
        editorMeses.getTextField().setEditable(false); // que no se pueda editar el spinner de edad-meses
        
        
        
        
        // --- NUEVO: LISTENER PARA CAMBIO DE NIVEL AUTOMÁTICO ---
        javax.swing.event.ChangeListener listenerEdad = new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                actualizarNivelPorEdad();
            }
        };
        
        // Se lo asignamos al spinner de Años (que es el que define el nivel principalmente)
        spnEdad.addChangeListener(listenerEdad);
        
        // (Opcional) También al de meses por si la lógica cambia en el futuro
        // spnMeses.addChangeListener(listenerEdad);
        
        
    }
    
    
    
    // Método de seguridad: Aplasta cualquier selección manual incorrecta
    private void corregirNivelPorEdad() {
        int anios = (Integer) spnEdad.getValue();
        // Nota: Asumimos que si tiene 0 años es Lactantes, 
        // pero si tuvieras lógica de meses, podrías usar spnMeses.getValue() aquí también.
        
        if (anios == 0) {
            cmbNivel.setSelectedIndex(0); // Lactantes
        } else if (anios >= 1 && anios <= 2) {
            cmbNivel.setSelectedIndex(1); // Maternal
        } else if (anios >= 3) {
            cmbNivel.setSelectedIndex(2); // Preescolar
        }
    }
    
    
    
    // Método para automatizar el Nivel según la edad
    private void actualizarNivelPorEdad() {
        int anios = (Integer) spnEdad.getValue();
        
        // Usamos los índices del Combo Box:
        // 0 = Lactantes
        // 1 = Maternal
        // 2 = Preescolar
        
        if (anios == 0) {
            cmbNivel.setSelectedIndex(0); // Lactantes
        } else if (anios >= 1 && anios <= 2) {
            cmbNivel.setSelectedIndex(1); // Maternal
        } else if (anios >= 3) {
            cmbNivel.setSelectedIndex(2); // Preescolar
        }
        
        // Opcional: Si tienes más niveles, ajusta la lógica aquí.
    }
    
    
    // -------------------------------------------------------------
    // PEGA ESTE BLOQUE EN RegistroInfanteFrm.java
    // -------------------------------------------------------------
    public void cargarDatosParaEdicion(String[] datos) {
        this.modoEdicion = true;
        this.nombreOriginal = datos[0];
        this.apellidoOriginal = datos[1];
        
        // Cambio visual para que el usuario sepa que está editando
        this.setTitle("Estancia Infantil - Azcapotzalco: EDICIoN DE DATOS");
        btnGuardar.setText("Actualizar Datos");
        
        // 1. Llenar Textos y Spinners
        txtNombre.setText(datos[0]);
        txtApellidos.setText(datos[1]);
        
        try {
            spnEdad.setValue(Integer.valueOf(datos[2]));
            spnMeses.setValue(Integer.valueOf(datos[3]));
        } catch (NumberFormatException e) {
            // Si el archivo tenía basura, ponemos 0
            spnEdad.setValue(0);
            spnMeses.setValue(0);
        }
        
        // 2. Llenar Género
        if (datos[4].equals("Masculino")) rdoMasculino.setSelected(true);
        else rdoFemenino.setSelected(true);
        
        // 3. Tutor y Contacto
        txtTutor.setText(datos[5]);
        txtDireccion.setText(datos[6]);
        txtTel.setText(datos[7]);
        txtEmergencia.setText(datos[8]);
        
        // 4. Niveles
        cmbNivel.setSelectedItem(datos[9]);
        cmbSubNivel.setSelectedItem(datos[10]);
        
        // 5. Horario
        if (datos[11].equals("Matutino")) rdoMatutino.setSelected(true);
        else rdoVespertino.setSelected(true);
        
        // 6. Salud
        chkDieta.setSelected(datos[12].equals("Si"));
        // Reemplazar ; por , para mostrarlo bien en pantalla (en el archivo usamos ;)
        txtAreaDieta.setText(datos[13].equals("Ninguna") ? "" : datos[13].replace(";", ","));
        
        // 7. Costos
        lblCostoTotal.setText(datos[14]);
    }
    
    
    private void limpiarFormulario() {
        txtNombre.setText("");
        txtApellidos.setText("");
        spnEdad.setValue(0);
        spnMeses.setValue(0);
        grpGenero.clearSelection();
        txtTutor.setText("");
        txtDireccion.setText("");
        txtTel.setText("");
        txtEmergencia.setText("");
        cmbNivel.setSelectedIndex(0);
        grpHorario.clearSelection();
        chkDieta.setSelected(false);
        txtAreaDieta.setText("");
        lblCostoNivel.setText("$0.00");
        lblCostoExtra.setText("$0.00");
        lblCostoTotal.setText("$0.00");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpGenero = new javax.swing.ButtonGroup();
        grpHorario = new javax.swing.ButtonGroup();
        lblNombreInfante = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        spnEdad = new javax.swing.JSpinner();
        rdoMasculino = new javax.swing.JRadioButton();
        rdoFemenino = new javax.swing.JRadioButton();
        lblDatosInfante = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombreTutor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTutor = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtEmergencia = new javax.swing.JTextField();
        cmbNivel = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbSubNivel = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        chkDieta = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDieta = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        rdoMatutino = new javax.swing.JRadioButton();
        rdoVespertino = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCostoNivel = new javax.swing.JLabel();
        lblCostoExtra = new javax.swing.JLabel();
        lblCostoTotal = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spnMeses = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estancia Infantil - Azcapotzalco:  Registro");

        lblNombreInfante.setText("Nombre");

        jLabel1.setText("Apellidos");

        jLabel2.setText("Edad (si el infante tiene 45 dias o mas, ponga 0 meses) ");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        spnEdad.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));

        grpGenero.add(rdoMasculino);
        rdoMasculino.setText("Masculino");

        grpGenero.add(rdoFemenino);
        rdoFemenino.setText("Femenino");

        lblDatosInfante.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDatosInfante.setText("Datos Del Infante");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Datos Del Tutor");

        lblNombreTutor.setText("Nombre Completo");

        jLabel4.setText("Direccion");

        jLabel5.setText("Telefono");

        jLabel6.setText("Telefono de Emergencia");

        txtTutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTutorKeyTyped(evt);
            }
        });

        txtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelKeyTyped(evt);
            }
        });

        txtEmergencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmergenciaKeyTyped(evt);
            }
        });

        cmbNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lactantes (45 dias a 11 meses)", "Maternal (1 a 2 años)", "Preescolar (3 a 4 años)" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Niveles");

        cmbSubNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subnivel A", "Subnivel B" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Salud y Alimentacion Especial");

        chkDieta.setText("Si necesita alimentacion especial");

        txtAreaDieta.setColumns(20);
        txtAreaDieta.setRows(5);
        jScrollPane1.setViewportView(txtAreaDieta);

        btnGuardar.setText("Guardar Datos y Registrar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar al Menu");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        grpHorario.add(rdoMatutino);
        rdoMatutino.setText("Matutino");

        grpHorario.add(rdoVespertino);
        rdoVespertino.setText("Vespertino");

        jLabel9.setText("Costo Nivel");

        jLabel10.setText("Costo Extra");

        jLabel11.setText("Total");

        lblCostoNivel.setText("$0.00");

        lblCostoExtra.setText("$0.00");

        lblCostoTotal.setText("$0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCostoNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblCostoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCostoNivel)
                    .addComponent(lblCostoExtra)
                    .addComponent(lblCostoTotal))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnCalcular.setText("Calcular Costos");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel12.setText("Años");

        jLabel13.setText("Meses");

        spnMeses.setModel(new javax.swing.SpinnerNumberModel(0, 0, 11, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2))
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(rdoMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNombreInfante, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(rdoMatutino, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(rdoVespertino, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(109, 109, 109)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addGap(22, 22, 22))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(rdoFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(spnEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatosInfante, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(cmbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(cmbSubNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkDieta)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(btnCalcular)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNombreTutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTel)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatosInfante)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreInfante)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoMasculino)
                            .addComponent(rdoFemenino)
                            .addComponent(spnEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreTutor)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSubNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoMatutino)
                            .addComponent(rdoVespertino))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(chkDieta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCalcular)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegresar)
                            .addComponent(btnGuardar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
            
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        MenuPrincipalFrm menu = new MenuPrincipalFrm();
        menu.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // 1. Corrección forzosa
        corregirNivelPorEdad();
        double costoBase = 0.0;
        double costoExtra = 0.0;

        String nivel = (String) cmbNivel.getSelectedItem();

        
        // precios
        if(nivel.contains("Lactantes")) costoBase = 2800.0;
        else if (nivel.contains("Maternal")) costoBase = 2500.0;
        else if (nivel.contains("Preescolar")) costoBase = 2200.0;
               
        if(chkDieta.isSelected()) costoExtra = 600.0;

        
        
        
        // Asignar a los labels 
        lblCostoNivel.setText("$ " + costoBase);
        lblCostoExtra.setText("$ " + costoExtra);
        lblCostoTotal.setText("$ " + (costoBase + costoExtra));
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // 1. VALIDACIÓN EXTERNA (Solo una línea)
        String error = uam.pvoe.sw.ei.operaciones.FormularioHelper.validarCampos(
                txtNombre, txtApellidos, txtTutor, txtTel, rdoMasculino, rdoFemenino, rdoMatutino, rdoVespertino);
        
        if (error != null) {
            javax.swing.JOptionPane.showMessageDialog(this, error, "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // ¡AGREGA ESTO AQUÍ!
        // Esto corrige el nivel milisegundos antes de guardar, 
        // anulando cualquier cambio manual incorrecto del usuario.
        corregirNivelPorEdad();
        
        
        
        // 2. RECOLECCIÓN DE DATOS (Solo una línea)
        // Ahora sí, lee los datos. 'nivel' tomará el valor corregido.
        String nombre = txtNombre.getText();
        String nivel = cmbNivel.getSelectedItem().toString();
        // Aseguramos que el costo esté calculado
        if(lblCostoTotal.getText().equals("$0.00")) btnCalcularActionPerformed(null);
        
        uam.pvoe.sw.ei.modelo.Infante infante = uam.pvoe.sw.ei.operaciones.FormularioHelper.recolectarDatos(
                txtNombre, txtApellidos, spnEdad, spnMeses, rdoMasculino, txtTutor, txtDireccion, 
                txtTel, txtEmergencia, cmbNivel, cmbSubNivel, rdoMatutino, chkDieta, txtAreaDieta, lblCostoTotal);

        // 3. GUARDADO (Lógica de Negocio)
        uam.pvoe.sw.ei.operaciones.GestionInfantes gestor = new uam.pvoe.sw.ei.operaciones.GestionInfantes();
        boolean exito;

        if (modoEdicion) {
            gestor.eliminarInfante(nombreOriginal, apellidoOriginal);
            exito = gestor.registrarInfante(infante.toCSV());
            if (exito) {
                javax.swing.JOptionPane.showMessageDialog(this, "Actualización exitosa.");
                this.dispose();
                new ConsultaNivelesFrm().setVisible(true);
            }
        } else {
            exito = gestor.registrarInfante(infante.toCSV());
            if (exito) {
                javax.swing.JOptionPane.showMessageDialog(this, "Registro exitoso.");
                limpiarFormulario();
            }
        }
        
        if (!exito) javax.swing.JOptionPane.showMessageDialog(this, "Error crítico al guardar.");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyTyped
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
}
    }//GEN-LAST:event_txtTelKeyTyped

    private void txtEmergenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmergenciaKeyTyped
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
}
    }//GEN-LAST:event_txtEmergenciaKeyTyped

    private void txtTutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTutorKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && c != ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTutorKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && c != ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isLetter(c) && c != ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new RegistroInfanteFrm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JCheckBox chkDieta;
    private javax.swing.JComboBox<String> cmbNivel;
    private javax.swing.JComboBox<String> cmbSubNivel;
    private javax.swing.ButtonGroup grpGenero;
    private javax.swing.ButtonGroup grpHorario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCostoExtra;
    private javax.swing.JLabel lblCostoNivel;
    private javax.swing.JLabel lblCostoTotal;
    private javax.swing.JLabel lblDatosInfante;
    private javax.swing.JLabel lblNombreInfante;
    private javax.swing.JLabel lblNombreTutor;
    private javax.swing.JRadioButton rdoFemenino;
    private javax.swing.JRadioButton rdoMasculino;
    private javax.swing.JRadioButton rdoMatutino;
    private javax.swing.JRadioButton rdoVespertino;
    private javax.swing.JSpinner spnEdad;
    private javax.swing.JSpinner spnMeses;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextArea txtAreaDieta;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmergencia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTutor;
    // End of variables declaration//GEN-END:variables
}
