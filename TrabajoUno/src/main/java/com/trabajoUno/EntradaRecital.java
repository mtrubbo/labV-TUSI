package com.trabajoUno;

import java.util.Date;

//CONSIGNA:
//Las entradas de los recitales tienen un costo de fijo 1500$ para entradas vip y 800$
//para entradas generales. A su vez, cada entrada pertenece a una banda, tiene un
//género en particular y puede tener una o dos bandas de soporte. Los géneros posibles
//para los recitales son los siguientes: rock, heavy metal, reggaetón, trap, latinos y pop.

//FALTA AGREGAR LO DE LAS BANDAS Y GENEROS

public class EntradaRecital extends Entrada {
	
	private final float costoGeneral = 800;
	private final float costoVip = 1500;
	private int tipoEntrada;

	public EntradaRecital(String nombreShow, Date diaYHorario, int duracion, int tipoEntrada) 
	{
		super(nombreShow, diaYHorario, duracion);
		if(validarEntrada(tipoEntrada)) {
			this.tipoEntrada = tipoEntrada;
			this.costo = calcularCosto(tipoEntrada);
		}
	}
	
	private boolean validarEntrada(final int tipoEntrada) //'tipo' es final, nos aseguramos de no modificar dentro del metodo el valor ingresado por el usuario
	{
		if(tipoEntrada>=0 && tipoEntrada <=1) 
			return true;
		
		System.out.println("Tipo de entrada invalida");
		return false;
	}

	@Override
	public final float calcularCosto(final int tipoEntrada) {
		switch (tipoEntrada) {
		case 0:
			return costoGeneral;
		case 1:
			return costoVip;
		default:
			return -1;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "EntradaRecital [tipoEntrada="
				+ tipoEntrada + "]";
	}
	
	

}
