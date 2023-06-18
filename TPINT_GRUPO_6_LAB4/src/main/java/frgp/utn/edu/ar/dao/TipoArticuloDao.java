package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.TipoArticulo;

public interface TipoArticuloDao {
	
	public void insertar(TipoArticulo a);
	public TipoArticulo obtenerPorNombre(String nombre);
	public TipoArticulo obtenerPorId(int id);
	public ArrayList<TipoArticulo> obtenerTodos();
	public void eliminar(int id);
	public void actualizar(TipoArticulo a);

}
