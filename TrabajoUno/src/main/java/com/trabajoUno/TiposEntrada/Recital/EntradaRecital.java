package com.trabajoUno.TiposEntrada.Recital;

import com.trabajoUno.Entrada;
import com.trabajoUno.Genero;
import com.trabajoUno.TiposEntrada.Recital.Categorias.CategoriaNormal;
import com.trabajoUno.TiposEntrada.Recital.Categorias.ICategoria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntradaRecital extends Entrada {
    private ICategoria categoria;
    private Genero genero;
    private Banda bandaPrincipal;
    private List<Banda> bandasSoporte;


    public EntradaRecital(String nombreShow, Date diaYHorario, int duracion, ICategoria categoria,
    		Genero genero, Banda bandaPrincipal, List<Banda> bandasSoporte) {
        super(nombreShow, diaYHorario, duracion);
        this.categoria = categoria;
        this.genero = genero;
        this.bandaPrincipal = bandaPrincipal;
        this.bandasSoporte = bandasSoporte;
        Entrada.entradasList.add(this);
    }

    @Override
    public float calcularCosto() {
        return this.categoria.obtenerCosto();
    }

    public ICategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ICategoria categoria) {
        this.categoria = categoria;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Banda getBandaPrincipal() {
        return bandaPrincipal;
    }

    public void setBandaPrincipal(Banda bandaPrincipal) {
        this.bandaPrincipal = bandaPrincipal;
    }

    public List<Banda> getBandasSoporte() {
        return bandasSoporte;
    }

    @Override
    public String toString() {
        return "Entrada Recital:  " + super.toString() +
                " | Categoria: " + categoria +
                " | Costo: $" + categoria.obtenerCosto() +
                " | Genero: " + genero +
                " | Banda Principal: " + bandaPrincipal +
                " | Bandas Soporte: " + bandasSoporte;

    }
}
