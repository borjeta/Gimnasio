package Utils;

import Clases.fecha;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Validacion {
    // validate email
    public static boolean validaEmail(String email) {
        return email
                .matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    // validate name
    public static boolean validaNombre(String nombre) {
        return nombre.matches("[a-zA-z]+([ ][a-zA-Z]+)*");
    }

    // validate surname
    public static boolean validaApellido(String lastName) {
        return lastName.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
    }

    // validate postal code
    public static boolean validaCoPostal(String postalCode) {
        return postalCode.matches("^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$");
    }

    // validate postal code
    public static boolean validaNumTelefono(String numTelf) {
        return numTelf.matches("[0-9]{9}");
    }
    
    // validate pass
    public static boolean validaPassword(String pass) {
        return pass.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
    }

    public static boolean validadia(int dia){
    	boolean val=false;
    	if((dia>=1)&&(dia<31))
    	{
    		val=true;
    	}
    	else{
    		JOptionPane.showMessageDialog(null,"Introduzca un dia real");
    	}
    	return val;
    }
    public static boolean validames( fecha a){
    	boolean val=false;
    	int[] months={0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	if((a.getMes()>1)&&(a.getMes()<12)){
    		val=true;
    	}
    	if (a.getMes()==2){
            int febMax=28;
            if (((a.getAño()%4)==0)&&((a.getAño()%100)!=0)||((a.getAño() % 400) == 0)){
                    febMax=29;
            }
            if ((a.getDia()<1)||(a.getDia()>febMax)){
            	JOptionPane.showMessageDialog(null, "Introduce un dia correcto para el mes "+a.getMes());
                    return false;
            }
    }
    if ((a.getDia() < 1)||(a.getDia() > months[a.getMes()])){
    	val=false;
    }
    return val;
    }
    
    public static boolean validaAño(int año){
    	boolean val=false;
    	if((año>1950)&&(año<2200))
    	{
    		val=true;
    	}else{
    		JOptionPane.showMessageDialog(null,"Introduzca un año correcto y valido");
    	}
    	return val;
    }
    public static boolean DNI(String DNI){ //Valida un DNI
	String nifPattern = "^[X-Zx-z0-9]{1}[0-9]{7}[A-Za-z]{1}$";

        return  DNI.matches(nifPattern);	
    }
        
        
        /*boolean val = true;
		String dni2 = "", caracteres="TRWAGMYFPDXBNJZSQVHLCKET";
		int dni = 0, modulo = 0;
			for(int i=0; i<8; i++)
				dni2 += DNI.charAt(i);			
			char letra = DNI.charAt(8);			
				dni = Integer.parseInt(dni2);
			    	modulo= dni % 23;
			    		char let = caracteres.charAt(modulo);
					    	if(let == letra)
                                                {	val = true;
                                                }else{
                                            JOptionPane.showMessageDialog(null,"Introduzca un DNI Valido");
					    		val = false;
                                                }
	    return val;
    }
*//*
        boolean resultado = false;

        try {
            String vCif = DNI.trim();

            int suma = 0;
            int contador = 0;
            int temporal = 0;
            int codigoControl = 0;
            String cadenaTemporal = null;
            String valoresCif = "ABCDEFGHJKLMNPQRSUVW";
            String letraControlCIF = "0123456789";
            String letraSociedadNumerica = "KLMNPQRSW";
            String primeraLetra = null;
            String ultimaLetra = null;

            // Comprueba la longitud correcta del CIF.
            if (!(vCif.length() == 9))
                return false;

            // Si encuentra alg�n caracter que no sea una letra o un n�mero, el cif
            // no es valido.
            if (vCif.matches("[^A-Za-z0-9]"))
                return false;

            // Convierte a may�sculas la cadena.
            vCif = vCif.toUpperCase();

            // Obtiene la primera letra (letra de la sociedad) y la �ltima letra del
            // CIF (letra de control).
            primeraLetra = vCif.substring(0, 1);

            // Obtiene la �ltima letra del CIF, para comprobar si es v�lida.
            ultimaLetra = vCif.substring(8, 9);

            // Comprueba si la primera letra es v�lida.
            if (valoresCif.indexOf(primeraLetra) < 0)
                return false;

            // Obtiene el c�digo de control.
            // Sumamos las cifras pares
            suma = suma + Integer.parseInt(vCif.substring(2, 3)) + Integer.parseInt(vCif.substring(4, 5))
                    + Integer.parseInt(vCif.substring(6, 7));

            // Ahora cada cifra impar la multiplicamos por dos y sumamos las cifras
            // del resultado.
            for (contador = 1; contador < 8; contador = contador + 2) {
                // Multiplica por 2
                temporal = (Integer.parseInt(vCif.substring(contador, contador + 1)) * 2);

                // Suma los digitos.
                // Diferencia si tiene una cifra, por ejemplo: 8 = 8
                // o si tiene varias, por ejemplo: 16 -> 6 + 1 = 7
                if (temporal < 10)
                    suma = suma + temporal;
                else {
                    cadenaTemporal = String.valueOf(temporal);
                    suma = suma + (Integer.parseInt(cadenaTemporal.substring(0, 1)))
                            + (Integer.parseInt(cadenaTemporal.substring(1, 2)));
                }
            }

            // Obtiene las unidades de la suma y se las resta a 10, para obtener el
            // d�gito de control.
            codigoControl = ((10 - (suma % 10)) % 10);

            // Si la letra es K, L, M, N, P, Q � S entonces al codigo de control le
            // suma 64 y
            // obtengo su ASCII para ver si coincide con la ultima letra del cif.
            if (letraSociedadNumerica.indexOf(primeraLetra) >= 0) {
                byte[] ascii = new byte[1];

                // Obtiene el c�digo ASCII asociado, al sumar 64 al c�digo de
                // control.
                if (codigoControl == 0)
                    codigoControl = 10;
                codigoControl = codigoControl + 64;
                ascii[0] = (Integer.valueOf(codigoControl)).byteValue();

                // El �ltimo d�gito tiene que coincidir con el d�gito de control
                // obtenido
                resultado = (ultimaLetra.equals(new String(ascii)));
            } else {
                // Para el resto de letras de comienzo de CIF el �ltimo d�gito debe ser
                // num�rico,
                // y coincidir con el c�digo de control.
                resultado = (codigoControl == letraControlCIF.indexOf(ultimaLetra));
            }
        } catch (Exception e) {
            // Si ha habido alg�n error es porque hay alg�n parseo que tira bien.
            resultado = false;
        }
        return resultado;
    }

	
 */
    
    public static boolean ValidafechaCompleta(fecha fechaNac){
		boolean val1=false,val2=false,val3=false,valor=false;
		val1=Validacion.validadia(fechaNac.getDia());
		val2=Validacion.validames(fechaNac);
		val3=Validacion.validaAño(fechaNac.getAño());
		if((val1==true)&&(val2==true)&&(val3==true)){
			valor=true;
		}
		
		return valor;
	}
	
}


