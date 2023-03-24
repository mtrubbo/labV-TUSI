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
        
        EntradaRecital er = new EntradaRecital("pitufines", new Date(),60, new CategoriaVip()
                , "pitufo", new Banda("Los pitufos"));

        er.getBandasSoporte().add(new Banda("Metallica"));

        System.out.println(er.toString());

        
        EntradaRecital er2 = new EntradaRecital("pitufines",new Date(),60, new CategoriaNormal()
                , "pitufo", new Banda("Los pitufos"));
        System.out.println(er2.toString());
    }
}