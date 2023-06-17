package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Articulo;

public interface ArticuloDao {
	
	public void insertar(Articulo a);
	public Articulo obtenerPorNombre(String nombre);
	public Articulo obtenerPorId(int id);
	public ArrayList<Articulo> obtenerTodos();
	public void eliminar(int id);
	public void actualizar(Articulo a);

}
