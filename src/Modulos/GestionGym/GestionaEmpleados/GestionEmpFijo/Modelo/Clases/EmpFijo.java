package Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.Clases;


import Modulos.GestionGym.GestionaEmpleados.ClasesMadre.empleado;
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
		this.setAntiguedad(fechaCont.restafechas());
                this.setEdad(fechaNac.restafechas());
		
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
	
     	public String SoloDNI(){
     		return DNI;
     	}
	



	
	
	}
