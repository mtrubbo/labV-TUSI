package GRUPO6.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import GRUPO6.entity.*;
import org.hibernate.Session;

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
	
	
	
	public static void Punto4() {
		Config();

		Libro l = (Libro)session.createQuery("FROM Libro l where l.ISBN = 12345").uniqueResult();
		System.out.println(l.toStringPunto4());
		
		ch.closeSession();
	}

}