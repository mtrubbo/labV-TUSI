package GRUPO6.dao;

import java.util.List;

import org.hibernate.Session;

import GRUPO6.entity.Biblioteca;
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
	
	public static void Punto2() {
		ConfigHibernate ch = new ConfigHibernate();
		Session s = ch.openConnection();
		
		List<Object[]> lBiblioteca = (List<Object[]>)s.createQuery("FROM Biblioteca as b JOIN b.libro where b.Estado = 2").list();
		
		System.err.println("PUNTO 2 - LIBROS PRESTADOS");
		
		for (Object[] obj : lBiblioteca) {
			Biblioteca b = (Biblioteca)obj[0];
			
			System.out.println(b.toString());
		}
		
		ch.closeSession();
	}

}
