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
import modelo.Usuario;

/**
 *
 * @author Usuario
 */
public class ControlUsuarios {
    final DefaultTableModel listaUsuarios = new DefaultTableModel(99,8);
    public DefaultTableModel validarUsuario(Usuario usu){
        BaseDatos DB = new BaseDatos();
        Connection cnx = DB.estableceConexion();
        ResultSet rs;
        try{
            Statement s = cnx.createStatement();
            rs = s.executeQuery("SELECT * FROM usuario WHERE usuario = '" + usu.getUsuario()+"'");
            GestorTabla.configuraColumnas(rs, listaUsuarios);
            GestorTabla.rellena(rs, listaUsuarios);
            s.close();
            rs.close();
            return listaUsuarios;
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            DB.cierraConexion();
            return null;
        }   
    }
    
    public boolean banearUsuario(String nombreUsuario){
        BaseDatos bd = new BaseDatos();
        Connection cnx = bd.estableceConexion();
        
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE usuario SET banned = 1 WHERE usuario = ?");
            ps.setString(1, nombreUsuario);
            int n = ps.executeUpdate();
            if (n!=0){
                bd.cierraConexion();
                return true;
            }else{
                ps.close();
                bd.cierraConexion();
                return false;      
            }
        }catch(SQLException ex){
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    
    }
    
}
