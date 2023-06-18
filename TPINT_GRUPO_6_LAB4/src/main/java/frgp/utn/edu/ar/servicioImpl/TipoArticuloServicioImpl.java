package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import frgp.utn.edu.ar.dao.ClienteDao;
import frgp.utn.edu.ar.dao.TipoArticuloDao;
import frgp.utn.edu.ar.dominio.TipoArticulo;
import frgp.utn.edu.ar.servicio.TipoArticuloServicio;

public class TipoArticuloServicioImpl implements TipoArticuloServicio {
	

	private TipoArticuloDao dataAccess = null;

	public void setDataAccess(TipoArticuloDao dataAccess) {
		this.dataAccess = dataAccess;
	}

	@Override
	public ArrayList<TipoArticulo> obtenerTodos() {
		return dataAccess.obtenerTodos();
	}

	@Override
	public void insertar(TipoArticulo c) {
		dataAccess.insertar(c);
	}

}
