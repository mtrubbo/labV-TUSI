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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Ventas {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
	private Date fecha;
    @Column(nullable = false)
    private double montoTotal;
    @Column(nullable = false)
    private int cantidadVendida;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="id_articulo")
    private Articulo art;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    
    public Ventas() {}

	public Ventas(int id, Date fecha, double montoTotal, int cantidadVendida, Articulo art, Cliente cliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.montoTotal = montoTotal;
		this.cantidadVendida = cantidadVendida;
		this.art = art;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	public Articulo getArt() {
		return art;
	}

	public void setArt(Articulo art) {
		this.art = art;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	};
    
    
    	
    
}
