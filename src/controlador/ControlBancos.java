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
import modelo.Banco;

/**
 *
 * @author Fabio
 * Contiene todos los métodos que involucran a la tabla banco de la bbdd
 */
public class ControlBancos {
    
    //Método que lista todos los bancos y los devuelve en un DefaultTableModel 
    public static DefaultTableModel listarBancos(){
        final DefaultTableModel listaBancos = new DefaultTableModel(99,8);
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        ResultSet rs;
        
        try{
            Statement s = cnx.createStatement();
            rs = s.executeQuery("SELECT * from banco");
            
            GestorTabla.configuraColumnas(rs, listaBancos);
            GestorTabla.rellena(rs, listaBancos);
            return listaBancos;
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    /*
    Método que usa como argumento un banco. Inserta éste último en la bbdd
    */
    public static boolean agregarBanco(Banco banco) {
       BaseDatos db = new BaseDatos();
       Connection cnx = db.estableceConexion();
       
        try{
            
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO banco (codigo,nombre,direccion) VALUES (?,?,?)");
            ps.setString(1,banco.getCodigo());
            ps.setString(2,banco.getNombre());
            ps.setString(3,banco.getDireccion());
            
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
    
    //Método que recibe un banco y actualiza los valores modificados según el idbanco (el cual es inmodificable)
    public static boolean modificarBanco(Banco banco) {
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        try{
            
            PreparedStatement ps = cnx.prepareStatement("UPDATE banco SET codigo=?,nombre=?,direccion=? WHERE idbanco = ?");
            ps.setString(1,banco.getCodigo());
            ps.setString(2,banco.getNombre());
            ps.setString(3,banco.getDireccion());
            ps.setString(4, String.valueOf(banco.getIdbanco()));
            
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
    
    /*
    Método que recibe como argumento un banco y lo elimina de la bbdd
    Suele arrojar SQLException cuando el banco tiene cuentas asociadas. En este caso se 
    solicita al usuario que compruebe que este banco no tiene cuentas asociadas para ser eliminado 
    */
    public static boolean eliminarBanco(Banco banco) {
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        try{
            
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM banco WHERE idbanco = ?");
            ps.setString(1,String.valueOf(banco.getIdbanco()));
            
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
