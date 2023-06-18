package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import frgp.utn.edu.ar.dao.ClienteDao;
import frgp.utn.edu.ar.dao.MarcasDao;
import frgp.utn.edu.ar.dominio.Marcas;
import frgp.utn.edu.ar.servicio.MarcasServicio;

public class MarcasServicioImpl implements MarcasServicio{

	private MarcasDao dataAccess = null;

	public void setDataAccess(MarcasDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<Marcas> obtenerTodos() {
		return dataAccess.obtenerTodos();
	}

	@Override
	public void insertar(Marcas c) {
		dataAccess.insertar(c);
	}

}
