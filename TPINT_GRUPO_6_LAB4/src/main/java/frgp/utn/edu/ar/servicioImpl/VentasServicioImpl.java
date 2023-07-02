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

import frgp.utn.edu.ar.dao.HistoricoDao;
import frgp.utn.edu.ar.dominio.*;
import frgp.utn.edu.ar.dtos.ConsultaVentasResponse;
import frgp.utn.edu.ar.dtos.VentaRequest;
import frgp.utn.edu.ar.servicio.ArticuloServicio;
import frgp.utn.edu.ar.servicio.ClienteServicio;
import frgp.utn.edu.ar.servicio.StockServicio;

import frgp.utn.edu.ar.dao.VentasDao;
import frgp.utn.edu.ar.servicio.VentasService;

public class VentasServicioImpl  implements VentasService{

	private VentasDao dataAccess;
	private HistoricoDao historico;
	private StockServicio stockServicio;
	private ArticuloServicio articuloServicio;
	private ClienteServicio clienteServicio;

	public void setDataAccess(VentasDao dataAccess) {
		this.dataAccess = dataAccess;
	}

	public void setHistorico(HistoricoDao historico) {
		this.historico = historico;
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
	public void crearVenta(List<String> idsArticulos,
						   List<String> idsCantidades,
						   String fechaVenta,
						   int clienteId,
						   double montoTotal) {
		try {
			Integer cont = 0;
			float ganancia = 0;

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate ingresoDate = LocalDate.parse(fechaVenta, formatter);
			LocalDateTime ingresoDateTime = ingresoDate.atStartOfDay();
			Instant instant = ingresoDateTime.toInstant(ZoneOffset.UTC);

			Cliente clienteVenta = this.clienteServicio.obtenerPorId(clienteId);

			Ventas venta = new Ventas(Date.from(instant), montoTotal, clienteVenta);

			for (String item : idsArticulos) {
				int idArt = Integer.parseInt(item);
				Articulo articulo = this.articuloServicio.getbyID(idArt);
				Stock stock = this.stockServicio.obtenerStockPorIdArticulo(articulo.getId());
				int cantidadArticulo = Integer.parseInt(idsCantidades.get(cont));

				venta.getListaArticulos().add(articulo);
				ganancia += (articulo.getPrecio() - stock.getPrecioCompra()) * cantidadArticulo;

				deducirStockDeArticulo(venta, articulo, cantidadArticulo);

				cont++;
			}

			venta.setGanancia(ganancia);
			dataAccess.insertar(venta);

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

	private void deducirStockDeArticulo(Ventas v,
										 Articulo a,
										 int cantidadPedidaDeArticulo){
		System.out.println("ARTICULO: " + a.getNombre() + " - CANTIDAD: " + cantidadPedidaDeArticulo);

		// Trae todos los stocks del articulo, del mas viejo al mas nuevo.
		List<Stock> stocksArt = this.stockServicio.obtenerStocksDeArticulo(a.getId());

		for(int i = 0; i < stocksArt.size(); i++){
			Stock s = stocksArt.get(i);
			int cantidadStock = s.getCantidad();

			// si cant. pedida > stock disponible, deduzco solo el stock disponible
			// para que no quede nro negativo.
			if(cantidadPedidaDeArticulo >= cantidadStock){
				this.stockServicio.deducirStock(a, cantidadStock);
				cantidadPedidaDeArticulo -= cantidadStock;
			}
			else{
				this.stockServicio.deducirStock(a, cantidadPedidaDeArticulo);
				break;
			}
		}

	}
}
