package GRUPO6.dao;

import org.hibernate.Session;

import GRUPO6.entity.Nacionalidad;

public class daoNacionalidad {

	public static void Add(Nacionalidad na)
	{
		ConfigHibernate cf = new ConfigHibernate();
		Session session = cf.openConnection();
		
		session.beginTransaction();
		session.save(na);
		session.getTransaction().commit();
		cf.closeSession();
	}
	
}
