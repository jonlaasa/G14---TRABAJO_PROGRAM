
package Main;

import java.sql.SQLException;

import BD.BDRegistro;
import BD.BDServicio;
import Datos.Administrador;
import Datos.Bus;
import Datos.Usuario;
import VentanasAdministrador.VentanaCrearBus;
import VentanasAdministrador.VentanaCrearVuelo;
import VentanasCompra.VentanaBus;
import VentanasCompra.VentanaVuelo;
import VentanasRegistro.VentanaInicio;


public class Main {

	public static void main(String[] args) throws SQLException {
		
//		PARA CREAR VENTANAS DE COMPRA MENU....
		Usuario u = new Usuario();
		Administrador a = new Administrador();
		
//		Bus bus = new Bus("2023-02-20",3600,"Madrid","Bilbao",20,70,"Alsa");
//		System.out.println(bus.getFecha());
//		BDServicio.crearBus(bus);
		
//		VentanaInicio v = new VentanaInicio();
//		v.setVisible(true);
	
//		VentanaInicio y = new VentanaInicio();
//		y.setVisible(true);
		
		VentanaCrearVuelo z = new VentanaCrearVuelo(a);
		z.setVisible(true);
		
//		VentanaCrearBus w = new VentanaCrearBus(a);
//		w.setVisible(true);
		
//		VentanaVuelo x = new VentanaVuelo(u);	
//		x.setVisible(true);
		
	}
	
}
