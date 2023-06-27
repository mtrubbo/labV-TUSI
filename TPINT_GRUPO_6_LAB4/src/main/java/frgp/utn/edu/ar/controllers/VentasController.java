package frgp.utn.edu.ar.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.Stock;
import frgp.utn.edu.ar.dominio.Ventas;
import frgp.utn.edu.ar.dtos.ArticuloInfo;
import frgp.utn.edu.ar.dtos.ResponseResult;
import frgp.utn.edu.ar.dtos.ResultStatus;
import frgp.utn.edu.ar.dtos.VentaRequest;
import frgp.utn.edu.ar.helpers.JsonUtils;
import frgp.utn.edu.ar.servicio.ArticuloServicio;
import frgp.utn.edu.ar.servicio.ClienteServicio;
import frgp.utn.edu.ar.servicio.StockServicio;
import frgp.utn.edu.ar.servicio.VentasService;

@Controller
@RequestMapping("/ventas")
public class VentasController {
	
	@Autowired
	public VentasService  service;
	
	@Autowired
	public ArticuloServicio artService;
	
	@Autowired
	public ClienteServicio cService;
	
	@Autowired
	public StockServicio sService;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		this.service = (VentasService) ctx.getBean("serviceBeanVentas");
	}
	
	@RequestMapping("")
	public ModelAndView lista(){
		ModelAndView MV = new ModelAndView();
		ArrayList<Ventas> listarr = this.service.obtenerTodos();
		if(listarr != null) {			
			MV.addObject("ventas", listarr);
		}
		
		ArrayList<Cliente> lClientes = this.cService.obtenerTodos();
		if(lClientes != null) {			
			MV.addObject("clientes", lClientes);
		}
		
		ArrayList<Articulo> lArt = this.artService.obtenerTodos();
		if(lArt != null) {			
			MV.addObject("Articulos", lArt);
		}
		
		
		MV.setViewName("Ventas/Listado");
		return MV;
	}
	
	
	
	@RequestMapping(value = "/crear/{fechaVenta}/{cliente}/{montoTotal}/{listaArticulos}/{listaCantidades}", method = RequestMethod.GET)
	@ResponseBody
	public String crearVenta(@PathVariable("fechaVenta") String fechaVenta,
			@PathVariable("cliente") int cliente,
			@PathVariable("montoTotal") Double montoTotal,
			@PathVariable("listaArticulos") List<String> listaArticulos,
			@PathVariable("listaCantidades") List<String> listaCantidades,
	                         HttpSession session) {
	    Gson gson = new Gson();
	    ResponseResult result = new ResponseResult();
	    String json = "";
	    VentaRequest vreq = new VentaRequest();	    
	  

	    //System.out.println("LISTA ART: "+listaArticulos.toString());
	   
	    try {
	    	vreq.setListaArticulos(new ArrayList<Articulo>());
	    	
	    		Integer cont = 0;
	    		
				
	    		for (String item : listaArticulos) { //item recibe los ids de listaarticulos
	    				
						Articulo a  = artService.getbyID(Integer.parseInt(item)); //buscamos objeto con ese id
						vreq.getListaArticulos().add(a);
						Integer c = Integer.parseInt(listaCantidades.get(cont));
						System.out.println("ARTICULO: "+a.getNombre() + " - CANTIDAD: " + c);
						sService.deducirStock(a, c);
						cont++;
				}
	    			    			    		    		
	  	    		
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        LocalDate ingresoDate = LocalDate.parse(fechaVenta, formatter);
		        LocalDateTime ingresoDateTime = ingresoDate.atStartOfDay();
		        Instant instant = ingresoDateTime.toInstant(ZoneOffset.UTC);
		        
		        
		        vreq.setFecha(Date.from(instant));
		        vreq.setCliente(cService.obtenerPorId(cliente));
		        vreq.setMontoTotal(montoTotal);
		                    
		        service.insertar(vreq.construirVentaConArts());
		        
		        System.out.println("TEST6");
	        result.setStatus(ResultStatus.ok);
	        result.setMessage("Se ha creado con �xito");
	    } catch (Exception e) {
	        result.setStatus(ResultStatus.error);
	        result.setMessage("Error al insertar venta");
	        System.out.println(e.getMessage());
	        System.out.println(e.getCause());
	        e.printStackTrace();
	    }

	    json = gson.toJson(result);
	    return json;
	}
	

	
	
     
	@RequestMapping(value ="/eliminar/{id}" , method= { RequestMethod.GET })
	@ResponseBody
	public String eliminar(@PathVariable int id){
		Gson gson = new Gson();
		ResponseResult result = new ResponseResult();
		String json = "";

		String Message="";

		try{
			Ventas a = service.getbyID(id);
			a.setEstado(false);
			service.actualizar(a);
			result.setStatus(ResultStatus.ok);
			result.setMessage("Se ha eliminado con exito con exito");
		}
		catch(Exception e)
		{
			result.setStatus(ResultStatus.error);
			result.setMessage("Error al eliminar la venta");
			System.out.println(e);
		}

		json = gson.toJson(result);
		return json;
	}

	@RequestMapping("/consultas")
	public ModelAndView consultaVentas(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Ventas/Consultas");
		
		float suma=0;
		ArrayList<Ventas> list = service.obtenerTodos();
		for (Ventas v : list) {
			suma += v.getMontoTotal();
		}
		MV.addObject("montoTotal", suma);
		
		return MV;
	}

	@RequestMapping(value = "/consultas/{fechaInicio}/{fechaFin}", method = RequestMethod.GET)
	public ModelAndView listaPorfecha(@PathVariable("fechaInicio") String fechaInicio, @PathVariable("fechaFin") String fechaFin)
			throws ParseException {

		ModelAndView vm = new ModelAndView("Ventas/Consultas");

		System.out.println(fechaInicio);
		System.out.println(fechaFin);
		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");

		Date fechaIni = dateFmt.parse(fechaInicio);
		Date fechaFinal = dateFmt.parse(fechaFin);

		vm.addObject("Ventas", this.service.obtenerPorRangoDeFechas(fechaIni, fechaFinal));

		return vm;
	}

	@RequestMapping(value = "/consultas/detalles/{id}", method = RequestMethod.GET)
	public ModelAndView detallesVenta(@PathVariable int id)
			throws ParseException {
		ModelAndView vm = new ModelAndView("Ventas/DetallesConsulta");
		vm.addObject("articulos", this.service.getbyID(id).getListaArticulos());

		return vm;
	}
	
	
	@RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getDetalle(@PathVariable int id) {
		Ventas venta = this.service.getbyID(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("venta", venta.getId());
		mv.addObject("fecha", venta.getFecha());
		mv.addObject("cliente", venta.getCliente().getNombre() + " "+venta.getCliente().getApellido());
		mv.addObject("articulos", venta.getListaArticulos());
		mv.addObject("monto", venta.getMontoTotal());
		mv.setViewName("Ventas/Detalle");
		return mv;	 
    }
	
	@RequestMapping(value = "/getArticulo_by_venta/{id}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<String> getArticuloById(@PathVariable int id) {
		Articulo articulo = this.artService.getbyID(id);
		ArticuloInfo aif = articulo.getArticuloInfo();
	    Gson gson = new Gson();
	    String jsonArray = gson.toJson(aif);
	    return new ResponseEntity<>(jsonArray, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/hasStock_by_id/{id}/{qt}", method = RequestMethod.GET)
	@ResponseBody
    public String hasStock(@PathVariable int id, @PathVariable int qt) {
	    Gson gson = new Gson();
	    String json;
		Stock s = sService.artByID(id);
		ResponseResult result = new ResponseResult();
		
		if(s.getCantidad() - qt >=0 && s!=null) {
			result.setStatus(ResultStatus.ok);
			result.setMessage("Con stock!");
			json = gson.toJson(result);
			return json;
		}				
		
		System.out.println("NO HAY STOCK");
		result.setStatus(ResultStatus.error);
		result.setMessage("Sin stock!");
		json = gson.toJson(result);
		return json;

		
    }
	
	

	
	
}
