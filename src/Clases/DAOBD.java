/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;

import java.sql.Connection;
import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Borja Alventosa
 */
public class DAOBD {
    public static int nouEmpleatFixDAO(EmpFijo ef, Connection conn) {

        PreparedStatement stmt = null;
        int resultado = 0;
        
        String query = ("INSERT INTO Empleados.Fijos (DNI,Nombre,Departamento,Fecha_nacimiento,Fecha_contratacion,Antiguedad,Sueldo,Edad) VALUES(?,?,?,?,?,?,?,?)");
            
        try {
           //stmt = (PreparedStatement) conn.PreparedStatement(query);
            stmt= (PreparedStatement)conn.prepareStatement(query);
            stmt.setString(1, ef.getDNI());
            stmt.setString(2, ef.getNombre());
            stmt.setString(3, ef.getDepartamento());
            stmt.setString(4, ef.getFechaNac().deFechaAString());
            stmt.setString(5, ef.getFechaCont().deFechaAString());
            stmt.setInt(6, ef.getAntiguedad());
            stmt.setFloat(7, ef.getSueldo());
            stmt.setInt(8, ef.getEdad());
            

            resultado = stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo pedido!");
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

    public static void ListaEmpleatFixDAO(Connection conn) {

         ResultSet rs = null;
        com.mysql.jdbc.PreparedStatement stmt = null;
        fecha fechanac, fechacont;

        ArrayListEmpFijo.efi.clear();
        try {
            stmt = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("SELECT * FROM Empleados.Fijos");
            rs = stmt.executeQuery();
            EmpFijo _empf = null;
           

            while (rs.next()) {

                _empf = new EmpFijo();
                _empf.setDNI(rs.getString("DNI"));
                _empf.setNombre(rs.getString("Nombre"));
                _empf.setDepartamento(rs.getString("Departamento"));
                fechanac = new fecha(rs.getString("Fecha_nacimiento"));
                fechacont = new fecha(rs.getString("Fecha_contratacion"));
                _empf.setFechaNac(fechanac);
                _empf.setFechaCont(fechacont);
                _empf.setAntiguedad(rs.getInt("Antiguedad"));
                _empf.setSueldo(rs.getFloat("Sueldo"));
                _empf.setEdad(rs.getInt("Edad"));
                _empf.setLogin(rs.getString("Login"));
                _empf.setPassword(rs.getString("Password"));
                _empf.setAvatar(rs.getString("Avatar"));
                _empf.setTipo(rs.getString("Tipo"));
                _empf.setEstado(rs.getInt("Estado"));
               
                
                
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

     public static int modificar(EmpFijo ef, Connection conn) {
        com.mysql.jdbc.PreparedStatement stmt = null;
        int resultado=0;
  
        try {
            stmt = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement("UPDATE Fijos SET DNI=?,Nombre=?,Departamento=?,Fecha_nacimiento=?,"
                    +"Fecha_contratacion=?,Antiguedad=?,Sueldo=?,Edad=?,Login=?,Password=?,Estado=?,Tipo=?,Avatar=? WHERE DNI=?");
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
            stmt.setInt(11, ArrayListEmpFijo.o.getEstado());
            stmt.setString(12, ArrayListEmpFijo.o.getTipo());
            stmt.setString(13, ArrayListEmpFijo.o.getAvatar());
            
            
            
            
            

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
        com.mysql.jdbc.PreparedStatement stmt = null;

        try {
            stmt = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("DELETE FROM Fijos WHERE DNI=?");
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

    

