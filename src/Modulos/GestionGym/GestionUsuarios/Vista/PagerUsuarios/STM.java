/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionUsuarios.Vista.PagerUsuarios;


import Modulos.ClasesMadre.persona;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Arraylistgym;
import Modulos.GestionGym.GestionUsuarios.Modelo.BLL.BLLBDUs;
import Modulos.GestionGym.GestionUsuarios.Modelo.Clases.user;
import Modulos.GestionGym.GestionUsuarios.Modelo.DAO.DAOBDUs;


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
    String [] columnas = {"Nombre","Login", "DNI", "Tipo"};//Mira que estiga tot correcte
    Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class //Ajusta parametros
        };

    
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
        user fila = (user) Arraylistgym.us.get(row);
        switch(col){
            case 0:
                
                dev=fila.getNombre();
                break;
            case 1:
                dev=fila.getLogin();
                break;
            case 2:
                dev=fila.getDNI();
                break;
            case 3:
                dev=fila.getTipo();
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
        user  fila = (user) Arraylistgym.us.get(row);
        switch(col){
            case 0:
                fila.setNombre(value.toString());
                
                break;
            case 1:
                fila.setLogin(value.toString());
                break;
           case 2:
               fila.setDNI(value.toString());
               
                break;
            case 3:
                fila.setTipo(value.toString());
                break;
            
                }
        fireTableCellUpdated(row, col);
    }    
    
    
    //Añade una fila al modelo
    public void addRow(user p) {
        Arraylistgym.us.add(p);
        fireTableDataChanged();
    }
    
    
    //Elimina una fila del modelo
    public void removeRow(int fila) {
        Arraylistgym.us.remove(fila);
        fireTableDataChanged();
    }
    
    
    public ArrayList<user> getdatos() {
        return Arraylistgym.us;
    }
    

    
    public void setdatos(ArrayList<user> a) {
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
        Arraylistgym.us.clear();
        user o = null;
        //Librerias.USUARIOS.XML.abrir_xmlOcultgym();
        BLLBDUs.listaUser();// LLENA ARRAY DESDE BASE DE DATOS
        
        for(int j=0;j<Arraylistgym.us.size();j++) {
           o=Arraylistgym.us.get(j);
           
           
           
            addRow(o);
            //datos.add(o);
            JOptionPane.showMessageDialog(null,o.getLogin());
            Arraylistgym.us.add(o);
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
    public user buscar(String s) {
        String res;
        for(int i=0;i<Arraylistgym.us.size();i++){
            res = Arraylistgym.us.get(i).toString();
            if(res.contains(s))
                return Arraylistgym.us.get(i); 
        }
        return null;
    }
    public int buscapersona(user p) {
        for(int i=0;i<Arraylistgym.us.size();i++)
            if(Arraylistgym.us.get(i).equals(p))
               return i;
        return -1;
    }
    
}


