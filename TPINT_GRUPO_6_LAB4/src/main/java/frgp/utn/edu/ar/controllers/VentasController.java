package frgp.utn.edu.ar.controllers;

import java.util.ArrayList;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dominio.Ventas;
import frgp.utn.edu.ar.servicio.VentasService;

@Controller
@RequestMapping("/ventas")
public class VentasController {
	
	@Autowired
	public VentasService  service;
	
	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		this.service = (VentasService) ctx.getBean("serviceBeanArt");
	}
	
	@RequestMapping("")
	public ModelAndView lista(){
		ModelAndView MV = new ModelAndView();
		ArrayList<Ventas> listarr = this.service.obtenerTodos();
		if(listarr != null) {			
			MV.addObject("ventas", listarr);
		}
		MV.setViewName("Ventas/Listado");
		return MV;
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
	
	
}
