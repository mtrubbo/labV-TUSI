package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import frgp.utn.edu.ar.dao.VentasDao;
import frgp.utn.edu.ar.dominio.Stock;

public class VentasDaoImpl  implements VentasDao{

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	@Override
	public void insertar(Stock a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Stock obtenerPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Stock> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Stock a) {
		// TODO Auto-generated method stub
		
	}
	
}
