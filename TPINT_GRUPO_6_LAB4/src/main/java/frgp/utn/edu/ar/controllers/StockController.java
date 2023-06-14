package frgp.utn.edu.ar.controllers;

import java.util.ArrayList;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;


import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dtos.ArticuloRequest;
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
	private ArticuloController articuloController;

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
		
		ArrayList<Articulo> listaArticulos = articuloController.service.obtenerTodos();
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

	@RequestMapping("/alta")
	public ModelAndView pantallaDeAlta(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Stocks/Alta");
		return MV;
	}

	@RequestMapping(value ="/crear" , method = RequestMethod.POST)
	public ModelAndView crearStock(@ModelAttribute StockRequest stockRequest,
									 BindingResult bindingResult){
		ModelAndView MV = new ModelAndView();
		
		String Message="";

		if(bindingResult.hasErrors()){
			for (ObjectError error: bindingResult.getAllErrors()) {
				Message += error.getObjectName() + ": " + error.getDefaultMessage() + "\n";
			}

			MV.addObject("Mensaje", Message);
			MV.setViewName("Stocks/Listado");
		}

		try{
			service.insertar(stockRequest.construirStock());
			Message = "Stock agregado";
		}
		catch(Exception e)
		{
			Message = "No se pudo agregar el stock";
		}
	
		MV.addObject("Mensaje", Message);
		MV.setViewName("Stocks/Listado");
		return MV;		
	}
	
     
	

}
