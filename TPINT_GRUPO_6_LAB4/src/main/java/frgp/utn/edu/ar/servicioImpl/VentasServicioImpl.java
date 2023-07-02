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
import frgp.utn.edu.ar.servicio.ArticuloServicio;
import frgp.utn.edu.ar.servicio.ClienteServicio;
import frgp.utn.edu.ar.servicio.StockServicio;

import frgp.utn.edu.ar.dao.VentasDao;
import frgp.utn.edu.ar.servicio.VentasService;
import frgp.utn.edu.ar.servicioImpl.dtos.DeduccionStock;

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
						   int clienteId) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate ingresoDate = LocalDate.parse(fechaVenta, formatter);
			LocalDateTime ingresoDateTime = ingresoDate.atStartOfDay();
			Instant instant = ingresoDateTime.toInstant(ZoneOffset.UTC);

			Cliente clienteVenta = this.clienteServicio.obtenerPorId(clienteId);

			Ventas venta = new Ventas(Date.from(instant), clienteVenta);

			List<Historico> historicos = new ArrayList<>();

			int cont = 0;
			double montoTotalSuma = 0;
			double ganancia = 0;
			for (String item : idsArticulos) {
				int idArt = Integer.parseInt(item);
				Articulo articulo = this.articuloServicio.getbyID(idArt);
				int cantidadArticulo = Integer.parseInt(idsCantidades.get(cont));

				venta.getListaArticulos().add(articulo);
				montoTotalSuma += articulo.getPrecio() * cantidadArticulo;

				List<DeduccionStock> stocksDeducidos = deducirStockDeArticulo(venta, articulo, cantidadArticulo);
				List<Historico> deduccionesDeStock = armarHistoricoDeStocksDeducidos(venta, stocksDeducidos);
				historicos.addAll(deduccionesDeStock);
				ganancia += calcularGananciaDeStocksDeducidos(stocksDeducidos, articulo);

				cont++;
			}

			venta.setGanancia(ganancia);
			venta.setMontoTotal(montoTotalSuma);
			venta.getHistorialDeduccionesStock().addAll(historicos);
			dataAccess.insertar(venta);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(int id) {
		Ventas v = getbyID(id);

		for (Historico h :
				v.getHistorialDeduccionesStock()) {
			Stock s = h.getStock();
			s.setCantidad(s.getCantidad() + h.getCantidadDeducida());
			stockServicio.actualizar(s);
		}

		v.setEstado(false);
		dataAccess.actualizar(v);
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
	
	@Override
	public double obtenerGananciaTotalPorRangoFechas(Date fechaIni, Date fechaFin) {
		return dataAccess.obtenerGananciaTotalPorRangoFechas(fechaIni, fechaFin);
	}

	private List<DeduccionStock> deducirStockDeArticulo(Ventas v, Articulo a, int cantidadPedidaDeArticulo){
		System.out.println("ARTICULO: " + a.getNombre() + " - CANTIDAD: " + cantidadPedidaDeArticulo);

		// Trae todos los stocks del articulo con cantidad > 0, del mas viejo al mas nuevo.
		List<Stock> stocksArt = this.stockServicio.obtenerStocksDeArticulo(a.getId());
		List<DeduccionStock> stocksDeducidos = new ArrayList<>();

		for(int i = 0; i < stocksArt.size(); i++){
			Stock s = stocksArt.get(i);

			int cantidadStock = s.getCantidad();

			if(cantidadPedidaDeArticulo >= cantidadStock){
				s.setCantidad(0);
				stockServicio.actualizar(s);
				cantidadPedidaDeArticulo -= cantidadStock;

				stocksDeducidos.add(new DeduccionStock(s, cantidadStock));
			}
			else{
				s.setCantidad(cantidadStock - cantidadPedidaDeArticulo);
				stockServicio.actualizar(s);
				stocksDeducidos.add(new DeduccionStock(s, cantidadStock));
				break;
			}
		}

		return stocksDeducidos;
	}
	
	private List<Historico> armarHistoricoDeStocksDeducidos(Ventas venta, List<DeduccionStock> stocksDeducidos){
		List<Historico> historial = new ArrayList<>();

		for (DeduccionStock stockDeducido :
				stocksDeducidos) {
			Historico h = new Historico(venta, stockDeducido.getStock(), stockDeducido.getCantidadDeducida());
			historial.add(h);
		}

		return historial;
	}

	private double calcularGananciaDeStocksDeducidos(List<DeduccionStock> deducciones, Articulo a){
		double ganancia = 0;

		for (DeduccionStock deduccion:
			 deducciones) {
			Stock s = deduccion.getStock();
			ganancia += (a.getPrecio() - s.getPrecioCompra()) * (double)deduccion.getCantidadDeducida();
		}

		return ganancia;
	}
}

