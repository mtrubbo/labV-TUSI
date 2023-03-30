package com.trabajoUno.TiposEntrada.Recital;

import java.util.ArrayList;
import java.util.List;

public class Banda {
    private String nombre;

    public Banda(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "" + this.nombre;
    }
}
