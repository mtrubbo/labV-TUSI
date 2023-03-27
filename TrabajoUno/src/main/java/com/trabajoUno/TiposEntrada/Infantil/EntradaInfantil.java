package com.trabajoUno.TiposEntrada.Infantil;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.trabajoUno.Entrada;

public class EntradaInfantil extends Entrada {
	
	private float costoEntrada;
	private LocalDate nacimiento;
	private boolean souvenir;
	

	//CONSTRUCTOR
	public EntradaInfantil(String nombreShow, Date diaYHorario, int duracion, LocalDate nacimiento, boolean souvenir) {
		super(nombreShow, diaYHorario, duracion);
		this.nacimiento = nacimiento;
		this.souvenir = souvenir;
		this.costoEntrada = calcularCosto();
		
	}

	//METODOS PARA CALCULAR EDAD Y COSTOS
	public long obtenerEdad(LocalDate nacimiento) {
		LocalDate hoy = LocalDate.now();   		
		long edad = ChronoUnit.YEARS.between(nacimiento, hoy); 		 
		return edad;
	}
	
	@Override
	public float calcularCosto() {
		long edad = obtenerEdad(nacimiento);
		
		if(edad < 8) {
			costoEntrada = 250;
		}
		else {
			costoEntrada = 500;
		}
		return costoEntrada;
	}
	
	
	//GETTERS Y SETTERS
	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public boolean isSouvenir() {
		return souvenir;
	}

	public void setSouvenir(boolean souvenir) {
		this.souvenir = souvenir;
	}
	

	public float getCostoEntrada() {
		return costoEntrada;
	}

	public void setCostoEntrada(float costoEntrada) {
		this.costoEntrada = costoEntrada;
	}

	@Override
	public String toString() {
		if(souvenir) {
		return "Entrada Infantil - Costo: $ " + costoEntrada + ", Fecha de Nacimiento: " + nacimiento + ", CON SOUVENIR - " + super.toString();
		}
		else {
		return "Entrada Infantil - Costo: $ " + costoEntrada + ", Fecha de Nacimiento: " + nacimiento + ", SIN SOUVENIR - " + super.toString();

		}
	}
	


}
