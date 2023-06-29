package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Stock;

public interface StockServicio {
	
	ArrayList<Stock> obtenerTodos();
	Stock obtenerPorNombre(String nombre);
	void insertar(Stock a);
    void eliminar(int id) ;
	void actualizar(Stock a);
	Stock getbyID(int id);	
	long artByID(int id);	
	Integer stockArtByID(int id);	
	void deducirStock(Articulo articulo, int cantidad);


}
