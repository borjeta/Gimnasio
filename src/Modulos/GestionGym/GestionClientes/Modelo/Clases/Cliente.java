/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionClientes.Modelo.Clases;

import Clases.fecha;
import Modulos.ClasesMadre.persona;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Borja Alventosa
 */
public class Cliente extends persona{
    @XStreamAlias("diaPago")
    public int diaPago;

    public Cliente( String nombre, String apellido, String DNI, fecha fechaNac, String login, String password, String categoria, int cuota, String avatar,String tipo,int diaPago) {
        super(nombre, apellido, DNI, fechaNac, login, password, categoria, cuota, avatar,tipo);
        this.diaPago = diaPago;
    }
    public Cliente (){
        
    }
    public Cliente (String login, String password){
        
    }

    public int getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(int diaPago) {
        this.diaPago = diaPago;
    }
    
    
    
    
}
