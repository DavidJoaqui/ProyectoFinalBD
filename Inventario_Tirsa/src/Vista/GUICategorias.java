/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControlCategorias;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class GUICategorias extends javax.swing.JFrame {

    ControlCategorias ca = new ControlCategorias();
    DefaultTableModel dtm;

    String nombresColumnas[] = {"codigo Categoria", "nombre Categoria"};

    /**
     * Creates new form GUICategorias
     */
    public GUICategorias() {

        Object[][] categorias = ca.consultarCategoria();
        dtm = new DefaultTableModel(categorias, nombresColumnas);
        initComponents();
    }

    public void actualizarTabla() {
        Object data[][] = ca.consultarCategoria();
        dtm = new DefaultTableModel(data, nombresColumnas);
        tblcategorias.setModel(dtm);
        //validate();
        //repaint();
    }

    public void actualizarTabla(int codigo) {
        Object data[][] = ca.consultarCategoriaCodigo(codigo);
        dtm = new DefaultTableModel(data, nombresColumnas);
        tblcategorias.setModel(dtm);
        //validate();
        //repaint();
    }
 public void actualizarTabla(String letras) {
        Object data[][] = ca.consultarCategoriaLetras(letras);
        dtm = new DefaultTableModel(data, nombresColumnas);
        tblcategorias.setModel(dtm);
        //validate();
        //repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtcod_categoria = new javax.swing.JTextField();
        txtnombrecategoria = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcategorias = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnvolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(734, 430));
        setMinimumSize(new java.awt.Dimension(734, 430));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Informacion Categorias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 14), new java.awt.Color(0, 102, 204))); // NOI18N

        txtcod_categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcod_categoriaKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Codigo Categoria");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Nombre Categoria");

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

        btnconsultar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnconsultar.setForeground(new java.awt.Color(51, 0, 102));
        btnconsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscar.png"))); // NOI18N
        btnconsultar.setText("Consultar");
        btnconsultar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtcod_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnguardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnconsultar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnactualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombrecategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcod_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtnombrecategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizar)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Registro de las categorias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 14), new java.awt.Color(0, 102, 204))); // NOI18N

        tblcategorias.setModel(dtm);
        jScrollPane1.setViewportView(tblcategorias);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 102));
        jLabel3.setText("Administracion categorias");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnvolver)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (!txtcod_categoria.getText().isEmpty() && !txtnombrecategoria.getText().isEmpty()) {
            int cod_categoria = Integer.parseInt(txtcod_categoria.getText());
            String nom_categoria = txtnombrecategoria.getText();
            if (ca.insertarCategoria(cod_categoria, nom_categoria)) {
                JOptionPane.showMessageDialog(this, "Guardado correctamente!", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo Guardar!\nRevisa la Informacion Ingresada", "Confirmacion", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar Codigo y Nombre de la Categoria!", "Advertencia",JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        if (!txtcod_categoria.getText().isEmpty()) {
            int cod_categoria = Integer.parseInt(txtcod_categoria.getText());
            Object[][] data = ca.consultarCategoriaCodigo(cod_categoria);
            if (data[0][0] != null) {
                txtnombrecategoria.setText(data[0][1].toString());

            } else {
                JOptionPane.showMessageDialog(this, "No se encontro el registro", "Advertencia", JOptionPane.WARNING_MESSAGE);
                txtnombrecategoria.setText("");
                txtcod_categoria.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar el codigo de la Categoria!","Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
       GUIPrincipal gpr=new GUIPrincipal();
        this.setVisible(false);
       gpr.setVisible(true);
       
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        if (!txtcod_categoria.getText().isEmpty() && !txtnombrecategoria.getText().isEmpty()) {
            int cod_categoria = Integer.parseInt(txtcod_categoria.getText());
            String nom_categoria = txtnombrecategoria.getText();
        if(ca.actualizarCategoria(cod_categoria, nom_categoria)){
        JOptionPane.showMessageDialog(this,"Se actulizo el registro correctamente!","Informacion",JOptionPane.INFORMATION_MESSAGE);
        actualizarTabla();
        }else{
        JOptionPane.showMessageDialog(this,"No se Encontro el Registro! "+cod_categoria,"Error!",JOptionPane.ERROR_MESSAGE);    
        }
        }else{
            JOptionPane.showMessageDialog(this,"Debe Consultar la Informacion de la Categoria! ","Error!",JOptionPane.WARNING_MESSAGE);    
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if(!txtcod_categoria.getText().isEmpty()){
        if(ca.eliminarCategoriaCodigo(Integer.parseInt(txtcod_categoria.getText()))){
            JOptionPane.showMessageDialog(this,"La categoria ha sido eliminada!","Confirmacion!",JOptionPane.INFORMATION_MESSAGE);
        }
        }else{
        JOptionPane.showMessageDialog(this,"Debe ingresar el codigo de la categoria","Advertencia!",JOptionPane.WARNING_MESSAGE);    
        }
        
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtcod_categoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcod_categoriaKeyReleased
        if(!txtcod_categoria.getText().isEmpty()){
            int numero = Integer.parseInt(txtcod_categoria.getText());
            actualizarTabla(numero);
        }
    }//GEN-LAST:event_txtcod_categoriaKeyReleased

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
            java.util.logging.Logger.getLogger(GUICategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICategorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblcategorias;
    private javax.swing.JTextField txtcod_categoria;
    private javax.swing.JTextField txtnombrecategoria;
    // End of variables declaration//GEN-END:variables
}
