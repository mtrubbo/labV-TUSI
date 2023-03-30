package com.trabajoUno;

import com.trabajoUno.TiposEntrada.Deporte.EntradaDeporte;
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
        
        										/*ENTRADAS RECITALES*/
    	/********************************************************************************************************/
		///BANDAS SOPORTE
		ArrayList<Banda> bandasSop1 = new ArrayList<Banda>();
		bandasSop1.add(new Banda("Twenty one pilots"));
		
		ArrayList<Banda> bandasSop2 = new ArrayList<Banda>();
		bandasSop2.add(new Banda("Lali"));
		bandasSop2.add(new Banda("Airbag"));
		
		
		///ENTRADAS RECITALES
        EntradaRecital e1 = new EntradaRecital("Lollapalooza", new Date(),60, new CategoriaVip()
                , new Genero(1, "Trap"), new Banda("Drake"), bandasSop1);
        
        Entrada e2 = new EntradaRecital("Cosquin Rock",new Date(),90, new CategoriaNormal()
                , new Genero(2, "Reggaeton"), new Banda("Rels b"), bandasSop2);
        
        
   	    /********************************************************************************************************/     
        											/*ENTRADAS INFANTILES*/
        /********************************************************************************************************/
        //ENTRADA INFANTIL SOLICITA UNA FECHA DE NACIMIENTO CON LocalDate. FALSE: SIN SOUVENIR - TRUE: CON SOUVENIR
        
        /*ENTRADA INFANTIL CON COSTO PARA MAYORES DE 8 AÑOS Y CON SOUVENIR*/
        EntradaInfantil e3 = new EntradaInfantil("LA VACA LOLA", new Date(), 60, LocalDate.parse("2010-05-08"), false);        
        /*ENTRADA INFANTIL CON COSTO PARA MAYORES DE 8 AÑOS Y CON SOUVENIR*/
        EntradaInfantil e4 = new EntradaInfantil("EL MAGO SIN DIENTES", new Date(), 60, LocalDate.parse("2020-05-08"), true);        
        /********************************************************************************************************/
        											   /* ENTRADA TEATRO */
        /********************************************************************************************************/
        ArrayList<Actor> listActor = new ArrayList<Actor>();
        Actor ac1 = new Actor("Lucas", "Gomez");
        Actor ac2  = new Actor("Pablo", "Caero");
        
        listActor.add(ac1);
        listActor.add(ac2);
        
        EntradaTeatro e5 = new EntradaTeatro("Opera 1", new Date(), 60, listActor, new Genero(3, "Drama"));
        EntradaTeatro e6 = new EntradaTeatro("Opera 1", new Date(), 60, listActor, new Genero(5, "Teatro"));
        EntradaTeatro e7= new EntradaTeatro("Opera 1", new Date(), 60, listActor, new Genero(4, "Comedia")); 
        
        
        /********************************************************************************************************/       
        									/*ENTRADAS EVENTOS DEPORTIVOS*/
        /********************************************************************************************************/
        //ENTRADA DE EVENTO DEPORTIVO SOLICITA EL TIPO DE DEPORTE (Futbol, Rugby o Hockey) 
        //Y SI ES INTERNACIONAL (true: SI - false: NO)
        
        /*ENTRADA DE DEPORTE FUTBOL NACIONAL*/
        EntradaDeporte e8 = new EntradaDeporte("Boca vs River", new Date(), 90, "Futbol", false);    
        /*ENTRADA DE DEPORTE FUTBOL INTERNACIONAL*/
        EntradaDeporte e9 = new EntradaDeporte("Argentina vs Alemania", new Date(), 90, "Futbol", true);
        /********************************************************************************************************/

        
        Entrada.getEntradasList();

    }
}