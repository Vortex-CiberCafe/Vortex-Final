package vortex.modelos;

public class Productos {
	private String nombre;
	private String tipo;
	private int precio;
	private int cantidad;

	public Productos(String nombre, String tipo, int precio, int cantidad) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Productos(String nombre, String tipo, int precio) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.cantidad = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

}
