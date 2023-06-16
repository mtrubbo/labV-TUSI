package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Stock;

public interface VentasDao {
	public void insertar(Stock a);
	public Stock obtenerPorNombre(String nombre);
	public Stock obtenerPorId(int id);
	public ArrayList<Stock> obtenerTodos();
	public void eliminar(int id);
	public void actualizar(Stock a);

}
