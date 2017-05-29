package vortex.modelos;

public class Productos {
	private String nombre;
	private String tipo;
	private double precio;
	private int cantidad;

	public Productos(String nombre, String tipo, double precio, int cantidad) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Productos(String nombre, String tipo, double precio) {
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

	public double getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return "Productos [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}

}
