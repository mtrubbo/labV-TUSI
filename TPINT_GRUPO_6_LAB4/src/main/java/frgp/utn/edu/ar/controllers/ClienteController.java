package frgp.utn.edu.ar.controllers;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.web.bind.annotation.PathVariable;

import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.servicio.ClienteServicio;

import java.util.Date;

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
	public ModelAndView crearUsuario(String dni,
									   String nombre,
									   String apellido,
									   String sexo,
									   Date fechaNac,
									   String direccion,
									   String localidad,
									   String email,
									   String telefono){
		ModelAndView MV = new ModelAndView();
		
		Cliente x = new Cliente(dni, nombre, apellido, sexo, fechaNac, direccion, localidad, email, telefono);

		String Message="";
		try{
			
			service.insertar(x);
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
	
     
	@RequestMapping(value ="/eliminar/{dni}" , method= { RequestMethod.GET })
	public ModelAndView eliminar(@PathVariable String dni){
		ModelAndView MV = new ModelAndView();
		service.eliminar(dni);
		MV.addObject("clientes",this.service.obtenerTodos());
		MV.addObject("Mensaje", "Usuario eliminado");
		MV.setViewName("Clientes/Listado");
		return MV;
	}

}
