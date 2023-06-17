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
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    @Column(nullable = false)
	private boolean estado;
    
    public Ventas() {}

	public Ventas(Date fecha, double montoTotal, Cliente cliente, boolean estado) {
		super();
		this.fecha = fecha;
		this.montoTotal = montoTotal;
		this.cliente = cliente;
		this.estado = estado;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	};
	
	
    
    
    	
    
}
