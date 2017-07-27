/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControlCategorias;
import Control.ControlDetalleFactura;
import Control.ControlFactura;
import Control.ControlPersona;
import Control.ControlProducto;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.gt;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 1061785255
 */
public class GUIPrincipal extends javax.swing.JFrame {
    
    Object datosCliente[][] = null;
    Object datosProducto[][] = null;
    Object datosCategoria[][] = null;
    Object productosAgregados[][] = new Object[20][5];
    DefaultTableModel dtm;
    int j = 1;
    int i = 0;

    String nombresColumnas[] = {"Codigo Producto", "Nombre", "Valor venta","Cantidad", "Categoría"};
   
  
    public void obtenerEmpleadoyRol(String codEmpleado, String codRol){
        lblRol.setText(codRol);
        lblEmpleado.setText(codEmpleado);     
    }

    public void AgregarProductos(){      
        ControlCategorias cc = new ControlCategorias();
        ControlDetalleFactura dfc = new ControlDetalleFactura();
        int suma=0;
        if(txtFactCodProducto.getText().length()>0 & txtFactNomProducto.getText().length()>0 && txtCantidad.getText().length()>0){
         
            for(int i=0; i<productosAgregados.length; i++){
                if(productosAgregados[i][0]!=null && String.valueOf(productosAgregados[i][0]).equals(txtFactCodProducto.getText())){
                    suma=Integer.parseInt(String.valueOf(productosAgregados[i][3]))+suma;
                }
            }
            Object cantidadProducto[][] = dfc.cantidadProductos(Integer.parseInt(txtFactCodProducto.getText()));
            if((suma+Integer.parseInt(txtCantidad.getText())+Integer.parseInt(String.valueOf(cantidadProducto[0][1])))
                    <=Integer.parseInt(String.valueOf(datosProducto[0][5]))){
                if(rbtnMaximo.isSelected() || rbtnMinimo.isSelected()){
                    if(rbtnMaximo.isSelected()){                 
                        productosAgregados[i][0] = datosProducto[0][0];
                        productosAgregados[i][1] = datosProducto[0][1];
                        float cantxvalor = Float.parseFloat(String.valueOf(datosProducto[0][4]))*Integer.parseInt(txtCantidad.getText());
                        productosAgregados[i][2] = cantxvalor;                   
                        productosAgregados[i][3] = txtCantidad.getText(); 
                        datosCategoria = cc.consultarCategoriaCodigo((int) datosProducto[0][6]);
                        productosAgregados[i][4] = datosCategoria[0][1]; 
                        btnAgregarProd.setEnabled(true);
                        i++;              
                        
                        float sum=0;
                        for(int i=0; i<productosAgregados.length; i++){
                            if(productosAgregados[i][2]!=null){
                                sum=Float.parseFloat(String.valueOf(productosAgregados[i][2]))+sum;
                                System.out.println(sum);
                            }
                        }
                        txtPagoTotal.setText(String.valueOf(sum));                       
                        dtm = new DefaultTableModel(productosAgregados, nombresColumnas);
                        tblProductos.setModel(dtm);
                        txtFactCodProducto.setText("");
                        txtFactNomProducto.setText("");
                        txtCantidad.setText("");
                        txtValorUnitario.setText("");
                        rbtnMaximo.setSelected(false);
                        rbtnMinimo.setSelected(false);
                    }else{
                        if(rbtnMinimo.isSelected()){                        
                            productosAgregados[i][0] = datosProducto[0][0];
                            productosAgregados[i][1] = datosProducto[0][1];
                            float cantxvalor = Float.parseFloat(String.valueOf(datosProducto[0][7]))*Integer.parseInt(txtCantidad.getText());
                            productosAgregados[i][2] = cantxvalor;                         
                            productosAgregados[i][3] = txtCantidad.getText();
                            datosCategoria = cc.consultarCategoriaCodigo((int) datosProducto[0][6]);
                            productosAgregados[i][4] = datosCategoria[0][1];  
                            btnAgregarProd.setEnabled(true);                        
                            i++;                      
                            
                            float sum=0;
                            for(int i=0; i<productosAgregados.length; i++){
                                if(productosAgregados[i][2]!=null){
                                    sum=Float.parseFloat(String.valueOf(productosAgregados[i][2]))+sum;
                                    System.out.println(sum);
                                }
                            }
                            txtPagoTotal.setText(String.valueOf(sum));                       
                            dtm = new DefaultTableModel(productosAgregados, nombresColumnas);
                            tblProductos.setModel(dtm);
                            txtFactCodProducto.setText("");
                            txtFactNomProducto.setText("");
                            txtCantidad.setText("");
                            txtValorUnitario.setText("");
                            rbtnMaximo.setSelected(false);
                            rbtnMinimo.setSelected(false);                            
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Debe selecionar el tipo de valor");           
                }         
            }else{
                JOptionPane.showMessageDialog(this, "El producto ha excedido la cantidad del inventario");  
            }      
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese todos los campos obligatorios (*)");
        }
        System.out.println(i);
    }    
    
    /**
     * Creates new form GUIPrincipal
     */
    public GUIPrincipal() {
        dtm = new DefaultTableModel(datosProducto, nombresColumnas);
        initComponents();
        if(lblRol.getText().equals("1")){
            mnuAdministrar.setVisible(true);
        }else{
            mnuAdministrar.setVisible(false);
        }
        
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        grpValor = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFactDocCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFactNomCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFactCodProducto = new javax.swing.JTextField();
        txtFactNomProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        gatitosh = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtPagoTotal = new javax.swing.JTextField();
        lblEmpleado = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFactApeCliente = new javax.swing.JTextField();
        rbtnMaximo = new javax.swing.JRadioButton();
        rbtnMinimo = new javax.swing.JRadioButton();
        btnAgregarProd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        calenFechaVenta = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnFacturar = new javax.swing.JButton();
        btnAbono = new javax.swing.JButton();
        lblRol = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCliente = new javax.swing.JMenu();
        btnInventario = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        mnuConsultarFactura = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuAdministrar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuEmpleado = new javax.swing.JMenuItem();
        btncategorias = new javax.swing.JMenuItem();
        mnuDesbloquear = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(780, 500));
        setMinimumSize(new java.awt.Dimension(780, 500));
        setPreferredSize(new java.awt.Dimension(780, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(780, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(780, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(780, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 0, 51));
        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, -1));

        txtFactDocCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFactDocClienteKeyReleased(evt);
            }
        });
        jPanel1.add(txtFactDocCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 140, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("Código:*");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("Apellido:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 100, -1));
        jPanel1.add(txtFactNomCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 200, -1));

        btnBuscarCliente.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscarCliente.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(51, 0, 102));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscar.png"))); // NOI18N
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 120, 40));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 710, 10));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Facturación");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 250, -1));

        jLabel4.setBackground(new java.awt.Color(51, 0, 51));
        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Cliente");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setText("Total:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("Cantidad:*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        txtFactCodProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFactCodProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFactCodProductoKeyTyped(evt);
            }
        });
        jPanel1.add(txtFactCodProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 150, -1));

        txtFactNomProducto.setEditable(false);
        jPanel1.add(txtFactNomProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 390, -1));

        btnBuscarProducto.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscarProducto.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnBuscarProducto.setForeground(new java.awt.Color(51, 0, 102));
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscar.png"))); // NOI18N
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 120, 40));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 20, 60));

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 650, 10));

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 20, 60));

        jSeparator6.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 20, 250));

        jSeparator7.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 20, 240));

        jSeparator8.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 710, 10));

        jSeparator9.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 630, -1));

        tblProductos.setModel(dtm);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductosMousePressed(evt);
            }
        });
        gatitosh.setViewportView(tblProductos);

        jPanel1.add(gatitosh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 699, 120));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setText("Número Documento:*");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        txtPagoTotal.setEditable(false);
        jPanel1.add(txtPagoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 140, -1));

        lblEmpleado.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        lblEmpleado.setForeground(new java.awt.Color(252, 250, 250));
        lblEmpleado.setText("1");
        jPanel1.add(lblEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 150, 20));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel9.setText("Nombre:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));
        jPanel1.add(txtFactApeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 180, -1));

        grpValor.add(rbtnMaximo);
        rbtnMaximo.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        rbtnMaximo.setText("Valor Máximo");
        rbtnMaximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnMaximoMousePressed(evt);
            }
        });
        jPanel1.add(rbtnMaximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        grpValor.add(rbtnMinimo);
        rbtnMinimo.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        rbtnMinimo.setText("Valor Mínimo");
        rbtnMinimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnMinimoMousePressed(evt);
            }
        });
        jPanel1.add(rbtnMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        btnAgregarProd.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregarProd.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnAgregarProd.setForeground(new java.awt.Color(51, 0, 102));
        btnAgregarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/agregar.png"))); // NOI18N
        btnAgregarProd.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProdActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 60, 40));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel10.setText("Nombre:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 60, -1));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel11.setText("Valor Unitario:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        txtValorUnitario.setEditable(false);
        jPanel1.add(txtValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 60, -1));
        jPanel1.add(calenFechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 130, -1));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel12.setText("Fecha de Venta:*");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(51, 0, 102));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/elimin.png"))); // NOI18N
        btnEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 60, 40));

        btnFacturar.setBackground(new java.awt.Color(204, 204, 204));
        btnFacturar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnFacturar.setForeground(new java.awt.Color(51, 0, 102));
        btnFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/facturar.png"))); // NOI18N
        btnFacturar.setText("Facturar");
        btnFacturar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });
        jPanel1.add(btnFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 120, 40));

        btnAbono.setBackground(new java.awt.Color(204, 204, 204));
        btnAbono.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnAbono.setForeground(new java.awt.Color(51, 0, 102));
        btnAbono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/abonar.png"))); // NOI18N
        btnAbono.setText("Abonos");
        btnAbono.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbono, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 120, 40));

        lblRol.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setText("1");
        jPanel1.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 150, 20));

        mnuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/group (1).png"))); // NOI18N
        mnuCliente.setText("Clientes");
        mnuCliente.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        mnuCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnuClienteMousePressed(evt);
            }
        });
        jMenuBar1.add(mnuCliente);

        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/list (1).png"))); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventarioMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnInventario);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/analytics.png"))); // NOI18N
        jMenu5.setText("Reportes");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        mnuConsultarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscar.png"))); // NOI18N
        mnuConsultarFactura.setText("Consultar Factura ");
        mnuConsultarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultarFacturaActionPerformed(evt);
            }
        });
        jMenu5.add(mnuConsultarFactura);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/reporte.png"))); // NOI18N
        jMenuItem2.setText("Reporte de Ventas por Fecha");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuBar1.add(jMenu5);

        mnuAdministrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/settings.png"))); // NOI18N
        mnuAdministrar.setText("Administrar");
        mnuAdministrar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/user.png"))); // NOI18N
        jMenuItem1.setText("Roles");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuAdministrar.add(jMenuItem1);

        mnuEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/multiple-users-silhouette.png"))); // NOI18N
        mnuEmpleado.setText("Empleados");
        mnuEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEmpleadoActionPerformed(evt);
            }
        });
        mnuAdministrar.add(mnuEmpleado);

        btncategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/settings-for-categories.png"))); // NOI18N
        btncategorias.setText("Categorías");
        btncategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncategoriasActionPerformed(evt);
            }
        });
        mnuAdministrar.add(btncategorias);

        mnuDesbloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/login_1.png"))); // NOI18N
        mnuDesbloquear.setText("Desbloqueo Empleados");
        mnuDesbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDesbloquearActionPerformed(evt);
            }
        });
        mnuAdministrar.add(mnuDesbloquear);

        jMenuBar1.add(mnuAdministrar);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/exit (2).png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        ControlProducto cp = new ControlProducto();
        if(txtFactCodProducto.getText().length()>0){
            datosProducto = cp.consultarproductoCodigo(Integer.parseInt(txtFactCodProducto.getText()));
            if(datosProducto[0][0]==null){
                 JOptionPane.showMessageDialog(this, "El producto no existe");
                 txtFactCodProducto.setText("");
                 txtFactNomProducto.setText("");       
             }else{
                 txtFactCodProducto.setText(String.valueOf(datosProducto[0][0]));
                 txtFactNomProducto.setText((String) datosProducto[0][1]);
                 if(rbtnMaximo.isSelected()){
                    float valorUnitario = (float) datosProducto[0][4];              
                    txtValorUnitario.setText(String.valueOf(valorUnitario));
                    btnAgregarProd.setEnabled(true);
                 }else{
                     if(rbtnMinimo.isSelected()){
                        float valorUnitario = (float) datosProducto[0][7];              
                        txtValorUnitario.setText(String.valueOf(valorUnitario));    
                        btnAgregarProd.setEnabled(true);
                     }
                 }
             }             
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese un parámetro de búsqueda");          
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        GUILoginUsuario em=new GUILoginUsuario();
        this.setVisible(false);
        em.setVisible(true); 
    }//GEN-LAST:event_mnuSalirMouseClicked

    private void btnInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseClicked
        GUIProductos gp=new GUIProductos();
        this.setVisible(false);
        gp.setVisible(true);
    }//GEN-LAST:event_btnInventarioMouseClicked

    private void btncategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncategoriasActionPerformed
        GUICategorias gc=new GUICategorias();
        this.setVisible(false);
        gc.setVisible(true);
    }//GEN-LAST:event_btncategoriasActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        ControlPersona cp = new ControlPersona();
       if(txtFactDocCliente.getText().length()>0 || txtFactNomCliente.getText().length()>0 || txtFactApeCliente.getText().length()>0){
            if(txtFactDocCliente.getText().length()>0 && txtFactNomCliente.getText().length()>0 && txtFactApeCliente.getText().length()>0){
                datosCliente = cp.consultarPersonaTodos(Integer.parseInt(txtFactDocCliente.getText()), 
                        txtFactNomCliente.getText(), txtFactApeCliente.getText());
            }else{
                if(txtFactDocCliente.getText().length()==0 && txtFactNomCliente.getText().length()>0 && txtFactApeCliente.getText().length()==0){
                    datosCliente = cp.consultarPersonaNombres(txtFactNomCliente.getText());
                }else{
                    if(txtFactDocCliente.getText().length()>0 && txtFactNomCliente.getText().length()==0 && txtFactApeCliente.getText().length()==0){
                        datosCliente = cp.consultarPersonaDocumento(Integer.parseInt(txtFactDocCliente.getText()));
                    }else{
                        if(txtFactDocCliente.getText().length()>0 && txtFactNomCliente.getText().length()>0 && txtFactApeCliente.getText().length()==0){
                            datosCliente = cp.consultarPersonaDocNombres(Integer.parseInt(txtFactDocCliente.getText()), txtFactNomCliente.getText());
                        }
                    }
                }
            }   
            if(datosCliente[0][0]==null){
                JOptionPane.showMessageDialog(this, "El cliente no existe");
                txtFactDocCliente.setText("");
                txtFactNomCliente.setText("");
                txtFactApeCliente.setText("");                
            }else{
                txtFactDocCliente.setText(String.valueOf(datosCliente[0][1]));
                txtFactNomCliente.setText((String) datosCliente[0][2]);
                txtFactApeCliente.setText((String) datosCliente[0][3]);
            } 
       }else{
            JOptionPane.showMessageDialog(this, "Ingrese un parámetro de búsqueda");           
       }
      

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnAgregarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProdActionPerformed
        this.AgregarProductos();      
    }//GEN-LAST:event_btnAgregarProdActionPerformed

    private void rbtnMaximoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnMaximoMousePressed
        if(txtFactNomProducto.getText().length()>0){
            float valorUnitario = (float) datosProducto[0][4];              
           txtValorUnitario.setText(String.valueOf(valorUnitario));
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un producto");
        }
    }//GEN-LAST:event_rbtnMaximoMousePressed

    private void txtFactCodProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFactCodProductoKeyReleased
        txtFactNomProducto.setText("");
        txtValorUnitario.setText("");
    }//GEN-LAST:event_txtFactCodProductoKeyReleased

    private void rbtnMinimoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnMinimoMousePressed
        if(txtFactNomProducto.getText().length()>0){
            float valorUnitario = (float) datosProducto[0][7];              
           txtValorUnitario.setText(String.valueOf(valorUnitario));
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un producto");
        }
    }//GEN-LAST:event_rbtnMinimoMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaseleccionada;
        DefaultTableModel modelotabla=(DefaultTableModel) tblProductos.getModel();
            try{
                filaseleccionada= tblProductos.getSelectedRow();
                if (filaseleccionada==-1 || modelotabla.getValueAt(filaseleccionada, 0)==null){
                    JOptionPane.showMessageDialog(null, "Elija un producto");
                    txtFactCodProducto.setText("");
                    txtFactNomProducto.setText("");
                    txtCantidad.setText("");
                    txtValorUnitario.setText("");
                    rbtnMaximo.setSelected(false);
                    rbtnMinimo.setSelected(false);
                }else{
                    txtFactCodProducto.setText(String.valueOf(modelotabla.getValueAt(filaseleccionada, 0)));
                    txtFactNomProducto.setText((String) modelotabla.getValueAt(filaseleccionada, 1));
                    txtValorUnitario.setText(String.valueOf(modelotabla.getValueAt(filaseleccionada, 2)));
                    txtCantidad.setText(String.valueOf(modelotabla.getValueAt(filaseleccionada, 3))); 
                    btnAgregarProd.setEnabled(false);
                    int res = JOptionPane.showConfirmDialog(this, "Está seguro que desea eliminar el producto: " + txtFactNomProducto.getText(), "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    if(res==JOptionPane.YES_OPTION){
                        for(int j=0; j<productosAgregados.length; j++){
                            if(txtFactCodProducto.getText().equals((String.valueOf(productosAgregados[j][0])))){
                                for(int k=j; k<productosAgregados.length-1; k++){
                                    productosAgregados[k][0] = productosAgregados[k+1][0];
                                    productosAgregados[k][1] = productosAgregados[k+1][1];
                                    productosAgregados[k][2] = productosAgregados[k+1][2];
                                    productosAgregados[k][3] = productosAgregados[k+1][3];
                                    productosAgregados[k][4] = productosAgregados[k+1][4];                                                                       
                                }
                                j=productosAgregados.length;
                            }
                        }
                        dtm = new DefaultTableModel(productosAgregados, nombresColumnas);
                        tblProductos.setModel(dtm);
                        txtFactCodProducto.setText("");
                        txtFactNomProducto.setText("");
                        txtCantidad.setText("");
                        txtValorUnitario.setText("");
                        rbtnMaximo.setSelected(false);
                        rbtnMinimo.setSelected(false);
                        i--;  
                                float sum=0;
                        for(int i=0; i<productosAgregados.length; i++){
                            if(productosAgregados[i][2]!=null){
                                sum=Float.parseFloat(String.valueOf(productosAgregados[i][2]))+sum;
                                System.out.println(sum);
                            }
                        }
                        txtPagoTotal.setText(String.valueOf(sum));
                    }
                    
                 }
              }catch (HeadlessException ex){
                    JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
              }     
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        ControlFactura cf = new ControlFactura();
        ControlDetalleFactura cdt = new ControlDetalleFactura();
        Object datos[][] = cf.consultarCodMaxFactura();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = null;
        
        if(calenFechaVenta.getDate()!=null){
           fecha = dateFormat.format(calenFechaVenta.getDate());            
        }
        int cod_fact;
        String prod = String.valueOf(productosAgregados[0][0]);
        
        if(datos[0][0]!=null){
            cod_fact = Integer.parseInt(String.valueOf(datos[0][0]))+1;
        }else{
            cod_fact = 1;
        }
        
        try{
            if(fecha!=null && lblEmpleado.getText().length()>0 && datosCliente[0][0].toString()!=null && prod!=null){        
                cf.insertarFactura(cod_fact, Float.parseFloat(txtPagoTotal.getText()), fecha, Integer.parseInt(String.valueOf(datosCliente[0][0]))
                        , Integer.parseInt(lblEmpleado.getText()));  
                for(int i=0; i<productosAgregados.length; i++){
                    if(productosAgregados[i][0]!=null){
                        cdt.insertarDetalleFactura(cod_fact, Integer.parseInt(String.valueOf(productosAgregados[i][0])), Integer.parseInt(String.valueOf(productosAgregados[i][3])), Float.parseFloat(String.valueOf(productosAgregados[i][2])));
                    }else{
                        i=productosAgregados.length;
                    }
                }
                JOptionPane.showMessageDialog(this, "Factura realizada exitosamente");
                txtFactCodProducto.setText("");
                txtFactNomProducto.setText("");
                txtFactApeCliente.setText("");
                txtFactNomCliente.setText("");
                txtFactDocCliente.setText("");
                txtCantidad.setText("");
                txtValorUnitario.setText("");
                rbtnMaximo.setSelected(false);
                rbtnMinimo.setSelected(false);
                datosCliente = null;
                datosProducto = null;
                datosCategoria = null;
                productosAgregados = new Object[20][5];
                DefaultTableModel dtm;                
                dtm = new DefaultTableModel(productosAgregados, nombresColumnas);
                tblProductos.setModel(dtm);
                j = 1;
                i = 0;
            }else{
                JOptionPane.showMessageDialog(this, "Debe ingresar todos los datos obligatorios, incluyendo productos");           
            }            
        }catch(NullPointerException npe){
             JOptionPane.showMessageDialog(this, "Ingrese un Cliente");
        }
        
    }//GEN-LAST:event_btnFacturarActionPerformed

    private void mnuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEmpleadoActionPerformed
        GUIEmpleado em=new GUIEmpleado();
        this.setVisible(false);
        em.setVisible(true);         
    }//GEN-LAST:event_mnuEmpleadoActionPerformed

    private void mnuClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuClienteMousePressed
        GUICliente cl=new GUICliente();
        this.setVisible(false);
        cl.setVisible(true);        
    }//GEN-LAST:event_mnuClienteMousePressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        GUIReporteVentasxFecha rv=new GUIReporteVentasxFecha();
        this.setVisible(false);
        rv.setVisible(true);          
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonoActionPerformed
        GUIAbonos abon = new GUIAbonos();
        abon.setVisible(true);
        this.setVisible(false);    
    }//GEN-LAST:event_btnAbonoActionPerformed

    private void tblProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMousePressed
        int filaseleccionada;
        DefaultTableModel modelotabla=(DefaultTableModel) tblProductos.getModel();
            try{
                filaseleccionada= tblProductos.getSelectedRow();
                if (filaseleccionada==-1 || modelotabla.getValueAt(filaseleccionada, 0)==null){
                    JOptionPane.showMessageDialog(null, "Elija un producto");
                    txtFactCodProducto.setText("");
                    txtFactNomProducto.setText("");
                    txtCantidad.setText("");
                    txtValorUnitario.setText("");
                    rbtnMaximo.setSelected(false);
                    rbtnMinimo.setSelected(false);
                }else{
                    txtFactCodProducto.setText(String.valueOf(modelotabla.getValueAt(filaseleccionada, 0)));
                    txtFactNomProducto.setText((String) modelotabla.getValueAt(filaseleccionada, 1));
                    txtValorUnitario.setText(String.valueOf(modelotabla.getValueAt(filaseleccionada, 2)));
                    txtCantidad.setText(String.valueOf(modelotabla.getValueAt(filaseleccionada, 3))); 
                    btnAgregarProd.setEnabled(false);                    
                }
            }catch (HeadlessException ex){
                  JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
            }     
    }//GEN-LAST:event_tblProductosMousePressed

    private void txtFactCodProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFactCodProductoKeyTyped
     
    }//GEN-LAST:event_txtFactCodProductoKeyTyped

    private void txtFactDocClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFactDocClienteKeyReleased
        txtFactNomCliente.setText("");
        txtFactApeCliente.setText("");
    }//GEN-LAST:event_txtFactDocClienteKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        GUIRoles rol=new GUIRoles();
        this.setVisible(false);
        rol.setVisible(true); 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnuDesbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDesbloquearActionPerformed
        GUIDesbloqueoEmpleados desb=new GUIDesbloqueoEmpleados();
        this.setVisible(false);
        desb.setVisible(true); 
    }//GEN-LAST:event_mnuDesbloquearActionPerformed

    private void mnuConsultarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultarFacturaActionPerformed
        GUIAbonos abon = new GUIAbonos();
        abon.setVisible(true);
        this.setVisible(false);          
    }//GEN-LAST:event_mnuConsultarFacturaActionPerformed

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
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbono;
    private javax.swing.JButton btnAgregarProd;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JMenu btnInventario;
    private javax.swing.JMenuItem btncategorias;
    private com.toedter.calendar.JDateChooser calenFechaVenta;
    private javax.swing.JScrollPane gatitosh;
    private javax.swing.ButtonGroup grpValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblRol;
    private javax.swing.JMenu mnuAdministrar;
    private javax.swing.JMenu mnuCliente;
    private javax.swing.JMenuItem mnuConsultarFactura;
    private javax.swing.JMenuItem mnuDesbloquear;
    private javax.swing.JMenuItem mnuEmpleado;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JRadioButton rbtnMaximo;
    private javax.swing.JRadioButton rbtnMinimo;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFactApeCliente;
    private javax.swing.JTextField txtFactCodProducto;
    private javax.swing.JTextField txtFactDocCliente;
    private javax.swing.JTextField txtFactNomCliente;
    private javax.swing.JTextField txtFactNomProducto;
    private javax.swing.JTextField txtPagoTotal;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
