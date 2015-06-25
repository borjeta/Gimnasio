/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author miguel
 */
public class FileUpload {

    public static String PATH_auto;

    public static void pintar_guardar_imag(JLabel etiqueta, int ancho, int alto) {
        String ruta;
        File imagen;
        BufferedImage image;
        String extension = "";
        JFileChooser fileChooser = new JFileChooser();

        lista_blanca(fileChooser);
        fileChooser.setCurrentDirectory(null);
        fileChooser.setSelectedFile(null);

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            imagen = fileChooser.getSelectedFile();

            ruta = imagen.getAbsolutePath();
            if (ruta.length() > 500) {
                JOptionPane.showMessageDialog(null, "La ruta de la imagen debe "
                        + "tener como máximo 500 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ImageIcon icon = new ImageIcon(ruta);
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                etiqueta.setIcon(newIcon); //pintamos la imagen en jlabel1

                try {
                    //guardamos la imagen
                    image = ImageIO.read(fileChooser.getSelectedFile().toURL());
                    extension = fileChooser.getSelectedFile().toURL().toString().substring(
                            fileChooser.getSelectedFile().toURL().toString().length() - 3);
                    String cad = getCadenaAleatoria(5);

                    PATH_auto = new java.io.File("") + "src/TPV/imag/" + cad + "." + extension;
                    File f = new File(PATH_auto);
                    ImageIO.write(image, extension, f);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error upload imagen", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else { //avatar per defecte
            ruta = "src/TPV/imag/default-avatar.jpg";
            ImageIcon icon = new ImageIcon(ruta);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            etiqueta.setIcon(newIcon); //pintamos la imagen_default en jlabel1

            try {
                //guardamos la imagen
                PATH_auto = new java.io.File("") + "src/TPV/imag/default-avatar.jpg";
                File f = new File(PATH_auto);
                image = ImageIO.read(f);
                ImageIO.write(image, "jpg", f);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error upload imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }

    public static void pintar(JLabel etiqueta, int ancho, int alto, int i,String ruta) {
        
        if (i == 0) {//avatar per defecte
            ruta = "src/TPV/imag/default-avatar.jpg";
            
            try {
            //Obtenemos el cliente logeado extrayendo el DNI que el usuario tramita al inicio
                //BLL_Login.obtenerEmpfLogin();

                //pintamos la imagen en el Jlabel con la ruta que deseemos
                ImageIcon icon = new ImageIcon(ruta);
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                etiqueta.setBackground(Color.red);
                etiqueta.setIcon(newIcon);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error upload imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (i == 1) {//avatar del singleton
              
            try {
                PATH_auto=ruta;
                //pintamos la imagen en el Jlabel con la ruta que deseemos
                ImageIcon icon = new ImageIcon(ruta);
                //Se extrae la imagen del icono
                Image img = icon.getImage();
                //Se modifica su tamaño
                Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
                ImageIcon newIcon = new ImageIcon(newimg);
                etiqueta.setBackground(Color.red);
                etiqueta.setIcon(newIcon);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error upload imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public static void guardar(JLabel etiqueta, int ancho, int alto, int i,String ruta) {
        
        BufferedImage image;

        if (i == 0) {//avatar per defecte
            try {
                //guardamos la imagen
                PATH_auto = new java.io.File("") + "src/TPV/imag/default-avatar.jpg";
                File f = new File(PATH_auto);
                image = ImageIO.read(f);
                ImageIO.write(image, "jpg", f);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error upload imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        
        if(i == 1){
            try {
                //guardamos la imagen
                PATH_auto = new java.io.File("") + ruta;
                File f = new File(PATH_auto);
                image = ImageIO.read(f);
                ImageIO.write(image, "jpg", f);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error upload imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        }
            

   

    public static void lista_blanca(JFileChooser buscador) {
        buscador.setAcceptAllFileFilterUsed(false);
        buscador.addChoosableFileFilter(new FileNameExtensionFilter("Imágenes (*.jpg, *.jpeg, *.gif, *.png)", "jpg", "jpeg", "gif", "png"));
    }

    public static String getCadenaAleatoria(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }



}
