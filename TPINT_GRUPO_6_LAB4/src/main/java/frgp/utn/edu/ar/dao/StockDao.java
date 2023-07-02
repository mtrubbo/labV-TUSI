package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Stock;

public interface StockDao {
	
	void insertar(Stock a);
	Stock obtenerPorNombre(String nombre);
	Stock obtenerPorId(int id);
	ArrayList<Stock> obtenerTodos();
	void eliminar(int id);
	void actualizar(Stock a);
	long artByID(int id);
	Integer obtenerStockDeArticuloMasViejo(int id);
	void deducirStock(Articulo articulo, int cantidad);
	Stock obtenerStockPorIdArticulo(int id);
	List<Stock> obtenerStocksDeArticulo(int artId);
}
