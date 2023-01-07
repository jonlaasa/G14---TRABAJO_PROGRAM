
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
		

		
		//Usuario u = new Usuario();
		//Administrador a = new Administrador();




		VentanaInicio es = new VentanaInicio();
		es.setVisible(true);


		
	}
	
	
}
