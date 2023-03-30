package com.trabajoUno.TiposEntrada.Teatro;

import java.util.List;
import java.util.Date;

import com.trabajoUno.Entrada;
import com.trabajoUno.Genero;

public class EntradaTeatro extends Entrada {
	private static final float costoEntrada = 1350.50F;
	
	private List<Actor> actoresPrincipales;
	private Genero genero;
	
	
	public EntradaTeatro(String nombreShow, Date diaYHorario, int duracion, List<Actor> actoresPrincipales, Genero genre) {
			super(nombreShow,diaYHorario,duracion);
		this.actoresPrincipales = actoresPrincipales;
		this.genero = genre;
		Entrada.entradasList.add(this);
	}


	public List<Actor> getActoresPrincipales() {
		return actoresPrincipales;
	}

	public void setActoresPrincipales(List<Actor> actoresPrincipales) { this.actoresPrincipales = actoresPrincipales; }

	public Genero getGenero() { return genero; }

	public void setGenero(Genero genero) { this.genero = genero; }

	public double getCostoEntrada() { return costoEntrada; }


	@Override
	public String toString() {
		return "Entrada Teatro:   "+ super.toString()+ " | Costo: $" + costoEntrada +  " | Actores Principales: " + this.actoresPrincipales + " | Genero: "
				+ this.genero;
	}

	@Override
	public float calcularCosto() {
		return costoEntrada;
	}
}
