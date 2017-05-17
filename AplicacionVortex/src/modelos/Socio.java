package modelos;

public class Socio extends Persona {
	private String nombre;
	private String direccion;
	private String telefono;
	private int premium;
	private String FH_Conexion;
	private int bono;
	private String fechaAlta;
	private String fechaBaja;

	public Socio(String dni, String correo, String usuario, String password, String nombre, String direccion,
			int premium, String FH_Conexion, int bono, String fechaAlta, String fechaBaja) {
		super(dni, correo, usuario, password);
		this.nombre = nombre;
		this.direccion = direccion;
		this.premium = premium;
		this.FH_Conexion = FH_Conexion;
		this.bono = bono;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;

	}

	public Socio(String dni, String correo, String usuario, String password, String nombre) {
		super(dni, correo, usuario, password);
		this.nombre = nombre;
		this.direccion = "";
		this.premium = 0;
		this.FH_Conexion = "0000-00-00";
		this.bono = 0;
		this.fechaAlta = "0000-00-00";
		this.fechaBaja = "0000-00-00";
	}

}
