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

/**
 *
 * @author Usuario
 */
public class ControlPrestamos {
    final static DefaultTableModel listaCuentas = new DefaultTableModel(99,8);
    public static DefaultTableModel listarCuentas(int idUsuario){
        BaseDatos bd = new BaseDatos();
        Connection cnx = bd.estableceConexion();
        ResultSet rs;
        
        try{
            Statement s = cnx.createStatement();
            //System.out.println("En try de ya sabes donde"+nombreUsuario);
            rs = s.executeQuery("SELECT * FROM cuenta WHERE idusuario ='"+ String.valueOf(idUsuario)+"'");
            
            GestorTabla.configuraColumnas(rs, listaCuentas);
            GestorTabla.rellena(rs, listaCuentas);
            return listaCuentas;
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    
    }
}
