/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionClientes.Modelo.Clases;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JPanel;

/**
 *
 * @author Borja Alventosa
 */
public class FondoInicio extends JPanel{
    URL imagen1 = FondoInicio.class.getResource("/img/GYMTONYBUENO.png");
    Image imagen=Toolkit.getDefaultToolkit().getImage(imagen1);
    
     @Override
    public void paint(Graphics g){
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        } else {
            setOpaque(true);
        }
        super.paint(g);
    }
    
}
