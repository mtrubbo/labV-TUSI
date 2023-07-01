package frgp.utn.edu.ar.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historicos")
public class Historico {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="venta_c")
	private Ventas venta;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="articulo_c")
	private Articulo articulo;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="stock_c")
	private Stock stock;
	
	@Column(name="cantidadStock")
	private int cantidadStock;
	
	@Column(name="estado")
	private Boolean estado; //true: Venta ok / false: devolución
	
	public Historico(int id, Ventas venta, Articulo articulo, Stock stock, int cantidadStock, Boolean estado) {
		super();
		this.id = id;
		this.venta = venta;
		this.articulo = articulo;
		this.stock = stock;
		this.cantidadStock = cantidadStock;
		this.estado = estado;
	}
		

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ventas getVenta() {
		return venta;
	}

	public void setVenta(Ventas venta) {
		this.venta = venta;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public int getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}


	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	
	
}
