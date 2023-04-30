package GRUPO6.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Nacionalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int IdNacionalidad;
	private String Descripcion;
	
	public Nacionalidad(){}
	
	public Nacionalidad(int idNacionalidad, String descripcion) {
		super();
		IdNacionalidad = idNacionalidad;
		Descripcion = descripcion;
	}

	public int getIdNacionalidad() {
		return IdNacionalidad;
	}

	public void setIdNacionalidad(int idNacionalidad) {
		IdNacionalidad = idNacionalidad;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
}

