package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Ventas;

public interface VentasService {
	ArrayList<Ventas> obtenerTodos();

	Ventas obtenerPorNombre(String dni);

	void insertar(Ventas a);

    void eliminar(int id) ;

	void actualizar(Ventas a);

	Ventas getbyID(int id);

}
