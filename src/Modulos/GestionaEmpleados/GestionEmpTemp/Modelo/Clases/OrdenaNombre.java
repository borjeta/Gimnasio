package Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases;

import java.util.Comparator;
import Modulos.GestionaEmpleados.ClasesMadre.*;

public class OrdenaNombre implements Comparator<empleado>{
	
	public int compare(empleado e1, empleado e2) {
		if(e1.getNombre().compareTo(e2.getNombre())>0)
			return 1;
		if(e1.getNombre().compareTo(e2.getNombre())<0)
			return -1;
		return 0;
		}

}
