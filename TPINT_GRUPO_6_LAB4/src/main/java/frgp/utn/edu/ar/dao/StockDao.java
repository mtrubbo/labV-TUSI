package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Stock;

public interface StockDao {
	
	public void insertar(Stock a);
	public Stock obtenerPorNombre(String nombre);
	public Stock obtenerPorId(int id);
	public ArrayList<Stock> obtenerTodos();
	public void eliminar(int id);
	public void actualizar(Stock a);
	public long artByID(int id);
	public Integer obtenerStockDeArticuloMasViejo(int id);
	public void deducirStock(Articulo articulo, int cantidad);

}
