package frgp.utn.edu.ar.daoImpl;

import frgp.utn.edu.ar.dao.UsuarioDao;
import frgp.utn.edu.ar.dominio.Usuario;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioDaoImpl implements UsuarioDao {
    private HibernateTemplate hibernateTemplate = null;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public Usuario obtenerUsuario(String nombreUsuario) {
        Query query = this.hibernateTemplate.getSessionFactory()
                .getCurrentSession()
                .createQuery("from Usuario where nombreUsuario= :usuario");

        query.setParameter("usuario", nombreUsuario);
        return (Usuario)query.uniqueResult();
    }
}
