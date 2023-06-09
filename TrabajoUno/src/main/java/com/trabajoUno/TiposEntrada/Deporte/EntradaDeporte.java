package com.trabajoUno.TiposEntrada.Deporte;

import java.time.LocalDate;
import java.util.Date;

import com.trabajoUno.Entrada;

public class EntradaDeporte extends Entrada {
	
	private float costoEntrada;
	private String deporte; //Futbol, Rugby, Hockey
	private boolean internacional; //true: internacional - false: nacional

	public EntradaDeporte(String nombreShow, Date diaYHorario, int duracion, String deporte, boolean internacional) {
		super(nombreShow, diaYHorario, duracion);
		this.deporte = deporte;
		this.internacional = internacional;
		this.costoEntrada = calcularCosto();
		
		Entrada.entradasList.add(this);
	}
	
	//METODO PARA CALCULAR COSTO SEGÚN DEPORTE Y CLASIFICACIÓN REGIONAL
	
	public float calcularCosto() {
		
		//ASIGNO VALOR DEL costoEntrada SEGÚN EL DEPORTE
		switch (deporte) {
		case "Futbol":
			costoEntrada = 300;
			break;
		case "Rugby":
			costoEntrada = 450;
			break;
		case "Hockey":
			costoEntrada = 380;
			break;
		default:
			break;
		}
		
		//VERIFICO SI ES INTERNACIONAL
		if(internacional){
			costoEntrada = costoEntrada* 1.3f;
		}
				
		return costoEntrada;
	}

	
	//GETTERS Y SETTERS
	public float getCostoEntrada() {
		return costoEntrada;
	}

	public void setCostoEntrada(float costoEntrada) {
		this.costoEntrada = costoEntrada;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public boolean isInternacional() {
		return internacional;
	}

	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}
	
	//METODO toString
	public String toString() {
		String internacionalResult = this.internacional?"SI":"NO";
		return "Entrada Deporte:  " + super.toString() + " | Costo: $ " + costoEntrada + " | Deporte: " + deporte + " | Internacional: " + internacionalResult + " | ";
	}
}
