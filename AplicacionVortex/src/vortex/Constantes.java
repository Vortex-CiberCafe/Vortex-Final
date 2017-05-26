package vortex;

public class Constantes {

	public static String user;

	public static double cajaAdmin = 0;
	
	public static double cajaDependiente = 0;

	public static double precio(int tiempo) {
		double precio = 0;

		precio = tiempo / 30;

		return precio;
	}
	
	/*
		public static double precioProducto(int cantidad) {
			
			// Sacar el precio de la BBDD y multiplicarlo por -> int cantidad
			
		}
	*/
	
	
}
