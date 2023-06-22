package frgp.utn.edu.ar.controllers;

import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
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

import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dominio.Ventas;
import frgp.utn.edu.ar.dtos.ResponseResult;
import frgp.utn.edu.ar.dtos.ResultStatus;
import frgp.utn.edu.ar.dtos.VentaRequest;
import frgp.utn.edu.ar.servicio.ArticuloServicio;
import frgp.utn.edu.ar.servicio.ClienteServicio;
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
	
	@RequestMapping(value ="/crear" , method = RequestMethod.POST)
	@ResponseBody
	public String crearVenta(@ModelAttribute VentaRequest ventaRequest,
									 BindingResult bindingResult, HttpSession session){
		Gson gson = new Gson();
		ResponseResult result = new ResponseResult();
		String json = "";

		String Message="";
		if(bindingResult.hasErrors()){
			for (ObjectError error: bindingResult.getAllErrors()) {
				Message += error.getObjectName() + ": " + error.getDefaultMessage() + "\n";
			}

			System.out.println(Message);

			result.setStatus(ResultStatus.error);
			result.setMessage("Hubo un error con los datos enviados. Por favor revise los campos.");
			json = gson.toJson(result);
			return json;
		}

		try{
			service.insertar(ventaRequest.construirVenta());
			result.setStatus(ResultStatus.ok);
			result.setMessage("Se ha creado con exito");
		}
		catch(Exception e)
		{
			result.setStatus(ResultStatus.error);
			result.setMessage("Error al insertar el  articulo");
			System.out.println(e);
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
		ArrayList<Ventas> listarr = this.service.obtenerTodos();
		if(listarr != null) {			
			MV.addObject("ventas", listarr);
		}
		MV.setViewName("Consultas/HomeConsultas");
		return MV;
	}
	
	@RequestMapping(value = "/getArticulo_by_venta/{id}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<String> getArticuloById(@PathVariable int id) {
		Articulo articulo = this.artService.getbyID(id);
	    Gson gson = new Gson();
	    String jsonArray = gson.toJson(articulo);
	    return new ResponseEntity<>(jsonArray, HttpStatus.OK);
    }

	
	
}
