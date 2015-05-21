/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases;

import static Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.STM.datos;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.STM.efi;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Borja Alventosa
 */
public class miniSTM extends AbstractTableModel{
    public static ArrayList<EmpFijo> datos = new ArrayList<EmpFijo>();
    String[] columnas = {"ID", "TITULO"};
     Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    public String getColumnName(int col) {
        return columnas[col].toString();
    }

    //Devuelve el numero de filas
    
    public int getRowCount() {
        return datos.size();
    }

    //Devuelve el numero de columnas
    
    public int getColumnCount() {
        return columnas.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    
    public Object getValueAt(int row, int col) {

        Object dev = null;
        EmpFijo fila = (EmpFijo) datos.get(row);

        switch (col) {
            case 0:
                dev = fila.getDNI();
                break;

            case 1:
                dev = fila.getNombre();
                break;


        }
        return dev;
    }

    //Determina si una fila y columna ha de ser editable
   
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    
    public void setValueAt(Object value, int row, int col) {



        EmpFijo fila = (EmpFijo) datos.get(row);

        switch (col) {
            case 0:
                fila.setDNI(value.toString());
                break;

            case 1:
                fila.setNombre(value.toString());
                break;


        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(EmpFijo ef) {
        datos.add(ef);
        fireTableDataChanged();
    }

    public void cargar() {
         datos.clear();
        EmpFijo o = null;
        Librerias.txt.abrir_txtOcultoEF();
        
        
        for(int j=0;j<ArrayListEmpFijo.efi.size();j++) {
           o=ArrayListEmpFijo.efi.get(j);
            addRow(o);
            datos.add(o);
            efi.add(o);
            try {
                Thread.sleep(1); //1 milliseconds
            } catch (InterruptedException ex) {
                Logger.getLogger(STM.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              
            }
        }

    public void removeRow(int fila) {
        datos.remove(fila);
        fireTableDataChanged();
    }
}


