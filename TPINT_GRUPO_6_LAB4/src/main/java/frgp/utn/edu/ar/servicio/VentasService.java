package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frgp.utn.edu.ar.dominio.Ventas;
import frgp.utn.edu.ar.dtos.ConsultaVentasResponse;

public interface VentasService {
	
	ArrayList<Ventas> obtenerTodos();
	List<ConsultaVentasResponse> obtenerPorRangoDeFechas(Date fechaIni, Date fechaFin);

	void insertar(Ventas a);

    void eliminar(int id) ;
    
    void actualizar (Ventas id);

	Ventas getbyID(int id);

}
