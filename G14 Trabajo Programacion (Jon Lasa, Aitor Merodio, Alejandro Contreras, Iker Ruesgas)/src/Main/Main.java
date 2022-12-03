
package Main;

import java.sql.SQLException;

import BD.BDRegistro;
import Datos.Usuario;
import VentanasAdministrador.VentanaVerUsuarios;
import VentanasCompra.VentanaBus;
import VentanasCompra.VentanaVuelo;
import VentanasCompra.VentanaVuelo;
import VentanasMenu.VentanaMenu;
import VentanasMenu.VentanaPerfil;
import VentanasRegistro.VentanaInicio;
import VentanasRegistro.VentanaLogin;
import VentanasRegistro.VentanaMetodoPago;

public class Main {

	public static void main(String[] args) throws SQLException	{
		
//		PARA CREAR VENTANAS DE COMPRA MENU....
		//Usuario u = new Usuario();
		
//		VentanaInicio v = new VentanaInicio();
//		v.setVisible(true);
	
		VentanaVerUsuarios x = new VentanaVerUsuarios();
		x.setVisible(true);
		 
	}
	
}
