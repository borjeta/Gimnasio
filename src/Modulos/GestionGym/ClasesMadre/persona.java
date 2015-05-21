package Modulos.GestionGym.ClasesMadre;

import Clases.fecha;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;




@XStreamAlias("persona")
public class persona {
	@XStreamAlias("nombre")
	public  String nombre;
	@XStreamAlias("DNI")
	public String DNI;
	@XStreamAlias("fechaNac")
	public fecha fechaNac;
        @XStreamAlias("login")
        public String login;
        @XStreamAlias("password")
        public String password;
        @XStreamAlias("avatar")
        private String avatar="";
        @XStreamAlias("tipo")
        private String tipo="";
        private int estado=0;
        public String categoria;
        public int cuota;
        public String apellido;
        
        



	public persona(String nombre,String DNI, fecha fechaNac,String login,String password,String categoria,int cuota,String apellido) {
		this.nombre = nombre;
		this.DNI=DNI;
		this.fechaNac = fechaNac;
                this.login = login;
                this.password = password;
                this.categoria=categoria;
                this.cuota=cuota;
                
	}

    public String getCategoria() {
        return categoria;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
        
	public persona(String DNI){
		this.DNI=DNI;
	}
        public persona(){
            
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


	public fecha getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(fecha fechaNac) {
		this.fechaNac = fechaNac;
	}

	public boolean equals(Object c){
		return getDNI().equals(((persona)c).getDNI());
}
	public int compareTo(persona emp) {//para ordenar los empleados
		if(this.getDNI().compareTo(emp.getDNI())>0)
			return 1;
		if(this.getDNI().compareTo(emp.getDNI())<0)
			return -1;
		return 0;
		 }
	
	
                       
}
