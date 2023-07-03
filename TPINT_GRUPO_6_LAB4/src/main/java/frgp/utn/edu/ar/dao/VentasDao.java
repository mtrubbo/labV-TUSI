package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frgp.utn.edu.ar.dominio.Ventas;
import frgp.utn.edu.ar.dtos.AVSFetch;

public interface VentasDao {
	public void insertar(Ventas a);
	public Ventas obtenerPorId(int id);
	public ArrayList<Ventas> obtenerTodos();
	public List<Ventas> obtenerPorRangoFechas(Date fechaIni, Date fechaFin);
	public void eliminar(int id);
	public void actualizar(Ventas a);
	public double obtenerTotalPorRangoFechas(Date fechaIni, Date fechaFin);
	public double obtenerGananciaTotalPorRangoFechas(Date fechaIni, Date fechaFin);
	AVSFetch fetchVentaDetails(int id);
}
