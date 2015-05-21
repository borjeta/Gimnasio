/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.DAO;

import Clases.fecha;
import Modulos.GestionaEmpleados.ClasesMadre.empleado;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.BLL.BLLEFgraf;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.BLL.BLLEFgraf.EliminaFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.STM;
import Modulos.GestionaEmpleados.GestionEmpFijo.Vista.CreaEmpFijoFrame;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Vista.CreaEmpFijoFrame.etiCon;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Vista.CreaEmpFijoFrame.etiNac;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Vista.CreaEmpFijoFrame.etidepartamento;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Vista.CreaEmpFijoFrame.etidni;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Vista.CreaEmpFijoFrame.etifalloDNI;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Vista.CreaEmpFijoFrame.etifallodepar;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Vista.CreaEmpFijoFrame.etinombre;
import Modulos.GestionaEmpleados.GestionEmpFijo.Vista.EliminaFijo;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Vista.EliminaFijo.etinombre;
import Modulos.GestionaEmpleados.GestionEmpFijo.Vista.PagerFijos;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Vista.PagerFijos.tablafijos;
import Modulos.GestionaEmpleados.GestionEmpFijo.Vista.modificafijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Vista.modificafijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Vista.muestrafijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.pagina;
import Utils.Validacion;
import com.toedter.calendar.JTextFieldDateEditor;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Borja Alventosa
 */
public class DAOEFgrafic {
    // Aqui comienza la clase //
    public static String pideNombreC(){
        String cad="";
        if(CreaEmpFijoFrame.etinombre.getText().isEmpty()){
            CreaEmpFijoFrame.etifalloNombre.setVisible(true);
        }
        else{
            if(Validacion.validaNombre(CreaEmpFijoFrame.etinombre.getText())!=true)
            {
                CreaEmpFijoFrame.etifalloNombre.setVisible(true);
            }else{
            cad=CreaEmpFijoFrame.etinombre.getText();
            CreaEmpFijoFrame.etifalloNombre.setVisible(false);
            }
                }
        return cad;
                }
    public static String pideNombreM(){
        String cad="";
        if(modificafijo.etinom.getText().isEmpty()){
            modificafijo.etifallonom.setVisible(true);
        }
        else{
            if(Validacion.validaNombre(modificafijo.etinom.getText())!=true)
            {
                modificafijo.etifallonom.setVisible(true);
            }else{
                cad=modificafijo.etinom.getText();
                modificafijo.etifallonom.setVisible(false);
            }
                }
        return cad;
                }
    public static String pidedepartamento(){
        String cad="";
        if(CreaEmpFijoFrame.etidepartamento.getText().isEmpty()){
            CreaEmpFijoFrame.etifallodepar.setVisible(true);
        }
        else{
            cad=CreaEmpFijoFrame.etidepartamento.getText();
        }
            return cad;
    }
    public static String pidedepartamentoM(){
        String cad="";
        if(modificafijo.etidepar.getText().isEmpty()){
            //.etifallodepar.setVisible(true);
        }
        else{
            cad=modificafijo.etidepar.getText();
        }
            return cad;
    }
    public static int comparafecha() {
        String Nacim="";
        Calendar Cont=null;
        int val = 0;
        fecha c1=null,c2=null;
        String date1 = ((JTextFieldDateEditor) CreaEmpFijoFrame.etiNac.getDateEditor()).getText();
        Cont=CreaEmpFijoFrame.etiCon.getCalendar();
        c1=new fecha(date1);
        val=c1.comparafechas(Cont);
        return val;
    }
     public static EmpFijo PideEmpFijo() {
         boolean val=false;
         int antiguedad=0;
         String nombre="",departamento="";
         fecha a1=null,a2=null;
         float sueldo = 0.0f;
         nombre=DAOEFgrafic.pideNombreC();
         
         departamento=DAOEFgrafic.pidedepartamento();
         int i =DAOEFgrafic.comparafecha();
         if(i==1){
             
             String date1 = ((JTextFieldDateEditor) CreaEmpFijoFrame.etiNac.getDateEditor()).getText();
             String date2 = ((JTextFieldDateEditor) CreaEmpFijoFrame.etiCon.getDateEditor()).getText();
             CreaEmpFijoFrame.etiFalloFecha.setVisible(false);
             a1=new fecha(date1);
             a2=new fecha(date2);
             
             
         }
         else{
             CreaEmpFijoFrame.etiFalloFecha.setVisible(true);
         }
         antiguedad=a2.restafechas();
         String dni=CreaEmpFijoFrame.etidni.getText();
         EmpFijo o=new EmpFijo(nombre,dni,departamento,a1,sueldo,antiguedad,a2);
         o.calcularSueldoFijo(o.getAntiguedad());
         return o;
//public EmpFijo(String nombre,int edad,String DNI, String departamento,fecha fechaNac,float sueldo,int antiguedad,fecha fechaCont)
         
         
         
         
     
    }
     public static EmpFijo PideEmpFijomodifica() {
         boolean val=false;
         int antiguedad=0;
         String nombre="",departamento="";
         fecha a1=null,a2=null;
         float sueldo = 0.0f;
         nombre=DAOEFgrafic.pideNombreM();
         
         departamento=DAOEFgrafic.pidedepartamentoM();
         int i =DAOEFgrafic.comparafecha();
         if(i==1){
             
             String date1 = ((JTextFieldDateEditor) modificafijo.etinac.getDateEditor()).getText();
             String date2 = ((JTextFieldDateEditor) modificafijo.eticon.getDateEditor()).getText();
             //CreaEmpFijoFrame.etiFalloFecha.setVisible(false);
             a1=new fecha(date1);
             a2=new fecha(date2);
             
             
         }
         else{
             //CreaEmpFijoFrame.etiFalloFecha.setVisible(true);
         }
         antiguedad=a2.restafechas();
         String dni=modificafijo.etidni.getText();
         EmpFijo o=new EmpFijo(nombre,a1.restafechas(),dni,departamento,a1,sueldo,antiguedad,a2);
         o.calcularSueldoFijo(o.getAntiguedad());
         return o;
//public EmpFijo(String nombre,int edad,String DNI, String departamento,fecha fechaNac,float sueldo,int antiguedad,fecha fechaCont)
         
         
         
         
     
    }
    public static int buscarfijo(EmpFijo ef){//Buscar
		int aux=-1;
		
		for (int i = 0; i<=(ArrayListEmpFijo.efi.size()-1); i++){
			if((ArrayListEmpFijo.efi.get(i)).equals(ef))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
				aux=i;
		}
		return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
	}
    public static DefaultComboBoxModel GeneraVecEmpFijo(){
        DefaultComboBoxModel modelo=new DefaultComboBoxModel();
	EmpFijo c;
		int n = ArrayListEmpFijo.efi.size();
			for(int i=0; i<n; i++){
				c =ArrayListEmpFijo.efi.get(i);
					
					modelo.addElement(c.getDNI() + " - "+c.getNombre() );
			}				
	return modelo;
}
    public static void cargardatosFijos(){
			int Antiguedad=0;
			
			int edad=0;
			EmpFijo o=null;
			float sueldo=1000.0f;
		String[] nombres={"Borja","Pablo","Julio","Javier","Miguel"};
		String[] departamentos={"Seguridad","Marketing","Test Calidad","Producci�n", "Ventas"};
		fecha[] fechaNacs={new fecha("1994/11/26",1),new fecha("1993/10/7",1),new fecha("1993/7/10",1),new fecha("1994/8/9",1),new fecha("1991/11/3",1)};
		String[] DNIS={"20416734W","20447497P","31972043L","83723295Y","36272513H"};
		fecha[] fechaCont={new fecha("2009/10/3",1),new fecha("2010/4/4",2),new fecha("2011/11/23",1),new fecha("2008/10/23",1),new fecha("2009/5/13",1)};
		for(int i=0;i<5;i++){
			Antiguedad=fechaCont[i].restafechas();
			edad=fechaNacs[i].restafechas();
			o=new EmpFijo(nombres[i],edad,DNIS[i],departamentos[i],fechaNacs[i],sueldo,Antiguedad,fechaCont[i]);
			
                          ArrayListEmpFijo.efi.add(o);
                          
			
			
		
		}
		}
    public static String  ObtenDNiFijo(String cod){
        String dni="";
        EmpFijo o=null;
        for(int j=0; j<9; j++)		//extrae del string elegido el dni
					dni += cod.charAt(j);								
			//o = new EmpFijo(dni);	
                        
                        
			
		return dni;
    }
    public static void pideEmpFijo(){
        String nombre,departamento,DNI;
        EmpFijo e=null;
        
        Calendar fechaNacimiento=null,fechaCont=null,fechaSis=null;
        fecha a1=null,a2=null;
        String fecha1=null;
        nombre=CreaEmpFijoFrame.etinombre.getText();
        departamento=etidepartamento.getText();
        DNI=etidni.getText();
        
        String date1 = ((JTextFieldDateEditor) CreaEmpFijoFrame.etiNac.getDateEditor()).getText();
        
            a1=new fecha(date1);
        fechaCont=CreaEmpFijoFrame.etiCon.getCalendar();
        String date2 = ((JTextFieldDateEditor) CreaEmpFijoFrame.etiCon.getDateEditor()).getText();
            a2=new fecha(date2);
        int edad=a1.restafechas();
        int antiguedad=a2.restafechas();
        float sueldo=1000.0f;
       EmpFijo o = new EmpFijo(nombre,edad,DNI,departamento,a1,sueldo,antiguedad,a2,);//Construcctor que li falta avatar , estado tipo pass y log
            
    }
    public void ObtenDatos(){
       /* EmpFijo ef1;
          String DNIbusca=modificafijo.listafijo.getSelectedItem().toString();
          String dni=DAOEFgrafic.ObtenDNiFijo(DNIbusca);
          EmpFijo o=new EmpFijo(dni);
        int pos=DAOEFgrafic.buscarfijo(o);
        ef1=ArrayListEmpFijo.efi.get(pos);
        return ef1;
    */
    }
    public static void rellenaFormFijo(){
        EmpFijo o;
        DAOEFgrafic.ObtenSelecionado();
        o=ArrayListEmpFijo.o;
        modificafijo.etinom.setText(o.getNombre());
        modificafijo.etidepar.setText(o.getDepartamento());
        modificafijo.etidni.setText(o.getDNI());
        modificafijo.lblAntiguitat1.setText(Integer.toString(o.getAntiguedad()));
        modificafijo.etisueldo.setText(Float.toString(o.getSueldo()));
        modificafijo.etinac.setCalendar(o.getFechaNac().deFechaToCalendar());
        modificafijo.eticon.setCalendar(o.getFechaCont().deFechaToCalendar());
        modificafijo.etiedad.setText(Integer.toString(o.getEdad()));
    }
    public static void cambianombre(EmpFijo o){
        o.setNombre(modificafijo.etinom.getText());
    }
    public static void cambiadepar(EmpFijo o ){
        o.setDepartamento(modificafijo.etidepar.getText());
    }
    public static void cambiaDNI (EmpFijo o ){
        EmpFijo a=null;
        String dni="";
        dni=modificafijo.etidni.getText();
        a=new EmpFijo(dni);
        int pos =DAOEFgrafic.buscarfijo(a);
        if (pos==-1){
            modificafijo.etidnirep.setVisible(true);
        }
        
        
    }
    public static void rellenaFormEliminar(){
        EmpFijo o;
        o=DAOEFgrafic.ObtenDatosE();
        EliminaFijo.etinombre.setText(o.getNombre());
        EliminaFijo.etidepar.setText(o.getDepartamento());
        EliminaFijo.etiDni.setText(o.getDNI());
        EliminaFijo.etidepar.setText(Integer.toString(o.getAntiguedad()));
        EliminaFijo.etiSueldo.setText(Float.toString(o.getSueldo()));
        EliminaFijo.etiNac.setText(o.getFechaNac().toString());
        EliminaFijo.etiCon.setText(o.getFechaCont().toString());
        EliminaFijo.etiEdad.setText(Integer.toString(o.getEdad()));
        EliminaFijo.etiAnti.setText(Integer.toString(o.getAntiguedad()));
    }
      
    public static void rellenaFormFijoMu(){
        EmpFijo o;
        o=DAOEFgrafic.ObtenDatosM();
        muestrafijo.etinom.setText(o.getNombre());
        muestrafijo.etidepar.setText(o.getDepartamento());
        muestrafijo.etidni.setText(o.getDNI());
        muestrafijo.etianti.setText(Integer.toString(o.getAntiguedad()));
        muestrafijo.etisueldo.setText(Float.toString(o.getSueldo()));
        muestrafijo.etinac.setCalendar(o.getFechaNac().deFechaToCalendar());
        muestrafijo.eticon.setCalendar(o.getFechaCont().deFechaToCalendar());
        muestrafijo.etiedad.setText(Integer.toString(o.getEdad()));
    }
    public static EmpFijo ObtenDatosM(){
        EmpFijo ef1;
          String DNIbusca=muestrafijo.listafijo.getSelectedItem().toString();
          String dni=DAOEFgrafic.ObtenDNiFijo(DNIbusca);
          EmpFijo o=new EmpFijo(dni);
        int pos=DAOEFgrafic.buscarfijo(o);
        ef1=ArrayListEmpFijo.efi.get(pos);
        return ef1;
    }
     public static EmpFijo ObtenDatosE(){
        EmpFijo ef1;
          String DNIbusca=EliminaFijo.listaFijos.getSelectedItem().toString();
          String dni=DAOEFgrafic.ObtenDNiFijo(DNIbusca);
          EmpFijo o=new EmpFijo(dni);
        int pos=DAOEFgrafic.buscarfijo(o);
        ef1=ArrayListEmpFijo.efi.get(pos);
        return ef1;
    }
    public static void cambiaNac(EmpFijo o) {
        fecha a1=null;
        String date1 = ((JTextFieldDateEditor) modificafijo.etinac.getDateEditor()).getText();
        a1=new fecha(date1);
        o.setFechaNac(a1);
    }
    public static void cambiaCont(EmpFijo o ) {
        fecha a1=null;
        String date1 = ((JTextFieldDateEditor) modificafijo.eticon.getDateEditor()).getText();
        a1=new fecha(date1);
        o.setFechaCont(a1);
    }
    public static void refrescaListaMo(){
       // modificafijo.listafijo.setModel(DAOEFgrafic.GeneraVecEmpFijo());
        JOptionPane.showMessageDialog(null,"Lista actualizada");
    }
   /* public static void pideDni(){
        
        boolean val=false;
        String cad="";
        cad=etidni.getText();
        //val=Validacion.DNI(cad);
        if(Validacion.DNI(cad)==false){
            CreaEmpFijoFrame.etifalloDNI.setVisible(true);
            CreaEmpFijoFrame.etidni.requestFocus();
        }
        if(CreaEmpFijoFrame.etidni.getText().isEmpty()){
        CreaEmpFijoFrame.etidni.requestFocus();
        }
        if(true==Validacion.DNI(cad)){
            CreaEmpFijoFrame.etifalloDNI.setVisible(false);
        }
        }
    */
    public static String pideDni(){
         String cad="";
        if(CreaEmpFijoFrame.etidni.getText().isEmpty()){
            CreaEmpFijoFrame.etifalloDNI.setVisible(true);
        }
        else{
            if(Validacion.DNI(CreaEmpFijoFrame.etidni.getText())!=true)
            {
                CreaEmpFijoFrame.etifalloDNI.setVisible(true);
            }else{
            cad=CreaEmpFijoFrame.etidni.getText();
            CreaEmpFijoFrame.etifalloDNI.setVisible(false);
            }
                }
        return cad;
                }
    public static void pideDepart(){
        boolean val=true;
        String cad="";
        cad=CreaEmpFijoFrame.etidepartamento.getText();
        val=Validacion.validaNombre(cad);
        if(val==false){
            etifallodepar.setText("No ha introducido un nombre correcto");
            etidepartamento.requestFocus();
        }
    }
    public static void borraCamCrea(){
        CreaEmpFijoFrame.etinombre.setText("");
        etidepartamento.setText("");
        etidni.setText("");
        etiNac.setDate(null);
        etiCon.setDate(null);
        
    }
    
    public static void eliminaFijo(int pos){
       ArrayListEmpFijo.efi.remove(pos);
       Librerias.txt.generatxtOcultoEF();
       // fitxer
        //PagerFijos.tablafijos.setModel(new STM());
        //((STM)PagerFijos.tablafijos.getModel()).cargar();
    }
    public static void ObtenSelecionado(){
        if (tablafijos.getModel().getRowCount() != 0) {
           
             int inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage;
              int selec = tablafijos.getSelectedRow();
              JOptionPane.showMessageDialog(null,selec);
                int selection1=inicio+selec;
                
    
            if (selec == -1) {
                //
            } else {
                String dni = (String) tablafijos.getModel().getValueAt(selection1, 0);
                JOptionPane.showMessageDialog(null,dni);
                ArrayListEmpFijo.o = new EmpFijo(dni);
            }
    }
  }
        public static void ObtenSeleccionadoCompleto(){
            if (tablafijos.getModel().getRowCount() != 0) {
           
             int inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage;
              int selec = tablafijos.getSelectedRow();
              
                int selection1=inicio+selec;
                
    
            if (selec == -1) {
                //
            } else {
                String dni = (String) tablafijos.getModel().getValueAt(selection1, 0);
                
                ArrayListEmpFijo.o = new EmpFijo(dni);
                
            }
            int pos=DAOEFgrafic.buscarfijo(ArrayListEmpFijo.o);
            ArrayListEmpFijo.o=ArrayListEmpFijo.efi.get(pos);
            
            
    }
  }
        public static int BuscaPorDniSolo(String dni){
            int pos = -1;
            EmpFijo o=new EmpFijo (dni);
            pos=DAOEFgrafic.buscarfijo(o);
            return pos;
        }
        public static void guardaEnArray(){
                       
                   }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

