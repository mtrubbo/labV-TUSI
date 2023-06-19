package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Ventas;

public interface VentasDao {
	public void insertar(Ventas a);
	public Ventas obtenerPorId(int id);
	public ArrayList<Ventas> obtenerTodos();
	public void eliminar(int id);
	public void actualizar(Ventas a);


}