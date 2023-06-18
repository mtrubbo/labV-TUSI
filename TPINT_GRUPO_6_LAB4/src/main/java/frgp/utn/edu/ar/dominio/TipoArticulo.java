package frgp.utn.edu.ar.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articulos")
public class TipoArticulo {
	
	@Id
	@Column(name="id_tipoarticulo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtipo;
	
	@Column(nullable = false)
	private String descripcion;
	
	public TipoArticulo(){};

	public TipoArticulo(int idtipo, String descripcion) {
		super();
		this.idtipo = idtipo;
		this.descripcion = descripcion;
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
