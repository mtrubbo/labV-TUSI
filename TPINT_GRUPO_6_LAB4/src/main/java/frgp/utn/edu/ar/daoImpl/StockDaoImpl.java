package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.StockDao;
import frgp.utn.edu.ar.dominio.Articulo;
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

	@Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Stock artByID(int id) {
        String hql = "FROM Stock s WHERE s.articulo.id = :idArticulo";
        Query query = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
        query.setParameter("idArticulo", id);
        query.setMaxResults(1);
        if(query.uniqueResult()!=null)
        	return (Stock) query.uniqueResult();
        return new Stock();
    }
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deducirStock(Articulo articulo, int cantidad) {
	    // Consultar los registros de stock ordenados por fecha de ingreso ascendente (FIFO)
	    String hql = "FROM Stock s WHERE s.articulo = :articulo ORDER BY s.fechaIngreso ASC";
	    Query query = this.hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
	    query.setParameter("articulo", articulo);
	    query.setMaxResults(1); // Obtener el registro de stock más antiguo
	    Stock stock = (Stock) query.uniqueResult();

	    if (stock != null) {
	        int stockDisponible = stock.getCantidad();
	        if (stockDisponible >= cantidad) {
	            // Si hay suficiente stock disponible, deducir la cantidad solicitada
	            stock.setCantidad(stockDisponible - cantidad);
	            this.hibernateTemplate.update(stock);
	        } else {
	            // Si no hay suficiente stock disponible, lanzar una excepción o manejar el caso según sea necesario
	            throw new RuntimeException("No hay suficiente stock disponible para deducir");
	        }
	    } else {
	        // Si no se encuentra ningún registro de stock, lanzar una excepción o manejar el caso según sea necesario
	        throw new RuntimeException("No se encontró ningún registro de stock para el artículo");
	    }
	}
	
	
}
