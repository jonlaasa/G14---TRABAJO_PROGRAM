package logicaDeNegocio;

public class Utils {
	
	
	

	
	//METODO PARA COMPROBAR SI EL STRING ES VALIDO
	public static boolean comprobarString(String a) throws StringValidoException{
		if (!a.equals("")&&!a.equals(null)&&!a.equals(" ")) {
			return true;
		}
		else {
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
	
	
	public static boolean comprobarStringUsuario(String a) throws LongitudStringException{
		try {
			if(a.length()<=6) {
				throw new LongitudStringException("Longitud no VALIDA (TIENE QUE SER MAYOR QUE 6 : " + a);
			}
			char[] palabra = a.toCharArray();
			if(!Character.isLetter(palabra[0])) {
				
				throw new LongitudStringException("Primer caracter no valido, tiene que empezar por letra : " + a);
			}
			
			
			else {
				return true;
			}
				
			
		}catch(IllegalArgumentException b) {
			throw new IllegalArgumentException();
		}
		
		
	}
	
	
	
	
	
	
	
	


}
