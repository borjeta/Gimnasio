package Modulos.GestionaEmpleados.ClasesMadre;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import tema6.Ppal;
import Utils.Menus;
import Utils.Validacion;
import Utils.Funciones;
import Clases.fecha;
public class SuperNucleo {
	public static String introNombre(String mensaje, String titulo){//Intro nombre correcto
		String nombre = null;
		boolean valor;
		do{
			nombre=Funciones.validastring(mensaje,titulo);
			valor=Validacion.validaNombre(nombre);
		}while(valor==false);
		return nombre;
	}
	
	
	public static String introApell(){
		//Intro apellidos Correctos
	boolean valor;
	String apellido=null;
	do{	
		
		apellido=Funciones.validastring("Introduce tu apellido", "Apellido");
		valor=Validacion.validaApellido(apellido);
	}while(valor==false);
		
		
		return apellido;
	}
	public static fecha pideFecha() throws ParseException{
		fecha fechaInt=null;
		int dia=0,mes=0,año=0;
		boolean val=false;
		do{
			
		dia=Funciones.validaint("Introduce un dia valido", "Dia");
		mes=Funciones.validaint("Introduce un mes valido ", "Mes");
		año=Funciones.validaint("Introduce un año correcto", "A�o");
		fechaInt=new fecha(dia,mes,año);
		val=Validacion.ValidafechaCompleta(fechaInt);
		}while(val==false);
		return fechaInt;
	}

	
	
	public static fecha pidefecha(String mensaje,String titulo) throws ParseException{
		String fechaInt="";
		fecha A=null;
		boolean val=false;
		do{	
			fechaInt=Funciones.validastring(mensaje,titulo);
			A=SuperNucleo.deStringaFecha(fechaInt);
			val=Validacion.ValidafechaCompleta(A);
		}while(val==false);

		return A;
	}
	public static String pideDni (){
		String DNI="";
		boolean val=false;
		do{
		DNI=Funciones.validastring("Introduce DNI ","DNI");
		val=Validacion.DNI(DNI);
		}while(val==false);
		return DNI;
		
	}
	public static fecha deStringaFecha(String fechaIntr) throws ParseException{
		fecha a=null;
		String[] SplitArray=null;
		int dia,mes,año;
		
		
		/*if(Ppal.conf.getNumdecimal()=="1"){*/
			SplitArray=fechaIntr.split("/");
			
			año=Integer.parseInt(SplitArray[0]);
			mes=Integer.parseInt(SplitArray[1]);
			dia=Integer.parseInt(SplitArray[2]);
		a=new fecha(año,mes,dia);
		
		return a;
	}
	public static String horaSysdeCalenaString(){
		String FechaString="";
		Calendar system=null;
		int dia,mes,año;
		system.getInstance();
		FechaString=system.getTime().toString();
		return FechaString;
		
		
		
		
	}
	public static int calcularEdad(fecha fechaNac){
		int resultado = 0;
		Calendar actual = Calendar.getInstance();
		int Adia = actual.get(Calendar.DATE); 
		int Ames = actual.get(Calendar.MONTH)+1; 
	   	int Aanyo = actual.get(Calendar.YEAR); 
	   	resultado = Aanyo-fechaNac.getAño();
	   	
		if(Ames<fechaNac.getMes()){
			resultado = resultado-1;
		}else if(Ames==fechaNac.getMes()){
			if(Adia<fechaNac.getDia()){
			resultado = resultado-1;
			}	
		}
	   	return resultado;   	
	}
	
	
	
	public int comparafechas ( fecha f ) {
		Calendar c1 = null;
		Calendar c2 = null;
		
		c2 = f.parseToCalendar("yyyy/MM/dd");
		c1 = this.parseToCalendar("yyyy/MM/dd");
		int i = 0;
		if ( c1.before(c2) ) {// retorne 1 quan c1 es anterior a c2
			i = 1;
		}
		else if ( c1.after(c2) ) {// retorne 0 quan c1 es posterior a c2
			i = 0;
		}
		JOptionPane.showMessageDialog(null, i);
		
		return i;
		
	}

	public Calendar parseToCalendar ( String f ) {// parsejem el string a
		// calendar enrecordarsen de
		// ficar sempre el mateix
		// formato dd/MM/yyyy
		Calendar fecha = null;
		Date fecha2 = null;
		try {
			SimpleDateFormat formato = new SimpleDateFormat(f);
			fecha = fecha.getInstance();
			fecha.setTime(fecha2);

		}
		catch (Exception e) {
			return fecha;
		}

		return fecha;
	}
	public static Calendar deStringToCalendar(String fecha){
		Date fechaDate = new Date();
		SimpleDateFormat formato 	= new SimpleDateFormat("yyyy/MM/dd");
		Calendar fechaCalendar=new GregorianCalendar();
		try{
		fechaDate = formato.parse(fecha);
		fechaCalendar.setTime(fechaDate);
		}catch (ParseException e){
		e.printStackTrace();
		}
		return fechaCalendar;
		}
	
	public static String deFechaAString(fecha a){
		String fechaString=null;
		fechaString=a.getAño()+"/"+a.getMes()+"/"+a.getDia();
		return fechaString;
	}
	
	public static int comparafechas ( Calendar c1,Calendar c2 ) {
		
		
		JOptionPane.showMessageDialog(null,c2.getTime());
		//c2 = f.parseToCalendar("yyyy/MM/dd");
		//c1 = this.parseToCalendar("yyyy/MM/dd");
		
		//JOptionPane.showMessageDialog(null, "La fecha de nacimiento"+c1.getTime()+"\n La fecha de contratacion"+c2.getTime());
		int i = 0;
		if ( c1.before(c2) ) {// retorne 1 quan c1 es anterior a c2
			i = 1;
		}
		else if ( c1.after(c2) ) {// retorne 0 quan c1 es posterior a c2
			i = 0;
		}
		else if ( c1.compareTo(c2)==1) {// retorne -1 quan c1 i c2 son iguals
			i = -1;
		}
		//JOptionPane.showMessageDialog(null, i);
		
		return i;
	
	}
	
		
		
		
		
		
		
		
		
		
		
	
}
