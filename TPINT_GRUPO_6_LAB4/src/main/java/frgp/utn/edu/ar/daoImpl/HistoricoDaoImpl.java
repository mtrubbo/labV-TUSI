package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.HistoricoDao;
import frgp.utn.edu.ar.dao.StockDao;
import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Historico;
import frgp.utn.edu.ar.dominio.Stock;

public class HistoricoDaoImpl implements HistoricoDao {
	
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Historico h) {
		this.hibernateTemplate.save(h);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Historico> obtenerHistoricoDeVenta(int idVenta) {
		Query q = this.hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery("FROM Historico h " +
						"WHERE h.estado=true AND h.venta.id = :idVenta");

		q.setParameter("idVenta", idVenta);

		return (List<Historico>)q.list();
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Historico> obtenerTodos() {
		return (ArrayList<Historico>) this.hibernateTemplate.loadAll(Historico.class);
	}
	
}
