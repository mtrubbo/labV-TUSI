package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.ClienteDao;
import frgp.utn.edu.ar.dominio.Cliente;

public class ClienteDaoImpl implements ClienteDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Cliente c) {
		this.hibernateTemplate.save(c);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Cliente obtenerPorDni(String dni) {
		Query query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession()
				.createQuery("from Cliente where dni= :dni and estado=true");

		query.setParameter("dni", dni);
		return (Cliente)query.uniqueResult();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Cliente obtenerPorId(int id) {
		Query query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession()
				.createQuery("from Cliente where id= :id and estado=true");

		query.setParameter("id", id);
		return (Cliente)query.uniqueResult();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Cliente> obtenerTodos() {
		Query query = this.hibernateTemplate.getSessionFactory()
				.getCurrentSession()
				.createQuery("from Cliente where estado=true ORDER BY id DESC");

		return (ArrayList<Cliente>)query.list();
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void eliminar(int id) {
		Cliente c = obtenerPorId(id);
		c.setEstado(false);
		this.hibernateTemplate.update(c);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Cliente c) {
		this.hibernateTemplate.update(c);
	}


}
