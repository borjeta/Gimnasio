package tema6;

import Modulos.menu.FramePpal;
import Clases.Conf;
import Clases.DAOBD;
import Clases.conexion;
import Modulos.GestionaEmpleados.GestionEmpFijo.Controlador.controladorfijos;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import static Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.STM.efi;
import Modulos.GestionaEmpleados.GestionEmpFijo.Vista.PagerFijos;
import com.mysql.jdbc.Connection;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class Ppal{

	public static Conf F=null;
	public static void main(String[] args) throws InterruptedException  {
            
            F=new Conf();
            //new FramePpal().setVisible(true);
                             new controladorfijos(new PagerFijos(), 0).iniciar(0);
        }
  }

    
             
            
                    
            
                
                    
               
                    
                    

                    

            
            
            
            
            
            
            
            
            
            /*
		ArrayListEmpFijo.efi=new ArrayList<EmpFijo>();
		ArrayListEmpTemp.eTe=new ArrayList<EmpTemp>();
		ArrayListEmpHoras.eHo=new ArrayList<EmpHoras>();

		int i =0;
		String[] opciones={"Crear empleado","Modificar empleado"," Eliminar empleado","Ordenar","Muestra empleado","Cambiar configuracion","Guardar/Abrir","Max/Min","Salir"};
		String[] opciones3={"Cambia formato fecha","Cambia moneda","Cambia formato decimales","Cambia tema","Volver"};
		String[] opciones4={"Guardar","Abrir","Volver"};

		boolean val=false;
		int op,resp=0,resp1=0,resp2=0;
		f = new Conf();


		do{	
			op=Menus.Cbotones(opciones);
			switch(op){

			case 0:		{

				do{
					resp=Menus.menuTipoEmpleados();
					if(resp==0)
						BLLEF.crearFijo();
					if(resp==1)
						BLLEH.crearHoras();
					if(resp==2)
						BLLET.crearTemp();;
					if(resp==3)
						val=true;
				}while(val==false);
				break;
			}
			case 1://Modifica empleados
				resp=Menus.menuTipoEmpleados();
				if(resp==0){		
					BLLEF.SupermodificarEmpFijo();
				}
				if(resp==1){//Modifica empleado elegido Horas
					BLLEH.SuperModificaEmpHora();
				}
				if(resp==2){
					BLLET.SupermodificarEmpTemp();
				}

				break;

			case 2:///Eliminar empleado
				resp=Menus.menuTipoEmpleados();
				if(resp==0)
					BLLEF.eliminaFijo();
				if(resp==1)			
					BLLEH.eliminaHoras();
				if(resp==2)
					BLLET.eliminaHoras();


				break;
			case 3://
				do{
				resp=Menus.menuTipoEmpleados();
					if(resp==0)
						BLLEF.Ordenar();
					if(resp==1)
						BLLEH.Ordenar();
					if(resp==2)
						BLLET.Ordenar();
					
				}while(resp!=3);
					break;
					
			case 4:{
				do{
				resp=Menus.menuTipoEmpleados();
				if(resp==0)
					BLLEF.muestraEmpleadoFijo();
				if(resp==1)
					BLLEH.muestraEmpleadoHoras();
				if(resp==2)
					BLLET.muestraEmpleadoTemp();
				//Muestra datos solo del empleado elegido
				}while(resp!=3);
				break;
			}



			case 5:
				//Configuracion
			do{	
				resp=Menus.Cbotones(opciones3);
				{
					if(resp==0)//Pruebas cambia confi fecha
						Menus.CambiaConfiguracionFecha();
					if(resp==1)
						f.setMoneda(Menus.AskCoin());
					if(resp==2)
						Menus.CambiaDecimales();
					if(resp==3)
						Apariencia.apariencia(Menus.Cambiatema());
				}
			}while(resp!=4);
				break;

			case 6:{//GUARDAR
			do{	
				resp=Menus.Cbotones(opciones4);
				if(resp==0)
				{ do{
					resp1=Menus.FormatoGuardado();
					if(resp1==0){
						Librerias.txt.generatxtEF();
						Librerias.txt.generatxtEmpHoras();
						Librerias.txt.generatxtEmpTemp();
						Librerias.txt.generatxtOcultoEF();
						Librerias.txt.generatxtOcultoEmpHoras();
						Librerias.txt.generatxtOcultoEmpTemp();
					}
					if(resp1==1){
						Librerias.xml.guardarxml_EmpFijo();
						Librerias.xml.generaxmlEmpHoras();
						Librerias.xml.generaxmlEmpTemp();
						Librerias.xml.generaxmlOcultoEF();
						Librerias.xml.generaxmlOcultoEmpHoras();
						Librerias.xml.generaxmlOcultoEmpTemp();
					}

				/*	if(resp1==2){
						Librerias.json.generajsonEF();
						Librerias.json.generajsonEmpHoras();
						Librerias.json.generajsonEmpTemp();
						Librerias.json.generajsonocultoEF();
						Librerias.json.generajsonocultoEmpHoras();
						Librerias.json.generajsonocultoEmpTemp();
					}
				}while(resp1!=3);
				}
				if(resp==1)//ABRIR
				{
					resp1=Menus.FormatoGuardado();
					if(resp1==0)
					{
						resp2=Menus.menuTipoEmpleados();
						if(resp2==0)
							Librerias.txt.abrir_txtEmpFijo();
						if(resp2==1)
							Librerias.txt.abrir_txtEmpHoras();
						if(resp2==2)
							Librerias.txt.abrir_txtEmpTemp();

					}
					if(resp1==1){
						resp2=Menus.menuTipoEmpleados();
						if(resp1==0)
							Librerias.xml.abrir_xmlEF();
						if(resp1==1)
							Librerias.xml.abrir_xmlEmpHoras();
						if(resp1==2)
							Librerias.xml.abrir_xmlEmpTemp();	

					}
					/*if(resp1==2){
							resp2=Menus.menuTipoEmpleados();
							if(resp2==0)
							Librerias.json.abrir_jsonEF();
							if(resp2==1)
							Librerias.json.abrir_jsonEmpHoras();
							if(resp2==2)
							Librerias.txt.abrir_txtEmpTemp();
						}

				}
				

			}while(resp!=2);
			}
			case 7:{
			do{	
				resp=Menus.menuTipoEmpleados();
				if(resp==0)
				{
					BLLEF.MaxMin();
				}
				if(resp==1){
					BLLEH.MaxMin();
				}
				if(resp==2){
					BLLET.MaxMin();
				}
			}while(resp!=3);
				
			}
			case 8:{
				op=-1;
				break;
			}
			}

		}while(op!=-1);
*/	

        
        
        
        






