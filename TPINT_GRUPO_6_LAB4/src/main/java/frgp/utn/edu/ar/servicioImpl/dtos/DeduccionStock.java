package frgp.utn.edu.ar.servicioImpl.dtos;

import frgp.utn.edu.ar.dominio.Stock;

public class DeduccionStock {
    Stock stock;
    int cantidadDeducida;

    public DeduccionStock() {
    }

    public DeduccionStock(Stock stock, int cantidad) {
        this.stock = stock;
        this.cantidadDeducida = cantidad;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getCantidadDeducida() {
        return cantidadDeducida;
    }

    public void setCantidadDeducida(int cantidadDeducida) {
        this.cantidadDeducida = cantidadDeducida;
    }
}
