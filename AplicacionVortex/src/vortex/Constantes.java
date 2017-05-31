package vortex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public static boolean validarDNI(String nif) {

		if (nif.toUpperCase().startsWith("X") || nif.toUpperCase().startsWith("Y") || nif.toUpperCase().startsWith("Z"))
			nif = nif.substring(1);

		Pattern nifPattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		Matcher m = nifPattern.matcher(nif);
		if (m.matches()) {
			String letra = m.group(2);
			// Extraer letra del NIF
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			int dni = Integer.parseInt(m.group(1));
			dni = dni % 23;
			String reference = letras.substring(dni, dni + 1);

			if (reference.equalsIgnoreCase(letra)) {
				// System.out.println("son iguales. Es NIF. " + letra + " " +
				// reference);
				return true;
			} else {
				// System.out.println("NO son iguales. NO es NIF. " + letra + "
				// " + reference);
				return false;
			}
		} else
			return false;
	}
}
