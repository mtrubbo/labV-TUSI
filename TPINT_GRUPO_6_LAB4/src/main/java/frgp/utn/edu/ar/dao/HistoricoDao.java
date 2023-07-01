package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Historico;
import frgp.utn.edu.ar.dominio.Stock;
import frgp.utn.edu.ar.dominio.Ventas;

public interface HistoricoDao {
	
	public void insertar(Historico h);
	public ArrayList<Historico> obtenerPorIDVenta(int idVenta);
	public ArrayList<Historico> obtenerTodos();
	public boolean obtenerEstado(int idVenta); 

}
