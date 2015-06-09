package Modulos.ClasesMadre;

import Clases.fecha;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.logging.Logger;




@XStreamAlias("persona")
public class persona {
	@XStreamAlias("nombre")
	public  String nombre;
        @XStreamAlias("apellido")
        public String apellido;
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
        @XStreamAlias("Tipo")
        private String tipo="";
        
        private int estado=0;
        @XStreamAlias("categoria")
        public String categoria;
        @XStreamAlias("cuota")
        public int cuota;
        
        
        



	public persona(String nombre,String apellido,String DNI, fecha fechaNac,String login,String password,String categoria,int cuota,String avatar) {
		this.nombre = nombre;
                this.apellido=apellido;
		this.DNI=DNI;
		this.fechaNac = fechaNac;
                this.login = login;
                this.password = password;
                this.categoria=categoria;
                this.cuota=cuota;
                this.avatar=avatar;
                
	}public persona(String nombre,String apellido,String DNI, fecha fechaNac,String login,String password,String categoria,int cuota,String avatar,String tipo) {
		this.nombre = nombre;
                this.apellido=apellido;
		this.DNI=DNI;
		this.fechaNac = fechaNac;
                this.login = login;
                this.password = password;
                this.categoria=categoria;
                this.cuota=cuota;
                this.avatar=avatar;
                this.tipo=tipo;
                
	}

    public persona(String login,String pass) {
        this.login = login;
        this.password= password;
    }
        
    

    public String getCategoria() {
        return categoria;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
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

        @Override
	public boolean equals(Object c){
		return getLogin().equals(((persona)c).getLogin());
}
	public int compareTo(persona emp) {//para ordenar los empleados
		if(this.getDNI().compareTo(emp.getDNI())>0)
			return 1;
		if(this.getDNI().compareTo(emp.getDNI())<0)
			return -1;
		return 0;
		 }
	
	
                       
}
