/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fabio
 * Clase creada de tipo singleton, con los mismos campos que usuario.
 * Solo permite la creación de una instancia de esta cuenta, la cual es creada al comienzo 
 * del programa y se llena de los datos del usuario en uso. Sirve para luego recuperar los diferentes
 * datos de este usuario en diferentes frames. 
 */
public class UsuarioSingleton {
    private static UsuarioSingleton instance;
    
    private Integer idusuario;
    private String usuario;
    private String password;
    private boolean banned;
    private String tipo;
 
    private String nombre;
 
    private String apellido;
 
    private String dni;
 
    private String celular;
    
    private UsuarioSingleton(){}

    

    public static void setInstance(UsuarioSingleton instance) {
        UsuarioSingleton.instance = instance;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public static UsuarioSingleton getInstance(){
        if (instance == null){
            instance = new UsuarioSingleton();}
        else{
            //System.out.println("Ya ha sido creado un objeto usuario");
        }
        return instance;}
    
}
