/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlBancos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Banco;
import modelo.UsuarioSingleton;

/**
 *
 * @author Usuario
 */
public class FrmBancos extends javax.swing.JFrame {
    //Se recuperan datos de usuarioSingleton, y se crea un banco nuevo. 
    UsuarioSingleton uSing = UsuarioSingleton.getInstance();
    Banco banco = new Banco();

    /**
     * Creates new form FrmBancos
     */
    public FrmBancos() {
        initComponents();
        //Se coloca en label el usuario en uso 
        lblUsuario.setText(uSing.getUsuario());
        actualizaTabla();
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
        tablaBancos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAgregarBanco = new javax.swing.JButton();
        btnModificarBanco = new javax.swing.JButton();
        btnEliminarBanco = new javax.swing.JButton();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de bancos"));

        tablaBancos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaBancos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBancosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBancos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Menú"));

        btnAgregarBanco.setText("Agregar banco");
        btnAgregarBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarBancoActionPerformed(evt);
            }
        });

        btnModificarBanco.setText("Modificar banco");
        btnModificarBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarBancoActionPerformed(evt);
            }
        });

        btnEliminarBanco.setText("Eliminar banco");
        btnEliminarBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarBancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarBanco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificarBanco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarBanco)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Volver: Cierra frame y devuelve al anterior. 
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        FrmInicio frmInicio = new FrmInicio();
        this.dispose();
        frmInicio.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed
    
    //Agregar banco: Cierra ventana y pasa a frame frmAgregarBancos. 
    private void btnAgregarBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarBancoActionPerformed
        // TODO add your handling code here:
        FrmAgregarBanco frmAgregarBanco = new FrmAgregarBanco();
        this.dispose();
        frmAgregarBanco.setVisible(true);
    }//GEN-LAST:event_btnAgregarBancoActionPerformed
    
    //Al clickear en tabla: LLama a método obtieneValores()
    private void tablaBancosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBancosMouseClicked
        // TODO add your handling code here:
        obtieneValores();
    }//GEN-LAST:event_tablaBancosMouseClicked
    
    //btn Modificar: cierra ventana y llama a FrmModificarBanco, asigna los valores de los textFields de acuerdo al elemento seleccionado en la tabla
    private void btnModificarBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarBancoActionPerformed
        // TODO add your handling code here:
        FrmModificarBanco frmModificarBanco = new FrmModificarBanco();
        this.dispose();
        frmModificarBanco.lblIdBanco.setText(String.valueOf(banco.getIdbanco()));
        frmModificarBanco.txtFieldCodigo.setText(banco.getCodigo());
        frmModificarBanco.txtFieldNombre.setText(banco.getNombre());
        frmModificarBanco.txtFieldDireccion.setText(banco.getDireccion());
        frmModificarBanco.setVisible(true);
    }//GEN-LAST:event_btnModificarBancoActionPerformed

    /*
    Btn elminar: LLama al método estático ControlBancos.eliminarBanco(banco), dnd banco es el 
    banco seleccionado en la tabla. Muestra el resultado de eliminar el banco. En caso de fallar 
    lanza advtertencia de acuerdo a si falla por las foreigns keys de la bbdd
    */
    private void btnEliminarBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarBancoActionPerformed
        // TODO add your handling code here:
        boolean res = ControlBancos.eliminarBanco(banco);
        if (res){
            JOptionPane.showMessageDialog(this, "Banco eliminado exitosamente");
            this.dispose();
            FrmBancos frmBancos = new FrmBancos();
            frmBancos.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el banco. Existen cuentas asociadas a dicho banco. Asegúrese que las cuentas pertenecientes a este banco sean transferidas a otro banco o eliminadas antes");
        }
    }//GEN-LAST:event_btnEliminarBancoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBancos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBancos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarBanco;
    private javax.swing.JButton btnEliminarBanco;
    private javax.swing.JButton btnModificarBanco;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tablaBancos;
    // End of variables declaration//GEN-END:variables

    //LLena la tabla con los bancos disponibles, llamando a listarBancos()
    private void actualizaTabla(){
        DefaultTableModel listaBancos;
        
        listaBancos = ControlBancos.listarBancos();
        tablaBancos.setModel(listaBancos);
        
    }
    
    //Método ejecutado al presionar en la tabla, selecciona los valores de la fila seleccionada y se 
    //los asigna al objeto banco creado al principio, son los que luego se usan en modificar o eliminar banco
    private void obtieneValores(){
       
        String idBanco = String.valueOf(tablaBancos.getValueAt(tablaBancos.getSelectedRow(), 0));
        banco.setIdbanco(Integer.valueOf(idBanco));
        banco.setCodigo(String.valueOf(tablaBancos.getValueAt(tablaBancos.getSelectedRow(),1)));
        banco.setNombre(String.valueOf(tablaBancos.getValueAt(tablaBancos.getSelectedRow(),2)));
        banco.setDireccion(String.valueOf(tablaBancos.getValueAt(tablaBancos.getSelectedRow(),3)));
        
    }
}
