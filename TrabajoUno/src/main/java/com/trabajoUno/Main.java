package com.trabajoUno;

import com.trabajoUno.TiposEntrada.Infantil.EntradaInfantil;
import com.trabajoUno.TiposEntrada.Recital.Banda;
import com.trabajoUno.TiposEntrada.Recital.Categorias.CategoriaNormal;
import com.trabajoUno.TiposEntrada.Recital.Categorias.CategoriaVip;
import com.trabajoUno.TiposEntrada.Teatro.Actor;
import com.trabajoUno.TiposEntrada.Teatro.EntradaTeatro;

import com.trabajoUno.TiposEntrada.Recital.EntradaRecital;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //prueba creacion de entradas recitales
        
		///BANDAS SOPORTE
		ArrayList<Banda> ls = new ArrayList<Banda>();
		ls.add(new Banda("Twenty one pilots"));
		
		ArrayList<Banda> ls2 = new ArrayList<Banda>();
		ls2.add(new Banda("Lali"));
		ls2.add(new Banda("Airbag"));

		///ENTRADAS RECITALES
        EntradaRecital er = new EntradaRecital("Lollapalooza", new Date(),60, new CategoriaVip()
                , new Genero(1, "Trap"), new Banda("Drake"), ls);

        System.out.println(er.toString());
        
        Entrada er2 = new EntradaRecital("Cosquin Rock",new Date(),90, new CategoriaNormal()
                , new Genero(2, "Reggaeton"), new Banda("Rels b"), ls2);
        
        System.out.println(er2.toString());
        
        //ENTRADA INFANTIL SOLICITA UNA FECHA DE NACIMIENTO CON LocalDate. FALSE: SIN SOUVENIR - TRUE: CON SOUVENIR
        
        /*ENTRADA INFANTIL CON COSTO PARA MAYORES DE 8 AÑOS Y CON SOUVENIR*/
        EntradaInfantil er3 = new EntradaInfantil("LA VACA LOLA", new Date(), 60, LocalDate.parse("2010-05-08"), false); 
        System.out.println(er3.toString());
        
        /*ENTRADA INFANTIL CON COSTO PARA MAYORES DE 8 AÑOS Y CON SOUVENIR*/
        EntradaInfantil er4 = new EntradaInfantil("EL MAGO SIN DIENTES", new Date(), 60, LocalDate.parse("2020-05-08"), true); 
        System.out.println(er4.toString());
        
        /* ENTRADA TEATRO */
        ArrayList<Actor> listActor = new ArrayList<Actor>();
        ArrayList<Entrada> listEntradas = new ArrayList<Entrada>();
        Actor ac1 = new Actor("Lucas", "Gomez");
        Actor ac2  = new Actor("Pablo", "Caero");
        
        listActor.add(ac1);
        listActor.add(ac2);
        
        EntradaTeatro et = new EntradaTeatro("Opera 1", new Date(), 60, listActor, new Genero(3, "Drama"));
        EntradaTeatro et2 = new EntradaTeatro("Opera 1", new Date(), 60, listActor, new Genero(5, "Teatro"));
        EntradaTeatro et3= new EntradaTeatro("Opera 1", new Date(), 60, listActor, new Genero(4, "Comedia"));
        
        listEntradas.add(et);
        listEntradas.add(et2);
        listEntradas.add(et3);
        
        for(Entrada etn : listEntradas) {
        	System.out.println(etn.toString());
        }
    }
}