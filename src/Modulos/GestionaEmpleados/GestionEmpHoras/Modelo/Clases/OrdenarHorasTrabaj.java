package Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases;

import java.util.Comparator;
import Modulos.GestionaEmpleados.ClasesMadre.*;

public class OrdenarHorasTrabaj implements Comparator<empleado>{

		public int compare(empleado e1, empleado e2) {
			if(((EmpHoras)e1).getHoras()>(((EmpHoras)e2).getHoras()))
				return 1;
			if(((EmpHoras)e1).getHoras()<(((EmpHoras)e2).getHoras()))
				return -1;
			return 0;
			}
		
	}
