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
            
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO destinatarios (cbu,persona,correo,nombreUsuario) VALUES (?,?,?,?)");
            ps.setString(1,desti.getCbu());
            ps.setString(2,desti.getPersona());
            ps.setString(3,desti.getCorreo());
            ps.setString(4, desti.getNombreUsuario());
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
    
    
    public DefaultTableModel listarDestinatarios(String nombreUsuario){
        BaseDatos bd = new BaseDatos();
        Connection cnx = bd.estableceConexion();
        ResultSet rs;
        
        try{
            Statement s = cnx.createStatement();
            //System.out.println("En try de ya sabes donde"+nombreUsuario);
            rs = s.executeQuery("SELECT * FROM destinatarios WHERE nombreUsuario ='"+ nombreUsuario+"'");
            
            GestorTabla.configuraColumnas(rs, listaDestinatario);
            GestorTabla.rellena(rs, listaDestinatario);
            return listaDestinatario;
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    
    }

    public boolean modificarDestinatario(Destinatarios desti) {
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        
        try{
            
            PreparedStatement ps = cnx.prepareStatement("UPDATE destinatarios SET cbu = ?, persona = ?, correo = ? WHERE iddestinatarios = ?");
            ps.setString(1,desti.getCbu());
            ps.setString(2,desti.getPersona());
            ps.setString(3,desti.getCorreo());
            ps.setString(4, Integer.toString(desti.getIddestinatarios()));
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

    public boolean eliminarDestinatario(String iddestinatarios) {
               BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        
        try{
            
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM destinatarios WHERE iddestinatarios = ?");
            ps.setString(1,iddestinatarios);
            
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
    
}
