package frgp.utn.edu.ar.controllers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;


import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dtos.ResponseResult;
import frgp.utn.edu.ar.dtos.ResultStatus;
import frgp.utn.edu.ar.servicio.ArticuloServicio;

import frgp.utn.edu.ar.dominio.Stock;
import frgp.utn.edu.ar.dtos.StockRequest;
import frgp.utn.edu.ar.servicio.StockServicio;

@Controller
@RequestMapping("/stocks")
public class StockController {
	
	@Autowired
	public StockServicio service;
	
	@Autowired
	public ArticuloServicio serviceArticulo;
	

	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		this.service = (StockServicio) ctx.getBean("serviceBeanStock");
	}


	//Inicio

	
	@RequestMapping("")
	public ModelAndView lista(){
		ModelAndView MV = new ModelAndView();
		ArrayList<Stock> listarr = this.service.obtenerTodos();
		if(listarr != null) {			
			MV.addObject("stocks", listarr);
		}
		
		//LISTA LOS ARTICULOS EN EL DROPDOWNLIST
		
		ArrayList<Articulo> listaArticulos = serviceArticulo.obtenerTodos();
		if(listaArticulos != null) {			
			MV.addObject("articulos", listaArticulos);
		}
		
		MV.setViewName("Stocks/Listado");
		return MV;
	}
	
	
	
	
	@RequestMapping(value = "/getStock/{id}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<String> getStockById(@PathVariable int id) {
		Stock stock = this.service.getbyID(id);
	    Gson gson = new Gson();
	    String jsonArray = gson.toJson(stock);
	    return new ResponseEntity<>(jsonArray, HttpStatus.OK);
    }


	@RequestMapping(value = "/adding/{articulo}/{fechaIngreso}/{precioCompra}/{cantidad}", method = RequestMethod.GET)
	@ResponseBody
	public String crear(@PathVariable int articulo, @PathVariable String fechaIngreso, 
			@PathVariable float precioCompra, @PathVariable int cantidad) {
	    System.out.println("llego aquí");
	    Gson gson = new Gson();
	    ResponseResult result = new ResponseResult();
	    String json = "";

	    try {
	        StockRequest stock = new StockRequest();
	        stock.setArticulo(serviceArticulo.getbyID(articulo));
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate ingresoDate = LocalDate.parse(fechaIngreso, formatter);
	        LocalDateTime ingresoDateTime = ingresoDate.atStartOfDay();
	        Instant instant = ingresoDateTime.toInstant(ZoneOffset.UTC);
	        stock.setFechaIngreso(Date.from(instant));
	        
	        stock.setPrecioCompra(precioCompra);
	        stock.setCantidad(cantidad);

	        System.out.println(stock.toString());

	        this.service.insertar(stock.construirStock());

	        result.setStatus(ResultStatus.ok);
	        result.setMessage("Se ha creado con éxito");
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	        result.setStatus(ResultStatus.error);
	        result.setMessage("Error al insertar el stock");
	        e.printStackTrace();
	    }

	    json = gson.toJson(result);
	    return json;
	}
}
