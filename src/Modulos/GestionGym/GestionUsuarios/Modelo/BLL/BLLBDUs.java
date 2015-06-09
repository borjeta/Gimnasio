/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionUsuarios.Modelo.BLL;

import Clases.conexion;
import Modulos.GestionGym.GestionClientes.Modelo.DAO.DAOBDGYM;
import Modulos.GestionGym.GestionUsuarios.Modelo.DAO.DAOBDUs;

/**
 *
 * @author Borja Alventosa
 */
public class BLLBDUs {
     public static void CreaUser(){
        java.sql.Connection A=conexion.connectar();
        
        DAOBDUs.NuevoUsuario(A);
        conexion.desconnectar(A);
    }
    public static void modificaUser(){
        java.sql.Connection A=conexion.connectar();
        DAOBDUs.modificarUser(A);
        conexion.desconnectar(A);
    }
    public static void listaUser(){
        java.sql.Connection A=conexion.connectar();
        DAOBDUs.listUsuarios(A);
        conexion.desconnectar(A);
        //Librerias.USUARIOS.XML.generaxmlOcultoGym();
    }
    public static void EliminaUserBD(){
        java.sql.Connection A=conexion.connectar();
        DAOBDUs.borraruser(A);
        conexion.desconnectar(A);
    }
    
    
}
