package GRUPO6.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import GRUPO6.entity.*;
import org.hibernate.Session;
import org.hibernate.Query;

public class DaoConsultas {
	
	private static Session session;
	private static ConfigHibernate ch;
	
	private static void Config() {
		ch = new ConfigHibernate();
		session= ch.openConnection();
	}


	public static void Punto1()
	{	
		Config();
        List<Libro> listaLibros= (List<Libro>) session.createQuery("FROM Libro l ORDER BY l.ISBN DESC").list();
        
        System.err.println("Mostrar todos los libros ordenados según ISBN de mayor a menor");
        
        for (Libro libro : listaLibros) {
        	  System.out.println("* "+ libro.toString()+" ");	
		}
  
        ch.closeSession();
	}

	
//  Mostrar todos los libros de la biblioteca que se encuentran prestados
//  Los campos que se deben mostrar son ID biblioteca, fecha de alta y estado
	
	public static void Punto2() {
		Config();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Object[]> lBiblioteca = (List<Object[]>)session.createQuery("FROM Biblioteca as b JOIN b.libro where b.Estado = 2").list();
		
		System.err.println("PUNTO 2 - LIBROS PRESTADOS");
		
		for (Object[] obj : lBiblioteca) {
			Biblioteca b = (Biblioteca)obj[0];
			
			System.out.println("ID: " + b.getId() +"\n"+ "Fecha de alta: " + sdf.format(b.getFechaAlta()) + "\n" + "Estado: "+ b.getEstado() + "\n\n");
		}
		
		ch.closeSession();
	}

//  Mostrar todos los autores que sean de nacionalidad Argentina
//  ID de autor, nombre, apellido, email y su nacionalidad (ID, Descripcion)
	
	public static void Punto3() {
		Config();

		Nacionalidad nacArgentino = DaoNacionalidad.GetByName("Argentina");

		if(nacArgentino == null){
			System.out.println("Error: no se encontro la nacionalidad");
		}

		List<Object[]> autores = session
				.createQuery("FROM Autor as a JOIN a.Nacionalidad as n where n.IdNacionalidad = :nac")
				.setParameter("nac", nacArgentino.getIdNacionalidad())
				.list();

		System.out.println("PUNTO 3 - Listado de autores argentinos");

		for (Object[] autor : autores) {
			System.out.println(autor[0]);
		}

		ch.closeSession();
	}
	
	/*4) Mostrar el libro con ISBN 12345 junto con todos sus géneros
		 Los campos que se deben mostrar son los siguientes: ISBN, Titulo, fecha de
		 lanzamiento, idioma, cantidad de páginas, autor (ID, Nombre, Apellido, Email),
		 descripción y la lista de géneros (ID Genero, descripción)*/

	
	public static void Punto4() {
		Config();

		Libro l = (Libro)session.createQuery("FROM Libro l where l.ISBN = 12345").uniqueResult();
		System.out.println(l.toStringPunto4());
		
		ch.closeSession();
	}
	
	/*5) Mostrar el libro que tenga el mayor número de ISBN
		 El único campo que se debe mostrar es ISBN.*/
		
	public static void Punto5() {
		Config();
		
		String hql = "SELECT l.ISBN " +
	             	 "FROM Libro l " +
	             	 "ORDER BY l.ISBN DESC";
		Query query = session.createQuery(hql);
		query.setMaxResults(1); // Unico campo que se debe mostrar
		String ISBN = (String) query.uniqueResult();

		System.out.println("El libro con el mayor número de ISBN es: " + ISBN);

		ch.closeSession(); 
	}
	
	/* 6) Mostrar la cantidad de libros que existen para cada género.
		  Los campos que se deben mostrar son ID género, descripción y cantidad.*/
	
	public static void Punto6() {
		Config(); 

		String hql = "SELECT g.id, g.descripcion, COUNT(l) " +
		             "FROM Genero g " +
		             "LEFT JOIN g.libros l " +
		             "GROUP BY g.id, g.descripcion";
		Query query = session.createQuery(hql);
		List<Object[]> result = query.list();

		System.out.println("Cantidad de libros por género:");
		for (Object[] row : result) {
		    int generoId = (int) row[0];
		    String generoDescripcion = (String) row[1];
		    long cantidadLibros = (long) row[2];

		    System.out.println("ID género: " + generoId);
		    System.out.println("Descripción: " + generoDescripcion);
		    System.out.println("Cantidad de libros: " + cantidadLibros);
		    System.out.println("----------------------------------------");
		}

		ch.closeSession(); 
	}
	
	

}
