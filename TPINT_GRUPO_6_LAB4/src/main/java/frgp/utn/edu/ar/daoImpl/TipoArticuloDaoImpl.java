package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;

import frgp.utn.edu.ar.dao.TipoArticuloDao;
import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.TipoArticulo;

public class TipoArticuloDaoImpl implements TipoArticuloDao{
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	
	@Override
	public void insertar(TipoArticulo a) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(a);
	}

	@Override
	public TipoArticulo obtenerPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoArticulo obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TipoArticulo> obtenerTodos() {
		return (ArrayList<TipoArticulo>) this.hibernateTemplate.loadAll(TipoArticulo.class);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(TipoArticulo a) {
		// TODO Auto-generated method stub
		
	}

}
