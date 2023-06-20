package frgp.utn.edu.ar.dtos;

import frgp.utn.edu.ar.dominio.TipoArticulo;

public class TipoArticuloRequest {
	
	private int idtipo;
	private String descripcion;
	
	public TipoArticuloRequest() {}
	
	public TipoArticuloRequest(int idtipo, String descripcion) {
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

	@Override
	public String toString() {
		return "TipoArticuloRequest [idtipo=" + idtipo + ", descripcion=" + descripcion + "]";
	}
	
	
	public TipoArticulo construirTipoArticulo() {
		TipoArticulo ta = new TipoArticulo(idtipo, descripcion);
		
		return ta;
	}
	
	
}
