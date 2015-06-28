/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionClientes.Modelo.BLL;

import Clases.fecha;
import Modulos.ClasesMadre.persona;
import static Modulos.GestionGym.GestionClientes.Controlador.controladorgym.Pagergym;
import static Modulos.GestionGym.GestionClientes.Controlador.controladorgym.sorter;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Arraylistgym;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Cliente;
import Modulos.GestionGym.GestionClientes.Modelo.DAO.DAOGYM;
import Modulos.GestionGym.GestionClientes.Vista.Altagym;
import Modulos.GestionGym.GestionClientes.Vista.Pager.PagerGym;
import Modulos.GestionGym.GestionClientes.Vista.Pager.STM;
import Modulos.GestionGym.GestionClientes.Vista.Pager.modificagym;
import Utils.Validacion;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JOptionPane;

/**
 *
 * @author Borja Alventosa
 */
public class BLLGYM {
     public static void creaCli() {
        Cliente o=null;
    o=DAOGYM.pideCliente();
    Arraylistgym.gym.add(o);
    Librerias.CLIENTES.txt.generatxtOcultoClientes();
    Librerias.CLIENTES.xml.generaxmlOcultoGym();
    
    
}
    
    public static void pidenomC(){
        DAOGYM.pideNombreA();
    }
    public static void pidenomM(){
        DAOGYM.pideNombreM();
    }
    public static void rellenaFormM(){
        persona o;
        DAOGYM.rellenaDatosCliMod();
    }
    public static Cliente cambiatodo(Cliente o) {
        
        
        DAOGYM.cambiaDNI(o);
        DAOGYM.cambianombre(o);
        DAOGYM.cambiaape(o);
        DAOGYM.cambiaNac(o);
        //DAOGYM.cambiapass(o); Nia que ferla
        
        return o ;
    }
    public static boolean validatodoModifica() {
            boolean val=false,val1=false,val2=false,val3=false,val4=false;
            fecha a1=null;
            Cliente a, b = null;
            String email;
            email=modificagym.etidni.getText();
            a=new Cliente(email,"");
            int pos=DAOGYM.buscarCliente(a);
            b=Arraylistgym.gym.get(pos);
            val1=Validacion.validaNombre(modificagym.etinom.getText());
            val2=Validacion.DNI(modificagym.etidni.getText());
            val3=Validacion.validaNombre(modificagym.etiape.getText());
            
                
            if((val1==true)&&(val2==true)&&(val3==true)){
                val=true;
            }
            BLLGYM.cambiatodo(b);
            Arraylistgym.gym.set(pos, b);
            Librerias.CLIENTES.xml.generaxmlOcultoGym();
            //modificafijo.listafijo.setModel(DAOGYM.GeneraVecEmpFijo());
           // DAOGYM.refrescaListaMo();
            
            
            return val;
    }
    public static void EliminaFijo(){
        DAOGYM.ObtenSelecionado();//Carregue el seleccionat en el Singleton del ArrayList
        int pos=DAOGYM.buscarCliente(Arraylistgym.C); // Busca la posicio
        JOptionPane.showMessageDialog(null,pos);
        DAOGYM.eliminaCli(pos); // El elimina del arrayList
       // JOptionPane.showMessageDialog(null,ArrayListEmpFijo.efi.toString());
        //PagerFijos.tablafijos.setModel(new STM()); //Refresca
                     PagerGym.tablagym.setModel(new STM());
                    ((STM) PagerGym.tablagym.getModel()).cargar();
                     PagerGym.tablagym.setFillsViewportHeight(true);
                     PagerGym.tablagym.setRowSorter(sorter);
    }
    public static void ModificaCliPager(){
        DAOGYM.ObtenSelecionado();
        int pos=DAOGYM.buscarfio(Arraylistgym.o);
        Cliente ef=Arraylistgym.gym.get(pos);
       ef= BLLGYM.cambiatodo(ef);
        Arraylistgym.gym.set(pos, ef);
        BLLGYM.guardaOcultoXML();
        BLLGYM.guardaOcultoTXT();
        
       //DAOEFGRAfic modificaFijoPager
    }
    public static void ObtenSeleccionado(){
        DAOGYM.ObtenSelecionado();
    }
    public static void pidedniCrea(){
        DAOGYM.pideDni();
    }
    public static void borracamposCrear(){
        DAOGYM.borraCamCrea();
    }
    public static void ValidaTodoCre(){
         boolean val=false,val1=false,val2=false,val3=false,val4=false;
            fecha a1=null;
            Cliente a, b = null;
            String DNI;
            String email=null;
            email=Altagym.etilogin.getText();
            a=new Cliente(email,"");
            int pos=DAOGYM.buscarCliente(a);
            
            if(pos==-1){
            val1=Validacion.validaNombre(Altagym.etinombre.getText());
            val2=Validacion.DNI(Altagym.etidni.getText());
            val3=Validacion.validaNombre(Altagym.etiapellido.getText());
            String date1 = ((JTextFieldDateEditor) Altagym.etinac.getDateEditor()).getText();
            a1=new fecha(date1);
            }
                
            if((val1==true)&&(val2==true)&&(val3==true)){
                val=true;
                
            }
    }
    public static void ObtenSeleccionadoCompleto(){
       DAOGYM.ObtenSeleccionadoCompleto();
    }
    public static void guardaOcultoXML(){
        Librerias.CLIENTES.xml.generaxmlOcultoGym();
        
    }
    public static void guardaOcultoTXT(){
        Librerias.CLIENTES.txt.generatxtOcultoClientes();
        
    }
    public static boolean compruebauser(){
        boolean val =DAOGYM.CompruebaUser();
    return val;
    }
    public static void refrescatabla(){
        DAOGYM.refrescatabla();
    }
    
    
    
    
}
