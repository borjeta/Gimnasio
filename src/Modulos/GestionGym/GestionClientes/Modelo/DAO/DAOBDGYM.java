/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionClientes.Modelo.DAO;

import Clases.fecha;
import Modulos.ClasesMadre.persona;
import Modulos.GestionGym.GestionClientes.Modelo.BLL.BLLBDGYM;
import Modulos.GestionGym.GestionClientes.Modelo.BLL.BLLGYM;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Arraylistgym;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Cliente;
import Modulos.GestionGym.GestionUsuarios.Modelo.BLL.BLLBDUs;
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
public class DAOBDGYM {
    public static void listClientes(Connection con) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        fecha fechanac;

        Arraylistgym.gym.clear();
       try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM Gimnasio.Clientes");
            rs = stmt.executeQuery();
            Cliente _empf = null;
           //(String nombre,String apellido,String DNI, fecha fechaNac,String login,String password,String categoria,int cuota) 

            while (rs.next()) {

                _empf = new Cliente();
                _empf.setNombre(rs.getString("Nombre"));
                _empf.setApellido(rs.getString("Apellido"));
                _empf.setDNI(rs.getString("DNI"));
                fechanac = new fecha(rs.getString("Fecha_nacimiento"));
                _empf.setFechaNac(fechanac);
                _empf.setLogin(rs.getString("Login"));
                _empf.setPassword(rs.getString("Password"));
                _empf.setAvatar(rs.getString("Avatar"));
                _empf.setCategoria(rs.getString("Categoria"));
                _empf.setCuota(rs.getInt("Cuota"));
                _empf.setTipo(rs.getString("Tipo"));
                _empf.setDiaPago(rs.getInt("diaPago"));
                
                Arraylistgym.gym.add(_empf);
                

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los Clientes!");
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
    
    
    public static int NuevoCliente(Connection con) {
        PreparedStatement stmt = null;
        int resultado=0;
        try {
            DAOGYM.CargaSingleton();
   
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Gimnasio.Clientes"
                    + "(Nombre,Apellido,DNI,Fecha_nacimiento,Login"
                    + ",Password,Categoria,Cuota,Avatar,Tipo,diaPago) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            //(String nombre,String apellido,String DNI, fecha fechaNac,String login,String password,String categoria,int cuota) 
            stmt.setString(1, Arraylistgym.C.getNombre());
            stmt.setString(2, Arraylistgym.C.getApellido());
            stmt.setString(3, Arraylistgym.C.getDNI());
            stmt.setString(4, Arraylistgym.C.getFechaNac().toString());
            //stmt.setString(8, Arraylistgym.o.getFechaCont().toString());
            stmt.setString(5, Arraylistgym.C.getLogin());
            stmt.setString(6, Arraylistgym.C.getPassword());
            
         
          //stmt.setInt(9, Arraylistgym.o.getEstado());
            stmt.setString(7, Arraylistgym.C.getCategoria());
            stmt.setInt(8, Arraylistgym.C.getCuota());
            //JOptionPane.showMessageDialog(null, ped);
            stmt.setString(9, Arraylistgym.C.getAvatar());
            stmt.setString(10, Arraylistgym.C.getTipo());
            stmt.setInt(11,Arraylistgym.C.getDiaPago());
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
    
    public static int modificarCliDAO(Connection con) {

        PreparedStatement stmt = null;
        int resultado=0;
  
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE Clientes SET DNI=?,Nombre=?,Apellido=?,Fecha_nacimiento=?"
                    +",Login=?,Password=?,Categoria=?,Cuota=?,Avatar=?,Tipo=?,DiaPago=? WHERE Login=?");
            //Nombre,Apellido,DNI,Fecha_nacimiento,Login"
              //       ",Password,Avatar,Tipo,Estado
            stmt.setString(1, Arraylistgym.C.getNombre());
            stmt.setString(2, Arraylistgym.C.getApellido());
            stmt.setString(3, Arraylistgym.C.getDNI());
            stmt.setString(4, Arraylistgym.C.getFechaNac().toString());
            stmt.setString(5, Arraylistgym.C.getLogin());
            stmt.setString(6, Arraylistgym.C.getPassword());
            stmt.setString(7,Arraylistgym.C.getCategoria());
            stmt.setInt(8, Arraylistgym.C.getCuota());
            stmt.setString(9, Arraylistgym.C.getAvatar());
            stmt.setString(10,Arraylistgym.C.getTipo());
            stmt.setInt(11,Arraylistgym.C.getDiaPago());
            
            
           
            

            resultado = stmt.executeUpdate();

            


        } catch (SQLException ex) {
            //throw new Exception("Ha habido un problema al insertar la factura "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el cliente!");
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
    
    public static int borrarEmpleadofijoDAO(Connection con) {
        int resultado=0;
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM Clientes WHERE Login=?");
            stmt.setString(1, Arraylistgym.o.getLogin());
            resultado = stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el cliente!");
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
    
    public static void empfMenorMayorDAO(Connection conexion) {

        CallableStatement cstmt = null;
        String cadena = "";
        try {
            cstmt = (CallableStatement) conexion.prepareCall("{call procedure_MaxMinEdad(?,?)}");
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            cstmt.execute();
            cadena = cadena + "Empleado fijo menor: " + cstmt.getInt(1) + " años" + "\n";
            cadena = cadena + "Empleado fijo mayor: " + cstmt.getInt(2) + " años";
            JOptionPane.showMessageDialog(null, cadena, "Empleado fijo menor/mayor", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }

    }
    
    
    public static void RefrescaDatos(){
        BLLGYM.guardaOcultoXML();
        BLLGYM.guardaOcultoTXT();
        BLLBDGYM.listaCli();
    }
    public static void iniciatodo(){
        BLLBDGYM.listaCli();
        BLLGYM.guardaOcultoXML();
        BLLGYM.guardaOcultoTXT();
        BLLBDUs.listaUser();
    }
    
    

}
