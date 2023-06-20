package frgp.utn.edu.ar.helpers;

import frgp.utn.edu.ar.dominio.Marcas;
import frgp.utn.edu.ar.dominio.TipoArticulo;
import frgp.utn.edu.ar.servicio.MarcasServicio;
import frgp.utn.edu.ar.servicio.TipoArticuloServicio;

public class ArticulosHelper {
		
	public MarcasServicio m;
	public TipoArticuloServicio ta;
	
	public Marcas marcaSearcher(int id) {
		return m.getbyID(id);
	}
	
	public TipoArticulo tipoSearcher(int id) {
		return ta.getbyID(id);
	}
}
