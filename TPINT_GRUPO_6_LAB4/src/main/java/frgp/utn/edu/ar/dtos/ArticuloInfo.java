package frgp.utn.edu.ar.dtos;

import frgp.utn.edu.ar.dominio.Marcas;
import frgp.utn.edu.ar.dominio.TipoArticulo;

public class ArticuloInfo {
	private int id;
    private String nombre;
    private String descripcion;
    private Marcas marca;
    private TipoArticulo tipo;
    private float precio;
    private boolean estado;
    
    
    
	public ArticuloInfo(int id, String nombre, String descripcion, Marcas marca, TipoArticulo tipo, float precio,
			boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.tipo = tipo;
		this.precio = precio;
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Marcas getMarca() {
		return marca;
	}
	public void setMarca(Marcas marca) {
		this.marca = marca;
	}
	public TipoArticulo getTipo() {
		return tipo;
	}
	public void setTipo(TipoArticulo tipo) {
		this.tipo = tipo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
    
    
}
