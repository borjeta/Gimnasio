/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.BLL;

import Clases.DAOBD;
import Clases.conexion;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import com.mysql.jdbc.Connection;

/**
 *
 * @author Borja Alventosa
 */
public class BLLBD {
    public static void CreaEmpFijoNou(){
        java.sql.Connection A=conexion.connectar();
        
        DAOBD.ListaEmpleatFixDAO(A);
        conexion.desconnectar(A);
    }
    public static void modificaEmpFijo(){
        java.sql.Connection A=conexion.connectar();
        DAOBD.modificar(ArrayListEmpFijo.o, A);
        conexion.desconnectar(A);
    }
    public static void listaEmpFijos(){
        java.sql.Connection A=conexion.connectar();
        DAOBD.ListaEmpleatFixDAO(A);
    }
    public static void EliminafijoBD(){
        java.sql.Connection A=conexion.connectar();
        DAOBD.borrarEmpleadofijoDAO(A);
        conexion.desconnectar(A);
    }
    
}
