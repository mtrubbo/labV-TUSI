package frgp.utn.edu.ar.dominio;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ventas")
public class Ventas {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
	private Date fecha;
    @Column(nullable = false)
    private double montoTotal;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(
        name = "ventas_articulos",
        joinColumns = {@JoinColumn(name = "venta_id")},
        inverseJoinColumns = {@JoinColumn(name = "articulo_id")}
    )
    private Set<Articulo> listaArticulos;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "venta")
	private List<Historico> historialDeduccionesStock;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    @Column(nullable = false)
	private boolean estado;
    
    @Column(nullable = false)
    private double ganancia;
    
    public Ventas() {}

	public Ventas(Date fecha, double montoTotal, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.montoTotal = montoTotal;
		this.cliente = cliente;
		this.estado = true;
		this.listaArticulos = new HashSet<>();
		this.historialDeduccionesStock = new ArrayList<>();
	}

   	@Transient
    public List<Integer> getListaArticulosIds() {
        List<Integer> articuloIds = new ArrayList<>();
        for (Articulo articulo : listaArticulos) {
            articuloIds.add(articulo.getId());
        }
        return articuloIds;
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

	public double getGanancia() {
		return ganancia;
	}

	public void setGanancia(double ganancia) {
		this.ganancia = ganancia;
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
	}

	public Set<Articulo> getListaArticulos() {
		return listaArticulos;
	}

	public List<Historico> getHistorialDeduccionesStock() {
		return historialDeduccionesStock;
	}

	public double calcularMontoTotal() {
		double suma = 0;
		for (Articulo art :
				this.listaArticulos) {
			suma += art.getPrecio();
		}

		return suma;
	}
	
}
