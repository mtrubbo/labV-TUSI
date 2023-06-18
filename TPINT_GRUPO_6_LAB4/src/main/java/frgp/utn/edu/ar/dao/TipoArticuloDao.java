package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.TipoArticulo;

public interface TipoArticuloDao {
	
	public void insertar(TipoArticulo a);
	public ArrayList<TipoArticulo> obtenerTodos();
}
