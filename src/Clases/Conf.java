package Clases;

import Modulos.ClasesMadre.persona;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Arraylistgym;
import Modulos.GestionGym.GestionUsuarios.Modelo.Clases.user;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import java.text.ParseException;



import Utils.Apariencia;
import java.util.ArrayList;

public class Conf {
	
	private int numdecimal;
	private String moneda;
	private int formatfecha;
	private int tema;
	private int formatSave;
	

	public Conf(){
		
                Arraylistgym.gym= new ArrayList<persona>();
                Arraylistgym.us= new ArrayList<user>();
                ArrayListEmpFijo.efi=new ArrayList<EmpFijo>();
                
                
		numdecimal=1;
		moneda="€";
		formatfecha=1;
		formatSave=1;
		Apariencia.apariencia(1);
		//DAOEFgrafic.cargardatosFijos();
        	//DAOEH.cargardatosHoras();
                //DAOET.cargardatosTempo();
                //Librerias.txt.abrir_txtOcultoEF();
                //Librerias.xml.abrir_xmlEF();
		//Librerias.txt.generatxtOcultoEF();
		//Librerias.xml.abrir_xmlOcultoEF();
		//Librerias.xml.generaxmlOcultoEF();
	//	Librerias.json.generajsonocultoEF();
	//	Librerias.txt.abrir_txtOcultoEmpHoras();
	//	Librerias.txt.generatxtOcultoEmpHoras();
	//	Librerias.xml.abrir_xmlOcultoEmpHoras();
	//	Librerias.xml.generaxmlOcultoEmpHoras();
	////  Librerias.json.generajsonocultoEmpHoras();
	//	Librerias.txt.abrir_txtOcultoEmpTemp();
	//	Librerias.txt.generatxtOcultoEmpTemp();
	//	Librerias.xml.abrir_xmlOcultoEmpTemp();
	//	Librerias.xml.generaxmlOcultoEmpTemp();
	//	Librerias.json.generajsonocultoEmpTemp();
		
	}

	@Override
	public String toString() {
		return "Conf [numdecimal=" + numdecimal + ", moneda=" + moneda + ", formatfecha=" + formatfecha + "]";
	}

	public int getNumdecimal() {
		return numdecimal;
	}
	public int getFormatSave() {
		return formatSave;
	}

	public void setFormatSave(int formatSave) {
		this.formatSave = formatSave;
	}

	public void setNumdecimal(int numdecimal) {
		this.numdecimal = numdecimal;
	}

	public String getMoneda() {
		return moneda;
	}

	public int getTema() {
		return tema;
	}

	public void setTema(int tema) {
		this.tema = tema;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public int getFormatfecha() {
		return formatfecha;
	}

	public void setFormatfecha(int formatfecha) {
		this.formatfecha = formatfecha;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
