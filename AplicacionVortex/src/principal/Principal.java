package principal;

import java.util.Scanner;
import java.util.Vector;

import bbdd.BD_Vortex;
import modelos.Socio;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int opc = 0;

		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");

		Vector<Socio> socio = bd.ver_socios();
		if (socio == null) {
			System.out.println("En este momento no podemos realizar la operación");

		} else {
			System.out.println("Lista de socios");
			for (int i = 0; i < socio.size(); i++)
				System.out.println((i + 1) + ".- " + socio.get(i).getUsuario());
		}
	}

}
