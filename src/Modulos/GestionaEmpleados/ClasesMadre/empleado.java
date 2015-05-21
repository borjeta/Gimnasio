package Modulos.GestionaEmpleados.ClasesMadre;

import Clases.fecha;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;




@XStreamAlias("empleado")
public class empleado implements Comparable<empleado>,Serializable{
	@XStreamAlias("nombre")
	public  String nombre;
	@XStreamAlias("departamento")
	public  String departamento;
	@XStreamAlias("DNI")
	public String DNI;
	@XStreamAlias("edad")
	public  int edad;
	@XStreamAlias("fechaNac")
	public fecha fechaNac;
	@XStreamAlias("sueldo")
	public float sueldo;
        @XStreamAlias("login")
        public String login;
        @XStreamAlias("password")
        public String password;
        @XStreamAlias("avatar")
        private String avatar="";
        @XStreamAlias("tipo")
        private String tipo="";
        private int estado=0;



	public empleado(String nombre,String DNI, String departamento, fecha fechaNac, float sueldo,String login,String password) {
		this.nombre = nombre;
		this.departamento = departamento;
		this.DNI=DNI;
		this.fechaNac = fechaNac;
		this.setEdad(fechaNac.restafechas());
		this.sueldo = sueldo;
                this.login = login;
                this.password = password;
                
	}
        
	public empleado(String DNI){
		this.DNI=DNI;
	}
        public empleado(){
            
        }

	public String getDNI(){
		return DNI;
	}
	public void setDNI(String DNI){
		this.DNI=DNI;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getEdad() {
		return edad;
	}

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getTipo() {
        return tipo;
    }

    public int getEstado() {
        return estado;
    }

	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public fecha getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(fecha fechaNac) {
		this.fechaNac = fechaNac;
	}

	public float getSueldo() {
		return sueldo;
	}
	public boolean equals(Object c){
		return getDNI().equals(((empleado)c).getDNI());
}
	public int compareTo(empleado emp) {//para ordenar los empleados
		if(this.getDNI().compareTo(emp.getDNI())>0)
			return 1;
		if(this.getDNI().compareTo(emp.getDNI())<0)
			return -1;
		return 0;
		 }
	
	
                       
}
