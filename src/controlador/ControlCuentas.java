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
import modelo.Cuenta;

/**
 *
 * @author Fabio
 * Clase que contiene todos los métodos que involucran a la tabla cuenta de la bbdd
 */
public class ControlCuentas {
    /*
    Método que recibe una cuenta como argumento y la inserta en la bbdd
    */
    public static boolean AgregarCuenta(Cuenta cuenta){
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
         
        try{
            
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO cuenta (nrodecuenta,saldo,idbanco,idusuario,fechaalta,usuarioalta) VALUES (?,?,?,?,?,?)");
            ps.setString(1,cuenta.getNrodecuenta());
            ps.setString(2,String.valueOf(cuenta.getSaldo()));
            ps.setString(3,String.valueOf(cuenta.getIdbanco().getIdbanco()));
            ps.setString(4, String.valueOf(cuenta.getIdusuario().getIdusuario()));
            ps.setString(5, String.valueOf(cuenta.getFechaalta()));
            ps.setString(6,String.valueOf(cuenta.getUsuarioalta()));
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
    Método que recibe una cuenta y la modifica en la bbdd, de acuerdo al idcuenta recibido
    */
    public static boolean modificarCuenta(Cuenta cuenta){
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        
        try{
            
            PreparedStatement ps = cnx.prepareStatement("UPDATE cuenta SET nrodecuenta=?,saldo=?,idbanco=?,idusuario=?,fechamodificacion= ?,usuariomodificacion=? WHERE idcuenta = ?");
            ps.setString(1,cuenta.getNrodecuenta());
            ps.setString(2,String.valueOf(cuenta.getSaldo()));
            ps.setString(3,String.valueOf(cuenta.getIdbanco().getIdbanco()));
            ps.setString(4, String.valueOf(cuenta.getIdusuario().getIdusuario()));
            ps.setString(5,String.valueOf(cuenta.getFechamodificacion()));
            ps.setString(6,String.valueOf(cuenta.getUsuariomodificacion()));
            ps.setString(7,String.valueOf(cuenta.getIdcuenta()));
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
    Método que devuelve un DefaultTableModel con todas las cuentas disponibles en la bbdd
    */
    public static DefaultTableModel listarTodasLasCuentas() {
        final DefaultTableModel listaCuentas = new DefaultTableModel(99,8);
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        ResultSet rs;
        
        try{
            Statement s = cnx.createStatement();
            //System.out.println("En try de ya sabes donde"+nombreUsuario);
            rs = s.executeQuery("SELECT * FROM cuenta");
            
            GestorTabla.configuraColumnas(rs, listaCuentas);
            GestorTabla.rellena(rs, listaCuentas);
            return listaCuentas;
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    /*
    Método que actualiza la fecha y usuario de baja de una cuenta. A diferencia de los otros métodos eliminar, este 
    no es de tipo DELETE si no que es un UPDATE. Además se coloca como idbanco e idusuario a 0 (usuario y banco 
    ficticios que permiten luego de realizar esta operación eliminar algún usuario o banco).
    */
    public static boolean eliminarCuenta(Cuenta cuenta) {
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion(); //To change body of generated methods, choose Tools | Templates.
    
        try{
            
            PreparedStatement ps = cnx.prepareStatement("UPDATE cuenta SET nrodecuenta=?,saldo=?,idbanco=?,idusuario=?,fechabaja= ?,usuariobaja=? WHERE idcuenta = ?");
            ps.setString(1,cuenta.getNrodecuenta());
            ps.setString(2,String.valueOf(cuenta.getSaldo()));
            ps.setString(3,String.valueOf(cuenta.getIdbanco().getIdbanco()));
            ps.setString(4, String.valueOf(cuenta.getIdusuario().getIdusuario()));
            ps.setString(5,String.valueOf(cuenta.getFechabaja()));
            ps.setString(6,String.valueOf(cuenta.getUsuariobaja()));
            ps.setString(7,String.valueOf(cuenta.getIdcuenta()));
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
