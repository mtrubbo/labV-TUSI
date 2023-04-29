package GRUPO6.dao;

import org.hibernate.Session;

import GRUPO6.entity.Genero;

public class daoGenero {
	
	public static void Add(Genero gn) {
		ConfigHibernate cf = new ConfigHibernate();
		Session session = cf.openConnection();
		
		session.beginTransaction();
		session.save(gn);
		session.getTransaction().commit();
		cf.closeSession();
	}
	
	public static Genero ReadOne(int id) {
		ConfigHibernate cf = new ConfigHibernate();
		Session s = cf.openConnection();
		
		s.beginTransaction();
		Genero gen = (Genero)s.get(Genero.class, id);
		
		cf.closeSession();
		
		return gen;
	}
}
