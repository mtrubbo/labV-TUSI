package frgp.utn.edu.ar.controllers;

import javax.servlet.ServletConfig;

import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dtos.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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


	@RequestMapping("/alta")
	public ModelAndView pantallaDeAlta(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Clientes/Alta");
		return MV;
	}


	@RequestMapping(value ="/crear" , method = RequestMethod.POST)
	public ModelAndView crear(@ModelAttribute ClienteRequest clienteRequest,
									 BindingResult bindingResult){
		ModelAndView MV = new ModelAndView();
		
		String Message="";

		if(bindingResult.hasErrors()){
			for (ObjectError error: bindingResult.getAllErrors()) {
				Message += error.getObjectName() + ": " + error.getDefaultMessage() + "\n";
			}

			MV.addObject("Mensaje", Message);
			MV.setViewName("Clientes/Alta");
		}

		try{
			service.insertar(clienteRequest.construirCliente());
			Message = "Cliente agregado";
		}
		catch(Exception e)
		{
			Message = "No se pudo insertar el cliente";
		}
	
		MV.addObject("Mensaje", Message);
		MV.setViewName("Clientes/Alta");
		return MV;
	}

	@RequestMapping("/modificar/{id}")
	public ModelAndView modificarGet(@PathVariable int id){
		ModelAndView MV = new ModelAndView();
		MV.addObject("Cliente", this.service.obtenerPorId(id));
		MV.setViewName("Clientes/Modificar");
		return MV;
	}

	@RequestMapping(value ="/modificar" , method = RequestMethod.POST)
	public ModelAndView modificarPost(@ModelAttribute ClienteRequest cliente,
									 BindingResult bindingResult){
		ModelAndView MV = new ModelAndView();

		String Message="";

		if(bindingResult.hasErrors()){
			for (ObjectError error: bindingResult.getAllErrors()) {
				Message += error.getObjectName() + ": " + error.getDefaultMessage() + "\n";
			}

			MV.addObject("Mensaje", Message);
			MV.addObject("Cliente", cliente);
			MV.setViewName("Clientes/Modificar");
		}

		try{
			service.actualizar(cliente.construirCliente());
			Message = "Cliente actualizado";
		}
		catch(Exception e)
		{
			System.out.println(e);
			Message = "No se pudo actualizar el cliente";
		}

		MV.addObject("Mensaje", Message);
		MV.addObject("Cliente", service.obtenerPorId(cliente.getId()));
		MV.setViewName("Clientes/Modificar");
		return MV;
	}
	
     
	@RequestMapping(value ="/eliminar/{id}" , method= { RequestMethod.GET })
	public ModelAndView eliminar(@PathVariable int id){
		ModelAndView MV = new ModelAndView();
		service.eliminar(id);
		MV.addObject("clientes",this.service.obtenerTodos());
		MV.addObject("Mensaje", "Usuario eliminado");
		MV.setViewName("Clientes/Listado");
		return MV;
	}

}
