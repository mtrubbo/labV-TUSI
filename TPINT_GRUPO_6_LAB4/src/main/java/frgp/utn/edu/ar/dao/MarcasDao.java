package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.Marcas;

public interface MarcasDao {

	public void insertar(Marcas c);
	public Marcas obtenerPorDni(String dni);
	public Marcas obtenerPorId(int id);
	public ArrayList<Marcas> obtenerTodos();
	public void eliminar(int id);
	public void actualizar(Marcas c);
}
