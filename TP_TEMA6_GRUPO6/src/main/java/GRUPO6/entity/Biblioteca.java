package GRUPO6.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Biblioteca implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int IdLibro;
	private Date FechaAlta;
	private int Estado;
	
	public Biblioteca(){}

	public Biblioteca(int idLibro, Date fechaAlta, int estado) {
		super();
		IdLibro = idLibro;
		FechaAlta = fechaAlta;
		Estado = estado;
	}

	public int getIdLibro() {
		return IdLibro;
	}

	public void setIdLibro(int idLibro) {
		IdLibro = idLibro;
	}

	public Date getFechaAlta() {
		return FechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		FechaAlta = fechaAlta;
	}

	public int isEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "ID= " + IdLibro + ", Fecha de alta= " + FechaAlta + ", Estado= " + Estado + "";
	}
	
}

