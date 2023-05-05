package GRUPO6.dao;

import GRUPO6.entity.Genero;
import org.hibernate.Criteria;
import org.hibernate.Session;

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

    public static Object GetById(Class clazz, int id){
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