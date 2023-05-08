package GRUPO6;

import GRUPO6.entity.*;
import GRUPO6.dao.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	///ALTA REGISTROS GENERO
    	Genero gen1 = new Genero();
    	gen1.setDescripcion("Terror");
    	Genero gen2 = new Genero();
    	gen2.setDescripcion("Suspenso");
    	Genero gen3 = new Genero();
    	gen3.setDescripcion("Thriller"); 	
    	Genero gen4 = new Genero();
    	gen4.setDescripcion("Accion"); 	
    	Genero gen5 = new Genero();
    	gen5.setDescripcion("Aventura");
     		
    	DaoBase.Add(gen1);
    	DaoBase.Add(gen2);
    	DaoBase.Add(gen3);
    	DaoBase.Add(gen4);
    	DaoBase.Add(gen5);
        
     	///ALTA REGISTROS NACIONALIDAD
        Nacionalidad n1 = new Nacionalidad(1,"Argentina");
        Nacionalidad n2 = new Nacionalidad(2,"Francia");
        Nacionalidad n3 = new Nacionalidad(3,"Holanda");
        Nacionalidad n4 = new Nacionalidad(4,"Inglaterra");
        Nacionalidad n5 = new Nacionalidad(5,"Brasil");
        
        DaoBase.Add(n1);
        DaoBase.Add(n2);
        DaoBase.Add(n3);
        DaoBase.Add(n4);
        DaoBase.Add(n5);

      ///ALTA REGISTROS AUTOR
        Autor au1 = new Autor();
        au1.setNombre("Jorge");
        au1.setApellido("Fernandez");
        au1.setEmail("jfernandez@outlook.com");
        au1.setNacionalidad(n1);

        Autor au2 = new Autor();
        au2.setNombre("Pepe");
        au2.setApellido("Lopez");
        au2.setEmail("pepito@hotmail.com");
        au2.setNacionalidad(n2);
        
        Autor au3 = new Autor();
        au3.setNombre("Gerardo");
        au3.setApellido("Nuñez");
        au3.setEmail("gernunez@hotmail.com");
        au3.setNacionalidad(n3);
        
        Autor au4 = new Autor();
        au4.setNombre("John");
        au4.setApellido("Wick");
        au4.setEmail("johnwick@hotmail.com");
        au4.setNacionalidad(n4);
        
        Autor au5 = new Autor();
        au5.setNombre("Anna");
        au5.setApellido("Davis");
        au5.setEmail("annadavis@hotmail.com");
        au5.setNacionalidad(n5);

        DaoBase.Add(au1);
        DaoBase.Add(au2);
        DaoBase.Add(au3);
        DaoBase.Add(au4);
        DaoBase.Add(au5);

        /*
        List autores = DaoBase.GetAll(Autor.class);
        for (Object au: autores) {
            System.out.println("Autor nuevo: " + au);
        }
        */

        
        ///ALTA REGISTROS BIBLIOTECA
        Biblioteca b1 = new Biblioteca(1,new Date(),1);
        Biblioteca b2 = new Biblioteca(2,new Date(),2);
        Biblioteca b3 = new Biblioteca(3,new Date(),2);
        Biblioteca b4 = new Biblioteca(4,new Date(),1);
        Biblioteca b5 = new Biblioteca(5,new Date(),2);
        
        DaoBase.Add(b1);
        DaoBase.Add(b2);
        DaoBase.Add(b3);
        DaoBase.Add(b4);
        DaoBase.Add(b5);
        
        
        ///ALTA REGISTROS LIBROS
        Libro l1 = new Libro("0000000000031", "Los Simpsons", new Date(),"Ingles",210,au1,"Historia de los personajes",Arrays.asList(gen1),b1);
        Libro l2 = new Libro("0000000000032", "El Pollo Pepe", new Date(),"Ingles",52,au2,"Una fascinante aventura",Arrays.asList(gen1,gen2),b2);
        Libro l3 = new Libro("0000000000033", "El Gran Lobo Feroz", new Date(),"Español",70,au3,"Cuidado con el lobo",Arrays.asList(gen3,gen2),b3);
        Libro l4 = new Libro("0000000000034", "Abrapalabra", new Date(),"Italiano",46,au3,"Conoceras palabras magicas",Arrays.asList(gen4,gen1),b4);
        Libro l5 = new Libro("0000000000035", "David el Dinosaurio", new Date(),"English",210,au1,"Guiá a david en sus vacaciones por el mundo",Arrays.asList(gen4,gen5),b5);
        DaoBase.Add(l1);
        DaoBase.Add(l2);
        DaoBase.Add(l3);
        DaoBase.Add(l4);
        DaoBase.Add(l5);
        
        
        //ABML REGISTRO BIBLIOTECA
        Biblioteca b6 = new Biblioteca(6,new Date(),2);
        //Alta
        DaoBase.Add(b6);
        //Baja
        DaoBase.Delete(b6);
        //Modificacion
        DaoBase.Add(b6);
        b6.setEstado(1);
        DaoBase.Update(b6);
        //Listado
        Class bclass = b6.getClass();
        System.out.println(DaoBase.GetById(bclass,b6.getIdLibro()));
    }
}
