package Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.BLL;

import java.text.ParseException;

import javax.swing.JOptionPane;

import Modulos.GestionaEmpleados.ClasesMadre.empleado;
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases.ArrayListEmpHoras;
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases.EmpHoras;
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.DAO.DAOEH;
import Utils.Menus;

public class BLLEH {
	public static void crearHoras() throws ParseException{//Crear un empleado fijo
		EmpHoras ef1=null;
		
		ef1=(EmpHoras)DAOEH.CreaEmpleadoHoras();//Pedimos los datos desde el DAO para crear un nuevo empleado fijo
		ArrayListEmpHoras.eHo.add(ef1);//Se incluye en el arraylist
	}
	
	
	
	
	public static void Ordenar(){//0 dni, 1 edad, 2 nombre, 3 antiguedad, 4 fechacontrata, 5 fechanac, 6 sueldo
		int op=0;
		do{
			op=Menus.menuOrdenar(1);
			switch(op){
				case 0://Ordena por dni
					DAOEH.Ordenar(0);
					break;
				case 1://Ordena por nombre
					DAOEH.Ordenar(1);
					break;
				case 2://Ordena por nombre
					DAOEH.Ordenar(2);
					break;
				case 3://Ordena por antiguedad
					DAOEH.Ordenar(3);
					break;
				case 4://Ordena por fecha de contratacion
					DAOEH.Ordenar(4);
					break;
				case 5://Ordena por fecha de nacimiento
					DAOEH.Ordenar(5);
					break;
				case 6://Ordena por sueldo
					DAOEH.Ordenar(6);
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
					DAOEH.maxmin(0);
					break;
				case 1://Ordena por nombre
					DAOEH.maxmin(1);
					break;
				case 2://Ordena por nombre
					DAOEH.maxmin(2);
					break;
				case 3://Ordena por antiguedad
					DAOEH.maxmin(3);
					break;
				case 4://Ordena por fecha de contratacion
					DAOEH.maxmin(4);
					break;
				case 5://Ordena por fecha de nacimiento
					DAOEH.maxmin(5);
					break;
				case 6://Ordena por sueldo
					DAOEH.maxmin(6);
					break;
				case 7://Volver
					break;
				default://Salir si cerramos ventana
					System.exit(0);
			}
		}while(op<7);
	}
	public static Object pideIDEmHoras(){	
		Object o  = null;		
		String cod = "";
			 //EMpleadosfijos
				String cli[] = BLLEH.GeneraVecEmpHoras();
				String se = Utils.Menus.cbox(cli);
					for(int j=0; j<9; j++)		//extrae del string elegido el dni
						cod += se.charAt(j);								
				o = new EmpHoras(cod);	
			
				
			return o;
	}
	public static void muestraEmpleadoHoras(){
		int pos=0;
		EmpHoras o=(EmpHoras) BLLEH.pideIDEmHoras();
		JOptionPane.showMessageDialog(null,"Datos del empleado fijo elegido"+o.SoloDNI());
		pos=DAOEH.buscarHoras(o);
		JOptionPane.showMessageDialog(null,"La posicion es "+pos);
		o=ArrayListEmpHoras.eHo.get(pos);
		JOptionPane.showMessageDialog(null,"Datos del empleado fijo elegido"+o.toString());
		
		
		
	}
	public static int buscarHoras(empleado ef){//Buscar
		int aux=-1;
		
		for (int i = 0; i<=(ArrayListEmpHoras.eHo.size()-1); i++){
			if((ArrayListEmpHoras.eHo.get(i)).equals(ef))//buclea hasta que encuentra un dni que concuadre con el comparator de la madre y lo devuelve como aux
				aux=i;
		}
		return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay dni que concuadre
	}

	public static String[] GeneraVecEmpHoras(){
		empleado c;	
		String s = "";
			int n = ArrayListEmpHoras.eHo.size();		
				String cli[] = new String[n];
				for(int i=0; i<n; i++){
					c = (empleado)ArrayListEmpHoras.eHo.get(i);
						s =  c.getDNI() + " - " + c.getNombre();
						cli[i] = s;
				}				
		return cli;
	}
	public static void SuperModificaEmpHora() throws ParseException{
		int pos;
		empleado ef=null;
		ef=(empleado) BLLEH.pideIDEmHoras();
		//Crea un empleadofijo solo con el DNI
		pos=BLLEH.buscarHoras((EmpHoras) ef);//Devuelve la posicion igual a la del empleadoHoras que hemos creado
		if(ArrayListEmpHoras.eHo.size()==0){
			JOptionPane.showMessageDialog(null, "No hay empleados creados para borrar","Aviso",JOptionPane.QUESTION_MESSAGE);
		}
		if(pos==-1){
			JOptionPane.showMessageDialog(null, "El DNI no concuerda con ninguno de los empleados creados","Aviso",JOptionPane.QUESTION_MESSAGE);
		}else{//Si la posicion no es 0 ni -1 crea un empleadohoras obteniendo los datos del array de dicha posicion
			ef=ArrayListEmpHoras.eHo.get(pos);
			ArrayListEmpHoras.eHo.set(pos,DAOEH.modificaEmpleadohoras((EmpHoras) ef) );//Elimina del Array el empleado
		}
		
	}
	public static void eliminaHoras(){//Eliminar un empleado Horas
		int pos;
		empleado ef=null;
		ef=(empleado) BLLEH.pideIDEmHoras();
		//Crea un empleadofijo solo con el DNI
		pos=BLLEH.buscarHoras(ef);//Devuelve la posicion igual a la del empleadofijo que hemos creado
		if(ArrayListEmpHoras.eHo.size()==0){
			JOptionPane.showMessageDialog(null, "No hay empleados creados para borrar","Aviso",JOptionPane.QUESTION_MESSAGE);
		}
		if(pos==-1){
			JOptionPane.showMessageDialog(null, "El DNI no concuerda con ninguno de los empleados creados","Aviso",JOptionPane.QUESTION_MESSAGE);
		}else{//Si la posicion no es 0 ni -1 crea un empleadofijo obteniendo los datos del array de dicha posicion
			ef=ArrayListEmpHoras.eHo.get(pos);
			ArrayListEmpHoras.eHo.remove(pos);//Elimina del Array el empleado
		}
	}



}
