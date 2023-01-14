
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
import VentanasMenu.VentanaPerfil;
import VentanasRegistro.VentanaInicio;
import VentanasRegistro.VentanaMetodoPago;


public class Main {

	public static void main(String[] args) throws SQLException {
		
		//Administrador a = new Administrador();
		//Usuario u = new Usuario();
		
		VentanaInicio v = new VentanaInicio();
		v.setVisible(true);
		
	}
	
	
}
