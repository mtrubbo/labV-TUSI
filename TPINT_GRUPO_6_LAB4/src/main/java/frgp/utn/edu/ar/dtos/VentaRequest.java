package frgp.utn.edu.ar.dtos;

import java.util.Date;
import java.util.List;

import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.Ventas;

public class VentaRequest {
	
	private int id;
	private Date fecha;
    private double montoTotal;
    private Cliente cliente;
    private List<Articulo> listaArticulos;
    private double ganancias;
	
	@Override
	public String toString() {
		return "Fecha = " + fecha + ", Monto Total = " + montoTotal + ", Cliente = " + cliente.getDni();
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
	
	
	
	public double getGanancias() {
		return ganancias;
	}
	public void setGanancias(double ganancias) {
		this.ganancias = ganancias;
	}
	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}
	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
	public Ventas construirVenta(){
		Ventas  a = new Ventas(fecha, montoTotal, cliente);

        if(id != 0){
            a.setId(id);
        }
        return a;
    }
	
	public Ventas construirVentaConArts(){
		Ventas  a = new Ventas(fecha, montoTotal, listaArticulos, cliente, ganancias);

        if(id != 0){
            a.setId(id);
        }
        return a;
    }

}
