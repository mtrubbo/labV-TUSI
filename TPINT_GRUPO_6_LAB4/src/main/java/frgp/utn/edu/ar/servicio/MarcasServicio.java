package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Marcas;

public interface MarcasServicio {
	ArrayList<Marcas> obtenerTodos();

	Marcas obtenerPorDni(String dni);

	Marcas obtenerPorId(int id);

	void insertar(Marcas c);

    void eliminar(int id) ;

	void actualizar(Marcas c);
}
