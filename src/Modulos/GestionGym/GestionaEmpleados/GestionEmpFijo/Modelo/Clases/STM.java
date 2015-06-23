/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.Clases;


import Clases.fecha;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Cliente;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Borja Alventosa
 */
public class STM extends AbstractTableModel{

    
    
    public static ArrayList <EmpFijo> datos= new ArrayList<EmpFijo>();
    public static ArrayList <EmpFijo> efi =new ArrayList<EmpFijo>();
    String [] columnas = {"DNI","Nombre", "Departamento", "Fecha nacimiento", "Fecha de contratacion", "Antiguedad","sueldo","Edad"};//Mira que estiga tot correcte
    Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class ,//Ajusta parametros
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};

    
    //Devuelve el nombre de la columna
    @Override
    public String getColumnName(int col) {
        return columnas[col].toString(); }
    //Devuelve el numero de filas
    @Override
    public int getRowCount() { 
        
        return datos.size(); }
    //Devuelve el numero de columnas
    @Override
    public int getColumnCount() { return columnas.length; }
    
    //Devuelve el valor del objeto en la fila y columna
    @Override
    public String getValueAt(int row, int col) {//Cambia lo de les files y ajusta als parametros
        String dev=null;
        
        EmpFijo fila = (EmpFijo) datos.get(row);
        switch(col){
            case 0:
                dev=fila.getDNI();
                break;
            case 1:
                dev=fila.getNombre();
                break;
            case 2:
                dev=fila.getDepartamento();
                break;
            case 3:
                dev=fila.getFechaNac().toString();
                break;
            case 4:
                dev=fila.getFechaCont().toString();
                break;
            case 5:
                dev= String.valueOf(fila.getAntiguedad());
                break;
            case 6:
                dev=String.valueOf(fila.getSueldo());
                break;
            case 7:
                dev=String.valueOf(fila.getEdad());
                break;
        }
        
        return dev;
    }
    //Devuelve la clase que corresponde al tipo de columna
    @Override
    
    
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }
    //Determina si una fila y columna ha de ser editable
    @Override
    
    
    public boolean isCellEditable(int row, int col) {
        return false; }
    
    
    //Actualiza un objeto de una fila y columna
    public void setValueAt(String value, int row, int col) throws ParseException {
        EmpFijo  fila = (EmpFijo) datos.get(row);
        switch(col){
            case 0:
                fila.setDNI(value.toString());
                break;
            case 1:
                fila.setNombre(value.toString());
                break;
           case 2:
               fila.setDepartamento(value.toString());
                break;
            case 3:
                fila.setFechaNac(new fecha(value.toString()));
                break;
            case 4:
                fila.setFechaCont(new fecha(value.toString()));
                break;
            case 5:
                fila.setAntiguedad(Integer.parseInt(value));
                break;
            case 6:
                fila.setSueldo(1500);
                break;
            case 7:
                fila.setEdad(fila.getFechaNac().restafechas());
                break;
                }
        fireTableCellUpdated(row, col);
    }    
    
    
    //Añade una fila al modelo
    public void addRow(EmpFijo p) {
        datos.add(p);
        fireTableDataChanged();
    }
    
    
    //Elimina una fila del modelo
    public void removeRow(int fila) {
        datos.remove(fila);
        fireTableDataChanged();
    }
    
    
    public ArrayList<EmpFijo> getdatos() {
        return datos;
    }
    

    
    public void setdatos(ArrayList<EmpFijo> a) {
        limpiarfilas();
        for(int i=0;i<a.size();i++)
            addRow(a.get(i));
    }
    
    
    public void limpiarfilas(){
        int numrows = getRowCount();
        for(int i=(numrows-1);i>=0;i--)
            removeRow(i);
    }
    
    
     public void cargar()  {
        datos.clear();
        efi.clear();
        
        EmpFijo o = null;
        
        
        Librerias.EMPLEADOS.xml.abrir_xmlOcultoEF();
        for(int j=0;j<ArrayListEmpFijo.efi.size();j++) {
           o=ArrayListEmpFijo.efi.get(j);
           
            addRow(o);
            //datos.add(o);
            efi.add(o);
            try {
                Thread.sleep(1); //1 milliseconds
            } catch (InterruptedException ex) {
                Logger.getLogger(STM.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              
            }
        }

    public EmpFijo buscar(String s) {
        String res;
        for(int i=0;i<datos.size();i++){
            res = datos.get(i).toString();
            if(res.contains(s))
                return datos.get(i); 
        }
        return null;
    }
    public int buscapersona(EmpFijo p) {
        for(int i=0;i<datos.size();i++)
            if(datos.get(i).equals(p))
               return i;
        return -1;
    }
    
    
}


