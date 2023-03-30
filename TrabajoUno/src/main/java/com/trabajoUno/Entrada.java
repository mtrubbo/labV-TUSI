package com.trabajoUno;

import java.util.ArrayList;
import java.util.Date;

public abstract class Entrada {
    private static int idCounter=0;
    
    protected static ArrayList<Entrada> entradasList = new ArrayList<Entrada>();

    protected int id;
    protected String nombreShow;
    protected Date diaYHorario;
    protected int duracion;
    
    public static void getEntradasList() {
        for(Entrada e : entradasList) {
        	System.out.println(e.toString());
        }
    }

    public Entrada(String nombreShow, Date diaYHorario, int duracion) {
        idCounter++;

        this.id = idCounter;
        this.nombreShow = nombreShow;
        this.diaYHorario = diaYHorario;
        this.duracion = duracion;
        
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Entrada.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public String getNombreShow() {
        return nombreShow;
    }

    public void setNombreShow(String nombreShow) {
        this.nombreShow = nombreShow;
    }

    public Date getDiaYHorario() {
        return diaYHorario;
    }

    public void setDiaYHorario(Date diaYHorario) {
        this.diaYHorario = diaYHorario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    

    @Override
	public String toString() {
    	return "Entrada Numero: " + id
				+ " | Nombre del show: " + nombreShow + " | Fecha: " + diaYHorario + " | Duracion: "
				+ duracion;
	}

	public abstract float calcularCosto();
}


