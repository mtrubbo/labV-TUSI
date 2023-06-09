package GRUPO6.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
		SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder strB = new StringBuilder();
		
		strB.append("ID Biblioteca: " + this.Id + "\n");
		strB.append("Fecha alta: " + dFormat.format(this.FechaAlta) + "\n");
		strB.append("Estado: "+ this.Estado + "\n");
		strB.append("Titulo Libro: " + this.libro.getTitulo() + "\n\n");
		
		return strB.toString();
	}

}

