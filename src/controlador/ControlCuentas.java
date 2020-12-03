/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cuenta;

/**
 *
 * @author Usuario
 */
public class ControlCuentas {
    
    public static boolean AgregarCuenta(Cuenta cuenta){
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        
        try{
            
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO cuenta (nrodecuenta,saldo,idbanco,idusuario,fechaalta,usuarioalta) VALUES (?,?,?,?,NOW(),?)");
            ps.setString(1,cuenta.getNrodecuenta());
            ps.setString(2,String.valueOf(cuenta.getSaldo()));
            ps.setString(3,String.valueOf(cuenta.getIdbanco()));
            ps.setString(4, String.valueOf(cuenta.getIdusuario()));
            ps.setString(5,String.valueOf(cuenta.getUsuarioalta()));
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
    
    public static boolean modificarCuenta(Cuenta cuenta){
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        
        try{
            
            PreparedStatement ps = cnx.prepareStatement("ALTER TABLE cuenta SET (nrodecuenta,saldo,idbanco,idusuario,fechamodificacion,usuarimodificacion) VALUES (?,?,?,?,NOW(),?) WHERE idcuenta = ?");
            ps.setString(1,cuenta.getNrodecuenta());
            ps.setString(2,String.valueOf(cuenta.getSaldo()));
            ps.setString(3,String.valueOf(cuenta.getIdbanco()));
            ps.setString(4, String.valueOf(cuenta.getIdusuario()));
            ps.setString(5,String.valueOf(cuenta.getUsuarioalta()));
            ps.setString(6,String.valueOf(cuenta.getIdcuenta()));
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
