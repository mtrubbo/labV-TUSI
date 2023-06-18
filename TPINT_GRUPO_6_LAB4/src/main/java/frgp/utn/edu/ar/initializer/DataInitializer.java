package frgp.utn.edu.ar.initializer;

import javax.annotation.PostConstruct;

import frgp.utn.edu.ar.dominio.Marcas;
import frgp.utn.edu.ar.dominio.TipoArticulo;
import frgp.utn.edu.ar.servicio.MarcasServicio;
import frgp.utn.edu.ar.servicio.TipoArticuloServicio;
import frgp.utn.edu.ar.servicioImpl.MarcasServicioImpl;
import frgp.utn.edu.ar.servicioImpl.TipoArticuloServicioImpl;

public class DataInitializer {
	
    private TipoArticuloServicio tipoArticuloService;
    private MarcasServicio marcaService;

    public void setTipoArticuloService(TipoArticuloServicio tipoArticuloService) {
        this.tipoArticuloService = tipoArticuloService;
    }

    public void setMarcaService(MarcasServicio marcaService) {
        this.marcaService = marcaService;
    }

    @PostConstruct
    public void initializeData() {
        // Código para inicializar los datos en la base de datos utilizando los servicios
        TipoArticulo tipoArticulo1 = new TipoArticulo();
        tipoArticulo1.setDescripcion("Indumentaria");
        
        // Inicializar datos para TipoArticulo
        tipoArticuloService.insertar(tipoArticulo1);

        Marcas marca1 = new Marcas();
        marca1.setNombre("Nike");
        // Inicializar datos para Marca
        
        marcaService.insertar(marca1);
    }
}
