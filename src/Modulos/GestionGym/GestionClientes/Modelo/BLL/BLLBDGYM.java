/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionClientes.Modelo.BLL;

import Clases.conexion;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Arraylistgym;
import Modulos.GestionGym.GestionClientes.Modelo.DAO.DAOBDGYM;

/**
 *
 * @author Borja Alventosa
 */
public class BLLBDGYM {
    public static void CreaCli(){
        java.sql.Connection A=conexion.connectar();
        
        DAOBDGYM.NuevoCliente(A);
        conexion.desconnectar(A);
    }
    public static void modificaCli(){
        java.sql.Connection A=conexion.connectar();
        DAOBDGYM.modificarCliDAO(A);
        conexion.desconnectar(A);
    }
    public static void listaCli(){
        java.sql.Connection A=conexion.connectar();
        DAOBDGYM.listClientes(A);
        conexion.desconnectar(A);
    }
    public static void EliminaCliBD(){
        java.sql.Connection A=conexion.connectar();
        DAOBDGYM.borrarEmpleadofijoDAO(A);
        conexion.desconnectar(A);
    }
    public static void iniciatodo(){
        DAOBDGYM.iniciatodo();
    }
    
}
