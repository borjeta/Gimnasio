/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionClientes.Vista.Pager;

import Clases.Conf;
import Clases.fecha;
import Modulos.ClasesMadre.persona;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Arraylistgym;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Borja Alventosa
 */
public class STM extends AbstractTableModel{

    /**
     *
     */
    //public static Conf f =null;
    public static ArrayList <persona> datos= new ArrayList<persona>();
    public static ArrayList <persona> gym =new ArrayList<persona>();
    String [] columnas = {"DNI","Nombre", "Apellido", "Fecha nacimiento","Categoria","Cuota","Login","Tipo"};//Mira que estiga tot correcte
    Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class ,//Ajusta parametros
        java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class};

    
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
        persona fila = (persona) datos.get(row);
        switch(col){
            case 0:
                dev=fila.getDNI();
                break;
            case 1:
                dev=fila.getNombre();
                break;
            case 2:
                dev=fila.getApellido();
                break;
            case 3:
                dev=fila.getFechaNac().toString();
                break;
            case 4:
                dev=fila.getCategoria();
                break;
            case 5:
                dev= String.valueOf(fila.getCuota());
                break;
            case 6:
                dev=String.valueOf(fila.getLogin());
                break;
            case 7:
                dev=String.valueOf(fila.getTipo());
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
        persona  fila = (persona) datos.get(row);
        switch(col){
            case 0:
                fila.setDNI(value.toString());
                break;
            case 1:
                fila.setNombre(value.toString());
                break;
           case 2:
               fila.setApellido(value.toString());
                break;
            case 3:
                fila.setFechaNac(new fecha(value.toString()));
                break;
            case 4:
                fila.setCategoria(value.toString());
                break;
            case 5:
                fila.setCuota(Integer.parseInt(value));
                break;
            case 6:
                fila.setLogin(value.toString());
                break;
            case 7:
                fila.setTipo(value.toString());
            
                }
        fireTableCellUpdated(row, col);
    }    
    
    
    //Añade una fila al modelo
    public void addRow(persona p) {
        datos.add(p);
        fireTableDataChanged();
    }
    
    
    //Elimina una fila del modelo
    public void removeRow(int fila) {
        datos.remove(fila);
        fireTableDataChanged();
    }
    
    
    public ArrayList<persona> getdatos() {
        return datos;
    }
    

    
    public void setdatos(ArrayList<persona> a) {
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
        gym.clear();
        
        persona o = null;
        
        Librerias.CLIENTES.xml.abrir_xmlOcultgym();
        
        
        for(int j=0;j<Arraylistgym.gym.size();j++) {
           o=Arraylistgym.gym.get(j);
           
           
            addRow(o);
            //datos.add(o);
            gym.add(o);
            try {
                Thread.sleep(1); //1 milliseconds
            } catch (InterruptedException ex) {
                Logger.getLogger(STM.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              
            }
        }
    
     
     
/*
    public void filtra1(String fono,String genero,JTable jTableConModelo){
            ArrayList<Integer> posiciones=new ArrayList<Integer>();
            //consultamos por cada item que hay en el agenda
            for(int i=0;i<datos.size();i++){
                EmpFijo p=datos.get(i);
                if(fono.compareTo("todos")!=0)//fijo o movil
                {
                    if(fono.compareTo(p.gettipotfno())==0)//segun sea fijo o movil
                    {
                        if(genero.compareTo("todos")!=0)
                        {
                            if(genero.compareTo(p.getsexo())==0)//segun sea masc o fem
                                posiciones.add(new Integer(i));
                        }
                        else//genero todos
                            posiciones.add(new Integer(i));
                    }
                }
                else//fono todos
                {
                    if(genero.compareTo("todos")!=0)
                    {
                        if(genero.compareTo(p.getsexo())==0)//segun sea masc o fem
                            posiciones.add(new Integer(i));
                    }
                    else//genero todos
                        posiciones.add(new Integer(i));
                }
            }
            for(int i=0;i<posiciones.size();i++)
                jTableConModelo.addRowSelectionInterval(posiciones.get(i), posiciones.get(i));
    }
     */
    public persona buscar(String s) {
        String res;
        for(int i=0;i<datos.size();i++){
            res = datos.get(i).toString();
            if(res.contains(s))
                return datos.get(i); 
        }
        return null;
    }
    public int buscapersona(persona p) {
        for(int i=0;i<datos.size();i++)
            if(datos.get(i).equals(p))
               return i;
        return -1;
    }
    /*
    public void ordena() {
        Collections.sort(datos, new OrdenaNombre());//ordeno la agenda por apellidos
        JOptionPane.showMessageDialog(null,
                "Apellido menor: "+Collections.min(datos)+
                "Apellido mayor: "+Collections.max(datos),
                "Info",JOptionPane.INFORMATION_MESSAGE);
    }
    */
}


