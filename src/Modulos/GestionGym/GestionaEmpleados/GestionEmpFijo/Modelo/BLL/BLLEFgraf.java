/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.BLL;

import Clases.conexion;
import Clases.fecha;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.STM;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Vista.CreaEmpFijoFrame;
import static Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Vista.PagerFijos.tablafijos;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Vista.modificafijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.DAO.DAOEFgrafic;

import Utils.Validacion;
import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.Connection;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Borja Alventosa
 */
public class BLLEFgraf {
    public static void creaEmpFijo() {
        EmpFijo o=null;
    o=DAOEFgrafic.PideEmpFijo();
    ArrayListEmpFijo.efi.add(o);
    Librerias.EMPLEADOS.txt.generatxtOcultoEF();
    
    
}
    public static void rellenaForm(){
        EmpFijo o ;
        
        ///o=DAOEFgrafic.ObtenDatos();
        DAOEFgrafic.rellenaFormFijo();
        
    }
    public static void pidenomC(){
        DAOEFgrafic.pideNombreC();
    }
    public static void pidenomM(){
        DAOEFgrafic.pideNombreM();
    }
    public static void rellenaFormM(){
        EmpFijo o;
        o=DAOEFgrafic.ObtenDatosM();
        DAOEFgrafic.rellenaFormFijoMu();
    }
    public static EmpFijo cambiatodo(EmpFijo o) {
        
        
        DAOEFgrafic.cambiaDNI(o);
        DAOEFgrafic.cambianombre(o);
        DAOEFgrafic.cambiadepar(o);
        DAOEFgrafic.cambiaNac(o);
        DAOEFgrafic.cambiaCont(o);
        
        return o ;
    }
    public static boolean validatodoModifica() {
            boolean val=false,val1=false,val2=false,val3=false,val4=false;
            fecha a1=null;
            EmpFijo a, b = null;
            String DNI;
            DNI=modificafijo.etidni.getText();
            a=new EmpFijo(DNI);
            int pos=DAOEFgrafic.buscarfijo(a);
            b=ArrayListEmpFijo.efi.get(pos);
            val1=Validacion.validaNombre(modificafijo.etinom.getText());
            val2=Validacion.DNI(modificafijo.etidni.getText());
            val3=Validacion.validaNombre(modificafijo.etidepar.getText());
            String date1 = ((JTextFieldDateEditor) modificafijo.etinac.getDateEditor()).getText();
            a1=new fecha(date1);
            val4=a1.comparafechasNAC(modificafijo.eticon.getCalendar());
                
            if((val1==true)&&(val2==true)&&(val3==true)&&(val4==true)){
                val=true;
                
            }
            BLLEFgraf.cambiatodo(b);
            ArrayListEmpFijo.efi.set(pos, b);
            Librerias.EMPLEADOS.xml.generaxmlOcultoEF();
            //modificafijo.listafijo.setModel(DAOEFgrafic.GeneraVecEmpFijo());
           // DAOEFgrafic.refrescaListaMo();
            
            
            return val;
    }
    public static void EliminaFijo(){
        DAOEFgrafic.ObtenSelecionado();//Carregue el seleccionat en el Singleton del ArrayList
        int pos=DAOEFgrafic.buscarfijo(ArrayListEmpFijo.o); // Busca la posicio
        JOptionPane.showMessageDialog(null,pos);
        DAOEFgrafic.eliminaFijo(pos); // El elimina del arrayList
       // JOptionPane.showMessageDialog(null,ArrayListEmpFijo.efi.toString());
        //PagerFijos.tablafijos.setModel(new STM()); //Refresca
        ((STM)tablafijos.getModel()).cargar();
    }
    public static void ModificaFijoPager(){
        DAOEFgrafic.ObtenSelecionado();
        int pos=DAOEFgrafic.buscarfijo(ArrayListEmpFijo.o);
        EmpFijo ef=ArrayListEmpFijo.efi.get(pos);
       ef= BLLEFgraf.cambiatodo(ef);
        ArrayListEmpFijo.efi.set(pos, ef);
        BLLEFgraf.guardaOcultoXML();
        BLLEFgraf.guardaOcultoTXT();
       //DAOEFGRAfic modificaFijoPager
    }
    public static void ObtenSeleccionado(){
        DAOEFgrafic.ObtenSelecionado();
    }
    public static void pidedniCrea(){
        DAOEFgrafic.pideDni();
    }
    public static void borracamposCrear(){
        DAOEFgrafic.borraCamCrea();
    }
    public static void ValidaTodoCre(){
         boolean val=false,val1=false,val2=false,val3=false,val4=false;
            fecha a1=null;
            EmpFijo a, b = null;
            String DNI;
            DNI=CreaEmpFijoFrame.etidni.getText();
            a=new EmpFijo(DNI);
            int pos=DAOEFgrafic.buscarfijo(a);
            b=ArrayListEmpFijo.efi.get(pos);
            val1=Validacion.validaNombre(CreaEmpFijoFrame.etinombre.getText());
            val2=Validacion.DNI(CreaEmpFijoFrame.etidni.getText());
            val3=Validacion.validaNombre(CreaEmpFijoFrame.etidepartamento.getText());
            String date1 = ((JTextFieldDateEditor) CreaEmpFijoFrame.etiNac.getDateEditor()).getText();
            a1=new fecha(date1);
            val4=a1.comparafechasNAC(CreaEmpFijoFrame.etiCon.getCalendar());
                
            if((val1==true)&&(val2==true)&&(val3==true)&&(val4==true)){
                val=true;
                
            }
    }
    public static void ObtenSeleccionadoCompleto(){
       DAOEFgrafic.ObtenSeleccionadoCompleto();
    }
    public static int BuscaSoloPorDni(String dni){
      int   pos = DAOEFgrafic.BuscaPorDniSolo(dni);
        return pos ;
    }
    public static void guardaOcultoXML(){
        Librerias.EMPLEADOS.xml.generaxmlOcultoEF();
    }
    public static void guardaOcultoTXT(){
        Librerias.EMPLEADOS.txt.generatxtOcultoEF();
    }
/*    public static boolean guardarM(EmpFijo ef) {
            Connection conn = conexion.connectar();
            if (conn != null) {
                EFDAO.modificar(ef, conn)
                    int pos = buscarDniEmpleat();
                    SingletonEF.efix.set(pos, ef);
                    Connexio.desconnectar(conn);
                    return true;
                            }
        return false;
    }*/
}
    


