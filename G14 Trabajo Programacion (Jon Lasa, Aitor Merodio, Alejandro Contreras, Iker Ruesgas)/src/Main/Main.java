
package Main;

import java.sql.SQLException;

import BD.BDRegistro;
import Datos.Usuario;
import VentanasAdministrador.VentanaCrearBus;
import VentanasCompra.VentanaBus;
import VentanasCompra.VentanaVuelo;
import VentanasRegistro.VentanaInicio;


public class Main {

	public static void main(String[] args) {
		
//		PARA CREAR VENTANAS DE COMPRA MENU....
		Usuario u = new Usuario();
		
//		VentanaInicio v = new VentanaInicio();
//		v.setVisible(true);
	
		VentanaVuelo y = new VentanaVuelo(u);
		y.setVisible(true);
//		
		VentanaCrearBus x = new VentanaCrearBus();
		x.setVisible(true);
	}
	
}
