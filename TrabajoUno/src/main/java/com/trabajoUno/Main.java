package com.trabajoUno;

import com.trabajoUno.TiposEntrada.Infantil.EntradaInfantil;
import com.trabajoUno.TiposEntrada.Recital.Banda;
import com.trabajoUno.TiposEntrada.Recital.Categorias.CategoriaNormal;
import com.trabajoUno.TiposEntrada.Recital.Categorias.CategoriaVip;

import com.trabajoUno.TiposEntrada.Recital.EntradaRecital;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //prueba creacion de entradas recitales
        
    	EntradaRecital er = new EntradaRecital("Lollapalooza", new Date(),60, new CategoriaVip()
                , new Genero(1, "Trap"), new Banda("Drake"));

        er.getBandasSoporte().add(new Banda("Metallica"));

        System.out.println(er.toString());
        
        Entrada er2 = new EntradaRecital("Cosquin Rock",new Date(),60, new CategoriaNormal()
                , new Genero(2, "Reggaeton"), new Banda("Rels b"));
        
        System.out.println(er2.toString());
        
        //ENTRADA INFANTIL SOLICITA UNA FECHA DE NACIMIENTO CON LocalDate. FALSE: SIN SOUVENIR - TRUE: CON SOUVENIR
        
        /*ENTRADA INFANTIL CON COSTO PARA MAYORES DE 8 AÑOS Y CON SOUVENIR*/
        EntradaInfantil er3 = new EntradaInfantil("LA VACA LOLA", new Date(), 60, LocalDate.parse("2010-05-08"), false); 
        System.out.println(er3.toString());
        
        /*ENTRADA INFANTIL CON COSTO PARA MAYORES DE 8 AÑOS Y CON SOUVENIR*/
        EntradaInfantil er4 = new EntradaInfantil("EL MAGO SIN DIENTES", new Date(), 60, LocalDate.parse("2020-05-08"), true); 
        System.out.println(er4.toString());
        
    }
}