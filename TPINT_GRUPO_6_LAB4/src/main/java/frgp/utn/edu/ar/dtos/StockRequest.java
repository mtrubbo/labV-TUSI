package frgp.utn.edu.ar.dtos;

import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Stock;

public class StockRequest {
	
	private int id;
	private Articulo articulo;
	private int cantidad;
	private float precioVenta;
	


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


	@Override
	public String toString() {
		return "ID: " + id + ", Articulo: " + articulo.getNombre() + ", Cantidad: " + cantidad + ", Precio de Venta: $" + precioVenta;
				
	}


	public Stock construirStock(){
        Stock s = new Stock(articulo, cantidad, precioVenta);
        
        if(id != 0){
            s.setId(id);
        }
        
        return s;
    }

}
