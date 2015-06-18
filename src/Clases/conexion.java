/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Utils.Menus;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Borja Alventosa
 */
public class conexion {
    

    static String driver = "com.mysql.jdbc.Driver";
    static String db = "Gimnasio";
    //static String url = "jdbc:mysql://192.168.21.200:3306/";
    static String url = "jdbc:mysql://192.168.1.134:3306/";
    static String user = "root";
    static String pass = "1234";

    public static Connection connectar() {
        Connection conn=null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url+db, user, pass);
        } catch (ClassNotFoundException cnfex) {
            Menus.warning("Ha estat impossible establir la connexió!","Atenció");
            System.out.println("Connectar:" + cnfex.getMessage());
        } catch (SQLException sqlex) {
            Menus.warning("Ha estat impossible establir la connexió!","Atenció");
            System.out.println("Connectar:" + sqlex.getMessage());
        } catch (Exception ex) {
            Menus.warning("Ha estat impossible establir la connexió!","Atenció");
            System.out.println("Connectar:" + ex.getMessage());
        }
        return conn;
    }

    public static void desconnectar(Connection conn) {
        try {
            conn.close();
        } catch (SQLException sqlex) {
            Menus.warning("Ha estat impossible tancar la connexió!", "Atenció");
            System.out.println("Desconnectar:" + sqlex.getMessage());
        } catch (Exception ex) {
            Menus.warning("Ha estat impossible tancar la connexió!", "Atenció");
            System.out.println("Desconnectar:" + ex.getMessage());
        }
    }

    

}

