package com.trabajoUno.TiposEntrada.Teatro;

public class Actor {
	private String Nombre;
	private String Apellido;
	
	
	
	public Actor(String nombre, String apellido) {
		super();
		this.Nombre = nombre;
		this.Apellido = apellido;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	
}
