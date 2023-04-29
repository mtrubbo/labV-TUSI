package GRUPO6.TP_TEMA6_GRUPO6;

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
    }
}
