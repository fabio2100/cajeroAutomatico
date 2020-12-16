/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
 * @author Fabio
 * Clase que contiene todos los métodos que involucran a la tabla usuario de la bbdd
 */
public class ControlUsuarios {
    
    /*
    Método que no recibe argumentos. Devuelve un defaultablemodel con todos los usuarios registrados 
    en la bbdd
    */
    public static DefaultTableModel listarUsuarios() {
       final DefaultTableModel listaUsuarios = new DefaultTableModel(99,8);
       BaseDatos db = new BaseDatos();
       Connection cnx = db.estableceConexion();
       ResultSet rs;
       try{
            Statement s = cnx.createStatement();
            rs = s.executeQuery("SELECT * FROM usuario");
            
            GestorTabla.configuraColumnas(rs, listaUsuarios);
            GestorTabla.rellena(rs, listaUsuarios);
            return listaUsuarios;
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    
    /*
    Método que recibe como parámetro un usuario y lo inserta en la bbdd
    */
    public static boolean agregarUsuario(Usuario usuario) {
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        int ban;
        if (usuario.getBanned()){
            ban = 1;
        }else{
            ban = 0;
        }
        
        String passEncriptado = null;
        
        try {
            passEncriptado = SHA1.SHA1(usuario.getPassword());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ControlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO usuario (usuario,password,banned,tipo,nombre,apellido,dni,celular) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, passEncriptado);
            ps.setString(3,String.valueOf(ban));
            ps.setString(4, usuario.getTipo());
            ps.setString(5, usuario.getNombre());
            ps.setString(6, usuario.getApellido());
            ps.setString(7, usuario.getDni());
            ps.setString(8, usuario.getCelular());
            
            int n = ps.executeUpdate();
            if (n!=0){
                db.cierraConexion();
                return true;
            }else{
                ps.close();
                db.cierraConexion();
                return false;
            }
        
        }catch (SQLException ex){
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
        
    }

    
    /*
    Método que recibe como parámetro un usuario ya registrado (según id) y lo actualiza de acuerdo 
    a nuevos valores. Devuelve true si la operación fue exitosa y false en caso contrario 
    */
    public static boolean modificarUsuario(Usuario usuario) {
        BaseDatos db = new BaseDatos();
        Connection cnx = db.estableceConexion();
        int ban;
        if (usuario.getBanned()){
            ban = 1;
        }else{
            ban = 0;
            
            
        }
        String passEncriptado = null;
        
        try {
            passEncriptado = SHA1.SHA1(usuario.getPassword());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ControlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE usuario SET usuario=?,password=?,banned=?,tipo=?,nombre=?,apellido=?,dni=?,celular=? WHERE idusuario = ?");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, passEncriptado);
            ps.setString(3,String.valueOf(ban));
            ps.setString(4, usuario.getTipo());
            ps.setString(5, usuario.getNombre());
            ps.setString(6, usuario.getApellido());
            ps.setString(7, usuario.getDni());
            ps.setString(8, usuario.getCelular());
            ps.setString(9, String.valueOf(usuario.getIdusuario()));
            
            int n = ps.executeUpdate();
            if (n!=0){
                db.cierraConexion();
                return true;
            }else{
                ps.close();
                db.cierraConexion();
                return false;
            }
        
        }catch (SQLException ex){
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
        
    }
    
    /*
    Método que recibe un usuario y elimina el registro de la bbdd. Devuelve true si la operación fue
    existosa o false en caso contrario 
    */
    public static boolean eliminarUsuario(Usuario usuario) {
        BaseDatos DB = new BaseDatos();
        Connection cnx = DB.estableceConexion();
       try{
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM usuario WHERE idusuario = ?");
            ps.setString(1, String.valueOf(usuario.getIdusuario()));
            int n = ps.executeUpdate();
            if (n!=0){
                DB.cierraConexion();
                return true;
            }else{
                ps.close();
                DB.cierraConexion();
                return false;      
            }
        }catch(SQLException ex){
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    
    
    final DefaultTableModel listaUsuarios = new DefaultTableModel(99,8);
    /*
    Método que recibe un usuario y devuelve un defaulttablemodel de la bbdd con ese nombre de usuario
    */
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
    
    
    /*
    Método que recibe un string un nombredeusuario registrado y coloca a uno la condición banned. 
    Usado en login en caso de colocar tres veces mal la contraseña
    */
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
