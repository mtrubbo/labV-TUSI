package frgp.utn.edu.ar.dtos;

import java.util.Date;

import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Stock;

public class StockRequest {
	




	private int id;
	private Articulo articulo;
	private Date fechaIngreso;
	private int cantidad;
	private float precioCompra;
	
	
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




	public Stock construirStock(){
        Stock s = new Stock(articulo, fechaIngreso, precioCompra, cantidad);
        
        if(id != 0){
            s.setId(id);
        }
        
        return s;
    }

	@Override
	public String toString() {
		return "StockRequest [id=" + id + ", articulo=" + articulo.getNombre() + ", fechaIngreso=" + fechaIngreso + ", cantidad="
				+ cantidad + ", precioCompra=" + precioCompra + "]";
	}
}
