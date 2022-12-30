package Estadistica;

import java.sql.Connection;

import BD.BDServicio;

public class Estadistica {

	public static void vueloMasVacio() {
		
		Connection con = BDServicio.abrirBaseDatos("basesDeDatos/serviciosCompanya.bd");
		String sql = "SELECT * FROM vuelo WHERE PLAZAS_RESTANTES = (SELECT MIN(PLAZAS_RESTANTES) FROM vuelo)";
		
		
	}
	
	
	
	
	
}
