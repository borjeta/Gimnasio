package Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.BLL;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
//ESTE ES MI BLL//






import Modulos.GestionaEmpleados.ClasesMadre.SuperNucleo;
import Modulos.GestionaEmpleados.ClasesMadre.empleado;
import Modulos.GestionaEmpleados.GestionEmpFijo.*;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.DAO.DAOEF;
import Utils.Menus;

import javax.swing.JOptionPane;

import tema6.Ppal;



public class BLLEF {
	public static void crearFijo() throws ParseException{//Crear un empleado fijo
	EmpFijo ef1=null;
	
	ef1=(EmpFijo)DAOEF.CreaEmpleadoFijo();//Pedimos los datos desde el DAO para crear un nuevo empleado fijo
	ArrayListEmpFijo.efi.add(ef1);//Se incluye en el arraylist
}
	
public static int buscar(empleado ef){//Buscar
	int aux=-1;
	
	for (int i = 0; i<=(ArrayListEmpFijo.efi.size()-1); i++){
		if((ArrayListEmpFijo.efi.get(i)).equals(ef))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
			aux=i;
	}
	return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
}

public static int buscarfijo(EmpFijo ef){//Buscar
	int aux=-1;
	
	for (int i = 0; i<=(ArrayListEmpFijo.efi.size()-1); i++){
		if((ArrayListEmpFijo.efi.get(i)).equals(ef))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
			aux=i;
	}
	return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
}

public static void buscarEmpleado(){
	int pos;
	empleado emp=null;
	
	pos=BLLEF.buscar((empleado) BLLEF.pideIDEmFijo());
	if (pos == -1)
		JOptionPane.showMessageDialog(null, "Ese usuario no existe", "Empleados fijos", JOptionPane.ERROR_MESSAGE);
		if(pos!=-1){
			emp=ArrayListEmpFijo.efi.get(pos);
			JOptionPane.showMessageDialog(null, "El empleado fijo con: "+"\n"+emp.toString()+"Esta en la posicion"+pos, "Empleados", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			JOptionPane.showMessageDialog(null, "No hay empleados fijos","Aviso",JOptionPane.QUESTION_MESSAGE);
		}
			
}

public static void eliminaFijo(){//Eliminar un empleado fijo
	int pos;
	empleado ef=null;
	ef=(EmpFijo) BLLEF.pideIDEmFijo();
	//Crea un empleadofijo solo con el DNI
	pos=buscar(ef);//Devuelve la posicion igual a la del empleadofijo que hemos creado
	if(ArrayListEmpFijo.efi.size()==0){
		JOptionPane.showMessageDialog(null, "No hay empleados creados para borrar","Aviso",JOptionPane.QUESTION_MESSAGE);
	}
	if(pos==-1){
		JOptionPane.showMessageDialog(null, "El DNI no concuerda con ninguno de los empleados creados","Aviso",JOptionPane.QUESTION_MESSAGE);
	}else{//Si la posicion no es 0 ni -1 crea un empleadofijo obteniendo los datos del array de dicha posicion
		ef=ArrayListEmpFijo.efi.get(pos);
		ArrayListEmpFijo.efi.remove(ef);//Elimina del Array el empleado
	}
}

public static void SupermodificarEmpFijo() throws ParseException{//Modificar los datos de un empleado fijo
	int pos;
	empleado ef=null;
	EmpFijo ef1=null;
	
	ef=(empleado) BLLEF.pideIDEmFijo();//Crea un empleadofijo solo con el DNI
	pos=buscar(ef);//Devuelve la posicion igual a la del empleadofijo que hemos creado
	if(ArrayListEmpFijo.efi.size()==0){
		JOptionPane.showMessageDialog(null, "No hay empleados creados para modificar","Aviso",JOptionPane.QUESTION_MESSAGE);
	}
	if(pos==-1){
		JOptionPane.showMessageDialog(null, "El DNI no concuerda con ninguno de los empleados creados","Aviso",JOptionPane.QUESTION_MESSAGE);
	}else{//Si la posicion no es 0 ni -1 crea un empleado fijo obteniendo los datos del array de dicha posicion
		ef1=ArrayListEmpFijo.efi.get(pos);
		DAOEF.modificaEmpleadofijo(ef1);//con el DAO de empleados fijos cambiamos los datos
		ArrayListEmpFijo.efi.set(pos, ef1);//y lo guardamos de nuevo en el arraylist en la misma posicion para sobreescribir
		
	}
}

public static Object pideIDEmFijo(){	
	Object o  = null;		
	String cod = "";
		 //EMpleadosfijos
			String cli[] = BLLEF.GeneraVecEmpFijo();
			String se = Utils.Menus.cbox(cli);
				for(int j=0; j<9; j++)		//extrae del string elegido el dni
					cod += se.charAt(j);								
			o = new EmpFijo(cod);	
		
			
		return o;
}

public static void muestraEmpleadoFijo(){
	int pos=0;
	EmpFijo o=(EmpFijo) BLLEF.pideIDEmFijo();
	JOptionPane.showMessageDialog(null,"Datos del empleado fijo elegido"+o.SoloDNI());
	pos=DAOEF.buscarfijo(o);
	JOptionPane.showMessageDialog(null,"La posicion es "+pos);
	o=ArrayListEmpFijo.efi.get(pos);
	JOptionPane.showMessageDialog(null,"Datos del empleado fijo elegido"+o.toString());
	
	
	
}
public static String[] GeneraVecEmpFijo(){
	empleado c;	
	String s = "";
		int n = ArrayListEmpFijo.efi.size();		
			String cli[] = new String[n];
			for(int i=0; i<n; i++){
				c = (empleado)ArrayListEmpFijo.efi.get(i);
					s =  c.getDNI() + " - " + c.getNombre();
					cli[i] = s;
			}				
	return cli;
}


public static void Abrir(){//Abrir en el formato elegido por el usuario previamente en configuracion

	if(Ppal.f.getFormatSave()==1){
		ArrayListEmpFijo.efi=Librerias.txt.abrir_txtEmpFijo();
		
		//imprimir(ArraylistEF.efi);
	}
	else if (Ppal.f.getFormatSave()==2){
		ArrayListEmpFijo.efi=Librerias.xml.abrir_xmlEF();
		//imprimir(ArraylistEF.efi);
	}
	else if (Ppal.f.getFormatSave()==3){
		
		ArrayListEmpFijo.efi=Librerias.json.abrir_jsonEF();
		//imprimir(ArraylistEF.efi);
	}
}
public static void GuardadoSilencioso(){
	Librerias.json.generajsonocultoEF();
	Librerias.txt.generatxtOcultoEF();
	Librerias.xml.generaxmlOcultoEF();
}
public static void AbrirSilencioso(){
	ArrayListEmpFijo.efi=Librerias.json.abrir_jsonOcultoEF();
	ArrayListEmpFijo.efi=Librerias.txt.abrir_txtOcultoEF();
	ArrayListEmpFijo.efi=Librerias.xml.abrir_xmlOcultoEF();
}

public static void Guardar(){//Guardar en el formato elegido por el usuario previamente en configuracion
	if(ArrayListEmpFijo.efi.size()!=0){

	if(Ppal.f.getFormatSave()==1){
		Librerias.txt.generatxtEF();//Genera un archivo txt con todos los datos del Arraylist de empleados fijos
		GuardadoSilencioso();
	}
	else if (Ppal.f.getFormatSave()==2){
		Librerias.xml.generaxmlEF();//Lo mismo que antes pero con un xml
		GuardadoSilencioso();
	}
	else if (Ppal.f.getFormatSave()==3){
		Librerias.json.generajsonEF();//GENERA JSON
		GuardadoSilencioso();
	}
	}else
		JOptionPane.showMessageDialog(null, "ArrayList vacio", "Error", JOptionPane.ERROR_MESSAGE);
}

public static void Ordenar(){//0 dni, 1 edad, 2 nombre, 3 antiguedad, 4 fechacontrata, 5 fechanac, 6 sueldo
	int op=0;
	do{
		op=Menus.menuOrdenar(1);
		switch(op){
			case 0://Ordena por dni
				DAOEF.Ordenar(0);
				break;
			case 1://Ordena por nombre
				DAOEF.Ordenar(1);
				break;
			case 2://Ordena por nombre
				DAOEF.Ordenar(2);
				break;
			case 3://Ordena por antiguedad
				DAOEF.Ordenar(3);
				break;
			case 4://Ordena por fecha de contratacion
				DAOEF.Ordenar(4);
				break;
			case 5://Ordena por fecha de nacimiento
				DAOEF.Ordenar(5);
				break;
			case 6://Ordena por sueldo
				DAOEF.Ordenar(6);
				break;
			case 7://Volver
				break;
			default://Salir si cerramos ventana
				System.exit(0);
		}
	}while(op<7);
}

public static void MaxMin(){//0 dni, 1 edad, 2 nombre, 3 antiguedad, 4 fechacontrata, 5 fechanac, 6 sueldo
	int op=0;

	do{
		op=Menus.menuOrdenar(2);
		switch(op){
			case 0://Ordena por dni
				DAOEF.maxmin(0);
				break;
			case 1://Ordena por nombre
				DAOEF.maxmin(1);
				break;
			case 2://Ordena por nombre
				DAOEF.maxmin(2);
				break;
			case 3://Ordena por antiguedad
				DAOEF.maxmin(3);
				break;
			case 4://Ordena por fecha de contratacion
				DAOEF.maxmin(4);
				break;
			case 5://Ordena por fecha de nacimiento
				DAOEF.maxmin(5);
				break;
			case 6://Ordena por sueldo
				DAOEF.maxmin(6);
				break;
			case 7://Volver
				break;
			default://Salir si cerramos ventana
				System.exit(0);
		}
	}while(op<7);
}


}
