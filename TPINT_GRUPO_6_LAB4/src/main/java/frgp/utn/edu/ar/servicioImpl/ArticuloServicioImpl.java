package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import frgp.utn.edu.ar.dao.ArticuloDao;
import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.servicio.ArticuloServicio;

public class ArticuloServicioImpl implements ArticuloServicio {

	private ArticuloDao dataAccess = null;

	public void setDataAccess(ArticuloDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<Articulo> obtenerTodos() {
		return dataAccess.obtenerTodos();
	}

	@Override
	public Articulo obtenerPorNombre(String nombre) {
		return dataAccess.obtenerPorNombre(nombre);
	}

	@Override
	public void insertar(Articulo a) {
		 dataAccess.insertar(a);
		
	}

	@Override
	public void eliminar(int id) {
		dataAccess.eliminar(id);
		
	}

	@Override
	public void actualizar(Articulo c) {
		dataAccess.actualizar(c);
		
	}

}
