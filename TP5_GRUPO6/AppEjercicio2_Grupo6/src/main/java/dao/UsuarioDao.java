package dao;

import org.hibernate.Session;

import entidad.Usuario;

public class UsuarioDao {

	private ConfigHibernate config;
	
	public void Add(Usuario user)
	{
		config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
	        
	    session.beginTransaction();
	    session.save(user);
	    
	    session.getTransaction().commit();    
		config.cerrarSession();
	}
	
	public Usuario ReadOne(String nombreUsuario)
	{
		config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
        Usuario usuario=(Usuario)session.get(Usuario.class,nombreUsuario);
        
        config.cerrarSession();
        
        return usuario;
	}

	public boolean Exist(String nombreUsuario)
	{
		config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
        Usuario usuario=(Usuario)session.get(Usuario.class,nombreUsuario);
        
        config.cerrarSession();
        if(usuario!=null)
        	return true;
        
        return false;
	}

	
	public void Update(Usuario usuario)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public static void Delete(Usuario usuario) 
	{	
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();        
        
        config.cerrarSession();

	}
}
