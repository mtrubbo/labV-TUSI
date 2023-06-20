package frgp.utn.edu.ar.controllers;

import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;


import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Marcas;
import frgp.utn.edu.ar.dominio.TipoArticulo;
import frgp.utn.edu.ar.dtos.ArticuloRequest;
import frgp.utn.edu.ar.dtos.MarcasRequest;
import frgp.utn.edu.ar.dtos.ResponseResult;
import frgp.utn.edu.ar.dtos.ResultStatus;
import frgp.utn.edu.ar.servicio.ArticuloServicio;
import frgp.utn.edu.ar.servicio.MarcasServicio;
import frgp.utn.edu.ar.servicio.TipoArticuloServicio;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {
	
	@Autowired
	public ArticuloServicio service;
	
	@Autowired
	public TipoArticuloServicio taService;
	
	@Autowired
	public MarcasServicio mService;

	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		this.service = (ArticuloServicio) ctx.getBean("serviceBeanArt");
	}


	//Inicio

	@RequestMapping("")
	public ModelAndView lista(){
		ModelAndView MV = new ModelAndView();
		ArrayList<Articulo> listarr = this.service.obtenerTodos();
		if(listarr != null) {			
			MV.addObject("articulos", listarr);
		}
		
		ArrayList<TipoArticulo> listTA = this.taService.obtenerTodos();
		if(listTA != null) {			
			MV.addObject("tipoArticulos", listTA);
		}
		
		ArrayList<Marcas> lMarcas = this.mService.obtenerTodos();
		if(lMarcas != null) {			
			MV.addObject("listaMarcas", lMarcas);
		}
		
		MV.setViewName("Articulos/Listado");
		return MV;
	}
	
	@RequestMapping(value = "/getArticulo/{id}", method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<String> getArticuloById(@PathVariable int id) {
		Articulo articulo = this.service.getbyID(id);
	    Gson gson = new Gson();
	    String jsonArray = gson.toJson(articulo);
	    return new ResponseEntity<>(jsonArray, HttpStatus.OK);
    }



	@RequestMapping(value ="/crear/{nombre}/{descripcion}/{marca}/{tipo}/{precio}" , method = RequestMethod.GET)
	@ResponseBody
	public String crearArticulo(@PathVariable String nombre, @PathVariable String descripcion, @PathVariable int marca, @PathVariable int tipo, 
		@PathVariable float precio){
		Gson gson = new Gson();
		ResponseResult result = new ResponseResult();
		String json = "";
		String Message="";
		ArticuloRequest ar = new ArticuloRequest();
		
		ar.setNombre(nombre);
		ar.setDescripcion(descripcion);
		ar.setPrecio(precio);
		ar.setMarca(mService.getbyID(marca));
		ar.setTipo(taService.getbyID(tipo));
		
		System.out.println(ar.toString());
		try{
			this.service.insertar(ar.construirArticulo());
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
			Articulo a = service.getbyID(id);
			a.setEstado(false);
			service.actualizar(a);
			result.setStatus(ResultStatus.ok);
			result.setMessage("Se ha eliminado con exito con exito");
		}
		catch(Exception e)
		{
			result.setStatus(ResultStatus.error);
			result.setMessage("Error al eliminar articulo");
			System.out.println(e);
		}

		json = gson.toJson(result);
		return json;
	}
	
	@RequestMapping(value="/editar/{id}/{nombre}/{descripcion}/{marca}/{tipo}/{precio}", method=RequestMethod.GET)
	@ResponseBody
	public String editar( @PathVariable int id, @PathVariable String nombre, @PathVariable String descripcion, @PathVariable int marca, @PathVariable int tipo, 
			@PathVariable float precio) {
		
		Gson gson = new Gson();
		ResponseResult result = new ResponseResult();
		String json = "";

		String Message="";
		ArticuloRequest ar = new ArticuloRequest();
		
		ar.setId(id);
		ar.setNombre(nombre);
		ar.setDescripcion(descripcion);
		ar.setPrecio(precio);
		ar.setMarca(mService.getbyID(marca));
		ar.setTipo(taService.getbyID(tipo));
		
		System.out.println(ar.toString());

		try{
			service.actualizar(ar.construirArticulo());
			result.setStatus(ResultStatus.ok);
			result.setMessage("Se ha actualizado con exito");
		}
		catch(Exception e)
		{
			result.setStatus(ResultStatus.error);
			result.setMessage("Error al actualizar articulo");
			System.out.println(e);
		}

		json = gson.toJson(result);
		return json;
	}

}
