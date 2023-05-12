package GRUPO6.dao;

import java.util.List;

import org.hibernate.Session;

import GRUPO6.entity.Libro;

public class DaoConsultas {
	
	public static void Punto1()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.openConnection();
		
        List<Libro> listaLibros= (List<Libro>) session.createQuery("FROM Libro l ORDER BY l.ISBN DESC").list();
        
        System.err.println("Mostrar todos los libros ordenados según ISBN de mayor a menor");
        
        for (Libro libro : listaLibros) {
        	  System.out.println("* "+ libro.toString()+" ");	
		}
  
        ch.closeSession();
	}

}
