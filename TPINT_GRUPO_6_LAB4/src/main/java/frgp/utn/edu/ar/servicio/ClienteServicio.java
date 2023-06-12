package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Cliente;

public interface ClienteServicio {

	ArrayList<Cliente> obtenerTodos();

	Cliente obtenerPorDni(String dni);

	Cliente obtenerPorId(int id);

	void insertar(Cliente c);

    void eliminar(int id) ;

	void actualizar(Cliente c);
	
}
