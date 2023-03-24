package com.trabajoUno.TiposEntrada.Recital.Categorias;

public class CategoriaNormal implements ICategoria{
    private final float costo = 800;

    @Override
    public float obtenerCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Entrada comun";
    }
}
