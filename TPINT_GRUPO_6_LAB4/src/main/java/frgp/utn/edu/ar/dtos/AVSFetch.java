package frgp.utn.edu.ar.dtos;

public class AVSFetch {
	
	private String descripcion;
	private int cantidadDeducida;
	private double precio;
	
	
	public AVSFetch() {} 
	
	public AVSFetch(String descripcion, int cantidadDeducida, double precio) {
		super();
		this.descripcion = descripcion;
		this.cantidadDeducida = cantidadDeducida;
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidadDeducida() {
		return cantidadDeducida;
	}
	public void setCantidadDeducida(int cantidadDeducida) {
		this.cantidadDeducida = cantidadDeducida;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "AVSFetch [descripcion=" + descripcion + ", cantidadDeducida=" + cantidadDeducida + ", precio=" + precio
				+ "]";
	}
	
}
