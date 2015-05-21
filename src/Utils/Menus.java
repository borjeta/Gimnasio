package Utils;
import javax.swing.JOptionPane;

import tema6.Ppal;

public class Menus {

	public static String cbox(String[] opciones){
		String op="";
		
		
		Object seleccion= JOptionPane.showInputDialog(null,"Seleccione una opci�n","�Que desea hacer?",JOptionPane.QUESTION_MESSAGE,null,opciones, opciones[0]);
		if(seleccion==null){
			op=null;
		}else 
			op=seleccion.toString();
		return op;
	}
	public static int Cbotones(String[] opciones){
		int op=0;
		op=JOptionPane.showOptionDialog(null,
				"Elija la opci�n deseada",null, 0,
				JOptionPane.QUESTION_MESSAGE,null, opciones,opciones[0]);
	return op;
	}
	
	public static void Salir(){
		
		JOptionPane.showMessageDialog(null,"Ssaliendo");
		
		
		
		
	}
	public static int menuTipoEmpleados(){
		int a=0;
		String[] tipo={"Empleado fijo","Empleado temporal","Empleado por horas","Volver"};
		String s="Selecci�n de tipo de empleado";
		a=JOptionPane.showOptionDialog(null,
				"�Elija el tipo de empleado",s,0,
				JOptionPane.QUESTION_MESSAGE,null,tipo,tipo[0]);
		
		
		
		return a;
	}
	public static int menuOrdenar(int i){
		String s="";
		int resp2;
		if(i==1)
		s=s+"Ordenar";
		else if(i==2)
		s=s+"MaxMin";

		String[] tipo3={"DNI","Edad","Nombre","Antiguedad","Fecha contrato","Fechanac","Sueldo", "Volver"};
		resp2 = JOptionPane.showOptionDialog(null,
		"Pulsa la operacin elegida",s,0,
		JOptionPane.QUESTION_MESSAGE,null,tipo3,tipo3[0]);
		return resp2;
		}
	public static String AskCoin(){
		String s="";
		int op=0;
		Object seleccion = JOptionPane.showInputDialog(
				   null,
				   "Seleccione que moneda desea:",
				   "Selector de opciones",
				   JOptionPane.QUESTION_MESSAGE,
				   null,  // null para icono defecto
				   new Object[] { "Dolar", "Libra", "Euro"},
				   "Dolar");
		
		if(seleccion==null){
			JOptionPane.showMessageDialog(null,
			"Saliendo de la aplicación","Saliendo ...",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		
		}else if (seleccion=="Dolar"){
			s="$";
			op=1;
		}
		else if (seleccion=="Libra"){
			s="�";
			op=2;
		}
		else if (seleccion=="Euro"){
			s="�";
			op=3;
		}
		return s;
		
	}
	
	public static float CambiaConfiguracionDecimales(){
		float o=0.0f;
		
		
		
		return o ;
		
	}
        public static void warning(String msg, String titol) {
        JOptionPane.showMessageDialog(null, // component pare
                msg, // missatge
                titol, // t�tol
                JOptionPane.WARNING_MESSAGE, // tipus de missatge
                null);
    }

	public static void CambiaConfiguracionFecha(){
		int resp=0;
		String[] opciones={"Configuracion 1\n yyyy/MM/dd","Configuracion 2\n dd/MM/yyyy","Configuracion 3\n yyyy-MM-dd"};
		resp=Menus.Cbotones(opciones);
		if(resp==0){
			Ppal.f.setFormatfecha(1);
		}
		if(resp==1){
			Ppal.f.setFormatfecha(2);
		}
		if(resp==2){
			Ppal.f.setFormatfecha(3);
		}
	}
	public static void CambiaDecimales(){
		int resp=0;
		String[] opciones={"0.0 ","0.00","0.00(Con redondeo)"};
		resp=Menus.Cbotones(opciones);
		if(resp==0){
			Ppal.f.setNumdecimal(1);
		}
		if(resp==1){
			Ppal.f.setNumdecimal(2);
		}
		if(resp==2){
			Ppal.f.setNumdecimal(3);
			
		}
	}
		public static int Cambiatema(){
			int i =0;
			String[] tipo={"Metal","Windows","CDE"};
				i=Menus.Cbotones(tipo);
			return i ;
		}
		public static int FormatoGuardado(){
			int resp=0;
			String[] tipo={"Archivo de texto","Formato XML","Archivo JSON","Volver"};
			resp=Menus.Cbotones(tipo);
			return resp;
		}
                public static boolean confirmar(String msg, String titol) {
        boolean confirmar = false;
        int sel = JOptionPane.showConfirmDialog(null, // component pare
                msg, // missatge
                titol, // t�tol
                JOptionPane.OK_CANCEL_OPTION, // tipud d'opci�
                JOptionPane.QUESTION_MESSAGE); // tipus de missatge
        if ((sel == 0) || (sel == -1)) {
            confirmar = true;
        }
        return confirmar;
    }
	}

