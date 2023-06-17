package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;

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
		return this.hibernateTemplate.get(Cliente.class, dni);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Cliente obtenerPorId(int id) {
		return this.hibernateTemplate.get(Cliente.class, id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Cliente> obtenerTodos() {
		return (ArrayList<Cliente>) this.hibernateTemplate.loadAll(Cliente.class);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void eliminar(int id) {
		Cliente c = obtenerPorId(id);
		this.hibernateTemplate.delete(c);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Cliente c) {
		this.hibernateTemplate.update(c);
	}


}
