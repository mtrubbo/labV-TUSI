package com.trabajoUno.TiposEntrada.Teatro;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.trabajoUno.Entrada;
import com.trabajoUno.Genero;

public class EntradaTeatro extends Entrada {
	
	private final double costoEntrada = 1350.50;
	
	private List<Actor> actoresPrincipales;
	private Genero genre;
	
	
	public EntradaTeatro(String nombreShow, Date diaYHorario, int duracion, List<Actor> actoresPrincipales, Genero genre) {
		super(nombreShow,diaYHorario,duracion);
		
		if(actoresPrincipales.size() <= 3) {			
			this.actoresPrincipales = new ArrayList<Actor>();
			this.actoresPrincipales = actoresPrincipales;
		}
		else {
			this.actoresPrincipales = new ArrayList<Actor>();
		}
		this.genre = genre;
	}


	public List<Actor> getActoresPrincipales() {
		return actoresPrincipales;
	}


	public void setActoresPrincipales(List<Actor> actoresPrincipales) {
		if(actoresPrincipales.size() <= 3) {
			if(this.actoresPrincipales.size() != 0 ) {
				if(!this.actoresPrincipales.equals(actoresPrincipales)) {					
					this.actoresPrincipales = actoresPrincipales;
				}
			}
			else {
				this.actoresPrincipales = actoresPrincipales;
			}
		}
	}


	public Genero getGenre() {
		return genre;
	}


	public void setGenre(Genero genre) {
		this.genre = genre;
	}


	public double getCostoEntrada() {
		return costoEntrada;
	}


	@Override
	public String toString() {
		return "Nombre Show: "+ this.nombreShow +" Duracion: "+ this.duracion + " Dia y Horario: "+ this.diaYHorario + " Costo: " + this.costoEntrada +  " actoresPrincipales=" + actoresPrincipales + ", genero: "
				+ genre;
	}


	@Override
	public float calcularCosto() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
