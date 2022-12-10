package Enum;

public enum ZonaAsientoVuelo {

		delantera, central, trasera;
		public double precio() {
			return new double [] {0,10,30} [(this.ordinal())];
		}
}
