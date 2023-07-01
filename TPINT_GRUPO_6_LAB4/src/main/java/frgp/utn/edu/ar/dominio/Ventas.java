package frgp.utn.edu.ar.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
        name = "ventas_articulos",
        joinColumns = {@JoinColumn(name = "venta_id")},
        inverseJoinColumns = {@JoinColumn(name = "articulo_id")}
    )
    private List<Articulo> listaArticulos;
   
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    @Column(nullable = false)
	private boolean estado;
    
    @Column(nullable = false)
    private float ganancia;
    
    public Ventas() {}

	public Ventas(Date fecha, double montoTotal, Cliente cliente, boolean estado) {
		super();
		this.fecha = fecha;
		this.montoTotal = montoTotal;
		this.cliente = cliente;
		this.estado = estado;
	}
	
	public Ventas(Date fecha, double montoTotal, List<Articulo> listaArticulos, Cliente cliente, float ganancia,
			boolean estado) {
		super();
		this.fecha = fecha;
		this.ganancia = ganancia;
		this.montoTotal = montoTotal;
		this.listaArticulos = listaArticulos;
		this.cliente = cliente;
		this.estado = estado;

	}    @Transient
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
	 
	
	
	public float getGanancia() {
		return ganancia;
	}

	public void setGanancia(float ganancia) {
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

	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	};


	public double calcularMontoTotal() {
		double suma = 0;
		for (Articulo art :
				this.listaArticulos) {
			suma += art.getPrecio();
		}

		return suma;
	}
	
}
