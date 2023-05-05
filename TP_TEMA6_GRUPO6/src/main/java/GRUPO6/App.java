package GRUPO6;

import GRUPO6.entity.*;
import GRUPO6.dao.*;

import java.util.Date;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Genero gen = new Genero();
    	gen.setDescripcion("Terror");
     	DaoBase.Add(gen);
        
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

        Autor au1 = new Autor();
        au1.setNombre("Jorge");
        au1.setApellido("Fernandez");
        au1.setEmail("jfernandez@outlook.com");
        au1.setNacionalidad(n4);

        Autor au2 = new Autor();
        au2.setNombre("Pepe");
        au2.setApellido("Lopez");
        au2.setEmail("pepito@hotmail.com");
        au2.setNacionalidad(n1);

        DaoBase.Add(au1);
        DaoBase.Add(au2);

        List autores = DaoBase.GetAll(Autor.class);

        for (Object au: autores) {
            System.out.println("Autor nuevo: " + au);
        }

        Biblioteca b1 = new Biblioteca(1,new Date(),1);
        Biblioteca b2 = new Biblioteca(2,new Date(),2);
        Biblioteca b3 = new Biblioteca(3,new Date(),2);
        Biblioteca b4 = new Biblioteca(4,new Date(),1);
        Biblioteca b5 = new Biblioteca(5,new Date(),2);
        
        ///ALTA REGISTROS BIBLIOTECA
        DaoBase.Add(b1);
        DaoBase.Add(b2);
        DaoBase.Add(b3);
        DaoBase.Add(b4);
        DaoBase.Add(b5);
    }
}
