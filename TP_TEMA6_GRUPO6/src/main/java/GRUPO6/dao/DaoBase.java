package GRUPO6.dao;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class DaoBase {

    public static void Add(Object entity){
        ConfigHibernate hibernate = new ConfigHibernate();
        Session session = hibernate.openConnection();

        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        hibernate.closeSession();
    }
    
    public static void Update(Object entity){
        ConfigHibernate hibernate = new ConfigHibernate();
        Session session = hibernate.openConnection();

        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        hibernate.closeSession();
    }
    
    
    public static void Delete(Object entity){
        ConfigHibernate hibernate = new ConfigHibernate();
        Session session = hibernate.openConnection();

        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        hibernate.closeSession();
    }

    public static Object GetById(Class clazz, Serializable id){
        ConfigHibernate hibernate = new ConfigHibernate();
        Session s = hibernate.openConnection();

        s.beginTransaction();
        Object obj = s.get(clazz, id);

        hibernate.closeSession();

        return obj;
    }

    public static List GetAll(Class entity){
        ConfigHibernate hibernate = new ConfigHibernate();
        Session s = hibernate.openConnection();

        s.beginTransaction();
        Criteria crit = s.createCriteria(entity);
        List results = crit.list();

        hibernate.closeSession();

        return results;
    }
}
