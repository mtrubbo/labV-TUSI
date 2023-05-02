package GRUPO6;

import GRUPO6.entity.*;
import GRUPO6.dao.*;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Genero gen = new Genero();
    	gen.setDescripcion("Terror");
//    	DaoBase.Add(gen);
    	
    	Genero gen2 = new Genero();	
    	gen2 = daoGenero.ReadOne(1);
    
        System.out.println("Info: " + gen2.toString());
        
        Nacionalidad n1 = new Nacionalidad(1,"Argentina");
        Nacionalidad n2 = new Nacionalidad(2,"Francia");
        Nacionalidad n3 = new Nacionalidad(3,"Holanda");
        Nacionalidad n4 = new Nacionalidad(4,"Inglaterra");
        Nacionalidad n5 = new Nacionalidad(5,"Brasil");
        
//        daoNacionalidad.AddNacionalidad(n1);
//        daoNacionalidad.AddNacionalidad(n2);
//        daoNacionalidad.AddNacionalidad(n3);
//        daoNacionalidad.AddNacionalidad(n4);
//        daoNacionalidad.AddNacionalidad(n5);

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


    }
}
