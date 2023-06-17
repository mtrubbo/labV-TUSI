package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.VentasDao;
import frgp.utn.edu.ar.dominio.Ventas;

public class VentasDaoImpl  implements VentasDao{

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Ventas a) {
		this.hibernateTemplate.save(a);		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Ventas obtenerPorId(int id) {
		return this.hibernateTemplate.get(Ventas.class, id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Ventas> obtenerTodos() {
		Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Ventas.class);
	    criteria.add(Restrictions.eq("estado", true));
	    List<Ventas> resultados = criteria.list();
	    return new ArrayList<>(resultados);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(int id) {
		Ventas a = obtenerPorId(id);
		this.hibernateTemplate.delete(a);		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Ventas a) {
		this.hibernateTemplate.update(a);		
	}
	
}
