package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Marcas;

public interface MarcasServicio {
	ArrayList<Marcas> obtenerTodos();

	void insertar(Marcas c);
	
	Marcas getbyID(int id);
}
