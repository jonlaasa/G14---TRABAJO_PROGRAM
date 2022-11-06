package Datos;

import java.sql.Date;
import java.util.ArrayList;

import Enum.TipoServicio;

public class ViajeCombinado extends Servicio {
	
	private int ntrasbordo;
	private ArrayList<String> nombreTrasbordo;
	
	//Constructor con parametros
	
	public ViajeCombinado(int codigo, Date fecha, int duracion, String origen, String destino, double precio,
			TipoServicio tipoServicio, int plazarRestantes, int ntrasbordo, ArrayList<String> nombreTrasbordo) {
		this.ntrasbordo = ntrasbordo;
		this.nombreTrasbordo = nombreTrasbordo;
	}
	
	
	//Constructor sin parametros usando los de la clase padre de la que hereda (SERVICIO)
	public ViajeCombinado(Date fecha,TipoServicio tipoServicio) {
		this.ntrasbordo = 0;
		this.nombreTrasbordo = new ArrayList<String> ();
	}

	public int getNtrasbordo() {
		return ntrasbordo;
	}

	public void setNtrasbordo(int ntrasbordo) {
		this.ntrasbordo = ntrasbordo;
	}

	public ArrayList<String> getNombreTrasbordo() {
		return nombreTrasbordo;
	}

	public void setNombreTrasbordo(ArrayList<String> nombreTrasbordo) {
		this.nombreTrasbordo = nombreTrasbordo;
	}


	@Override
	public String toString() {
		return  super.toString()+ "ntrasbordo=" + ntrasbordo + ", nombreTrasbordo=" + nombreTrasbordo ;
	}
	
	
	
	
	
	
	
	
	
	

}
