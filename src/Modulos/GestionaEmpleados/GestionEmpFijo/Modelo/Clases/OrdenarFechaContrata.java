package Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases;

import java.util.Comparator;
import Modulos.GestionaEmpleados.ClasesMadre.*;
import Clases.fecha;
public class OrdenarFechaContrata implements Comparator<empleado>{
	
	public int compare(empleado e1, empleado e2) {
		
		if(((EmpFijo)e1).getFechaCont().comparafechas((((EmpFijo)e2).getFechaCont().deFechaToCalendar()))>0)
			return 1;
		if(((EmpFijo)e1).getFechaCont().comparafechas(((EmpFijo)e2).getFechaCont().deFechaToCalendar())<0)
			return -1;
		return 0;
		}

}
