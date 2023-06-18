package frgp.utn.edu.ar.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marcas {
	
	@Id
	@Column(name="id_marca")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmarca;
	
	@Column(nullable = false)
	private String nombre;
	
	public Marcas(){}

	public Marcas(int idmarca, String nombre) {
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
}
