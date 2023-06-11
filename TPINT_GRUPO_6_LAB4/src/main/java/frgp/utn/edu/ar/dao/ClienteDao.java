package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Cliente;


public interface ClienteDao {

	public void insertar(Cliente c);
	public Cliente obtenerPorDni(String dni);
	public Cliente obtenerPorId(int id);
	public ArrayList<Cliente> obtenerTodos();
	public void eliminar(int id);
	public void actualizar(Cliente c);
	

}
