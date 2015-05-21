package Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases;


import Modulos.GestionaEmpleados.ClasesMadre.empleado;
import Clases.fecha;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import tema6.Ppal;



@XStreamAlias("EmpFijo")
public class EmpFijo extends empleado {
	@XStreamAlias("antiguedad")
	public int antiguedad;
	@XStreamAlias("fechacontrata")
	public fecha fechaCont;
	public EmpFijo(String nombre,int edad,String DNI, String departamento,fecha fechaNac,float sueldo,int antiguedad,fecha fechaCont,String login,String password){
		super(nombre,DNI,departamento,fechaNac,sueldo,login,password);
		this.fechaCont=fechaCont;
		this.setAntiguedad(fechaNac.restafechas());
		
	}
        public EmpFijo(){
            
        }
	public EmpFijo(String DNI){
		super(DNI);
	}
        
	
	public float calcularSueldoFijo(int antiguedad){
		float sueldo=0.0f; 
		sueldo=(float) (antiguedad*40)+1000;
		return sueldo;
	}
	

	public int getAntiguedad() {
		return antiguedad;
	}

public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	


	public fecha getFechaCont() {
		return fechaCont;
	}


	public void setFechaCont(fecha fechaCont) {
		this.fechaCont = fechaCont;
	}
	
	public float calcularSueldo(int antiguedad){
		float sueldo=0.0f; 
		sueldo=(float) ((antiguedad)*40)+1000;
		return sueldo;
	}
	/*
	public String toString() {
String cad="";
		
		if(Ppal.f==null){
			
			cad="Empleado Fijo \n "+ "Nombre:" + nombre
					+ "\n Departamento:" + departamento + "\n "+DNI+ "\n Edad:" + edad + "\n Fecha de Nacimiento:" + fechaNac.aStringFecha() +"\n Antiguedad:" + antiguedad+" A�os \n Fecha de Contratacion:" + fechaCont.aStringFecha() + 
					" \n Sueldo:"
					+(getSueldo()) +"�/mes";
		}
		else if(Ppal.f.getNumdecimal()==1){
		cad="Empleado Fijo \n "+ "Nombre:" + nombre
				+ "\n Departamento:" + departamento + "\n "+DNI+ "\n Edad:" + edad + "\n Fecha de Nacimiento:" + fechaNac.aStringFecha() +"\n Antiguedad:" + antiguedad+" A�os \n Fecha de Contratacion:" + fechaCont.aStringFecha() + 
				" \n Sueldo:"
				+(getSueldo()) + Ppal.f.getMoneda()+"/mes";
		}
		else if(Ppal.f.getNumdecimal()==2){
			cad="Empleado Fijo \n "+ "Nombre:" + nombre
					+ "\n Departamento:" + departamento + "\n "+DNI+ "\n Edad:" + edad + "\n Fecha de Nacimiento:" + fechaNac.aStringFecha() +"\n Antiguedad:" + antiguedad+" A�os \n Fecha de Contratacion:" + fechaCont.aStringFecha() + 
					" \n Sueldo:"
					+ Formato.dosDecimales(getSueldo()) + Ppal.f.getMoneda()+"/mes";
			}
		else if(Ppal.f.getNumdecimal()==3){
			cad="Empleado Fijo \n "+ "Nombre:" + nombre
					+ "\n Departamento:" + departamento + "\n "+DNI+ "\n Edad:" + edad + "\n Fecha de Nacimiento:" + fechaNac.aStringFecha() +"\n Antiguedad:" + antiguedad+" A�os \n Fecha de Contratacion:" + fechaCont.aStringFecha() + 
					" \n Sueldo:"
					+ Formato.dosDecimalesRedondea(getSueldo()) + Ppal.f.getMoneda()+"/mes";
		}
		
		
		return cad;
	}
*/
        
	/*public String toString(){
		StringBuilder tarjeta=new StringBuilder();
	    String cad="";
		cad=cad+super.toString() + "\n" 
	    + "Antiguedad: "+getAntiguedad() 
	    + " años\n" 
	    + "Fecha de Contratacion: "+getFechaCont().aStringFecha() + "\n";
	    
		tarjeta.append(cad);
		return tarjeta.toString();
	}*/
     	public String SoloDNI(){
     		return DNI;
     	}
	



	
	
	}
