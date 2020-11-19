/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Destinatarios;

/**
 *
 * @author Usuario
 */
public class ControlDestinatarios {
    final DefaultTableModel listaDestinatario = new DefaultTableModel(99,8);
    public boolean guardarDestinatario(Destinatarios desti){
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        
        try{
            
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO destinatarios (cbu,persona,correo) VALUES (?,?,?)");
            ps.setString(1,desti.getCbu());
            ps.setString(2,desti.getPersona());
            ps.setString(3,desti.getCorreo());
            int n = ps.executeUpdate();
            if (n!=0){
                db.cierraConexion();
                return true;
            }else{
                ps.close();
                db.cierraConexion();
                return false;
            }
        }catch(SQLException ex){
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    
    
    public DefaultTableModel listarDestinatarios(){
        BaseDatos bd = new BaseDatos();
        Connection cnx = bd.estableceConexion();
        ResultSet rs;
        
        try{
            Statement s = cnx.createStatement();
            rs = s.executeQuery("SELECT * FROM destinatarios");
            
            GestorTabla.configuraColumnas(rs, listaDestinatario);
            GestorTabla.rellena(rs, listaDestinatario);
            return listaDestinatario;
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    
    }
    
}
