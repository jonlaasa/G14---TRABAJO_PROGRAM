package Logica_de_Negocio;



public class Utils {
	
	
	

	
	//METODO PARA COMPROBAR SI EL STRING ES VALIDO
	public static boolean comprobarString(String a) throws StringValidoException{
		if (!a.equals("")&&!a.equals(null)&&!a.equals(" ")) {
			return true;
		}
		else {
			throw new StringValidoException();
		}
	}
	
	
public static boolean comprobarMail(String a) throws CorreoNoValidoException {
		
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      if( a.matches(regex)) {
	    	  return true;
	      }
	      else {
	    	  throw new CorreoNoValidoException();
	    	  
	      }
	}


//METODO PARA COMPROBAR SI EL VALOR INTRODUCIDO ES UN NUMERO

	public static boolean comprobarNumero(String a) throws IllegalArgumentException{
		try {
			int numero =Integer.parseInt(a);
			return true;
		}catch(IllegalArgumentException b) {
			throw new IllegalArgumentException();
		}
		
		
	}
	
	
	
	
	

}
