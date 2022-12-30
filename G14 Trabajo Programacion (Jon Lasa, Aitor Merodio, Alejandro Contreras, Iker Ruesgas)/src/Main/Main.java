
package Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import BD.BDRegistro;
import BD.BDServicio;
import Datos.Administrador;
import Datos.Bus;
import Datos.RentingCoche;
import Datos.Usuario;
import Datos.Vuelo;
import Datos.VueloComprado;
import Enum.ClaseCoche;
import Enum.TipoServicio;
import Enum.ZonaAsientoVuelo;
import VentanasAdministrador.VentanaCrearBus;
import VentanasAdministrador.VentanaCrearVuelo;
import VentanasAdministrador.VentanaInicioAdmin;
import VentanasAdministrador.VentanaMostrarEstadistica;
import VentanasCompra.VentanaBus;
import VentanasCompra.VentanaViajesC;
import VentanasCompra.VentanaVuelo;
import VentanasMenu.VentanaMenu;
import VentanasRegistro.VentanaInicio;


public class Main {

	public static void main(String[] args) throws SQLException {
		
//		PARA CREAR VENTANAS DE COMPRA MENU...

		Usuario u = new Usuario();
		Administrador a = new Administrador();

//		Usuario u = new Usuario();
//		Administrador a = new Administrador();

//		Bus bus = new Bus("2023-02-20",3600,"Madrid","Bilbao",20,70,"Alsa");
//		System.out.println(bus.getFecha());
//		BDServicio.crearBus(bus);
		
//		VentanaInicio v = new VentanaInicio();
//		v.setVisible(true);
	
//		VentanaInicio y = new VentanaInicio();
//		y.setVisible(true);
		
//		VentanaCrearVuelo z = new VentanaCrearVuelo(a);
//		z.setVisible(true);
		
//		VentanaCrearBus w = new VentanaCrearBus(a);
//		w.setVisible(true);

//		VentanaInicio c =  new VentanaInicio();
//		c.setVisible(true);

//		VentanaViajesC c =  new VentanaViajesC(u);
//		c.setVisible(true);
		
		VentanaMostrarEstadistica es = new VentanaMostrarEstadistica(a);
		es.setVisible(true);

//		BDServicio.crearViajesCombinados();

		
	}
	
}
