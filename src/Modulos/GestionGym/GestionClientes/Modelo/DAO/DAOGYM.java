/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionClientes.Modelo.DAO;

import Clases.fecha;
import Modulos.ClasesMadre.persona;
import Modulos.GestionGym.GestionClientes.Controlador.controladorgym;
import static Modulos.GestionGym.GestionClientes.Controlador.controladorgym.Pagergym;
import static Modulos.GestionGym.GestionClientes.Controlador.controladorgym.sorter;
import Modulos.GestionGym.GestionClientes.Modelo.BLL.BLLBDGYM;
import Modulos.GestionGym.GestionClientes.Modelo.BLL.BLLGYM;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Arraylistgym;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Cliente;
import Modulos.GestionGym.GestionClientes.Vista.Altagym;
import Modulos.GestionGym.GestionClientes.Vista.Login.Login;
import Modulos.GestionGym.GestionClientes.Vista.Pager.PagerGym;
import Modulos.GestionGym.GestionClientes.Vista.Pager.STM;
import Modulos.GestionGym.GestionClientes.Vista.Pager.modificagym;
import Modulos.GestionGym.GestionClientes.Vista.Pager.pagina;
import Modulos.GestionGym.GestionUsuarios.Controlador.ControladorUser;
import Modulos.GestionGym.GestionUsuarios.Modelo.BLL.BLLBDUs;
import Modulos.GestionGym.GestionUsuarios.Modelo.Clases.user;
import Modulos.GestionGym.GestionUsuarios.Modelo.DAO.DAOUs;
import Modulos.GestionGym.GestionUsuarios.Vista.RootMenu;
import Modulos.GestionGym.GestionUsuarios.Vista.VistaAdmin;
import Utils.Validacion;
import com.toedter.calendar.JTextFieldDateEditor;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Borja Alventosa
 */
public class DAOGYM {
    
     public static String pideNombreA(){
        String cad="";
        if(Altagym.etinombre.getText().isEmpty()){
           // Altagym.etifalloNombre.setVisible(true);
        }
        else{
            if(Validacion.validaNombre(Altagym.etinombre.getText())!=true)
            {
             //   Altagym.etifalloNombre.setVisible(true);
            }else{
            cad=Altagym.etinombre.getText();
            //Altagym.etifalloNombre.setVisible(false);
            }
                }
        return cad;
                }
    public static String pideNombreM(){
        String cad="";
        if(modificagym.etinom.getText().isEmpty()){
            modificagym.etifallonom.setVisible(true);
        }
        else{
            if(Validacion.validaNombre(modificagym.etinom.getText())!=true)
            {
                modificagym.etifallonom.setVisible(true);
            }else{
                cad=modificagym.etinom.getText();
                modificagym.etifallonom.setVisible(false);
            }
                }
        return cad;
                }
    public static String pideApellidoAlta(){
        String cad="";
        if(Altagym.etiapellido.getText().isEmpty()){
            Altagym.etifalloape.setVisible(true);
        }
        else{
            cad=Altagym.etiapellido.getText();
        }
            return cad;
    }
    public static String pideApellidoModi(){
        String cad="";
        if(modificagym.etiape.getText().isEmpty()){
            modificagym.etifalloape.setVisible(true);
        }
        else{
            cad=modificagym.etiape.getText();
        }
            return cad;
    }
    
    
     public static Cliente pideCliente() {
         boolean val=false;
         
         String nombre="",Apellido="";
         fecha a1=null;
         String categoria="";
         int cuota = 0;
         nombre=Altagym.etinombre.getText(); //ANRECORDOT DE CAMBIARo PER EL BLLGYM.PIDENOMBRE()
         Apellido=Altagym.etiapellido.getText();
             String date1 = ((JTextFieldDateEditor) Altagym.etinac.getDateEditor()).getText();
             //JOptionPane.showMessageDialog(null,"Fecha Seleccionanda:"+date1);
             a1=new fecha(date1);
             if(Altagym.btnsilver.isSelected()==true){
                 categoria="Silver";
                 Altagym.eticuota.setText("20");
                 cuota=20;
             }
             
           else  if(Altagym.btngolden.isSelected()==true){
                 categoria="Golden";
                 Altagym.eticuota.setText("40");
                 cuota=40;
             }
             else  if(Altagym.btndiamond.isSelected()==true){
                 categoria="Diamond";
                 Altagym.eticuota.setText("60");
                 cuota=60;
             }
             else {
                 JOptionPane.showMessageDialog(null,"DEBE SELECCIONAR UNA CATEGORIA");
             }
             int diaPago=Altagym.CalenDia.getDay();
             
             
         String login=Altagym.etilogin.getText();
         String password=Altagym.etipassword.getText();
         String dni=Altagym.etidni.getText();
         Cliente o=new Cliente(nombre,Apellido,dni,a1,login,password,categoria, cuota,"","user",diaPago);
         JOptionPane.showMessageDialog(null,"Nombre"+o.getNombre() +o.getApellido() +"Categoria"+ o.getCategoria() +" Pass "+o.getPassword() +o.getLogin());
         
         //(String nombre,String apellido,String DNI, fecha fechaNac,String login,String password,String categoria,int cuota)
         
         return o;

         
         
         
         
     
    }
     
     public static persona ModificaCli() {
         boolean val=false;
         int antiguedad=0;
         String nombre="",apellido="";
         fecha a1=null;
         int cuota = 0;
         String categoria="";
         nombre=DAOGYM.pideNombreM();
         
         apellido=DAOGYM.pideApellidoModi();
             String date1 = ((JTextFieldDateEditor) modificagym.etinac.getDateEditor()).getText();
             a1=new fecha(date1);
         String password=modificagym.etipassword.getText();
         String login=Arraylistgym.o.getLogin();
         String dni=modificagym.etidni.getText();
         if(modificagym.btnSilver.isSelected()){
             categoria="Silver";
             cuota=20;
         }
         if(modificagym.btnGolden.isSelected()){
             categoria="Golden";
             cuota=40;
         }
         if(modificagym.btnDiamond.isSelected()){
             categoria="Diamond";
             cuota=60;
         }
         persona o=new persona(nombre,apellido,dni,a1,login,password,categoria,cuota,"user");
         return o;
//public EmpFijo(String nombre,int edad,String DNI, String departamento,fecha fechaNac,float sueldo,int antiguedad,fecha fechaCont)
         
         
         
         
     
    }
    public static int buscarCliente(Cliente ef){//Buscar
		int aux=-1;
		
		for (int i = 0; i<=(Arraylistgym.gym.size()-1); i++){
			if((Arraylistgym.gym.get(i)).equals(ef))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
				aux=i;
		}
		return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
	}
   
    public static void cargardatosFijos(){
			int Antiguedad=0;
			
			int edad=0;
			persona o=null;
			float sueldo=1000.0f;
		String[] nombres={"Borja","Pablo","Julio","Javier","Miguel"};
		String[] departamentos={"Seguridad","Marketing","Test Calidad","Producci�n", "Ventas"};
		fecha[] fechaNacs={new fecha("1994/11/26",1),new fecha("1993/10/7",1),new fecha("1993/7/10",1),new fecha("1994/8/9",1),new fecha("1991/11/3",1)};
		String[] DNIS={"20416734W","20447497P","31972043L","83723295Y","36272513H"};
		fecha[] fechaCont={new fecha("2009/10/3",1),new fecha("2010/4/4",2),new fecha("2011/11/23",1),new fecha("2008/10/23",1),new fecha("2009/5/13",1)};
		for(int i=0;i<5;i++){
			Antiguedad=fechaCont[i].restafechas();
			edad=fechaNacs[i].restafechas();
			//o=new EmpFijo(nombres[i],edad,DNIS[i],departamentos[i],fechaNacs[i],sueldo,Antiguedad,fechaCont[i]);
			
                          //ArrayListEmpFijo.efi.add(o);
		}
		}
    public static String  ObtenDNiFijo(String cod){
        String dni="";
        persona o=null;
        for(int j=0; j<9; j++)		//extrae del string elegido el dni
					dni += cod.charAt(j);								
			//o = new EmpFijo(dni);	
		return dni;
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
    public static void rellenaDatosCliMod(){
        persona o;
        
        o=Arraylistgym.o;
        
        modificagym.etinom.setText(o.getNombre());
        modificagym.etiape.setText(o.getApellido());
        modificagym.etidni.setText(o.getDNI());
        modificagym.eticat.setText(o.getCategoria());
        modificagym.eticuota.setText(String.valueOf(o.getCuota()));
        
        
        modificagym.etinac.setCalendar(o.getFechaNac().deFechaToCalendar());
        
        
    }
    public static void cambianombre(Cliente o){
        o.setNombre(modificagym.etinom.getText());
    }
    public static void cambiaape(Cliente o ){
        o.setApellido(modificagym.etiape.getText());
    }
    public static void cambiaDNI (Cliente o ){
        Cliente a=null;
        String dni="";
        dni=modificagym.etidni.getText();
        a=new Cliente(dni,"");
        int pos =DAOGYM.buscarCliente(a);
        if (pos==-1){
           // modificagym.etidnirep.setVisible(true);
        }
        
        
    }
   
      
    
     
    public static void cambiaNac(persona o) {
        fecha a1=null;
        String date1 = ((JTextFieldDateEditor) modificagym.etinac.getDateEditor()).getText();
        a1=new fecha(date1);
        Arraylistgym.o.setFechaNac(a1);
    }
   
    public static void refrescaListaMo(){
       // modificafijo.listafijo.setModel(DAOEFgrafic.GeneraVecEmpFijo());
        JOptionPane.showMessageDialog(null,"Lista actualizada");
    }
   
    public static String pideDni(){
         String cad="";
        if(Altagym.etidni.getText().isEmpty()){
            Altagym.etifalloDNI.setVisible(true);
        }
        else{
            if(Validacion.DNI(Altagym.etidni.getText())!=true)
            {
                Altagym.etifalloDNI.setVisible(true);
            }else{
            cad=Altagym.etidni.getText();
            Altagym.etifalloDNI.setVisible(false);
            }
                }
        return cad;
                }
    public static void pideApellidoM(){
        boolean val=true;
        String cad="";
        cad=modificagym.etiape.getText();
        val=Validacion.validaNombre(cad);
       
    }
    public static void borraCamCrea(){
        Altagym.etinombre.setText("");
        Altagym.etiapellido.setText("");
        Altagym.etidni.setText("");
        Altagym.etinac.setDate(null);
        
        
    }
    
    public static void eliminaCli(int pos){
       Arraylistgym.gym.remove(pos);
       BLLGYM.guardaOcultoTXT();
       BLLGYM.guardaOcultoXML();
       // fitxer
        //PagerFijos.tablafijos.setModel(new STM());
        //((STM)PagerFijos.tablafijos.getModel()).cargar();
    }
    public static void ObtenSelecionado(){
        Cliente A=null;
        if (PagerGym.tablagym.getModel().getRowCount() != 0) {
           
             int inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage;
              int selec = PagerGym.tablagym.getSelectedRow();
              JOptionPane.showMessageDialog(null,selec);
                int selection1=inicio+selec;
                
    
            if (selec == -1) {
                //
            } else {
                String email = (String) PagerGym.tablagym.getModel().getValueAt(selec, 6);
                
                JOptionPane.showMessageDialog(null,email);
                
                Arraylistgym.o = new persona(email,"");
                Arraylistgym.C= new Cliente (email,"");
                int pos=DAOGYM.buscarCliente(Arraylistgym.C);
                A=Arraylistgym.gym.get(pos);
                Arraylistgym.C=A;
                JOptionPane.showMessageDialog(null,"ESTA ES LA CONTRASEÑA DE LA PERSONA SELECCIONADA"+ A.getPassword());
                Arraylistgym.pass=A.getPassword();
                
            }
    }
  }
        public static void ObtenSeleccionadoCompleto(){
            persona Cli=null;
            
            if (PagerGym.tablagym.getModel().getRowCount() != 0) {
           
             int inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage;
              int selec = PagerGym.tablagym.getSelectedRow();
              
                int selection1=inicio+selec;
                
    
            if (selec != -1) {
                //
            
                String email = (String) PagerGym.tablagym.getModel().getValueAt(selection1, 6);
                
                 Cli= new persona(email,"");
                JOptionPane.showMessageDialog(null,email);
            }
            int pos=DAOGYM.buscarfio(Cli);
            JOptionPane.showMessageDialog(null,"POSICION DEL EMAIL"+pos);
            Arraylistgym.C =Arraylistgym.gym.get(pos);
    }
  }
        
        
        public static void CompruebaUser(){
            //DAOUs.MiraTipo();
            boolean val =false;
                persona per=null;
               String email= Login.etiLogin.getText();
               String pass= Login.etiPass.getText();
               per = new persona( email, pass);
               JOptionPane.showMessageDialog(null,"Contraseña escrita:"+per.getLogin());
                //JOptionPane.showMessageDialog(null,"Contraseña del usuario introducido"+o.getPassword());
               int pos =DAOGYM.buscarfio(per);
               JOptionPane.showMessageDialog(null,"pos"+pos);
               if(pos!=-1){
                        persona o=Arraylistgym.gym.get(pos);
                        String tipo=o.getTipo();
                            if (tipo.equalsIgnoreCase("admin")){
                                JOptionPane.showMessageDialog(null,"Administrador!");
                                Arraylistgym.tipo=2;
                                }
                            if (tipo.equalsIgnoreCase("user")){
                                JOptionPane.showMessageDialog(null,"Usuario normal");
                                Arraylistgym.tipo=0;
                                }
                            JOptionPane.showMessageDialog(null,"Contraseña escrita:"+Login.etiPass.getText());
                            JOptionPane.showMessageDialog(null,"Contraseña del usuario introducido"+o.getPassword());
                            if(o.getPassword().equalsIgnoreCase(Login.etiPass.getText())){
                                val=true;
                                }
               }
               if(pos==-1){
                   Arraylistgym.tipo=-1;
               }
        }
        
       
        public static void CargaSingletonCliCre(){
            
         String nombre="",Apellido="";
         fecha a1=null;
         String categoria="";
         int cuota = 0;
         nombre=Altagym.etinombre.getText(); 
         Apellido=Altagym.etiapellido.getText();
             String date1 = ((JTextFieldDateEditor) Altagym.etinac.getDateEditor()).getText();
             JOptionPane.showMessageDialog(null,"Fecha Seleccionanda:"+date1);
             a1=new fecha(date1);
             if(Altagym.btnsilver.isSelected()==true){
                 categoria="Silver";
                 Altagym.eticuota.setText("20");
                 cuota=20;
             }
             
           else  if(Altagym.btngolden.isSelected()==true){
                 categoria="Golden";
                 Altagym.eticuota.setText("40");
                 cuota=40;
             }
             else  if(Altagym.btndiamond.isSelected()==true){
                 categoria="Diamond";
                 Altagym.eticuota.setText("60");
                 cuota=60;
             }
             else {
                 JOptionPane.showMessageDialog(null,"DEBE SELECCIONAR UNA CATEGORIA");
             }
             
             
             String login=Altagym.etilogin.getText();
             String password=Altagym.etipassword.getText();
         String dni=Altagym.etidni.getText();
         Arraylistgym.C=new Cliente(nombre,Apellido,dni,a1,login,password,categoria, cuota,"","user",Altagym.CalenDia.getDay());
         //super(nombre, apellido, DNI, fechaNac, login, password, categoria, cuota, avatar,tipo);
        }
        public static void singletonCli(){
            
        }
        public static void Singletonuser(){
             user A=DAOUs.ObtenUser();
             int pos=DAOUs.BuscaUser(A);
             JOptionPane.showMessageDialog(null,"POS: "+pos);
             //Arraylistgym.us.get(pos).setPassword("1234");
             //BLLGYM.guardaOcultoXML();
             //BLLGYM.guardaOcultoTXT();
            
             //JOptionPane.showMessageDialog(null,"Password encontrado: "+Arraylistgym.us.get(0).getPassword());
             
             Arraylistgym.U=Arraylistgym.us.get(pos);
             //JOptionPane.showMessageDialog(null,"Password guardado en singleton: "+Arraylistgym.U.getPassword());
        }
        public static persona ObtenCli(){
             String email=Login.etiLogin.getText();
           String pass=Login.etiPass.getText();
           persona per=new persona(email,pass);
           return per;
        }
        public static void refrescatabla(){
                 ((STM)Pagergym.tablagym.getModel()).cargar();
                 Pagergym.tablagym.setFillsViewportHeight(true);
                 Pagergym.tablagym.setRowSorter(sorter);
                 Pagergym.tablagym.addRowSelectionInterval(0, 0);
        }
        public static int buscauser(user u ){
            int aux=-1;
            int tipo=25;
            int i=0;
            user o=null;
            String Login="";
            persona a =null;
            for ( i = 0; i==(Arraylistgym.us.size()); i++){
                  o =Arraylistgym.us.get(i);
			if(o.getLogin().equals(u.getLogin())){
//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
				aux=i;
                        }
            }
            
            for ( i = 0; i==(Arraylistgym.gym.size()); i++){
                  a =Arraylistgym.gym.get(i);
			if(a.getLogin().equals(u.getLogin())){
//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
				aux=i;
                        }
            }
            JOptionPane.showMessageDialog(null,aux);
            //JOptionPane.showMessageDialog(null,o.getLogin());
            //JOptionPane.showMessageDialog(null,a.getLogin());
                                if(Arraylistgym.us.get(i).getPassword().equals(u.getPassword())){
                                   new controladorgym (new PagerGym(), 0).iniciar(0);
                                  // JOptionPane.showMessageDialog(null,"Ha entrado como usuario cliente");
                                   tipo=0;
                                }
                                if(Arraylistgym.us.get(i).getTipo().equals("user")){
                                    //JOptionPane.showMessageDialog(null,"Ha entrado como usuario normal");
                                    tipo=1;
                                    new controladorgym (new PagerGym(), 0).iniciar(0);
                                }
                                if(Arraylistgym.us.get(i).getTipo().equals("Admin")){
                                    //JOptionPane.showMessageDialog(null,"Ha entrado como administrador");
                                    new ControladorUser(new RootMenu(),0).iniciar(0);
                                    tipo=2;
                                }
        
            
            return tipo;
        }
 
     public static int buscarfio(persona ef){//Buscar
		int aux=-1;
		
		for (int i = 0; i<=(Arraylistgym.gym.size()-1); i++){
			if((Arraylistgym.gym.get(i)).equals(ef))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
				aux=i;
		}
		return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
	}
     public static void cargarArrays(){
         BLLBDUs.listaUser();
         BLLBDGYM.listaCli();
     }
     public static void cargaSingletonLog(){
         int aux=-1;
         String email=Login.etiLogin.getText();
         user u =new user(email,"");
         for ( int i = 0; i==(Arraylistgym.us.size()); i++){
			if((Arraylistgym.us.get(i).getLogin()).equals(u.getLogin())){
//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
				aux=i;
                                JOptionPane.showMessageDialog(null,"SingletonCargado");
                                Arraylistgym.o=Arraylistgym.gym.get(i);
                                JOptionPane.showMessageDialog(null,Arraylistgym.o.getLogin());
                                
                                
                        }
            }
         
     
      
         
     }
     public static void CargaPassSingle(){
         DAOGYM.ObtenSelecionado();
     }
     public static void cargaSingleCliModifica(){
         DAOGYM.CargaPassSingle();
         String nombre,apellido,email,pass=null,categoria=null;
         int diapago,cuota=0;
         fecha a1=null;
// String nombre, String apellido, String DNI, fecha fechaNac, String login, String password, String categoria, int cuota, String avatar,String tipo,int diaPago
         nombre=modificagym.etinom.getText();
         apellido=modificagym.etiape.getText();
         email=modificagym.etiLogin.getText();
         diapago=modificagym.CalenDiaMo.getDay();
         String DNI=modificagym.etidni.getText();
         String date1 = ((JTextFieldDateEditor) Altagym.etinac.getDateEditor()).getText();
             a1=new fecha(date1);
         if(modificagym.btnSilver.isSelected()==true){
                 categoria="Silver";
                 modificagym.eticuota.setText("20");
                 cuota=20;
             }
           else  if(modificagym.btnGolden.isSelected()==true){
                 categoria="Golden";
                 modificagym.eticuota.setText("40");
                 cuota=40;
             }
             else  if(modificagym.btnDiamond.isSelected()==true){
                 categoria="Diamond";
                 modificagym.eticuota.setText("60");
                 cuota=60;
             }
             else {
                 JOptionPane.showMessageDialog(null,"DEBE SELECCIONAR UNA CATEGORIA");
             }
            Cliente A=new Cliente (nombre,apellido,DNI,a1,email,Arraylistgym.pass,categoria,cuota,"",Arraylistgym.C.getTipo(),diapago);
     
     }
}
