package GRUPO6.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConfigHibernate {
	
	private SessionFactory sFactory;
	private Session session;
	
	public ConfigHibernate() {
		Configuration cf = new Configuration();
		cf.configure();
		ServiceRegistry sRegistry = new ServiceRegistryBuilder().applySettings(cf.getProperties()).buildServiceRegistry();
		sFactory = cf.buildSessionFactory(sRegistry);
	}
	
	
	public Session openConnection() {
		session = sFactory.openSession();
		return session;
	}
	
	public void closeSession() {
		session.close();
		closeSessionFactory();
	}
	
	public void closeSessionFactory() {
		sFactory.close();
	}
}
