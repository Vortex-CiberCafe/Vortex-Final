package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				socio.add(new Socio(reg.getString("dni"), reg.getString("correo"), reg.getString("nick"),
						reg.getString("password"), reg.getString("nombre"), reg.getString("direccion"),
						reg.getInt("premium"), reg.getString("FH_Conexion"), reg.getInt("bono"),
						reg.getString("Fecha_alta"), reg.getString("Fecha_baja")));

			}
			s.close();
			this.cerrar();
			return socio;
		} catch (SQLException e) {
			return null;
		}

	}
}
