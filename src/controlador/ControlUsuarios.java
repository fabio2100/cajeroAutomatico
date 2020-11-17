/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
    
}
