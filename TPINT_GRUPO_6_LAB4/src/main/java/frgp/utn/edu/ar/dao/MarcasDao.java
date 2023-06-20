package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Marcas;

public interface MarcasDao {

	public void insertar(Marcas c);
	public ArrayList<Marcas> obtenerTodos();
	public Marcas getbyID(int id);
}
