package Librerias.CLIENTES;


import Modulos.ClasesMadre.persona;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Arraylistgym;
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
    
    public static void generaxmlgym() {
        String PATH=null;
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, persona.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(Arraylistgym.gym, osw);
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
    
	public static void generaxmlOcultoGym() {
        String PATH=null;
		try {
            try (OutputStream os = new ByteArrayOutputStream(); 
                    OutputStreamWriter osw = new OutputStreamWriter(os)) {
                XStream xstream = new XStream();
                Annotations.configureAliases(xstream, persona.class);
                
                String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
                xstream.toXML(Arraylistgym.gym, osw);
                StringBuilder xml = new StringBuilder();
                xml.append(header);
                xml.append(os.toString());
                
                PATH = new java.io.File(".").getCanonicalPath()+"/src/Modulos/GestionGym/GestionClientes/Modelo/Archivos/Clientes"
                        + ".xml";
                
                
                try (FileWriter fileXml = new FileWriter(PATH)) {
                    fileXml.write(xml.toString());
                }
            }

            
	    }catch (Exception e1){
	    } 
	    
 
      
        }
    
    
    
    public static ArrayList<persona> abrir_xmlgym() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, persona.class);
 
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                Arraylistgym.gym = (ArrayList <persona>)xstream.fromXML(new FileReader(PATH));
            }
            
        } catch (Exception e1) {
        	JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return Arraylistgym.gym;
    }
    
          public static ArrayList<persona> abrir_xmlOcultgym() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, persona.class);
                                                             
            PATH = new java.io.File(".").getCanonicalPath()+"/src/Modulos/GestionGym/GestionClientes/Modelo/Archivos/Clientes.xml";
            Arraylistgym.gym = (ArrayList <persona>)xstream.fromXML(new FileReader(PATH));
            
        } catch (Exception e1) {
        	JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return Arraylistgym.gym;
    }
    
    public static void guardarxml_GYM() {
        String PATH;

        try {
            OutputStream os = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            XStream xstream = new XStream();

            // Annotations.configureAliases(xstream, Actividades.class);
            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING
                    + "\"?>\n";
            xstream.toXML(Arraylistgym.gym, osw);
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
}