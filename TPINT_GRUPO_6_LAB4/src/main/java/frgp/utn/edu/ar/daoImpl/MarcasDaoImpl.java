package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import frgp.utn.edu.ar.dao.MarcasDao;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.Marcas;

public class MarcasDaoImpl implements MarcasDao {
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


	@Override
	public void insertar(Marcas c) {
		this.hibernateTemplate.save(c);
	}

	@Override
	public Marcas obtenerPorDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marcas obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Marcas> obtenerTodos() {
		return (ArrayList<Marcas>) this.hibernateTemplate.loadAll(Marcas.class);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Marcas c) {
		// TODO Auto-generated method stub
		
	}

}
