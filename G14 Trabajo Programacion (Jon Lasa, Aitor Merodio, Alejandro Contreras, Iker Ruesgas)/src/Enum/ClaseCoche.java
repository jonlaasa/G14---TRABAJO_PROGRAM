package Enum;

public enum ClaseCoche {

	gamaBaja, gamaMedia, gamaAlta;
	public double precio() {
		return new double [] {20,35,60} [(this.ordinal())];
	}
}
