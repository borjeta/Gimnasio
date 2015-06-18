package Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.DAO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import tema6.Ppal;
import Modulos.GestionaEmpleados.GestionEmpFijo.*;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.BLL.BLLEF;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenaEdad;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenaNombre;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenarAntiguedad;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenarFechaContrata;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenarFechaNac;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenarSueldo;
import Clases.fecha;
import Modulos.GestionaEmpleados.ClasesMadre.*;

import Utils.Funciones;
import Utils.Validacion;
import Modulos.GestionaEmpleados.*;


public class DAOEF {
	public static EmpFijo CreaEmpleadoFijo() throws ParseException{
		String nombre="",departamento="";
		float sueldo=0.0f;
		int edad=0,antiguedad=0;
		EmpFijo A=null;
		fecha fechaNac=null;
		fecha fechaContra=null;
		boolean val=false;
		
		String DNI=null;

			//Crea Empleado Fijo
			nombre = SuperNucleo.introNombre("Introduce el nombre del nuevo empleado","Nombre");
			departamento=Funciones.validastring("Introduce el departamento", "Departamento");
			DNI=SuperNucleo.pideDni();
			do{
					
				fechaNac=SuperNucleo.pidefecha("Introduce la fecha de nacimiento\n Con formato A�o/Mes/Dia","Fecha de nacimiento");
				edad=SuperNucleo.calcularEdad(fechaNac);
				JOptionPane.showMessageDialog(null,edad);
				if(edad<16){
					JOptionPane.showMessageDialog(null,"No puedes registrar un menor de 16 a�os");
				}
				else
					val=true;
			}while((val==false));
			do{
				fechaContra=SuperNucleo.pidefecha("Introduce una fecha de contratacion \n Con formato aaaa/mm/dd"," Fecha de alta");
			}while((fechaNac.comparafechas(fechaContra.deFechaToCalendar())!=1));
			antiguedad=SuperNucleo.calcularEdad(fechaContra);
		
			A=new EmpFijo(nombre,edad,DNI,departamento,fechaNac,sueldo,antiguedad,fechaContra);
			A.setSueldo(A.calcularSueldoFijo(antiguedad));
			
			return A;
		}
	
	public static void imprimir(ArrayList<? extends empleado>l){
		empleado ef;
		Iterator <empleado> it=(Iterator<empleado>)l.iterator();
		while(it.hasNext()){
			ef=it.next();
			JOptionPane.showMessageDialog(null, ef.toString(),
			"Impresion",JOptionPane.QUESTION_MESSAGE);
		}
		
	}///Calcula sueldo en la clase ef
	
	public static empleado modificaEmpleadofijo(EmpFijo o) throws ParseException{
		Calendar c2=null;
		String[] tipo1={"Nombre","Departamento","Fecha de nacimiento","DNI","Fecha de Contrataci�n"};
		int resp=0;
		fecha fechaContra=null;
		resp=JOptionPane.showOptionDialog(null, "Que quieres modificar ?", "Men� tipo empleado", 0, JOptionPane.QUESTION_MESSAGE,
				null, tipo1, tipo1[0]);

		if((resp==0)&&(o!=null))
			o.setNombre(SuperNucleo.introNombre("Introduce el nombre nuevo del empleado","Nombre nuevo"));
		if((resp==1)&&(o!=null))
			o.setDepartamento(Funciones.validastring("Introduce el nuevo departamento","Departamento"));
		if((resp==2)&&(o!=null)){
			do{	
				o.setFechaNac(SuperNucleo.pidefecha("Introduce la nueva fecha de nacimiento \n Con formato aaaa/mm/dd","Fecha Nacimiento"));
				o.setEdad(2015-(o.getFechaNac().getAño()));
			}while((o.getEdad()>16)&&(Validacion.ValidafechaCompleta(o.getFechaNac())));
		}
		if((resp==3)&&(o!=null)){
			do{
			o.setDNI(SuperNucleo.pideDni());
			}while(DAOEF.CompruebaDnIenBase(o)!=1);
		}
		if((resp==4)&&(o!=null)){
			do{
				fechaContra=SuperNucleo.pidefecha("Introduce la nueva fecha de nacimiento \n Con formato aaaa/mm/dd","Fecha Nacimiento");
				c2=fechaContra.deFechaToCalendar();
			}while(o.getFechaNac().comparafechas(c2)!=1);
		}
		
		return o;
	}
	public static void Ordenar(int i){
	if(i==0){//Ordena por dni
			Collections.sort(ArrayListEmpFijo.efi);
			DAOEF.imprimir(ArrayListEmpFijo.efi);
		}

		 if(i==1){//Ordena por edad
			Collections.sort(ArrayListEmpFijo.efi, new OrdenaEdad());
			DAOEF.imprimir(ArrayListEmpFijo.efi);
		}
		
		else if(i==2){//Ordena por nombre
			Collections.sort(ArrayListEmpFijo.efi, new OrdenaNombre());
			DAOEF.imprimir(ArrayListEmpFijo.efi);
		}
		
		else if(i==3){//Ordena por antiguedad
			Collections.sort(ArrayListEmpFijo.efi, new OrdenarAntiguedad());
			DAOEF.imprimir(ArrayListEmpFijo.efi);
		}
		
		else if(i==4){//Ordena por fecha de contratacion
			Collections.sort(ArrayListEmpFijo.efi, new OrdenarFechaContrata());
			DAOEF.imprimir(ArrayListEmpFijo.efi);
		}
		
		else if(i==5){//Ordena por fecha de nacimiento
			Collections.sort(ArrayListEmpFijo.efi, new OrdenarFechaNac());
			DAOEF.imprimir(ArrayListEmpFijo.efi);
		}
		
		else if(i==6){//Ordena por sueldo
			Collections.sort(ArrayListEmpFijo.efi, new OrdenarSueldo());
			DAOEF.imprimir(ArrayListEmpFijo.efi);
		}
	}

	
		

	public static void maxmin(int i){	
		if(i==0){//dni
			JOptionPane.showMessageDialog(null, 
			Collections.max(ArrayListEmpFijo.efi),
			"Max DNI", JOptionPane.QUESTION_MESSAGE);
			
			JOptionPane.showMessageDialog(null, 
			Collections.min(ArrayListEmpFijo.efi),
			"Min DNI", JOptionPane.QUESTION_MESSAGE);
		}
		else	if(i==1){//edad
			JOptionPane.showMessageDialog(null, 
			Collections.max(ArrayListEmpFijo.efi, new OrdenaEdad()),
			"Máx Edad", JOptionPane.QUESTION_MESSAGE);
			
			JOptionPane.showMessageDialog(null, 
			Collections.min(ArrayListEmpFijo.efi, new OrdenaEdad()),
			"Min Edad", JOptionPane.QUESTION_MESSAGE);
		}
		
		else if(i==2){//nombre
			JOptionPane.showMessageDialog(null, 
			Collections.max(ArrayListEmpFijo.efi, new OrdenaNombre()),
			"Máx Nombre", JOptionPane.QUESTION_MESSAGE);
			
			JOptionPane.showMessageDialog(null, 
			Collections.min(ArrayListEmpFijo.efi, new OrdenaNombre()),
			"Min Nombre", JOptionPane.QUESTION_MESSAGE);
		}
		
		else if(i==3){//antiguedad
			JOptionPane.showMessageDialog(null, 
			Collections.max(ArrayListEmpFijo.efi, new OrdenarAntiguedad()),
			"Máx Antiguedad", JOptionPane.QUESTION_MESSAGE);
			
			JOptionPane.showMessageDialog(null, 
			Collections.min(ArrayListEmpFijo.efi, new OrdenarAntiguedad()),
			"Min Antiguedad", JOptionPane.QUESTION_MESSAGE);
		}
		
		else if(i==4){//fecha de contratacion
			JOptionPane.showMessageDialog(null, 
			Collections.max(ArrayListEmpFijo.efi, new OrdenarFechaContrata()),
			"Máx Fecha contratacion", JOptionPane.QUESTION_MESSAGE);
			
			JOptionPane.showMessageDialog(null, 
			Collections.min(ArrayListEmpFijo.efi, new OrdenarFechaContrata()),
			"Min Fecha contratacion", JOptionPane.QUESTION_MESSAGE);
		}
		
		else if(i==5){//fecha de nacimiento
			JOptionPane.showMessageDialog(null, 
			Collections.max(ArrayListEmpFijo.efi, new OrdenarFechaNac()),
			"Máx Fecha de nacimiento", JOptionPane.QUESTION_MESSAGE);
			
			JOptionPane.showMessageDialog(null, 
			Collections.min(ArrayListEmpFijo.efi, new OrdenarFechaNac()),
			"Min Fecha de nacimiento", JOptionPane.QUESTION_MESSAGE);
		}
		
		else if(i==6){//sueldo
			JOptionPane.showMessageDialog(null, 
			Collections.max(ArrayListEmpFijo.efi, new OrdenarSueldo()),
			"Máx Sueldo", JOptionPane.QUESTION_MESSAGE);
			
			JOptionPane.showMessageDialog(null, 
			Collections.min(ArrayListEmpFijo.efi, new OrdenarSueldo()),
			"Min Sueldo", JOptionPane.QUESTION_MESSAGE);
		}
	}
	public static void cargardatosFijos() throws ParseException{
			
			int antiguedad=0;
			int edad=0;
			EmpFijo o=null;
			float sueldo=1000.0f;
		String[] nombres={"Borja","Pablo","Julio","Javier","Miguel"};
		String[] departamentos={"Seguridad","Marketing","Test Calidad","Producci�n", "Ventas"};
		fecha[] fechaNacs={new fecha("1994/11/26",1),new fecha("1993/10/7",1),new fecha("1993/7/10",1),new fecha("1994/8/9",1),new fecha("1991/11/3",1)};
		String[] DNIS={"20416734W","20447497P","31972043L","83723295Y","36272513H"};
		fecha[] fechaCont={new fecha("2009/10/3",1),new fecha("2010/4/4",2),new fecha("2011/11/23",1),new fecha("2008/10/23",1),new fecha("2009/5/13",1)};
		for(int i=0;i<5;i++){
			antiguedad=fechaCont[i].restafechas();
			edad=fechaNacs[i].restafechas();
			o=new EmpFijo(nombres[i],edad,DNIS[i],departamentos[i],fechaNacs[i],sueldo,antiguedad,fechaCont[i]);
			
			ArrayListEmpFijo.efi.add(o);	
			
			
		
		}
		}
	public static int buscarfijo(EmpFijo ef){//Buscar
		int aux=-1;
		
		for (int i = 0; i<=(ArrayListEmpFijo.efi.size()-1); i++){
			if((ArrayListEmpFijo.efi.get(i)).equals(ef))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
				aux=i;
		}
		return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
	}
	public static int CompruebaDnIenBase(EmpFijo ef){//Buscar
		int aux=1;
		
		for (int i = 0; i<=(ArrayListEmpFijo.efi.size()-1); i++){
			if((ArrayListEmpFijo.efi.get(i)).equals(ef)==true)//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
			{	JOptionPane.showMessageDialog(null,"Ha introducido un DNI que ya se encuentra en la base de datos");
				aux=0;
			}
		}
		return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
	}
	
	
	}

	
	
	
	
	
	
	
	

