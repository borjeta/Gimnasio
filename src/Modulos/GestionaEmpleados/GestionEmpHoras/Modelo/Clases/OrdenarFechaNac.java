package Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases;

import java.util.Comparator;

import Modulos.GestionaEmpleados.ClasesMadre.empleado;

public class OrdenarFechaNac implements Comparator<empleado>{

	public int compare(empleado e1, empleado e2) {
		if(e1.getFechaNac().comparafechas(e2.getFechaNac().deFechaToCalendar())>0)
			return 1;
		if(e1.getFechaNac().comparafechas(e2.getFechaNac().deFechaToCalendar())<0)
			return -1;
		return 0;
		}
	
}
