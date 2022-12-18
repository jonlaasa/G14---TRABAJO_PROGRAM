package Enum;

public enum ZonaAsientoVuelo {

		trasera, central, delantera;
		public double precio() {
			return new double [] {0,10,30} [(this.ordinal())];
		}
}
