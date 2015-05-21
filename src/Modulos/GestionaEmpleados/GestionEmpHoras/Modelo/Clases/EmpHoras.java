package Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import Modulos.GestionaEmpleados.ClasesMadre.*;
import Clases.fecha;


@XStreamAlias("EmpHoras")
public class EmpHoras extends empleado {
	@XStreamAlias("horas")
		public int horas;
	@XStreamAlias("p_hora")
		public float p_hora;
	
	
	public EmpHoras(String nombre, int edad,String DNI, String departamento, fecha fechaNac, float sueldo,int horas,float p_hora) {
		super(nombre,DNI, departamento,  fechaNac, sueldo);
		this.horas=horas;
		this.p_hora=p_hora;
		
	}
	public EmpHoras(String DNI){
		super(DNI);
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}
	public String SoloDNI(){
 		return DNI;
 	}


	public float getP_hora() {
		return p_hora;
	}
	public float calcularSueldo(float horas){
		float sueldo=0.0f; 
		sueldo=((horas)*(p_hora));
		return sueldo;
	}

	public void setP_hora(float p_hora) {
		this.p_hora = p_hora;
	}


	
	

}
