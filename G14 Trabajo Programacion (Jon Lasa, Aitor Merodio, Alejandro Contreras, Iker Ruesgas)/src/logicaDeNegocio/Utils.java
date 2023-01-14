package logicaDeNegocio;

import javax.swing.JOptionPane;


public class Utils {
	
	
	

	
	//METODO PARA COMPROBAR SI EL STRING ES VALIDO
	public static boolean comprobarString(String a) throws StringValidoException{
		if (!a.equals("")&&!a.equals(null)&&!a.equals(" ")) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos","ERROR",JOptionPane.ERROR_MESSAGE);
			throw new StringValidoException(a);
		}
	}
	
	
public static boolean comprobarMail(String a) throws CorreoNoValidoException {
		
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      if( a.matches(regex)) {
	    	  return true;
	      }
	      else {
	    	  throw new CorreoNoValidoException("Correo incorrecto: " + a);
	    	  
	      }
	}


//METODO PARA COMPROBAR SI EL PRECIO VALOR INTRODUCIDO ES UN VALIDO

	public static boolean comprobarPrecio(String a) throws PrecioException{
		try {
			int numero =Integer.parseInt(a);
			if (numero>=0) {
				return true;
			}
			else {
				throw new PrecioException("Precio negativo: " + numero);
			}
				
			
		}catch(IllegalArgumentException b) {
			throw new IllegalArgumentException();
		}
		
		
	}
	
	
	public static boolean comprobarDuracion(String a) throws DuracionException{
		try {
			int numero =Integer.parseInt(a);
			if (numero<=0) {
				throw new DuracionException("Duracion de 0 o negativo NO VALIDO : " + numero);
			}
			return true;
		}catch(IllegalArgumentException b) {
			throw new IllegalArgumentException();
	}
	}
	
	
	
	
	public static boolean comprobarPreciPlazas(String a) throws PlazasRestantesException{
		try {
			int numero =Integer.parseInt(a);
			if (numero>=0) {
				return true;
			}
			else {
				throw new PlazasRestantesException("Plazas negativo: " + numero);
			}
				
			
		}catch(IllegalArgumentException b) {
			throw new IllegalArgumentException();
		}
		
		
	}
	
	
	public static boolean comprobarStringUsuario(String a) throws LongitudStringException, CaracterNoValidoExcepcion{
		try {
			if(a.length()<=6) {
				JOptionPane.showMessageDialog(null,"El usuario debe contener mas de 6 caracteres" );
				throw new LongitudStringException("Longitud no VALIDA (TIENE QUE SER MAYOR QUE 6 : " + a);
			}
			char[] palabra = a.toCharArray();
			if(!Character.isLetter(palabra[0])) {
				JOptionPane.showMessageDialog(null,"El usuario debe empezar por una letra" );
				throw new CaracterNoValidoExcepcion("Primer caracter no valido, tiene que empezar por letra : " + a);
			}
			else {
				boolean comilla=false;
				
				for( int i =0;i<palabra.length;i++) {
					if(Character.toString(palabra[i])=="'") {
						comilla=true;
					}
				}
				//una vez sabemos si tiene comillas, LO NOTIFICAMOS,
				//NO VAMOS A REEMPLAZARLAS, YA QUE EL USUARIO PODRIA NO SABERLO
				
				if(comilla==true) {
					throw new CaracterNoValidoExcepcion("No puede contener caracteres"+ "'"+", ningun campo de escritura de caracteres");
				}
				
				return true;
			}
				
			
		}catch(IllegalArgumentException b) {
			throw new IllegalArgumentException();
			}
		}
	
	public static boolean comprobarStringContra(String a) throws LongitudStringException{
		try {
			if(a.length()<=6) {
				JOptionPane.showMessageDialog(null,"La contrasenya debe contener mas de 6 caracteres" );
				throw new LongitudStringException("Longitud no VALIDA (TIENE QUE SER MAYOR QUE 6 : " + a);
			}	
			else {
				return true;
			}
				
			
		}catch(IllegalArgumentException b) {
			throw new IllegalArgumentException();
			}
		}
	

		
		
	public static boolean comprobarContrasenyas(String a,String b) throws Exception {
		if(a.equals(b)) {
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Las contrasenyas no coinciden");
			throw new Exception("Las contrasenya no coinciden");
			}
		}
	
	
	public static boolean comprobarNumerosConLongitud(String a, int longitud, String campo) throws Exception {
	
		try {
			Double.parseDouble(a);
			
			if(a.length()!=longitud) {
				JOptionPane.showMessageDialog(null, "Informacion incorrecta en: "+campo+". Tiene que introducir "+longitud+" digitos","ERROR",JOptionPane.ERROR_MESSAGE);
				throw new Exception("Revisa valores numericos: Introducido "+a+"en el campo " + campo+" y tiene que introducir "+longitud+"digitos");
			}else {
				return true;
			}
		}catch(Exception e ) {
			throw new Exception("Revisa valores numericos: Introducido "+a+"en el campo " + campo+" y tiene que introducir "+longitud+"digitos");
		}
		
		
	}
	
	public static boolean comprobarNumeroTarjeta(String num,String campo) throws Exception {
		try {
			String num1 = num.replaceAll("-", "");
			String num2 = num1.replaceAll(" ", "");

			if(num2.length()!=16) {
				JOptionPane.showMessageDialog(null, "Informacion incorrecta en: "+campo+". Tiene que introducir 16 digitos","ERROR",JOptionPane.ERROR_MESSAGE);
				throw new Exception("Revisa valores numericos: Introducido "+num+"en el campo " + campo+" y tiene que introducir 16 digitos");
			} else {
				return true;
			}
			
		} catch (Exception e) {
			throw new Exception("Revisa valores numericos: Introducido "+num+"en el campo " + campo+" y tiene que introducir 16 digitos");
		}
	}
	
	
	public static boolean comprobarFechaCaducidad(String fechaC,String campo) throws Exception {
		try {
			String fecha1 = fechaC.replaceAll("/", "");
			String fecha2 = fecha1.replaceAll(" ", "");
			
			if(fecha2.length()!=4) {
				JOptionPane.showMessageDialog(null, "Informacion incorrecta en: "+campo+". Tiene que introducir 4 digitos","ERROR",JOptionPane.ERROR_MESSAGE);
				throw new Exception("Revisa valores numericos: Introducido "+fechaC+"en el campo " + campo+" y tiene que introducir 4 digitos");
			} else {
				return true;
			}
			
		} catch (Exception e) {
			throw new Exception("Revisa valores numericos: Introducido "+fechaC+"en el campo " + campo+" y tiene que introducir 4 digitos");
		}
	}
	
		
		
	
	
	
	
	
	

	
	


}
