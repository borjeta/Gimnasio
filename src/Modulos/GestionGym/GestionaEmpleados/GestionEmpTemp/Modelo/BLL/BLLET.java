package Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.BLL;

import java.text.ParseException;

import javax.swing.JOptionPane;

import Modulos.GestionaEmpleados.ClasesMadre.SuperNucleo;
import Modulos.GestionaEmpleados.ClasesMadre.empleado;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.BLL.BLLEF;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.DAO.DAOEF;
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases.ArrayListEmpHoras;
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases.EmpHoras;
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.DAO.DAOEH;
import Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases.ArrayListEmpTemp;
import Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases.EmpTemp;
import Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.DAO.DAOET;
import Utils.Menus;


public class BLLET {
	public static void crearTemp() throws ParseException{//Crear un empleado fijo
		EmpTemp ef1=null;
		
		ef1=(EmpTemp)DAOET.creaEmpTemp();//Pedimos los datos desde el DAO para crear un nuevo empleado fijo
		ArrayListEmpTemp.eTe.add(ef1);//Se incluye en el arraylist
	}
	
	public static String[] GeneraVecEmpTemp(){
		empleado c;	
		String s = "";
			int n = ArrayListEmpTemp.eTe.size();			
				String eTe[] = new String[n];
				for(int i=0; i<n; i++){
					c = (empleado)ArrayListEmpTemp.eTe.get(i);
						s =  c.getDNI() + " - " + c.getNombre();
						eTe[i] = s;
				}				
		return eTe;
	}
	public static int buscar(empleado ef){//Buscar
		int aux=-1;
		
		for (int i = 0; i<=(ArrayListEmpTemp.eTe.size()-1); i++){
			if((ArrayListEmpTemp.eTe.get(i)).equals(ef))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
				aux=i;
		}
		return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
	}
	
	public static void SupermodificarEmpTemp() throws ParseException{//Modificar los datos de un empleado fijo
		int pos;
		empleado ef=null;
		EmpTemp ef1=null;
		
		ef=new empleado (SuperNucleo.pideDni());//Crea un empleadofijo solo con el DNI
		pos=buscar(ef);//Devuelve la posicion igual a la del empleadofijo que hemos creado
		if(ArrayListEmpTemp.eTe.size()==0){
			JOptionPane.showMessageDialog(null, "No hay empleados creados para modificar","Aviso",JOptionPane.QUESTION_MESSAGE);
		}
		if(pos==-1){
			JOptionPane.showMessageDialog(null, "El DNI no concuerda con ninguno de los empleados creados","Aviso",JOptionPane.QUESTION_MESSAGE);
		}else{//Si la posicion no es 0 ni -1 crea un empleado fijo obteniendo los datos del array de dicha posicion
			ef1=ArrayListEmpTemp.eTe.get(pos);
			DAOET.modificaEmpleTemp(ef1);//con el DAO de empleados fijos cambiamos los datos
			ArrayListEmpTemp.eTe.set(pos, ef1);//y lo guardamos de nuevo en el arraylist en la misma posicion para sobreescribir
		}
	}
	public static void eliminaHoras(){//Eliminar un empleado fijo
		int pos;
		empleado ef=null;
		ef=(empleado) BLLET.pideIDEmTemp();
		//Crea un empleadofijo solo con el DNI
		pos=buscar(ef);//Devuelve la posicion igual a la del empleadofijo que hemos creado
		if(ArrayListEmpTemp.eTe.size()==0){
			JOptionPane.showMessageDialog(null, "No hay empleados creados para borrar","Aviso",JOptionPane.QUESTION_MESSAGE);
		}
		if(pos==-1){
			JOptionPane.showMessageDialog(null, "El DNI no concuerda con ninguno de los empleados creados","Aviso",JOptionPane.QUESTION_MESSAGE);
		}else{//Si la posicion no es 0 ni -1 crea un empleadofijo obteniendo los datos del array de dicha posicion
			ef=ArrayListEmpTemp.eTe.get(pos);
			ArrayListEmpTemp.eTe.remove(ef);//Elimina del Array el empleado
		}
	}
	public static Object pideIDEmTemp(){	
		Object o  = null;		
		String cod = "";
			 //EMpleadosfijos
				String cli[] = BLLET.GeneraVecEmpTemp();
				String se = Utils.Menus.cbox(cli);
					for(int j=0; j<9; j++)		//extrae del string elegido el dni
						cod += se.charAt(j);								
				o = new EmpTemp(cod);	
			
				
			return o;
	}

	public static void muestraEmpleadoTemp(){
		int pos=0;
		EmpTemp o=(EmpTemp) BLLET.pideIDEmTemp();
		JOptionPane.showMessageDialog(null,"Datos del empleado fijo elegido"+o.SoloDNI());
		pos=DAOET.buscarTemp(o);
		JOptionPane.showMessageDialog(null,"La posicion es "+pos);
		o=ArrayListEmpTemp.eTe.get(pos);
		JOptionPane.showMessageDialog(null,"Datos del empleado fijo elegido"+o.toString());
		
		
		
	}
	public static void Ordenar(){//0 dni, 1 edad, 2 nombre, 3 antiguedad, 4 fechacontrata, 5 fechanac, 6 sueldo
		int op=0;
		do{
			op=Menus.menuOrdenar(1);
			switch(op){
				case 0://Ordena por dni
					DAOET.Ordenar(0);
					break;
				case 1://Ordena por nombre
					DAOET.Ordenar(1);
					break;
				case 2://Ordena por nombre
					DAOET.Ordenar(2);
					break;
				case 3://Ordena por antiguedad
					DAOET.Ordenar(3);
					break;
				case 4://Ordena por fecha de contratacion
					DAOET.Ordenar(4);
					break;
				case 5://Ordena por fecha de nacimiento
					DAOET.Ordenar(5);
					break;
				case 6://Ordena por sueldo
					DAOET.Ordenar(6);
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
					DAOET.maxmin(0);
					break;
				case 1://Ordena por nombre
					DAOET.maxmin(1);
					break;
				case 2://Ordena por nombre
					DAOET.maxmin(2);
					break;
				case 3://Ordena por antiguedad
					DAOET.maxmin(3);
					break;
				case 4://Ordena por fecha de contratacion
					DAOET.maxmin(4);
					break;
				case 5://Ordena por fecha de nacimiento
					DAOET.maxmin(5);
					break;
				case 6://Ordena por sueldo
					DAOET.maxmin(6);
					break;
				case 7://Volver
					break;
				default://Salir si cerramos ventana
					System.exit(0);
			}
		}while(op<7);
	}

	



}
