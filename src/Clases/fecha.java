package Clases;




import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import tema6.Ppal;



;


public class fecha  implements Serializable{


	/**
	 * 
	 */

	
	@XStreamAlias("dia")
	public int dia ;
	@XStreamAlias("mes")
	public int mes ;
	@XStreamAlias("año")
	public int año;


	public String fecha;

	boolean interruptor=false;
	private Calendar Fecha				= Calendar.getInstance();;
	private SimpleDateFormat formato 	= new SimpleDateFormat("yyyy/MM/dd");
	private String[] SplitArray;
	private Calendar fecha_calendar;
    private Object FramePpal;

	public fecha(int año, int mes, int dia)  {//Constructor 1
		this.mes 	= mes;
		this.año 	= año;
		this.dia 	= dia;
		
	}

	public fecha (String fecha){
		String formatofecha=null;//Constructor 2
		/*if (FramePpal.F==null)
		{
		} else {
                    SplitArray=fecha.split("/");
                    this.dia=Integer.parseInt(SplitArray[2]);
                    this.mes=Integer.parseInt(SplitArray[1]);
                    this.año=Integer.parseInt(SplitArray[0]);
                    this.Fecha.setTime(this.formato.parse(this.año+"/"+this.mes+"/"+this.dia));
            }*/

		
		//A�o/Mes/Dia formato 1
		{
			SplitArray=fecha.split("/"); 
			this.dia=Integer.parseInt(SplitArray[2]);
			this.mes=Integer.parseInt(SplitArray[1]);
			this.año=Integer.parseInt(SplitArray[0]);
			
		}/*
		else if(Ppal.f.getFormatfecha()==2){//dia/mes/año formato 2
			SplitArray=fecha.split("/");	
			this.dia=Integer.parseInt(SplitArray[0]);
			this.mes=Integer.parseInt(SplitArray[1]);
			this.año=Integer.parseInt(SplitArray[2]);
			this.Fecha.setTime(this.formato.parse(this.dia+"/"+this.mes+"/"+this.año));
		}
		else if(Ppal.f.getFormatfecha()==3){//A�o-mes-dia formato 3
			SplitArray=fecha.split("-");
			this.dia=Integer.parseInt(SplitArray[2]);
			this.mes=Integer.parseInt(SplitArray[1]);
			this.año=Integer.parseInt(SplitArray[0]);
			this.Fecha.setTime(this.formato.parse(this.año+"-"+this.mes+"-"+this.dia));
		}*/
		formatofecha=año+"/"+mes+"/"+dia;
		this.fecha=formatofecha;

	}

	public fecha (String fecha,int i) {//Constructor 2
		{
			SplitArray=fecha.split("/"); 
			this.dia=Integer.parseInt(SplitArray[2]);
			this.mes=Integer.parseInt(SplitArray[1]);
			this.año=Integer.parseInt(SplitArray[0]);
			//	this.Fecha.setTime(this.formato.parse(this.año+"/"+this.mes+"/"+this.dia));
		}
	}

	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public String toString() {
		String cad=null;
		cad=año + "/" + mes + "/" + dia ;
		return cad;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public boolean compruebadia(int dia){
		if((dia<0)&&(dia>31))
			interruptor=false;
		else
			interruptor=true;

		return interruptor;	
	}
	public boolean compruebaMes(int mes){
		if((mes<0)&&(mes>12))
			interruptor=false;
		else
			interruptor=true;

		return interruptor;	
	}
	public boolean compruebaaño(int año){
		if((año<1950)&&(año>2020))
			interruptor=false;
		else
			interruptor=true;

		return interruptor;	
	}
	public static String horaSysdeCalenaString(){
		String FechaString="";
		Calendar system=null;
		system.getInstance();
		FechaString=system.getTime().toString();
		return FechaString;

	}
	public int restafechas(){
		int diferencia=0;
		diferencia=((2015)-(this.año));
		return diferencia;

	}
	public Calendar parseToCalendar ( String f ) {// parsejem el string a
		fecha_calendar = null; 

		String fecha_string = f;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 

		try
		{
			Date fecha_date = sdf.parse(fecha_string);
			fecha_calendar.setTime(fecha_date);

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "printfERROR!: can not parsing! ");
		}
		return fecha_calendar;
	}
	public String deFechaAString(){
		String fechaString=null;
		fechaString=this.año+"/"+this.mes+"/"+this.dia;
		return fechaString;
	}
	public Calendar deFechaToCalendar(){//Metodo que pasa de fecha mia a String y de String a Calendar
		Date fechaDate = new Date();
		SimpleDateFormat formato 	= new SimpleDateFormat("yyyy/MM/dd");
		Calendar fechaCalendar=new GregorianCalendar();
		try{
			fechaDate = formato.parse(this.deFechaAString());
			fechaCalendar.setTime(fechaDate);
		}catch (ParseException e){
			e.printStackTrace();
		}
		return fechaCalendar;
	}
	public int comparafechas ( Calendar c2 ) {
		Calendar c1 = null;
		c1=this.deFechaToCalendar();


		//JOptionPane.showMessageDialog(null, "La fecha de Contratacion:"+c2.getTime()+"\n La fecha de Nacimiento"+c1.getTime());
		int i = 0;
		if ( c1.before(c2) ) {// retorne 1 quan c1 es anterior a c2
			i = 1;
		}
		else if ( c1.after(c2) ) {// retorne 0 quan c1 es posterior a c2
			i = 0;
		}
		else if ( c1.compareTo(c2)==1) {// retorne -1 quan c1 i c2 son iguals
			i = -1;
			JOptionPane.showMessageDialog(null, "Error:La fecha de contratacion es igual a la de Nacimiento");
		}
		JOptionPane.showMessageDialog(null,i);
		return i;

	}
	public String deCalendartoString(){
		String fechaString=null;

		fechaString=this.Fecha.getTime().getYear()+"/"+this.Fecha.getTime().getMonth()+1+"/"+this.Fecha.getTime().getDay();
		return fechaString;
	}
/*
	public String aStringFecha(){
		StringBuffer tarjeta=new StringBuffer();
		if(tema6.Ppal.f==null){
		tarjeta.append(getAño()+"/");
		tarjeta.append(getMes()+"/");
		tarjeta.append(getDia());
		}
		if(tema6.Ppal.f.getFormatfecha()==1){
			tarjeta.append(getAño()+"/");
			tarjeta.append(getMes()+"/");
			tarjeta.append(getDia());
		}
		if(tema6.Ppal.f.getFormatfecha()==2){
			tarjeta.append(getDia()+"/");
			tarjeta.append(getMes()+"/");
			tarjeta.append(getAño());
		}
		if(tema6.Ppal.f.getFormatfecha()==3){
			tarjeta.append(getAño()+"-");
			tarjeta.append(getMes()+"-");
			tarjeta.append(getDia());
		}

					
				String fecha=null;

				if(Ppal.f==null){
					fecha=this.año+"/"+this.mes+"/"+this.dia;
				}
				else if(Ppal.f.getFormatfecha()==1){
					fecha=this.año+"/"+this.mes+"/"+this.dia;
				}
				else if(Ppal.f.getFormatfecha()==2){
					fecha=this.dia+"/"+this.mes+"/"+this.año;
				}
				else if(Ppal.f.getFormatfecha()==1){
					fecha=this.año+"-"+this.mes+"-"+this.dia;
				}	
		 
		return tarjeta.toString();
        }
        */
public boolean comparafechasNAC ( Calendar c2 ) {
    boolean val=false;

		Calendar c1 = null;
		c1=this.deFechaToCalendar();


		//JOptionPane.showMessageDialog(null, "La fecha de Contratacion:"+c2.getTime()+"\n La fecha de Nacimiento"+c1.getTime());
		int i = 0;
		if ( c1.before(c2) ) {// retorne 1 quan c1 es anterior a c2
			val=true;
		}
                return val;
}

}
