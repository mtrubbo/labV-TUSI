package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.dominio.Historico;

public interface HistoricoDao {
	
	void insertar(Historico h);
	List<Historico> obtenerHistoricoDeVenta(int idVenta);
	List<Historico> obtenerTodos();
}
