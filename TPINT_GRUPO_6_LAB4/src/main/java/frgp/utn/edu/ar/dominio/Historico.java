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
@Table(name = "stock_deducciones_historico")
public class Historico {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="venta_c")
	private Ventas venta;

	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="stock_c")
	private Stock stock;
	
	@Column(name="cantidadStock")
	private int cantidadDeducida;


	public Historico() {
	}

	public Historico(Ventas venta, Stock stock, int cantidadStock) {
		super();
		this.venta = venta;
		this.stock = stock;
		this.cantidadDeducida = cantidadStock;
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

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public int getCantidadDeducida() {
		return cantidadDeducida;
	}

	public void setCantidadDeducida(int cantidadDeducida) {
		this.cantidadDeducida = cantidadDeducida;
	}


	
	
}
