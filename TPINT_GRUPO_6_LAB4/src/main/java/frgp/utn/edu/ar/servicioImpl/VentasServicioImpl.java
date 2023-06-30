package frgp.utn.edu.ar.servicioImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frgp.utn.edu.ar.dtos.ConsultaVentasResponse;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import frgp.utn.edu.ar.dao.ClienteDao;
import frgp.utn.edu.ar.dao.VentasDao;
import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Ventas;
import frgp.utn.edu.ar.servicio.VentasService;

public class VentasServicioImpl  implements VentasService{

	private VentasDao dataAccess = null;

	public void setDataAccess(VentasDao dataAccess) {
		this.dataAccess = dataAccess;
	}

	@Override
	public ArrayList<Ventas> obtenerTodos() {
		return dataAccess.obtenerTodos();
	}

	@Override
	public List<ConsultaVentasResponse> obtenerPorRangoDeFechas(Date fechaIni, Date fechaFin) {
		List<ConsultaVentasResponse> response = new ArrayList<>();

		List<Ventas> ventas = this.dataAccess.obtenerPorRangoFechas(fechaIni, fechaFin);

		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");

		for (Ventas venta :
				ventas) {
			ConsultaVentasResponse item = new ConsultaVentasResponse();
			item.setId(venta.getId());
			item.setNombreCliente(venta.getCliente().getNombreCompleto());
			item.setMontoTotal(venta.calcularMontoTotal());
			item.setFecha(dateFmt.format(venta.getFecha()));

			response.add(item);
		}

		return response;
	}

	@Override
	public void insertar(Ventas a) {
		 dataAccess.insertar(a);		
	}

	@Override
	public void eliminar(int id) {
		dataAccess.eliminar(id);		
	}

	@Override
	public Ventas getbyID(int id) {
		return dataAccess.obtenerPorId(id);
	}

	@Override
	public void actualizar(Ventas id) {
		dataAccess.actualizar(id);		
	}

	@Override
	public double obtenerTotalPorRangoFechas(Date fechaIni, Date fechaFin) {
		return dataAccess.obtenerTotalPorRangoFechas(fechaIni, fechaFin);
	}
	
}
