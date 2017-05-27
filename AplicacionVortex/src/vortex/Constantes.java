package vortex;

public class Constantes {

	public static String user;

	public static double cajaAdmin = 0;
	
	public static double cajaDependiente = 0;
	
	public static double cajaTotal = 0;
	
	public static int minutos;

	public static double precio(int tiempo) {
		double precio = 0;

		precio = tiempo / 30;

		return precio;
	}
	
	
}
