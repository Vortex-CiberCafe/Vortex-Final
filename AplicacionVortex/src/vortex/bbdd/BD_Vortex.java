package vortex.bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import vortex.Constantes;
import vortex.modelos.Productos;
import vortex.modelos.Socio;

public class BD_Vortex extends BD_Conector {

	private static Statement s;
	private static ResultSet reg;
	private static int res;

	public BD_Vortex(String file) {
		super(file);
	}

	// metodo que devuelve un vector con todos los socios del cibercafe
	public Vector<Socio> ver_socios() {
		String cadenaSQL = "Select * from socio";
		Vector<Socio> socio = new Vector<Socio>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				java.sql.Date f = reg.getDate("FH_Conexion");
				LocalDate FH_Conexion = f.toLocalDate();
				java.sql.Date f1 = reg.getDate("Fecha_alta");
				LocalDate Fecha_alta = f1.toLocalDate();
				java.sql.Date f2 = reg.getDate("Fecha_baja");
				LocalDate Fecha_baja = f2.toLocalDate();
				socio.add(new Socio(reg.getString("dni"), reg.getString("correo"), reg.getString("nick"),
						reg.getString("password"), reg.getString("nombre"), reg.getString("direccion"),
						reg.getString("telefono"), reg.getInt("premium"), FH_Conexion, reg.getInt("bono"), Fecha_alta,
						Fecha_baja));
			}
			s.close();
			this.cerrar();
			return socio;
		} catch (SQLException e) {
			return null;
		}
	}

	// metodo para A�adir Socios
	public int anadir_Socio(Socio socio) {
		// ID_Socio DNI Nombre Direccion Telefono Correo Nick
		// Password Premium FH_Conexion Fecha_alta Bono Fecha_baja

		String cadenaSQL = "INSERT INTO socio (DNI, Nombre, Direccion, Telefono, Correo, Nick,Password ,Premium ,FH_Conexion, Fecha_alta, Bono, Fecha_baja) VALUES('"
				+ socio.getDni() + "','" + socio.getNombre() + "','" + socio.getDireccion() + "','"
				+ socio.getTelefono() + "','" + socio.getCorreo() + "','" + socio.getUsuario() + "','"
				+ socio.getPassword() + "','" + socio.getPremium() + "','" + socio.getFH_Conexion() + "','"
				+ socio.getFechaAlta() + "','" + socio.getBono() + "','" + socio.getFechaBaja() + "')";
		// System.out.println(cadenaSQL);
		try {
			this.abrir();
			s = c.createStatement();
			res = s.executeUpdate(cadenaSQL);
			while (reg.next()) {
			}
			s.close();
			this.cerrar();
			return 1;
		} catch (SQLException e) {
			return -1;
		}
	}

	// metodo para iniciar sesion como Socio
	public int loginSocio(String usu, String password) {

		String cadenaSQL = "Select * from socio where nick='" + usu + "' and password='" + password + "'";
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				return 1;
			}
			s.close();
			this.cerrar();
			return 0;
		} catch (SQLException e) {
			return -1;
		}
	}

	// metodo para iniciar sesion como Administrador
	public int loginAdmin(String usu, String password) {

		String cadenaSQL = "Select * from administrador where Admin_user='" + usu + "' and Admin_password='" + password
				+ "'";
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				return 1;
			}
			s.close();
			this.cerrar();
			return 0;
		} catch (SQLException e) {
			return -1;
		}
	}

	// metodo para iniciar sesion como dependiente
	public int loginDependiente(String usu, String password) {

		String cadenaSQL = "Select * from dependiente where usuario='" + usu + "' and password='" + password + "'";
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				return 1;
			}
			s.close();
			this.cerrar();
			return 0;
		} catch (SQLException e) {
			return -1;
		}
	}

	// metodo para cambiar la contrase�a desde el panel de Socios
	public int updatePassSocio(String password, String passwordNueva1, String passwordNueva2) {
		String cadenaSQL = "Select * from socio where nick='" + Constantes.user + "' and password='" + password + "'";
		// System.out.println(cadenaSQL);
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				String SQL = "update socio set  password='" + passwordNueva1 + "' where nick='" + Constantes.user + "'";
				// System.out.println(SQL);
				try {
					this.abrir();
					s = c.createStatement();
					int filas = s.executeUpdate(SQL);
					s.close();
					this.cerrar();
					return filas;
				} catch (SQLException e) {
					return -1;
				}
			}
			s.close();
			this.cerrar();
			return 0;
		} catch (SQLException e) {
			return -1;
		}
	}

	public int bajaSocio(String usu) {

		String cadenaSQL = "delete from socio where nick='" + usu + "'";
		// System.out.println(cadenaSQL);
		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			return -1;
		}
	}

	public int darConexion(String usu, int minutos) {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");

		String cadenaSQL = "update socio set minutos=" + bd.getMinutoSocio(usu) + " + " + minutos
				+ " where nick='" + usu + "'";
		// System.out.println(cadenaSQL);
		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			return -1;
		}
	}

	public int guardarConexion(String usu, int minutos) {
		String cadenaSQL = "update socio set minutos=" + Constantes.minutos + " where nick='" + usu + "'";
		// System.out.println(cadenaSQL);
		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			return -1;
		}
	}

	public int updateNick(String usu) {
		String cadenaSQL = "update socio set nick='" + usu + "' where nick='" + Constantes.user + "'";
		// System.out.println(cadenaSQL);
		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			return -1;
		}
	}

	// metodo para pasar los minutos
	public int getMinutoSocio(String nick) {
		int minutos = 0;
		String cadenaSQL = "Select minutos from socio where nick='" + nick + "'";
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if (reg.next()) {
				minutos = reg.getInt("minutos");
			}

			s.close();
			this.cerrar();
			return minutos;
		} catch (SQLException e) {
			return -1;
		}
	}

	public LocalDate ver_ultimaConexion(String usu) {
		String cadenaSQL = "Select FH_Conexion from socio where nick='" + usu + "'";
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			LocalDate FH_Conexion = null;
			while (reg.next()) {
				java.sql.Date f = reg.getDate("FH_Conexion");
				FH_Conexion = f.toLocalDate();
			}
			s.close();
			this.cerrar();
			return FH_Conexion;
		} catch (SQLException e) {
			return null;
		}
	}

	public int ver_Tiempos(String usu) {
		String cadenaSQL = "Select minutos from socio where nick='" + usu + "'";
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			int minutos = -1;
			while (reg.next()) {
				minutos = reg.getInt("minutos");
			}
			s.close();
			this.cerrar();
			return minutos;
		} catch (SQLException e) {
			return -2;
		}
	}

	public Vector<Productos> ver_Productos() {
		String cadenaSQL = "Select * from productos";
		Vector<Productos> productos = new Vector<Productos>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				productos.add(new Productos(reg.getString("nombre"), reg.getString("tipo"), reg.getInt("precio"),
						reg.getInt("cantidad")));
			}
			s.close();
			this.cerrar();
			return productos;
		} catch (SQLException e) {
			return null;
		}
	}

	public double cobrar(String producto, double cantidad1) {
		String cadenaSQL = "Select precio from productos where nombre='" + producto + "'";
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			double precio = 0;
			while (reg.next()) {
				precio = reg.getDouble("precio");
				precio = precio * cantidad1;
			}
			s.close();
			this.cerrar();
			return precio;
		} catch (SQLException e) {
			return -1;
		}
	}

	public int verCodSocio(String usu) {
		String cadenaSQL = "Select ID_Socio from socio where nick='" + usu + "'";

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			int id = -1;
			while (reg.next()) {
				id = reg.getInt("ID_Socio");
			}
			s.close();
			this.cerrar();
			return id;
		} catch (SQLException e) {
			return -2;
		}
	}

	public int verCodProducto(String nombre) {
		String cadenaSQL = "Select ID_Producto from productos where nombre='" + nombre + "'";

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			int id = -1;
			while (reg.next()) {
				id = reg.getInt("ID_Producto");
			}
			s.close();
			this.cerrar();
			return id;
		} catch (SQLException e) {
			return -2;
		}
	}

	public int verStock(String nombre) {
		String cadenaSQL = "Select cantidad from productos where nombre='" + nombre + "'";

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			int cantidad = -1;
			while (reg.next()) {
				cantidad = reg.getInt("Cantidad");
			}
			s.close();
			this.cerrar();
			return cantidad;
		} catch (SQLException e) {
			return -2;
		}
	}

	public int anadirCompra(int idSocio, int idProducto, int cantidad) {
		String cadenaSQL = "insert into compras values(null," + idSocio + "," + idProducto + "," + cantidad + ")";

		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			return -1;
		}
	}

	public int restarProductos(int idProducto, int cantidad) {
		String cadenaSQL = "select cantidad from productos where id_Producto=" + idProducto;

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			int numProductos = -1;
			while (reg.next()) {
				numProductos = reg.getInt("Cantidad");
			}
			int numDisponibles = numProductos - cantidad;
			String SQL = "update productos set cantidad=" + numDisponibles + " where id_Producto=" + idProducto;

			try {
				this.abrir();
				s = c.createStatement();
				int filas = s.executeUpdate(SQL);

			} catch (SQLException e) {
				return -1;
			}

			s.close();
			this.cerrar();
			return 1;
		} catch (SQLException e) {
			return -2;
		}
	}

	public int pedirProductos(int idProducto, int cantidad) {
		String cadenaSQL = "select cantidad from productos where id_Producto=" + idProducto;

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			int numProductos = -1;
			while (reg.next()) {
				numProductos = reg.getInt("Cantidad");
			}
			int numDisponibles = numProductos + cantidad;
			String SQL = "update productos set cantidad=" + numDisponibles + " where id_Producto=" + idProducto;

			try {
				this.abrir();
				s = c.createStatement();
				int filas = s.executeUpdate(SQL);

			} catch (SQLException e) {
				return -1;
			}

			s.close();
			this.cerrar();
			return 1;
		} catch (SQLException e) {
			return -2;
		}
	}

}
