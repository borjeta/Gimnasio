/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import java.util.Random;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author miguel
 */
public class Encriptar {
    
    public static String getCadenaAleatoria(int longitud){//microtime
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while ( i < longitud){
                    char c = (char)r.nextInt(255);
                    if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') || (c >='a' && c <='z') || (c == '$') || (c == '_') ){
			cadenaAleatoria += c;
			i ++;
                    }
		}
		return cadenaAleatoria;
	}
	
	public static String encriptarTokenMD5(String name){
            String cadena_encriptada = DigestUtils.md5Hex(name);
            return cadena_encriptada;
	}
	
	public static boolean validarTokenMD5(String cadenaAleatoria, String cadena_encriptada){
		if(encriptarTokenMD5(cadenaAleatoria).equals(cadena_encriptada))
			return true;
		return false;
	}
    
}
