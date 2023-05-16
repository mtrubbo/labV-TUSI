package GRUPO6.dao;

import GRUPO6.entity.Nacionalidad;
import org.hibernate.Session;

import java.io.Serializable;

public class DaoNacionalidad {
    public static Nacionalidad GetByName(String nombre){
        ConfigHibernate hibernate = new ConfigHibernate();
        Session s = hibernate.openConnection();

        s.beginTransaction();
        Nacionalidad obj = (Nacionalidad)s
                .createQuery("from Nacionalidad as n where n.Descripcion = :desc")
                .setParameter("desc", nombre)
                .uniqueResult();

        hibernate.closeSession();

        return obj;
    }
}
