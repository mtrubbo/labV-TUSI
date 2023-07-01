package frgp.utn.edu.ar.servicioImpl;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frgp.utn.edu.ar.dtos.ConsultaVentasResponse;
import frgp.utn.edu.ar.dtos.StockRequest;
import frgp.utn.edu.ar.dtos.VentaRequest;
import frgp.utn.edu.ar.servicio.ArticuloServicio;
import frgp.utn.edu.ar.servicio.ClienteServicio;
import frgp.utn.edu.ar.servicio.StockServicio;

import frgp.utn.edu.ar.dao.VentasDao;
import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Stock;
import frgp.utn.edu.ar.dominio.Ventas;
import frgp.utn.edu.ar.servicio.VentasService;
import org.springframework.beans.factory.annotation.Autowired;

public class VentasServicioImpl  implements VentasService{

	private VentasDao dataAccess = null;
	private StockServicio stockServicio;
	private ArticuloServicio articuloServicio;
	private ClienteServicio clienteServicio;
	
	public void setDataAccess(VentasDao dataAccess) {
		this.dataAccess = dataAccess;
	}

	public void setStockServicio(StockServicio stockServicio) {
		this.stockServicio = stockServicio;
	}

	public void setArticuloServicio(ArticuloServicio articuloServicio) {
		this.articuloServicio = articuloServicio;
	}

	public void setClienteServicio(ClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
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
	public void crearVenta(VentaRequest vreq,
						   List<String> idsArticulos,
						   List<String> idsCantidades,
						   String fechaVenta,
						   int clienteId,
						   double montoTotal) {
		try {
			vreq.setListaArticulos(new ArrayList<>());

			Integer cont = 0;
			float ganancia = 0;

			for (String item : idsArticulos) {
				int cantidadArticulo = Integer.parseInt(idsCantidades.get(cont));

				ganancia += deducirStockDeArticulo(vreq, Integer.parseInt(item), cantidadArticulo);

				cont++;
			}

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate ingresoDate = LocalDate.parse(fechaVenta, formatter);
			LocalDateTime ingresoDateTime = ingresoDate.atStartOfDay();
			Instant instant = ingresoDateTime.toInstant(ZoneOffset.UTC);

			vreq.setFecha(Date.from(instant));
			vreq.setCliente(this.clienteServicio.obtenerPorId(clienteId));
			vreq.setMontoTotal(montoTotal);

			Ventas v = vreq.construirVentaConArts();
			
			v.setGanancia(ganancia);
			dataAccess.insertar(v);


		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
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

	private float deducirStockDeArticulo(VentaRequest vreq, int idArt, int cantidadPedidaDeArticulo){
			Articulo a = this.articuloServicio.getbyID(idArt); // buscamos objeto con ese id
			vreq.setListaArticulos(new ArrayList<Articulo>());
			vreq.getListaArticulos().add(a);
			System.out.println("ARTICULO: " + a.getNombre() + " - CANTIDAD: " + cantidadPedidaDeArticulo);

			Boolean stockInsuficiente = true;
			Stock s = this.stockServicio.get_STOCKOBJ_BY_IDART(idArt);
			
			

			if (cantidadPedidaDeArticulo <= this.stockServicio.obtenerStockDeArticuloMasViejo(a.getId())) {
				this.stockServicio.deducirStock(a, cantidadPedidaDeArticulo);
				stockInsuficiente = false;
			}

			while (stockInsuficiente) {
				if (cantidadPedidaDeArticulo >= this.stockServicio.obtenerStockDeArticuloMasViejo(a.getId()))
				{
					Integer restar = this.stockServicio.obtenerStockDeArticuloMasViejo(a.getId());
					this.stockServicio.deducirStock(a, restar);
					cantidadPedidaDeArticulo -= restar;
				}
				if (cantidadPedidaDeArticulo < this.stockServicio.obtenerStockDeArticuloMasViejo(a.getId())) {
					this.stockServicio.deducirStock(a, cantidadPedidaDeArticulo);
					cantidadPedidaDeArticulo = 0;
				}
				if (cantidadPedidaDeArticulo == 0) {
					stockInsuficiente = false;
				}
			}
			return (a.getPrecio() - s.getPrecioCompra()) * cantidadPedidaDeArticulo;
	}
	
}
