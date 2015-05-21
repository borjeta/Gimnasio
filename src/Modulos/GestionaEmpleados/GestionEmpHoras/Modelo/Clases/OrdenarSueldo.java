package Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases;

import java.util.Comparator;
import Modulos.GestionaEmpleados.ClasesMadre.*;

public class OrdenarSueldo implements Comparator<empleado>{
	
	public int compare(empleado e1, empleado e2) {
		if(((EmpHoras)e1).getSueldo()>(((EmpHoras)e2).getSueldo()))
			return 1;
		if(((EmpHoras)e1).getSueldo()<(((EmpHoras)e2).getSueldo()))
			return -1;
		return 0;
		}

}
