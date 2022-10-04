package servicios;

import enumeraciones.TipoCoche;
import enumeraciones.TipoServicio;

public class RentingCoche extends Servicio {

	private int diasAlquilado;
	private TipoCoche tipoCoche;
	
	public RentingCoche(double precio, TipoServicio tipoServicio, int diasAlquilado, TipoCoche tipoCoche) {
		super(precio, tipoServicio);
		this.diasAlquilado = diasAlquilado;
		this.tipoCoche = tipoCoche;
	}

	
	
	
	public int getDiasAlquilado() {
		return diasAlquilado;
	}

	public void setDiasAlquilado(int diasAlquilado) {
		this.diasAlquilado = diasAlquilado;
	}

	public TipoCoche getTipoCoche() {
		return tipoCoche;
	}

	public void setTipoCoche(TipoCoche tipoCoche) {
		this.tipoCoche = tipoCoche;
	}




	@Override
	public String toString() {
		return "RentingCoche [diasAlquilado=" + diasAlquilado + ", tipoCoche=" + tipoCoche + "]";
	}

	

	
	
}
