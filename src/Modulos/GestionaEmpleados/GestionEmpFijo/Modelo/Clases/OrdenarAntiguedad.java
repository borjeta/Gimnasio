package Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases;

import java.util.Comparator;
import Modulos.GestionaEmpleados.ClasesMadre.*;

public class OrdenarAntiguedad implements Comparator<empleado>{
	
	public int compare(empleado e1, empleado e2) {
		
		if(((EmpFijo)e1).getAntiguedad()>(((EmpFijo)e2).getAntiguedad()))
			return 1;
		if(((EmpFijo)e1).getAntiguedad()<(((EmpFijo)e2).getAntiguedad()))
			return -1;
		return 0;
		}

}
