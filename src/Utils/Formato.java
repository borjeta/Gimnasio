package Utils;

import Clases.fecha;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Formato {		
	private int dia;
	private int mes;
	private int año;		
	public static String dosDecimales(float num){//45.456
		DecimalFormat format1 = new DecimalFormat(".00");
		return format1.format(num);//45.46
	}
	
	public static String dosDecimalesRedondea(float num){//2.315f
		DecimalFormat format2 = new DecimalFormat("00.00");
		float f = (float)num;
		return(format2.format(f));//02,32
	}
		
	public static String porcentajeInt(int i){
		String s = "";
			s = Integer.toString(i) + "%";
		return s;
	}
	
	public static String formatoUnidades(int i){
		String s = "";
			s = Integer.toString(i) + " unid.";
		return s;
	}
	
	public static String porcentajeDouble(float per)
	{//0.47
		NumberFormat percentFormatter = NumberFormat.getPercentInstance(Locale.US);
		String percentOut = percentFormatter.format(per);
		return percentOut;//47%
	}
	public static String fechatoString(fecha f){
		String cad="";
		cad=f.getDia()+"/"+f.getMes()+"/"+f.getAño();
		return cad;
		
	}
	
	public  fecha deSTringaFechaMia(String introducefecha){
		String[] SplitArray=null;
		String fechaform=null;
		fecha A=null;
			SplitArray=introducefecha.split("/");
			this.dia=Integer.parseInt(SplitArray[0]);
			this.mes=Integer.parseInt(SplitArray[1]);
			this.año=Integer.parseInt(SplitArray[2]);
		fechaform=dia+"/"+mes+"/"+año;
		A.setDia(dia);
		A.setMes(mes);
		A.setAño(año);
		return A;
	}
	
}


