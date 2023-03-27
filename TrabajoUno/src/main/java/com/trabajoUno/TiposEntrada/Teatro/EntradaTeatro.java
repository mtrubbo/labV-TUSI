package com.trabajoUno.TiposEntrada.Teatro;

import java.util.List;

import com.trabajoUno.Genero;

public class EntradaTeatro {
	
	private final double costoEntrada = 1350.50;
	
	private List<Actor> actoresPrincipales;
	private Genero genre;
	
	
	public EntradaTeatro(List<Actor> actoresPrincipales, Genero genre) {
		super();
		this.actoresPrincipales = actoresPrincipales;
		this.genre = genre;
	}
	
	
}
