/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlUsuarios;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import modelo.UsuarioSingleton;

/**
 *
 * @author Usuario
 */
public class FrmUsuarios extends javax.swing.JFrame {
    //Se crea un nuevo usuario y se recupera el usuarioSingleton
    UsuarioSingleton uSing = UsuarioSingleton.getInstance();
    Usuario usuario = new Usuario();

    /**
     * Creates new form FrmUsuarios
     */
    public FrmUsuarios() {
        initComponents();
        lblUsuario.setText(uSing.getUsuario());
        actualizaUsuarios();
        ocultaCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAgregarUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Usuario:");

        lblUsuario.setText("jLabel2");

        btnVolver.setBackground(new java.awt.Color(255, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblUsuario))
                    .addComponent(btnVolver))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Menú"));

        btnAgregarUsuario.setText("Agregar usuario");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });

        btnModificarUsuario.setText("Modificar usuario");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setText("Eliminar usuario");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarUsuario)
                .addGap(18, 18, 18)
                .addComponent(btnModificarUsuario)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarUsuario)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //btn volver: Cierra la ventana y devuelve a frame anterior
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        FrmInicio frmInicio = new FrmInicio();
        this.dispose();
        frmInicio.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed
    
    //btn agregar usuario: Cierra la ventana y pasa a frame frmAgregarUsuario
    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        // TODO add your handling code here:
        FrmAgregarUsuario frmAgregarUsuario = new FrmAgregarUsuario();
        this.dispose();
        frmAgregarUsuario.setVisible(true);
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed
    
    //Click en tabla: Asigna a usuario creado inicialmente los valores de la fila seleccionada
    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        // TODO add your handling code here:
        String idUsuario = String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0));
        usuario.setIdusuario(Integer.valueOf(idUsuario));
        usuario.setUsuario(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 1)));
        usuario.setPassword(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2)));
        String banned =(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 3)));
        usuario.setBanned(Boolean.valueOf(banned));
        usuario.setTipo(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 4)));
        usuario.setNombre(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 5)));
        usuario.setApellido(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 6)));
        usuario.setDni(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 7)));
        usuario.setCelular(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 8)));
    }//GEN-LAST:event_tablaUsuariosMouseClicked
    
    /*
    btn Modificar: Se llama a frmModificar usuario, se cierra la ventana actual. Se asignan los valores
    de la fila seleccionada a los labels y textFields, en password se deja vacío. 
    */
    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        // TODO add your handling code here:
        FrmModificarUsuario frmModificarUsuario = new FrmModificarUsuario();
        this.dispose();
        frmModificarUsuario.lblIdUsuario.setText(String.valueOf(usuario.getIdusuario()));
        frmModificarUsuario.txtFieldUsuario.setText(usuario.getUsuario());
        frmModificarUsuario.passwordField.setText("");
        frmModificarUsuario.txtFieldBanned.setText(String.valueOf(usuario.getBanned()));
        frmModificarUsuario.txtFieldTipo.setText(usuario.getTipo());
        frmModificarUsuario.txtFieldNombre.setText(usuario.getNombre());
        frmModificarUsuario.txtFieldApellido.setText(usuario.getApellido());
        frmModificarUsuario.txtFieldDNI.setText(usuario.getDni());
        frmModificarUsuario.txtFieldCelular.setText(usuario.getCelular());
        frmModificarUsuario.setVisible(true);
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed
    
    /*
    btn eliminar: Llama a controlUsuarios.eliminarUsuario(usuario) y envía como parámetro los valores
    de la fila seleccionada. Advierte el resutlado de la operación y devuelve a frame anterior
    */
    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        // TODO add your handling code here:
        boolean res = ControlUsuarios.eliminarUsuario(usuario);
        if (res){
            JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente");
            this.dispose();
            FrmUsuarios frmUsuarios = new FrmUsuarios();
            frmUsuarios.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el usuario. Asegúrese que no tenga cuentas asociadas a su nombre");
        
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables

    //Llena la tabla con los valores obtenidos de la bbdd
    private void actualizaUsuarios(){
        DefaultTableModel listaUsuarios;
        listaUsuarios = ControlUsuarios.listarUsuarios();
        tablaUsuarios.setModel(listaUsuarios);
    
    }
    
    //oculta campo password y asigna diferentes anchos de acuerdo al tipo de dato 
    private void ocultaCampos() {
        tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(150);
        
        tablaUsuarios.getColumnModel().getColumn(2).setMinWidth(0);
        tablaUsuarios.getColumnModel().getColumn(2).setMaxWidth(0);
        tablaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(0);
        
        tablaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(50);
        tablaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(150);
        tablaUsuarios.getColumnModel().getColumn(5).setPreferredWidth(150);
        tablaUsuarios.getColumnModel().getColumn(6).setPreferredWidth(150);
        tablaUsuarios.getColumnModel().getColumn(7).setPreferredWidth(150);
        tablaUsuarios.getColumnModel().getColumn(8).setPreferredWidth(150);
    }
}