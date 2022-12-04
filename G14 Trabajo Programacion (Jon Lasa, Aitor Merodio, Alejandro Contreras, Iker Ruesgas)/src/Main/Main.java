
package Main;

import java.sql.SQLException;

import BD.BDRegistro;
import Datos.Usuario;
import VentanasCompra.VentanaBus;
import VentanasCompra.VentanaVuelo;
import VentanasRegistro.VentanaInicio;


public class Main {

	public static void main(String[] args) {
		
//		PARA CREAR VENTANAS DE COMPRA MENU....
		Usuario u = new Usuario();
		
//		VentanaInicio v = new VentanaInicio();
//		v.setVisible(true);
	
//		VentanaVuelo x = new VentanaVuelo(u);
//		x.setVisible(true);
//		
		VentanaBus x = new VentanaBus(u);
		x.setVisible(true);
	}
	
}
