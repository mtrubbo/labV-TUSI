package com.trabajoUno.TiposEntrada.Recital.Categorias;

public class CategoriaVip implements ICategoria{
    private final float costo = 1500;

    @Override
    public float obtenerCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Entrada VIP";
    }
}
