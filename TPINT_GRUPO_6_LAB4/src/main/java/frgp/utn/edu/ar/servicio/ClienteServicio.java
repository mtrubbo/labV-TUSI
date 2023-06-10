package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Cliente;

public interface ClienteServicio {

	ArrayList<Cliente> obtenerTodos();

	Cliente obtenerPorDni(String dni);

	void insertar(Cliente c);

    void eliminar(String dni) ;

	void actualizar(Cliente c);
	
}
