/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.DAO;

import Clases.fecha;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
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
           

            while (rs.next()) {

                _empf = new EmpFijo();
                _empf.setNombre(rs.getString("Nombre"));
                _empf.setDNI(rs.getString("DNI"));
                fechanac = new fecha(rs.getString("fecha_nacimiento"));
                _empf.setFechaNac(fechanac);
                _empf.setLogin(rs.getString("login"));
                _empf.setPassword(rs.getString("password"));
                _empf.setAvatar(rs.getString("avatar"));
                _empf.setTipo(rs.getString("tipo"));
                _empf.setEstado(rs.getInt("estado"));
                fechacont = new fecha(rs.getString("fecha_contratacion"));
                _empf.setFechaCont(fechacont);
                _empf.setAntiguedad(rs.getInt("Antiguedad"));
                _empf.setSueldo(rs.getFloat("sueldo"));
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
                    + "(Nombre,Edad,DNI,Departamento,Fecha_nacimiento,Sueldo"
                    + ",Antiguedad,Fecha_contratacion,Login,Password,Avatar,Tipo,Estado) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, ArrayListEmpFijo.o.getNombre());
            stmt.setInt(2, ArrayListEmpFijo.o.getEdad());
            stmt.setString(3, ArrayListEmpFijo.o.getDNI());
            stmt.setString(4, ArrayListEmpFijo.o.getDepartamento());
            stmt.setString(5, ArrayListEmpFijo.o.getFechaNac().toString());
            stmt.setFloat(6, ArrayListEmpFijo.o.getSueldo());
            stmt.setInt(7, ArrayListEmpFijo.o.getAntiguedad());
            stmt.setString(8, ArrayListEmpFijo.o.getFechaCont().toString());
            stmt.setString(9, ArrayListEmpFijo.o.getLogin());
            stmt.setString(10, ArrayListEmpFijo.o.getPassword());
            stmt.setString(11, ArrayListEmpFijo.o.getAvatar());
            stmt.setString(12, ArrayListEmpFijo.o.getTipo());
            stmt.setInt(13, ArrayListEmpFijo.o.getEstado());
            //JOptionPane.showMessageDialog(null, ped);
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
  
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE Fijos SET Nombre=?,Edad=?,DNI=?,Departamento,Fecha_nacimiento=?"
                    +",Sueldo=?,Login=?,Password=?,Avatar=?,Tipo=?,Estado=?,Antiguedad=?,Fecha_contratacion=? WHERE DNI=?");
            stmt.setString(1, ArrayListEmpFijo.o.getNombre());
            stmt.setInt(2, ArrayListEmpFijo.o.getEdad());
            stmt.setString(3, ArrayListEmpFijo.o.getDNI());
            stmt.setString(4, ArrayListEmpFijo.o.getDepartamento());
            stmt.setString(5, ArrayListEmpFijo.o.getFechaNac().toString());
            stmt.setFloat(6, ArrayListEmpFijo.o.getSueldo());
            stmt.setString(7, ArrayListEmpFijo.o.getLogin());
            stmt.setString(8, ArrayListEmpFijo.o.getPassword());
            stmt.setString(9, ArrayListEmpFijo.o.getAvatar());
            stmt.setString(10, ArrayListEmpFijo.o.getTipo());
            stmt.setInt(11, ArrayListEmpFijo.o.getEstado());
            stmt.setInt(12, ArrayListEmpFijo.o.getAntiguedad());
            stmt.setString(13, ArrayListEmpFijo.o.getFechaCont().toString());
            

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

    

