package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Articulo;

public interface ArticuloServicio {
	
	ArrayList<Articulo> obtenerTodos();

	Articulo obtenerPorNombre(String dni);

	void insertar(Articulo a);

    void eliminar(int id) ;

	void actualizar(Articulo a);

}
