package GRUPO6.TP_TEMA6_GRUPO6;

import GRUPO6.entity.Nacionalidad;
import GRUPO6.dao.daoNacionalidad;
import GRUPO6.dao.daoGenero;
import GRUPO6.entity.Genero;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Genero gen = new Genero();
    	gen.setDescripcion("Terror");
    	daoGenero.Add(gen);
    	
    	Genero gen2 = new Genero();	
    	gen2 = daoGenero.ReadOne(1);
    
        System.out.println("Info: " + gen2.toString());
        
        Nacionalidad n1 = new Nacionalidad(1,"Argentina");
        Nacionalidad n2 = new Nacionalidad(2,"Francia");
        Nacionalidad n3 = new Nacionalidad(3,"Holanda");
        Nacionalidad n4 = new Nacionalidad(4,"Inglaterra");
        Nacionalidad n5 = new Nacionalidad(5,"Brasil");
        
        daoNacionalidad.Add(n1);
        daoNacionalidad.Add(n2);
        daoNacionalidad.Add(n3);
        daoNacionalidad.Add(n4);
        daoNacionalidad.Add(n5);
        
    }
}
