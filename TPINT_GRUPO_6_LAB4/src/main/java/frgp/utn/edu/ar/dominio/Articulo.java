package frgp.utn.edu.ar.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articulos")

public class Articulo {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String descripcion;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idmarca")
	private Marcas marca;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idtipo")
	private TipoArticulo tipo;
	
	@ManyToMany(mappedBy = "listaArticulos", fetch = FetchType.EAGER)
	private List<Ventas> vLista;
	
	@Column(nullable = false)
	private float precio;
	
	@Column(nullable = false)
	private boolean estado;
	
	public Articulo() {}

	public Articulo(String nombre, String descripcion, Marcas marca, TipoArticulo tipo, float precio, boolean estado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.tipo = tipo;
		this.precio = precio;
		this.estado = estado;
	}

	public Articulo(int id, String nombre, String descripcion, Marcas marca, TipoArticulo tipo, List<Ventas> vLista,
			float precio, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.tipo = tipo;
		this.vLista = vLista;
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

	public List<Ventas> getvLista() {
		return vLista;
	}

	public void setvLista(List<Ventas> vLista) {
		this.vLista = vLista;
	}

}
