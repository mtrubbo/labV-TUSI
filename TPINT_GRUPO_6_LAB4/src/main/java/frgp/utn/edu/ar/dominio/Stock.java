package frgp.utn.edu.ar.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")

public class Stock {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="articulo_c")
	private Articulo articulo;
	
	@Column(nullable = false)
	private int cantidad;
	
	@Column(nullable = false)
	private float precioVenta;
	
	
	
	public Stock() {
		
	}


	public Stock(Articulo articulo, int cantidad, float precioVenta) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}


}
