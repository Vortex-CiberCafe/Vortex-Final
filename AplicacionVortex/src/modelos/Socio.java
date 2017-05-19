package modelos;

import java.time.LocalDate;

public class Socio extends Persona {
	private String nombre;
	private String direccion;
	private String telefono;
	private int premium;
	private LocalDate FH_Conexion;
	private int bono;
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;

	public Socio(String dni, String correo, String usuario, String password, String nombre, String direccion,
			String telefono, int premium, LocalDate FH_Conexion, int bono, LocalDate fechaAlta, LocalDate fechaBaja) {
		super(dni, correo, usuario, password);
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
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
		this.FH_Conexion = null;
		this.bono = 0;
		this.fechaAlta = null;
		this.fechaBaja = null;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public int getPremium() {
		return premium;
	}

	public LocalDate getFH_Conexion() {
		return FH_Conexion;
	}

	public int getBono() {
		return bono;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

}
