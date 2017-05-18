package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import modelos.Socio;

public class BD_Vortex extends BD_Conector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Vortex(String file) {
		super(file);
	}

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

	public int anadir_Socio(Socio socio) {
		// ID_Socio DNI Nombre Direccion Telefono Correo Nick
		// Password Premium FH_Conexion Fecha_alta Bono Fecha_baja

		String cadenaSQL = "INSERT INTO socio (DNI, Nombre, Direccion, Telefono, Correo, Nick,Password ,Premium ,FH_Conexion, Fecha_alta, Bono, Fecha_baja) VALUES('"
				+ socio.getDni() + "','" + socio.getNombre() + "','" + socio.getDireccion() + "','"
				+ socio.getTelefono() + "','" + socio.getCorreo() + "','" + socio.getUsuario() + "','"
				+ socio.getPassword() + "','" + socio.getPremium() + "','" + socio.getFH_Conexion() + "','"
				+ socio.getFechaAlta() + "','" + socio.getBono() + "','" + socio.getFechaBaja() + "')";

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
			}
			s.close();
			this.cerrar();
			return 1;
		} catch (SQLException e) {
			return -1;
		}
	}

	public int login(String usu, String password) {

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

}

// INSERT INTO socios (DNI, Nombre, Direccion, Telefono, Correo, Nick,Password
// ,Premium ,FH_Conexion, Fecha_alta, Bono, Fecha_baja)
// VALUES('a','a','a','null','a','a','a','0','0000-00-00','0000-00-00','0','0000-00-00')
