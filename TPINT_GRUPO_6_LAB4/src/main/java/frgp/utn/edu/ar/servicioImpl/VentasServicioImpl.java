package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import frgp.utn.edu.ar.dao.ClienteDao;
import frgp.utn.edu.ar.dao.VentasDao;
import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Ventas;
import frgp.utn.edu.ar.servicio.VentasService;

public class VentasServicioImpl  implements VentasService{

	private VentasDao dataAccess = null;

	public void setDataAccess(VentasDao dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public ArrayList<Ventas> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ventas obtenerPorNombre(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Ventas a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Ventas a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ventas getbyID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
