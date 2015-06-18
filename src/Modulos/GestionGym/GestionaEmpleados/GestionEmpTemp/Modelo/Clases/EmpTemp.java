package Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import Clases.fecha;
import Modulos.GestionaEmpleados.ClasesMadre.empleado;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
@XStreamAlias("EmpTemp")
public class EmpTemp extends empleado
{
	@XStreamAlias("duracionCon")
	public int duracionCont;
	@XStreamAlias("fechaCont")
	public fecha fechaCont;
public EmpTemp	(String nombre,int edad,String DNI, String departamento,fecha fechaNac,float sueldo,int duracionCont,fecha fechaCont){
		super(nombre,DNI,departamento,fechaNac,sueldo);
		this.fechaCont=fechaCont;
		this.duracionCont=duracionCont;
}
public EmpTemp(String DNI){
	super(DNI);
}
public int getDuracionCont() {
	return duracionCont;
}
public void setDuracionCont(int duracionCont) {
	this.duracionCont = duracionCont;
}
public fecha getFechaCont() {
	return fechaCont;
}
public void setFechaCont(fecha fechaCont) {
	this.fechaCont = fechaCont;
}

	public String SoloDNI(){
 		return DNI;
 	}
@Override
public String toString() {
	return "EmpTemp [ Nombre:" + nombre+"\n"
			+" Departamento:" + departamento +"\n"
			+" DNI:" + DNI + "\n"
			+" Edad:" + edad + "\n"
			+" Fecha de Nacimiento:" + fechaNac.aStringFecha()+"\n"
			+" Sueldo:" + sueldo + "\n"+
			"Duracion del Contrato:" + duracionCont + "\n"+
			"Fecha de Contratación:" + fechaCont.aStringFecha() +"]";
}





}