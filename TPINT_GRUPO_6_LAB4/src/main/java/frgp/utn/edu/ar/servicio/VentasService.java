package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Ventas;

public interface VentasService {
	
	ArrayList<Ventas> obtenerTodos();

	void insertar(Ventas a);

    void eliminar(int id) ;
    
    void actualizar (Ventas id);

	Ventas getbyID(int id);

}
