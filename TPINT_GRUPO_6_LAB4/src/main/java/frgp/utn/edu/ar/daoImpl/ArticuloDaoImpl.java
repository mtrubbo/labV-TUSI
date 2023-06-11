package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.ArticuloDao;
import frgp.utn.edu.ar.dominio.Articulo;

public class ArticuloDaoImpl implements ArticuloDao {
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Articulo a) {
		this.hibernateTemplate.save(a);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Articulo obtenerPorNombre(String nombre) {
		return this.hibernateTemplate.get(Articulo.class, nombre);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Articulo obtenerPorId(int id) {
		return this.hibernateTemplate.get(Articulo.class, id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Articulo> obtenerTodos() {
		return (ArrayList<Articulo>) this.hibernateTemplate.loadAll(Articulo.class);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(int id) {
		Articulo a = obtenerPorId(id);
		this.hibernateTemplate.delete(a);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Articulo a) {
		this.hibernateTemplate.update(a);
	}


}
