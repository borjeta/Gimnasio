package Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases;

import java.util.Comparator;
import Modulos.GestionaEmpleados.ClasesMadre.*;

public class OrdenarSueldo implements Comparator<empleado>{
	
	public int compare(empleado e1, empleado e2) {
		if(((EmpTemp)e1).getSueldo()>(((EmpTemp)e2).getSueldo()))
			return 1;
		if(((EmpTemp)e1).getSueldo()<(((EmpTemp)e2).getSueldo()))
			return -1;
		return 0;
		}

}
