package Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.DAO;

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
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases.ArrayListEmpHoras;
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases.EmpHoras;
import Utils.Validacion;
import Utils.Funciones;


public class DAOEH {
	public static void imprimir(ArrayList<? extends empleado>l){
		empleado ef;
		Iterator <empleado> it=(Iterator<empleado>)l.iterator();
		while(it.hasNext()){
			ef=it.next();
			JOptionPane.showMessageDialog(null, ef.toString(),
			"Impresion",JOptionPane.QUESTION_MESSAGE);
		}
	}
	public static EmpHoras CreaEmpleadoHoras() throws ParseException{
		String nombre="",departamento="";
		float sueldo=0.0f;
		int edad=0;
		EmpHoras A=null;
		fecha fechaNac=null;
		fecha fechaContra=null;
		boolean val=false;
		float p_hora=0.0f;
		int horas=0;
		
		String DNI=null;
		nombre = SuperNucleo.introNombre("Introduce el nombre del nuevo empleado","Nombre");
		departamento=Funciones.validastring("Introduce el departamento", "Departamento");
		DNI=SuperNucleo.pideDni();
		do{
			fechaNac=SuperNucleo.pidefecha("Introduce la fecha de nacimiento\n Con formato aaaa/mm/dd","Fecha de nacimiento");
			edad=fechaNac.restafechas();
			if(edad<=16){
				JOptionPane.showMessageDialog(null, "El empleado debe tener un minimo de 16 a�os");
			}
		}while(edad<16);

		p_hora=Funciones.validafloat("Dame el precio al que vas a pagar la hora","Precio hora");
		horas=DAOEH.pidetiempotrabajado(p_hora);
		sueldo=DAOEH.calcularSueldoHoras(p_hora, horas);
		A=new EmpHoras(nombre,edad,DNI,departamento,fechaNac,(float) 0.0,horas,p_hora);
		
		return A;
	}
	public static EmpHoras modificaEmpleadohoras(EmpHoras o) throws ParseException{
		Calendar c2=null;
		String[] tipo1={"Nombre","Departamento","Fecha de nacimiento","DNI","precio/hora"};
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
			o.setDNI(SuperNucleo.pideDni());
		}
		if((resp==4)&&(o!=null)){
			o.setP_hora(Funciones.validafloat("Introduce el nuevo precio de la hora","Precio/Hora"));
		}
			
		return o;
	}
	public static float calcularSueldoHoras(float P,int h){
		float sueldo=0.0f; 
		sueldo=(P*h);
		return sueldo;
	}
	public static int pidetiempotrabajado(float P){
		int horas=0,dias=0,semanas=0,meses=0;
		int total=0;
		String[] tipo1={"Horas","Dias","Semanas","Meses","Calcular"};
		int resp=0;
		resp=JOptionPane.showOptionDialog(null, "Introduce el tiempo trabajado(Acumulado).\n"
				+ "cuando haya finalizado pulse Calcular ", "Tiempo", 0, JOptionPane.QUESTION_MESSAGE,
				null, tipo1, tipo1[0]);
		if(resp==0)
		{
			horas=Funciones.validaint("Dame la cantidad de horas trabajadas", "horas");

		}
		if(resp==1)
		{
			dias=Funciones.validaint("Dame la cantidad de dias trabajados a jornada completa","Dias");

		}
		if(resp==2)
		{
			resp=Funciones.validaint("Introduce la cantidad de semanas", "Semanas");
		}
		if(resp==3){
			meses=Funciones.validaint("Introduce la cantidad de meses trabajados","Mesess");
		}
		if(resp==4){
			total=horas+(dias*8)+(semanas*40);
		}


		return total;
	}
	public static void cargardatosHoras() throws ParseException{
		
		int edad=0;
		EmpHoras o=null;
		float sueldo=1000.0f,p_hora=6.0f;
		
	String[] nombres={"Borja","Pablo","Julio","Javier","Miguel"};
	String[] departamentos={"Seguridad","Marketing","Test Calidad","Producci�n", "Ventas"};
	fecha[] fechaNacs={new fecha("1994/11/26",1),new fecha("1993/10/7",1),new fecha("1993/7/10",1),new fecha("1994/8/9",1),new fecha("1991/11/3",1)};
	String[] DNIS={"20416734W","20447497P","31972043L","83723295Y","36272513H"};
	int[] Horas1={15,23,534,12,43};
	for(int i=0;i<5;i++){
		edad=fechaNacs[i].restafechas();
		o=new EmpHoras(nombres[i],edad,DNIS[i],departamentos[i],fechaNacs[i],sueldo,Horas1[i],p_hora);
		ArrayListEmpHoras.eHo.add(o);	
		
	
	}
	}
	public static void Ordenar(int i){
		if(i==0){//Ordena por dni
				Collections.sort(ArrayListEmpHoras.eHo);
				DAOEH.imprimir(ArrayListEmpHoras.eHo);
			}
	
			 if(i==1){//Ordena por edad
				Collections.sort(ArrayListEmpHoras.eHo, new OrdenaEdad());
				DAOEH.imprimir(ArrayListEmpHoras.eHo);
			}
			
			else if(i==2){//Ordena por nombre
				Collections.sort(ArrayListEmpHoras.eHo, new OrdenaNombre());
				DAOEH.imprimir(ArrayListEmpHoras.eHo);
			}
			
			else if(i==3){//Ordena por antiguedad
				Collections.sort(ArrayListEmpHoras.eHo, new OrdenarAntiguedad());
				DAOEH.imprimir(ArrayListEmpHoras.eHo);
			}
			
			else if(i==4){//Ordena por fecha de contratacion
				Collections.sort(ArrayListEmpHoras.eHo, new OrdenarFechaContrata());
				DAOEH.imprimir(ArrayListEmpHoras.eHo);
			}
			
			else if(i==5){//Ordena por fecha de nacimiento
				Collections.sort(ArrayListEmpHoras.eHo, new OrdenarFechaNac());
				DAOEH.imprimir(ArrayListEmpHoras.eHo);
			}
			
			else if(i==6){//Ordena por sueldo
				Collections.sort(ArrayListEmpHoras.eHo, new OrdenarSueldo());
				DAOEH.imprimir(ArrayListEmpHoras.eHo);
			}
		}
	
		
			
	
		public static void maxmin(int i){
			if(i==0){//dni
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpHoras.eHo),
				"Max DNI", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpHoras.eHo),
				"Min DNI", JOptionPane.QUESTION_MESSAGE);
			}
			else if(i==1){//edad
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpHoras.eHo, new OrdenaEdad()),
				"Máx Edad", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpHoras.eHo, new OrdenaEdad()),
				"Min Edad", JOptionPane.QUESTION_MESSAGE);
			}
			
			else if(i==2){//nombre
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpHoras.eHo, new OrdenaNombre()),
				"Máx Nombre", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpHoras.eHo, new OrdenaNombre()),
				"Min Nombre", JOptionPane.QUESTION_MESSAGE);
			}
			
			else if(i==3){//antiguedad
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpHoras.eHo, new OrdenarAntiguedad()),
				"Máx Antiguedad", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpHoras.eHo, new OrdenarAntiguedad()),
				"Min Antiguedad", JOptionPane.QUESTION_MESSAGE);
			}
			
			else if(i==4){//fecha de contratacion
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpHoras.eHo, new OrdenarFechaContrata()),
				"Máx Fecha contratacion", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpHoras.eHo, new OrdenarFechaContrata()),
				"Min Fecha contratacion", JOptionPane.QUESTION_MESSAGE);
			}
			
			else if(i==5){//fecha de nacimiento
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpHoras.eHo, new OrdenarFechaNac()),
				"Máx Fecha de nacimiento", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpHoras.eHo, new OrdenarFechaNac()),
				"Min Fecha de nacimiento", JOptionPane.QUESTION_MESSAGE);
			}
			
			else if(i==6){//sueldo
				JOptionPane.showMessageDialog(null, 
				Collections.max(ArrayListEmpHoras.eHo, new OrdenarSueldo()),
				"Máx Sueldo", JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showMessageDialog(null, 
				Collections.min(ArrayListEmpHoras.eHo, new OrdenarSueldo()),
				"Min Sueldo", JOptionPane.QUESTION_MESSAGE);
			}
		}
		public static int buscarHoras(EmpHoras ef){//Buscar
			int aux=-1;
			
			for (int i = 0; i<=(ArrayListEmpHoras.eHo.size()-1); i++){
				if((ArrayListEmpHoras.eHo.get(i)).equals(ef))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
					aux=i;
			}
			return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
		}

}
