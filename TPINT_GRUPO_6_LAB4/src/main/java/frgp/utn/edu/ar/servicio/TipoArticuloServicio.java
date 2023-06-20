package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.TipoArticulo;

public interface TipoArticuloServicio {
	
	ArrayList<TipoArticulo> obtenerTodos();

	void insertar(TipoArticulo c);
	
	TipoArticulo getbyID(int id);
}
