package Librerias.EMPLEADOS;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;

public class txt {
    public static void generatxtEF() {
        String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH=PATH+ ".txt";
                f = new File(PATH);
                
                FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(ArrayListEmpFijo.efi);
				o.close();
                JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public static void generatxtOcultoEF() {
        String PATH = null;
        try {
            File f;
            PATH = new java.io.File(".").getCanonicalPath()+"/src/Modulos/GestionGym/GestionaEmpleados/GestionEmpFijo/Modelo/Archivos/empleadosfijos.txt";

                f = new File(PATH);
                
                FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(ArrayListEmpFijo.efi);
				o.close();
            
        } catch (Exception e) {
        }
    }
    
   
    public static ArrayList<EmpFijo> abrir_txtEmpFijo() {
    	String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                f = new File(PATH);
                
                FileInputStream fi=new FileInputStream(f);
    			ObjectInputStream oi=new ObjectInputStream(fi);
    			ArrayListEmpFijo.efi = (ArrayList<EmpFijo>)oi.readObject();
    			oi.close();
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    	return ArrayListEmpFijo.efi;
    }
    
   
    public static ArrayList<EmpFijo> abrir_txtOcultoEF() {
    	String PATH = null;
        try {
            File f;
            PATH = new java.io.File(".").getCanonicalPath()+"/src/Modulos/GestionGym/GestionaEmpleados/GestionEmpFijo/Modelo/Archivos/empleadosfijos.txt";

                f = new File(PATH);
                
                FileInputStream fi=new FileInputStream(f);
    			ObjectInputStream oi=new ObjectInputStream(fi);
    			ArrayListEmpFijo.efi = (ArrayList<EmpFijo>)oi.readObject();
    			oi.close();
            
        } catch (Exception e) {
        	
        }
    	return ArrayListEmpFijo.efi;
    }
   
    

}
