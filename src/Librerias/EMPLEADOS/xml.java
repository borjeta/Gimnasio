package Librerias.EMPLEADOS;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases.ArrayListEmpHoras;
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases.EmpHoras;
import Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases.ArrayListEmpTemp;
import Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases.EmpTemp;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
public class xml {
    private static final String ENCODING = "UTF-8";
    
    public static void generaxmlEF() {
        String PATH=null;
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, EmpFijo.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(ArrayListEmpFijo.efi, osw);
            StringBuffer xml = new StringBuffer();
            xml.append(header);
            xml.append(os.toString());
	    
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH+".xml";
                
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();
                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);

            }
	    }catch (Exception e1){
	    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
	    } 
    }
    
   
    
    
	public static void generaxmlOcultoEF() {
        String PATH=null;
		try {
            try (OutputStream os = new ByteArrayOutputStream(); 
                    OutputStreamWriter osw = new OutputStreamWriter(os)) {
                XStream xstream = new XStream();
                Annotations.configureAliases(xstream, EmpFijo.class);
                
                String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
                xstream.toXML(ArrayListEmpFijo.efi, osw);
                StringBuilder xml = new StringBuilder();
                xml.append(header);
                xml.append(os.toString());
                
                PATH = new java.io.File(".").getCanonicalPath()+"/src/Modulos/GestionGym/GestionaEmpleados/GestionEmpFijo/Modelo/Archivos/EmpleadosFijos"
                        + ".xml";
                
                
                try (FileWriter fileXml = new FileWriter(PATH)) {
                    fileXml.write(xml.toString());
                }
            }

            
	    }catch (Exception e1){
	    } 
	    
 
      
        }
    
    
    
    public static ArrayList<EmpFijo> abrir_xmlEF() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, EmpFijo.class);
 
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                ArrayListEmpFijo.efi = (ArrayList <EmpFijo>)xstream.fromXML(new FileReader(PATH));
            }
            
        } catch (Exception e1) {
        	JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ArrayListEmpFijo.efi;
    }
    
          public static ArrayList<EmpFijo> abrir_xmlOcultoEF() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, EmpFijo.class);
                                                             
            PATH = new java.io.File(".").getCanonicalPath()+"/src/Modulos/GestionGym/GestionaEmpleados/GestionEmpFijo/Modelo/Archivos/EmpleadosFijos.xml";
            ArrayListEmpFijo.efi = (ArrayList <EmpFijo>)xstream.fromXML(new FileReader(PATH));
            
        } catch (Exception e1) {
        	
        }
        return ArrayListEmpFijo.efi;
    }
    
    
    public static void guardarxml_EmpFijo() {
        String PATH;

        try {
            OutputStream os = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            XStream xstream = new XStream();

            // Annotations.configureAliases(xstream, Actividades.class);
            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING
                    + "\"?>\n";
            xstream.toXML(ArrayListEmpFijo.efi, osw);
            StringBuffer xml = new StringBuffer();
            xml.append(header);
            xml.append(os.toString());

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

            int seleccion = fileChooser.showSaveDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                if (!PATH.endsWith(".xml")) {
                    PATH = PATH + ".xml";
                }

                try (FileWriter fileXml = new FileWriter(PATH)) {
                    fileXml.write(xml.toString());
                }
                osw.close();
                os.close();

                JOptionPane.showMessageDialog(null,
                        "Archivo XML guardado con �xito", "Archivo XML",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al grabar el XML",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ArrayList<EmpFijo> abrirxml1_ACT() {
        String PATH;

        try {
            XStream xstream = new XStream();
            // Annotations.configureAliases(xstream, Actividades.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

            int seleccion = fileChooser.showOpenDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                ArrayListEmpFijo.efi = ((ArrayList<EmpFijo>) xstream
                        .fromXML(new FileReader(PATH)));

                JOptionPane.showMessageDialog(null,
                        "Archivo XML abierto con �xito", "Archivo XML",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (HeadlessException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el XML",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return ArrayListEmpFijo.efi;
    }
}



