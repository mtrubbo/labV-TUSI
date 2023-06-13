package frgp.utn.edu.ar.controllers;

import javax.servlet.ServletConfig;

import com.google.gson.Gson;
import frgp.utn.edu.ar.dominio.Articulo;
import frgp.utn.edu.ar.dominio.Cliente;
import frgp.utn.edu.ar.dtos.ClienteRequest;
import frgp.utn.edu.ar.dtos.ResponseResult;
import frgp.utn.edu.ar.dtos.ResultStatus;
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



	@RequestMapping(value ="/crear" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult crear(@ModelAttribute ClienteRequest cliente,
									 BindingResult bindingResult){

		String Message="";
		ResponseResult result = new ResponseResult();
		if(bindingResult.hasErrors()){
			for (ObjectError error: bindingResult.getAllErrors()) {
				Message += error.getObjectName() + ": " + error.getDefaultMessage() + "\n";
			}

			System.out.println(Message);

			result.setStatus(ResultStatus.error);
			result.setMessage("Hubo un error con los datos enviados. Por favor revise los campos.");
			return result;
		}

		try{
			service.insertar(cliente.construirCliente());
			result.setStatus(ResultStatus.ok);
			result.setMessage("Cliente dado de alta exitosamente");
		}
		catch(Exception e)
		{
			System.out.println(e);
			result.setStatus(ResultStatus.error);
			result.setMessage("Error al intentar dar de alta el cliente");
		}

		return result;
	}


	@RequestMapping(value ="/modificar" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult modificarPost(@ModelAttribute ClienteRequest cliente,
									 BindingResult bindingResult){
		ModelAndView MV = new ModelAndView();

		String Message="";
		ResponseResult result = new ResponseResult();
		if(bindingResult.hasErrors()){
			for (ObjectError error: bindingResult.getAllErrors()) {
				Message += error.getObjectName() + ": " + error.getDefaultMessage() + "\n";
			}

			System.out.println(Message);

			result.setStatus(ResultStatus.error);
			result.setMessage("Hubo un error con los datos enviados. Por favor revise los campos.");
			return result;
		}

		try{
			service.actualizar(cliente.construirCliente());
			result.setStatus(ResultStatus.ok);
			result.setMessage("Cliente actualizado exitosamente");
		}
		catch(Exception e)
		{
			System.out.println(e);
			result.setStatus(ResultStatus.error);
			result.setMessage("Error al actualizar el cliente");
		}

		return result;
	}
	
     
	@RequestMapping(value ="/eliminar/{id}" , method= { RequestMethod.GET })
	public ModelAndView eliminar(@PathVariable int id){
		ModelAndView MV = new ModelAndView();
		service.eliminar(id);
		MV.setViewName("redirect:/clientes");
		return MV;
	}

}
