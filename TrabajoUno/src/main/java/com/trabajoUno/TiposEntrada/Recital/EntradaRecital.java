package com.trabajoUno.TiposEntrada.Recital;

import com.trabajoUno.Entrada;
import com.trabajoUno.TiposEntrada.Recital.Categorias.CategoriaNormal;
import com.trabajoUno.TiposEntrada.Recital.Categorias.ICategoria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntradaRecital extends Entrada {
    private ICategoria categoria;
    private String genero;
    private Banda bandaPrincipal;
    private List<Banda> bandasSoporte;


    public EntradaRecital(String nombreShow, Date diaYHorario, int duracion, ICategoria categoria,
                          String genero, Banda bandaPrincipal) {
        super(nombreShow, diaYHorario, duracion);
        this.categoria = categoria;
        this.genero = genero;
        this.bandaPrincipal = bandaPrincipal;
        this.bandasSoporte = new ArrayList<Banda>();
    }

    public EntradaRecital(String nombreShow, Date diaYHorario, int duracion, ICategoria categoria,
                          String genero, Banda bandaPrincipal, List<Banda> bandasSoporte) {
        super(nombreShow, diaYHorario, duracion);
        this.categoria = categoria;
        this.genero = genero;
        this.bandaPrincipal = bandaPrincipal;
        this.bandasSoporte = bandasSoporte;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
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
        return "EntradaRecital{" +
                "categoria=" + categoria +
                ", costo=" + categoria.obtenerCosto() +
                ", genero='" + genero + '\'' +
                ", bandaPrincipal=" + bandaPrincipal +
                ", bandasSoporte=" + bandasSoporte +
                ", id=" + id +
                ", nombreShow='" + nombreShow + '\'' +
                ", diaYHorario=" + diaYHorario +
                ", duracion=" + duracion +
                '}';
    }
}
