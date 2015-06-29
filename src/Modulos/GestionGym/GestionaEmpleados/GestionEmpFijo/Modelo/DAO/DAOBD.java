/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.DAO;

import Clases.fecha;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
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
public class DAOBD {
        public static void listAllempFDAO(Connection con) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        fecha fechanac, fechacont;

        ArrayListEmpFijo.efi.clear();
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM Gimnasio.Fijos");
            rs = stmt.executeQuery();
            EmpFijo _empf = null;
  //(String nombre,int edad,String DNI, String departamento,fecha fechaNac,float sueldo,int antiguedad,fecha fechaCont,String login,String password){
            while (rs.next()) {

                _empf = new EmpFijo();
                _empf.setNombre(rs.getString("Nombre"));
                _empf.setEdad(rs.getInt("Edad"));
                _empf.setDNI(rs.getString("DNI"));
                _empf.setDepartamento(rs.getString("Departamento"));
                fechanac = new fecha(rs.getString("Fecha_nacimiento"));
                _empf.setFechaNac(fechanac);
                _empf.setSueldo(rs.getFloat("Sueldo"));
                _empf.setAntiguedad(rs.getInt("Antiguedad"));
                fechacont = new fecha(rs.getString("Fecha_contratacion"));
                _empf.setFechaCont(fechacont);
                _empf.setLogin(rs.getString("Login"));
                _empf.setPassword(rs.getString("Password"));
                
                ArrayListEmpFijo.efi.add(_empf);
                 

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los empleados fijos!");
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
    
    
    public static  int nuevoEmpfDAO(Connection con) {
        PreparedStatement stmt = null;
        int resultado=0;
        try {
            
   // String nombre,int edad,String DNI, String departamento,fecha fechaNac,float sueldo,int antiguedad,fecha fechaCont,String login,String password
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Empleados.Fijos"
                    + "(DNI,Nombre,Departamento,Fecha_nacimiento,Fecha_contratacion,Antiguedad"
                    + ",Sueldo,Edad,Login,Password) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, ArrayListEmpFijo.o.getDNI());
            stmt.setString(2, ArrayListEmpFijo.o.getNombre());
            stmt.setString(3, ArrayListEmpFijo.o.getDepartamento());
            stmt.setString(4, ArrayListEmpFijo.o.getFechaNac().toString());
            stmt.setString(5, ArrayListEmpFijo.o.getFechaCont().toString());
            stmt.setInt(6, ArrayListEmpFijo.o.getAntiguedad());
            stmt.setFloat(7, ArrayListEmpFijo.o.getSueldo());
            stmt.setInt(8, ArrayListEmpFijo.o.getEdad());
            stmt.setString(9, ArrayListEmpFijo.o.getLogin());
            stmt.setString(10, ArrayListEmpFijo.o.getPassword());
            resultado=stmt.executeUpdate();
            
            
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo empleado fijo!");
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
    
    public static  int modificarUsuarioDAO(Connection con) {

        PreparedStatement stmt = null;
        int resultado=0;
        DAOEFgrafic.ObtenSeleccionadoCompleto();
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE Fijos SET Nombre=?,Edad=?,Departamento=?,Fecha_nacimiento=?"
                    +",Sueldo=?,Login=?,Password=?,Antiguedad=?,Fecha_contratacion=? WHERE DNI=?");
            stmt.setString(1, ArrayListEmpFijo.o.getNombre());
            stmt.setInt(2, ArrayListEmpFijo.o.getEdad());
            stmt.setString(3, ArrayListEmpFijo.o.getDepartamento());
            stmt.setString(4, ArrayListEmpFijo.o.getFechaNac().toString());
            stmt.setFloat(5, ArrayListEmpFijo.o.getSueldo());
            stmt.setString(6, ArrayListEmpFijo.o.getLogin());
            stmt.setString(7, ArrayListEmpFijo.o.getPassword());
            stmt.setInt(8, ArrayListEmpFijo.o.getAntiguedad());
            stmt.setString(9, ArrayListEmpFijo.o.getFechaCont().toString());
            stmt.setString(10, ArrayListEmpFijo.o.getDNI());

            resultado = stmt.executeUpdate();

            


        } catch (SQLException ex) {
            //throw new Exception("Ha habido un problema al insertar la factura "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el empleado fijo!");
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
JOptionPane.showMessageDialog(null,"Esta es la persona que se va a borrar"+ArrayListEmpFijo.o.getNombre());
        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM Fijos WHERE DNI=?");
            stmt.setString(1, ArrayListEmpFijo.o.getDNI());
            resultado = stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el empleado fijo!");
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
    
    
    
    
    
    

}

    

