package frgp.utn.edu.ar.dtos;

import java.text.SimpleDateFormat;
import java.util.Date;

import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.Marcas;

public class MarcasRequest {
	
	private int idmarca;
	private String nombre;
	
	
	
	public MarcasRequest(int idmarca, String nombre) {
		super();
		this.idmarca = idmarca;
		this.nombre = nombre;
	}
	
	public int getIdmarca() {
		return idmarca;
	}
	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Marcas construirMarca(){

		Marcas m = new Marcas(idmarca, nombre);
			return m;
    }
	
	@Override
	public String toString() {
		return "MarcasRequest [idmarca=" + idmarca + ", nombre=" + nombre + "]";
	}
	
	
	
}
