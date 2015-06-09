/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionUsuarios.Modelo.DAO;

import Clases.fecha;
import Modulos.ClasesMadre.persona;
import Modulos.GestionGym.GestionClientes.Modelo.BLL.BLLBDGYM;
import Modulos.GestionGym.GestionClientes.Modelo.BLL.BLLGYM;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Arraylistgym;
import Modulos.GestionGym.GestionClientes.Modelo.DAO.DAOGYM;
import Modulos.GestionGym.GestionUsuarios.Modelo.Clases.user;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Borja Alventosa
 */
public class DAOBDUs {
    
    
        public static void listUsuarios(Connection con) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        fecha fechanac;

        Arraylistgym.us.clear();
       try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM Gimnasio.Usuarios");
            rs = stmt.executeQuery();
            user _empf = null;
           //(String nombre,String apellido,String DNI, fecha fechaNac,String login,String password,String categoria,int cuota) 

            while (rs.next()) {

                _empf = new user();
                _empf.setNombre(rs.getString("Nombre"));
                _empf.setLogin(rs.getString("Login"));
                _empf.setDNI(rs.getString("DNI"));
                _empf.setTipo(rs.getString("Tipo"));
                _empf.setPassword("Password");
               // JOptionPane.showMessageDialog(null,_empf.getNombre());
                Arraylistgym.us.add(_empf);
                

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los usuarios!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
       
    }
    
    
    public static int NuevoUsuario(Connection con) {
        PreparedStatement stmt = null;
        int resultado=0;
        try {
            DAOGYM.CargaSingleton();
   
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Gimnasio.Usuarios"
                    + "(Nombre,Login,DNI,Tipo,Password) "
                    + "VALUES(?,?,?,?)");
            stmt.setString(1, Arraylistgym.U.getNombre());
            stmt.setString(3, Arraylistgym.U.getDNI());
            stmt.setString(2, Arraylistgym.U.getLogin());
             stmt.setString(4, Arraylistgym.U.getTipo());
             stmt.setString(5,Arraylistgym.U.getPassword());
            resultado=stmt.executeUpdate();
            
            
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo Cliente!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        return resultado;
    }
    
    public static int modificarUser(Connection con) {

        PreparedStatement stmt = null;
        int resultado=0;
  
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE Usuarios SET Nombre=?,Login=?,DNI=?,Tipo=?,Password=? WHERE Login=?");
            //Nombre,Apellido,DNI,Fecha_nacimiento,Login"
              //       ",Password,Avatar,Tipo,Estado
            stmt.setString(1, Arraylistgym.U.getNombre());
            stmt.setString(2, Arraylistgym.U.getLogin());
            stmt.setString(3, Arraylistgym.U.getDNI());
            stmt.setString(4,Arraylistgym.U.getTipo());
            stmt.setString(5, Arraylistgym.U.getPassword());

            resultado = stmt.executeUpdate();

            


        } catch (SQLException ex) {
            //throw new Exception("Ha habido un problema al insertar la factura "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    //Logger.getLogger(alumnoPresencialDAO.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        return resultado;

    }
    
    public static int borraruser(Connection con) {
        int resultado=0;
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM Usuarios WHERE Login=?");
            stmt.setString(1, Arraylistgym.o.getDNI());
            resultado = stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger!");
                }
            }
        }
        return resultado;
    }
    
    public static void RefrescaDatos(){
        BLLGYM.guardaOcultoXML();
        BLLGYM.guardaOcultoTXT();
        BLLBDGYM.listaCli();
    }
    
    
}
