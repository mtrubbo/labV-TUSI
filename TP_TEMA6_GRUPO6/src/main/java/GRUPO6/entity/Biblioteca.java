package GRUPO6.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Biblioteca implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int Id;
	private Date FechaAlta;
	private int Estado;
	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="Libro")
    private Libro libro;
	
	public Biblioteca(){}

	public Biblioteca(int idLibro, Date fechaAlta, int estado, Libro libro) {
		super();
		Id = idLibro;
		FechaAlta = fechaAlta;
		Estado = estado;
		this.libro = libro;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id= id;
	}

	public Date getFechaAlta() {
		return FechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		FechaAlta = fechaAlta;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "Id= " + Id + ", Fecha de alta= " + FechaAlta + ", Estado= " + Estado + ", Libro=" + libro.getTitulo()
				+ "";
	}

	
	
}

