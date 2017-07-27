package Vista;

import Control.ControlEmpleado;
import Control.ControlEmpleado_Rol;
import Control.ControlPersona;
import Control.ControlRoles;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 1061792939
 */
public class GUIEmpleado extends javax.swing.JFrame {

    ControlEmpleado ce = new ControlEmpleado();
    ControlPersona cp = new ControlPersona();
    ControlRoles cr = new ControlRoles();
    ControlEmpleado_Rol cer=new ControlEmpleado_Rol();
    DefaultTableModel dtm;
    DefaultComboBoxModel cbx;
    String nombresColumnas[] = {"codigo Persona", "Usuario", "Contraseña"};

    public GUIEmpleado() {
        Object[][] roles = cr.consultarRol();
        int num_roles = cr.contarRoles();
        int i = 0;
        String aux[] = new String[num_roles];
        while (i != num_roles) {
            aux[i] = String.valueOf(roles[i][0] + "-" + roles[i][1]);
            i++;
        }
        cbx = new DefaultComboBoxModel(aux);
        Object[][] data = ce.consultarEmpleado();
        dtm = new DefaultTableModel(data, nombresColumnas);
        initComponents();
        setLocationRelativeTo(null);

    }

    public void actualizarTabla() {
        Object data[][] = ce.consultarEmpleado();
        dtm = new DefaultTableModel(data, nombresColumnas);
        tblempleados.setModel(dtm);
        //validate();
        //repaint();
    }

    public void limpiar() {
        txtcod_empleado.setText("");
        txtnumero_documento.setText("");
        txtnombres.setText("");
        txtapellido.setText("");
        txtcorreo.setText("");
        txtfecha.setDate(null);
        txtusuario.setText("");
        txtpassword.setText("");
        txtconfirmacionPassword.setText("");
    }

    public boolean validacionIngreso() {
        boolean bandera = false;
        if (!txtcod_empleado.getText().isEmpty() && !txtnumero_documento.getText().isEmpty() && !txtnombres.getText().isEmpty() && !txtapellido.getText().isEmpty() && !txtcorreo.getText().isEmpty() && !txtusuario.getText().isEmpty() && !txtpassword.getText().isEmpty() && !txtconfirmacionPassword.getText().isEmpty()) {
            bandera = true;
        }
        return bandera;
    }
    public int Conseguir_cod_Rol() {
        int aux = cbxroles.getSelectedItem().toString().indexOf("-");
        Object data[][] =cr.consultarRolNombre(cbxroles.getSelectedItem().toString().substring(aux + 1, cbxroles.getSelectedItem().toString().length()));;

        String cadena = String.valueOf(cbxroles.getSelectedItem().toString().substring(0, aux));
        int numero = Integer.parseInt(cadena);
        return numero;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtcod_empleado = new javax.swing.JTextField();
        txtnumero_documento = new javax.swing.JTextField();
        txtnombres = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtconfirmacionPassword = new javax.swing.JPasswordField();
        txtfecha = new com.toedter.calendar.JDateChooser();
        cbxroles = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnvolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblempleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setText("Codigo Empleado");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 22, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setText("Número de Documento");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 48, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel4.setText("Nombres");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 74, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel5.setText("Apellidos");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel6.setText("Correo");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel7.setText("Fecha Nacimiento");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        jPanel2.add(txtcod_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 20, 116, -1));
        jPanel2.add(txtnumero_documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 46, 116, -1));
        jPanel2.add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 72, 116, -1));
        jPanel2.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 98, 115, -1));
        jPanel2.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 20, 230, -1));

        btnguardar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(51, 0, 102));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 196, -1, -1));

        btnconsultar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnconsultar.setForeground(new java.awt.Color(51, 0, 102));
        btnconsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscar.png"))); // NOI18N
        btnconsultar.setText("Buscar");
        btnconsultar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });
        jPanel2.add(btnconsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 200, -1, -1));

        btnactualizar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnactualizar.setForeground(new java.awt.Color(51, 0, 102));
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/actualizar.png"))); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 196, -1, -1));

        btneliminar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(51, 0, 102));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 196, -1, 41));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("Usuario");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel8.setText("Contraseña");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));
        jPanel2.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 228, -1));
        jPanel2.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 228, -1));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel9.setText("Confirmar Contraseña");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));
        jPanel2.add(txtconfirmacionPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 228, -1));
        jPanel2.add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 140, -1));

        cbxroles.setModel(cbx);
        jPanel2.add(cbxroles, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 228, -1));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel11.setText("Rol");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 0, 102));
        jLabel10.setText("Administracion Empleados");

        btnvolver.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnvolver.setForeground(new java.awt.Color(51, 0, 102));
        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/atras.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnvolver)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        tblempleados.setModel(dtm);
        jScrollPane1.setViewportView(tblempleados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (validacionIngreso()) {
            int codigo = Integer.parseInt(txtcod_empleado.getText());
            int num_doc = Integer.parseInt(txtnumero_documento.getText());
            String nombres = txtnombres.getText();
            String apellidos = txtapellido.getText();
            String correo = txtcorreo.getText();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String fecha = "";
            String usuario = txtusuario.getText();
            String password = txtpassword.getText();
            String confirmcionPassword = txtconfirmacionPassword.getText();
            if (txtfecha.getDate() != null) {
                fecha = dateFormat.format(txtfecha.getDate());
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese la fecha de naciminento!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            Object[][] data = ce.consultarEmpleadoLogin(usuario);
            if (data[0][0] == null) {
                if (password.equals(confirmcionPassword)) {
                    if (cp.insertarPersona(codigo, num_doc, nombres, apellidos, correo, fecha)) {
                        if (ce.insertarEmpleado(codigo, usuario, password)) {                            
                            if(cer.insertarEmpleado_Rol(codigo, this.Conseguir_cod_Rol())){
                            JOptionPane.showMessageDialog(this, "Guardado Exitosamente!", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                            limpiar();
                            actualizarTabla();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "El registro NO se ha guardado Corrrectamente\nRevise los datos Ingresados!", "Confirmacion", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "El registro de la persona NO se ha guardado Corrrectamente\nRevise los datos Ingresados!", "Confirmacion", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "las contraseñas No coinciden\n Vuelva intentarlo...", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El Usuario ya Existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "debe ingresar la Informacion Requerida", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        if (!txtcod_empleado.getText().isEmpty()) {
            int cod_cliente = Integer.parseInt(txtcod_empleado.getText());
            Object[][] data = ce.consultarEmpleadoPersona(cod_cliente);
            if (data[0][0] != null) {
                txtcod_empleado.setText(data[0][0].toString());
                txtusuario.setText(data[0][1].toString());
                txtpassword.setText(data[0][2].toString());
                txtnumero_documento.setText(data[0][3].toString());
                txtnombres.setText(data[0][4].toString());
                txtapellido.setText(data[0][5].toString());
                txtcorreo.setText(data[0][6].toString());
                String fecha = data[0][7].toString();

                try {
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaDate;
                    fechaDate = formato.parse(fecha);
                    txtfecha.setDate(fechaDate);
                } catch (ParseException ex) {
                    Logger.getLogger(GUIEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(this, "El cliente No se encuentra Registrado!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(this, "Por favor Ingresa el codigo del cliente!", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        if (validacionIngreso()) {
            int codempleado = Integer.parseInt(txtcod_empleado.getText());
            int num_doc = Integer.parseInt(txtnumero_documento.getText());
            String nombres = txtnombres.getText();
            String apellidos = txtapellido.getText();
            String correo = txtcorreo.getText();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String fecha = "";
            String usuario = txtusuario.getText();
            String password = txtpassword.getText();
            String confirmcionPassword = txtconfirmacionPassword.getText();
            if (txtfecha.getDate() != null) {
                fecha = dateFormat.format(txtfecha.getDate());
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese la fecha compra!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

            Object[][] data = ce.consultarEmpleadoLogin(usuario);
            Object[][] data2 = ce.consultarEmpleadoPersona(codempleado);
            if (data2[0][0] != null) {
                if (data[0][0] == null || data[0][1].equals(usuario)) {
                    if (password.equals(confirmcionPassword)) {
                        if (cp.actualizarPersona(codempleado, num_doc, nombres, apellidos, correo, fecha)) {
                            if (ce.actualizarEmpleado(codempleado, usuario, password)) {
                                JOptionPane.showMessageDialog(this, "Se ha actualizado Exitosamente!", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                                limpiar();
                                actualizarTabla();

                            } else {
                                JOptionPane.showMessageDialog(this, "El empleado No se actualizo correctamente!", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "El registro NO se actualizo Corrrectamente\nRevise los datos Ingresados!", "Confirmacion", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "las contraseñas No coinciden\n Vuelva intentarlo...", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El Usuario ya Existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El Usuario No Existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "debe ingresar la Informacion Requerida", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if (!txtcod_empleado.getText().isEmpty()) {
            Object[][] data = ce.consultarEmpleadoPersona(Integer.parseInt(txtcod_empleado.getText()));
            if (data[0][0] != null) {
                int res = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar el registro del empleado: " + txtcod_empleado.getText(), "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {

                    if (ce.eliminarEmpleadoCodigo(Integer.parseInt(txtcod_empleado.getText()))) {
                        JOptionPane.showMessageDialog(this, "Eliminado");
                        txtcod_empleado.setText("");
                        actualizarTabla();
                    } else {
                        JOptionPane.showMessageDialog(this, "El Empleado No se Encontro");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "El registro No fue Eliminado");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El usuario No existe!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe Ingresar el codigo del empleado!", "Advertencia!", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        GUIPrincipal gpr = new GUIPrincipal();
        this.setVisible(false);
        gpr.setVisible(true);
    }//GEN-LAST:event_btnvolverActionPerformed

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
            java.util.logging.Logger.getLogger(GUIEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox cbxroles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblempleados;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcod_empleado;
    private javax.swing.JPasswordField txtconfirmacionPassword;
    private javax.swing.JTextField txtcorreo;
    private com.toedter.calendar.JDateChooser txtfecha;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txtnumero_documento;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
