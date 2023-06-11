package frgp.utn.edu.ar.dtos;

import frgp.utn.edu.ar.dominio.Articulo;

public class ArticuloRequest {
	
	private String nombre;
	private String descripcion;
	private String marca;
	private String tipo;
	private float precio;
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Descripcion: " + descripcion + ", Marca: " + marca
				+ ", Tipo: " + tipo + ", Precio: " + precio + "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public Articulo construirArticulo(){
        return new Articulo(nombre, descripcion, marca, tipo, precio);
    }

}
