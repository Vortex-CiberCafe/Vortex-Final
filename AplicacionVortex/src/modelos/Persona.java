package modelos;

public class Persona {

	private String dni;
	private String correo;
	private String usuario;
	private String password;

	public Persona(String dni, String correo, String usuario, String password) {
		this.dni = dni;
		this.correo = correo;
		this.usuario = usuario;
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getUsuario() {
		return usuario;
	}

}
