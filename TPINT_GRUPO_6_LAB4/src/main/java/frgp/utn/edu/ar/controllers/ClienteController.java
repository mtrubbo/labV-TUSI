package frgp.utn.edu.ar.controllers;

import javax.servlet.ServletConfig;

import com.google.gson.Gson;
import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dtos.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;


import frgp.utn.edu.ar.servicio.ClienteServicio;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	public ClienteServicio service;

	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		this.service = (ClienteServicio) ctx.getBean("serviceBean");
	}


	//Inicio

	@RequestMapping("")
	public ModelAndView lista(){
		ModelAndView MV = new ModelAndView();
		MV.addObject("clientes",this.service.obtenerTodos());
		MV.setViewName("Clientes/Listado");
		return MV;
	}

	@RequestMapping("/{id}")
	@ResponseBody
	public ResponseEntity<String> obtenerClienteJSON(@PathVariable int id) {
		Cliente c = this.service.obtenerPorId(id);
		Gson gson = new Gson();
		String jsonArray = gson.toJson(c);
		return new ResponseEntity<>(jsonArray, HttpStatus.OK);
	}


	@RequestMapping("/alta")
	public ModelAndView pantallaDeAlta(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Clientes/Alta");
		return MV;
	}


	@RequestMapping(value ="/crear" , method = RequestMethod.POST)
	@ResponseBody
	public String crear(@ModelAttribute ClienteRequest clienteRequest,
									 BindingResult bindingResult){

		String Message="";
		if(bindingResult.hasErrors()){
			for (ObjectError error: bindingResult.getAllErrors()) {
				Message += error.getObjectName() + ": " + error.getDefaultMessage() + "\n";
			}

			System.out.println(Message);

			return "Error al intentar dar de alta cliente";
		}

		try{
			service.insertar(clienteRequest.construirCliente());
			return "Cliente agregado";
		}
		catch(Exception e)
		{
			return "No se pudo insertar el cliente";
		}
	}

	@RequestMapping("/modificar/{id}")
	public ModelAndView modificarGet(@PathVariable int id){
		ModelAndView MV = new ModelAndView();
		MV.addObject("Cliente", this.service.obtenerPorId(id));
		MV.setViewName("Clientes/Modificar");
		return MV;
	}

	@RequestMapping(value ="/modificar" , method = RequestMethod.POST)
	@ResponseBody
	public String modificarPost(@ModelAttribute ClienteRequest cliente,
									 BindingResult bindingResult){
		ModelAndView MV = new ModelAndView();

		String Message="";

		if(bindingResult.hasErrors()){
			for (ObjectError error: bindingResult.getAllErrors()) {
				Message += error.getObjectName() + ": " + error.getDefaultMessage() + "\n";
			}

			System.out.println(Message);

			return "Hubo un error con los datos enviados. Por favor revise los campos.";
		}

		try{
			service.actualizar(cliente.construirCliente());
			return "Cliente actualizado exitosamente";
		}
		catch(Exception e)
		{
			System.out.println(e);
			return "Error al actualizar el cliente";
		}
	}
	
     
	@RequestMapping(value ="/eliminar/{id}" , method= { RequestMethod.GET })
	public ModelAndView eliminar(@PathVariable int id){
		ModelAndView MV = new ModelAndView();
		service.eliminar(id);
		MV.setViewName("redirect:/clientes");
		return MV;
	}

}
