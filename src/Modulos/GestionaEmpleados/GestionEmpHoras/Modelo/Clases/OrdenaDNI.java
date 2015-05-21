package Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases;

import java.util.Comparator;
import Modulos.GestionaEmpleados.ClasesMadre.*;

public class OrdenaDNI implements Comparator<empleado> {

	public int compare(empleado e1, empleado e2) {
		if(e1.getDNI().compareTo(e2.getDNI())>0)
			return 1;
		if(e1.getDNI().compareTo(e2.getDNI())<0)
			return -1;
		return 0;
		}

}
