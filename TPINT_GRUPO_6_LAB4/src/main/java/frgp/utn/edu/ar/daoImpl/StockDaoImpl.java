package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.StockDao;
import frgp.utn.edu.ar.dominio.Stock;

public class StockDaoImpl implements StockDao {
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Stock a) {
		this.hibernateTemplate.save(a);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Stock obtenerPorNombre(String nombre) {
		return this.hibernateTemplate.get(Stock.class, nombre);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Stock obtenerPorId(int id) {
		return this.hibernateTemplate.get(Stock.class, id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Stock> obtenerTodos() {
		return (ArrayList<Stock>) this.hibernateTemplate.loadAll(Stock.class);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(int id) {
		Stock a = obtenerPorId(id);
		this.hibernateTemplate.delete(a);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Stock a) {
		this.hibernateTemplate.update(a);
	}


}
