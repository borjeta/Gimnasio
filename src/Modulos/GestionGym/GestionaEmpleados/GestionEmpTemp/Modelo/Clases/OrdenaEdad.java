package Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases;

import java.util.Comparator;
import Modulos.GestionaEmpleados.ClasesMadre.*;

public class OrdenaEdad implements Comparator<empleado>{

	public int compare(empleado e1, empleado e2) {
		if(e1.getEdad()>(e2.getEdad()))
			return 1;
		if(e1.getEdad()<(e2.getEdad()))
			return -1;
		return 0;
		}
	
}
