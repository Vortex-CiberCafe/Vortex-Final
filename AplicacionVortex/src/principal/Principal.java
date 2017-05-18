package principal;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import bbdd.BD_Vortex;
import modelos.Socio;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		boolean Conectado = false;
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");
		do {
			System.out.println("Introduce el nombre de usuario");
			String usu = sc.nextLine();
			System.out.println("Introduce la contraseña");
			String pass = sc.nextLine();
			int filas = bd.login(usu, pass);
			switch (filas) {
			case 1:
				System.out.println("\nConectado");
				Conectado = true;
				break;
			case 0:
				System.out.println("\nError al iniciar sesion, los campos usuario o contraseña incorrectos");
				break;
			case -1:
				System.out.println("\nNo estas conectado");
				break;

			}

		} while (Conectado == false);
		if (Conectado == true) {
			do {
				System.out.println("\n\nGESTIÓN VORTEX - Cibercafé");
				System.out.println("***************");
				System.out.println("1.Nuevo Socio\n" + "2.Ver Socios\n"
				// + "3.Borrar Alumno\n"
						+ " ");
				System.out.println("Teclea opción: ");
				try {
					opc = sc.nextInt();
				} catch (NumberFormatException e) {
					System.out.println("Opcion incorrecta");
					opc = 0;
				} catch (InputMismatchException e) {
					System.out.println("Debes introducir número 1-5");
					opc = 0;
				}

				sc.nextLine();
				switch (opc) {
				case 1:
					System.out.println("\n\nALTA SOCIO");
					System.out.print("Introduce DNI\t");
					String dni = sc.nextLine();
					System.out.print("Introduce nombre\t");
					String nombre = sc.nextLine();
					System.out.print("Introduce direccion\t");
					String direccion = sc.nextLine();
					System.out.print("Introduce número de telefono\t");
					String telefono = sc.nextLine();
					System.out.print("Introduce correo electronico\t");
					String correo = sc.nextLine();
					System.out.print("Introduce nombre de usuario\t");
					String nick = sc.nextLine();
					System.out.print("Introduce la contraseña del usuario\t");
					String password = sc.nextLine();

					Socio socio = new Socio(dni, correo, nick, password, nombre, direccion, telefono, 0,
							LocalDate.now(), 0, LocalDate.now(), LocalDate.now());
					int filas = bd.anadir_Socio(socio);
					switch (filas) {
					case 1:
						System.out.println("\nAlumno añadido");
						break;
					case 0:
						System.out.println("\nNo añadido");
						break;
					case -1:
						System.out.println("\nProblemas técnicos");
						break;

					}
					break;
				case 2:
					Vector<Socio> socios = bd.ver_socios();
					if (socios == null) {
						System.out.println("En este momento no podemos realizar la operación");

					} else {
						System.out.println("Lista de socios");
						for (int i = 0; i < socios.size(); i++)
							System.out.println((i + 1) + ".- " + socios.get(i).getUsuario());
					}

				}
			} while (opc != 8);
		} else {
			System.out.println("No estas conectado a la aplicacion");
		}
	}

}
