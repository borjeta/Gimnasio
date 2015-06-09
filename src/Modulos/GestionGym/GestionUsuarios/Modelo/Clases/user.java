/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionUsuarios.Modelo.Clases;

import Modulos.ClasesMadre.persona;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Borja Alventosa
 */
public class user {
    @XStreamAlias("nombre")
    public String nombre;
    @XStreamAlias("Login")
    public String Login ;
    @XStreamAlias("DNI")
    public String DNI;
    @XStreamAlias("tipo")
    public String tipo;
    @XStreamAlias("password")
    public String password;

    public user(String nombre, String Login, String DNI, String tipo,String password) {
        this.nombre = nombre;
        this.Login = Login;
        this.DNI = DNI;
        this.tipo = tipo;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public boolean equals(Object c){
		return getLogin().equals(((user)c).getLogin());
}
    public user(){
        
    }
    public user(String Login,String pass){
        this.Login=Login;
        this.password=password;
        
    }
    public String getNombre() {
        return nombre;
    }

    public String getLogin() {
        return Login;
    }

    public String getDNI() {
        return DNI;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public boolean equals(user c){
		return getLogin().equals(((user)c).getLogin());
}
    
}
