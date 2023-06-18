package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.TipoArticulo;

public interface TipoArticuloServicio {
	
	ArrayList<TipoArticulo> obtenerTodos();

	TipoArticulo obtenerPorDni(String dni);
	TipoArticulo obtenerPorId(int id);

	void insertar(TipoArticulo c);

    void eliminar(int id) ;

	void actualizar(TipoArticulo c);

}
