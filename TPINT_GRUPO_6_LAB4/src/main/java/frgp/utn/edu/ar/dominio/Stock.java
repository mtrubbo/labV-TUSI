package frgp.utn.edu.ar.dominio;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")

public class Stock {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="articulo_c")
	private Articulo articulo;
	
	@Column(nullable = false)
	private Date fechaIngreso;
	
	@Column(nullable = false)
	private int cantidad;
	
	@Column(nullable = false)
	private float precioCompra;
	
	

	public Stock() {
		
		
	}

	public Stock(Articulo articulo, Date fechaIngreso, int cantidad, float precioCompra) {
		super();
		this.articulo = articulo;
		this.fechaIngreso = fechaIngreso;
		this.cantidad = cantidad;
		this.precioCompra = precioCompra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}
	
	
	
	

}
