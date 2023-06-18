package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.MarcasDao;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.Marcas;

public class MarcasDaoImpl implements MarcasDao {
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Marcas c) {
		this.hibernateTemplate.save(c);
	}

	@Override
	public ArrayList<Marcas> obtenerTodos() {
		return (ArrayList<Marcas>) this.hibernateTemplate.loadAll(Marcas.class);
	}

}
