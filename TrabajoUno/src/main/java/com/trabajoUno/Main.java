package com.trabajoUno;

import com.trabajoUno.TiposEntrada.Recital.Banda;
import com.trabajoUno.TiposEntrada.Recital.Categorias.CategoriaNormal;
import com.trabajoUno.TiposEntrada.Recital.Categorias.CategoriaVip;

import com.trabajoUno.TiposEntrada.Recital.EntradaRecital;

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
    }
}