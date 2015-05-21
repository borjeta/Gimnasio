package Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.DAO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JOptionPane;

import Clases.fecha;
import Modulos.GestionaEmpleados.ClasesMadre.SuperNucleo;
import Modulos.GestionaEmpleados.ClasesMadre.empleado;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenaEdad;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenaNombre;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenarAntiguedad;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenarFechaContrata;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenarFechaNac;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.OrdenarSueldo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.DAO.DAOEF;
import Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases.ArrayListEmpTemp;
import Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases.EmpTemp;
import Utils.Funciones;
import Utils.Validacion;




public class DAOET {
	
	public static EmpTemp creaEmpTemp() throws ParseException{
		String nombre="",departamento="";
		float sueldo=0.0f;
	
		int edad=0;
		empleado A=null;
		fecha fechaNac=null;
		fecha fechaContra=null;
		boolean val=false;
		
		int duracionCont=0;
		
		String DNI=null;
	nombre = SuperNucleo.introNombre("Introduce el nombre del nuevo empleado temporal","Nombre del E.Temporal");
	departamento=Funciones.validastring("Introduce el departamento", "Departamento");
	DNI=SuperNucleo.pideDni();
	do{
		fechaNac=SuperNucleo.pidefecha("Introduce la fecha de nacimiento\n Con formato A�o/Mes/Dia","Fecha de nacimiento");
		edad=fechaNac.restafechas();
		JOptionPane.showMessageDialog(null,edad);
		if(edad<16){
			JOptionPane.showMessageDialog(null,"No puedes registrar un menor de 16 a�os");
		}
		else
			val=true;
	}while(val==false);
	do{
		fechaContra=SuperNucleo.pidefecha("Introduce una fecha de contratacion \n Con formato aaaa/mm/dd"," Fecha de alta");
		if((fechaNac.comparafechas(fechaContra.deFechaToCalendar())==-1)||(fechaNac.comparafechas(fechaContra.deFechaToCalendar())==0));	
		JOptionPane.showMessageDialog(null,"Debe introducir una fecha de contratacion posterior a la de nacimiento");
	}while((fechaNac.comparafechas(fechaContra.deFechaToCalendar())!=1));
	duracionCont=Funciones.validaint("Introduce la duracion del contrato en meses","Duraci�n del contrato");
	A=new EmpTemp(nombre,edad,DNI,departamento,fechaNac,sueldo,duracionCont,fechaContra);
	return (EmpTemp) A;
}
	public static EmpTemp modificaEmpleTemp( EmpTemp o) throws ParseException{
		
		Calendar c2=null;
		String[] tipo1={"Nombre","Departamento","Fecha de nacimiento","DNI","Fecha de Contrataci�n","Duracion del Contrato"};
		int resp=0;
		fecha fechaContra=null;
		resp=JOptionPane.showOptionDialog(null, "Que quieres modificar ?", "Men� tipo empleado", 0, JOptionPane.QUESTION_MESSAGE,
				null, tipo1, tipo1[0]);
		
		if((resp==0)&&(o!=null))
		o.setNombre(SuperNucleo.introNombre("Introduce el nuevo nombre para el empleado temporal","Nombre nuevo E.Temporal"));
		if((resp==1)&&(o!=null))
		o.setDepartamento(Funciones.validastring("Introduce el nuevo departamento","Departamento"));
		if((resp==2)&&(o!=null)){
		do{	
			o.setFechaNac(SuperNucleo.pidefecha("Introduce la nueva fecha de nacimiento \n Con formato aaaa/mm/dd","Fecha Nacimiento"));
			o.setEdad(2015-(o.getFechaNac().getAño()));
		}while((o.getEdad()>16)&&(Validacion.ValidafechaCompleta(o.getFechaNac())));
		}
		if((resp==3)&&(o!=null)){
			o.setDNI(SuperNucleo.pideDni());
		}
		if((resp==4)&&(o!=null)){
			do{
			fechaContra=SuperNucleo.pidefecha("Introduce la nueva fecha de nacimiento \n Con formato aaaa/mm/dd","Fecha Nacimiento");
			c2=fechaContra.deFechaToCalendar();
			}while(o.getFechaNac().comparafechas(c2)!=1);
		if((resp==5)&&(o!=null)){
			o.setDuracionCont(Funciones.validaint("Introduce la nueva duracion del contrato en meses","Duracion del contrato"));
		}
		}
		
		return o ;
	}
	public static void imprimir(ArrayList<? extends empleado>l){
		empleado ef;
		Iterator <empleado> it=(Iterator<empleado>)l.iterator();
		while(it.hasNext()){
			ef=it.next();
			JOptionPane.showMessageDialog(null, ef.toString(),
			"Impresion",JOptionPane.QUESTION_MESSAGE);
		}
		
	}
	public static void Ordenar(int i){
		if(i==0){//Ordena por dni
				Collections.sort(ArrayListEmpTemp.eTe);
				DAOET.imprimir(ArrayListEmpTemp.eTe);
			}

			 if(i==1){//Ordena por edad
				Collections.sort(ArrayListEmpTemp.eTe, new OrdenaEdad());
				DAOET.imprimir(ArrayListEmpTemp.eTe);
			}
			
			else if(i==2){//Ordena por nombre
				Collections.sort(ArrayListEmpTemp.eTe, new OrdenaNombre());
				DAOET.imprimir(ArrayListEmpTemp.eTe);
			}
			
			else if(i==3){//Ordena por antiguedad
				Collections.sort(ArrayListEmpTemp.eTe, new OrdenarAntiguedad());
				DAOET.imprimir(ArrayListEmpTemp.eTe);
			}
			
			else if(i==4){//Ordena por fecha de contratacion
				Collections.sort(ArrayListEmpTemp.eTe, new OrdenarFechaContrata());
				DAOET.imprimir(ArrayListEmpTemp.eTe);
			}
			
			else if(i==5){//Ordena por fecha de nacimiento
				Collections.sort(ArrayListEmpTemp.eTe, new OrdenarFechaNac());
				DAOET.imprimir(ArrayListEmpTemp.eTe);
			}
			
			else if(i==6){//Ordena por sueldo
				Collections.sort(ArrayListEmpTemp.eTe, new OrdenarSueldo());
				DAOET.imprimir(ArrayListEmpTemp.eTe);
			}
		}

		public static void cargardatosTempo() throws ParseException{
			int antiguedad=0;
			int edad=0;
			int duracion=10;
			EmpTemp o=null;
			float sueldo=1000.0f;
		String[] nombres={"David","Jorge","Raquel","Cristina","Ramon"};
		String[] departamentos={"Seguridad","Marketing","Test Calidad","Producci�n", "Ventas"};
		fecha[] fechaNacs={new fecha("1994/11/26",1),new fecha("1993/10/7",1),new fecha("1993/7/10",1),new fecha("1994/8/9",1),new fecha("1991/11/3",1)};
		String[] DNIS={"20416734W","20447497P","31972043L","83723295Y","36272513H"};
		fecha[] fechaCont={new fecha("2009/10/3",1),new fecha("2010/4/4",2),new fecha("2011/11/23",1),new fecha("2008/10/23",1),new fecha("2009/5/13",1)};
		for(int i=0;i<5;i++){
			antiguedad=fechaCont[i].restafechas();
			edad=fechaNacs[i].restafechas();
			o=new EmpTemp(nombres[i],edad,DNIS[i],departamentos[i],fechaNacs[i],sueldo,duracion,fechaCont[i]);
			
			ArrayListEmpTemp.eTe.add(o);	
			
		}
			
		}
		public static void maxmin(int i){	
			if(i==0){//dni
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpTemp.eTe),
				"Max DNI", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpTemp.eTe),
				"Min DNI", JOptionPane.QUESTION_MESSAGE);
			}
			else	if(i==1){//edad
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpTemp.eTe, new OrdenaEdad()),
				"Máx Edad", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpTemp.eTe, new OrdenaEdad()),
				"Min Edad", JOptionPane.QUESTION_MESSAGE);
			}
			
			else if(i==2){//nombre
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpTemp.eTe, new OrdenaNombre()),
				"Máx Nombre", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpTemp.eTe, new OrdenaNombre()),
				"Min Nombre", JOptionPane.QUESTION_MESSAGE);
			}
			
			else if(i==3){//antiguedad
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpTemp.eTe, new OrdenarAntiguedad()),
				"Máx Antiguedad", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpTemp.eTe, new OrdenarAntiguedad()),
				"Min Antiguedad", JOptionPane.QUESTION_MESSAGE);
			}
			
			else if(i==4){//fecha de contratacion
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpTemp.eTe, new OrdenarFechaContrata()),
				"Máx Fecha contratacion", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpTemp.eTe, new OrdenarFechaContrata()),
				"Min Fecha contratacion", JOptionPane.QUESTION_MESSAGE);
			}
			
			else if(i==5){//fecha de nacimiento
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpTemp.eTe, new OrdenarFechaNac()),
				"Máx Fecha de nacimiento", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpTemp.eTe, new OrdenarFechaNac()),
				"Min Fecha de nacimiento", JOptionPane.QUESTION_MESSAGE);
			}
			
			else if(i==6){//sueldo
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpTemp.eTe, new OrdenarSueldo()),
				"Máx Sueldo", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpTemp.eTe, new OrdenarSueldo()),
				"Min Sueldo", JOptionPane.QUESTION_MESSAGE);
			}
		}
		public static int buscarTemp(EmpTemp ef){//Buscar
			int aux=-1;
			
			for (int i = 0; i<=(ArrayListEmpFijo.efi.size()-1); i++){
				if((ArrayListEmpFijo.efi.get(i)).equals(ef))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
					aux=i;
			}
			return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
		}
	
}
