package frgp.utn.edu.ar.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;

import com.google.gson.Gson;
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
		ArrayList<Cliente> listar = this.service.obtenerTodos();
		if(listar != null) {			
			MV.addObject("clientes", listar);
		}
		MV.setViewName("Clientes/Listado");
		return MV;
	}

	@RequestMapping("/{id}")
	@ResponseBody
	public ResponseEntity<String> obtenerClienteJSON(@PathVariable int id) {
		Cliente c = this.service.obtenerPorId(id);

		Gson gson = new Gson();
		String jsonArray = gson.toJson(c.construirDtoClienteRequest());
		return new ResponseEntity<>(jsonArray, HttpStatus.OK);
	}

	@RequestMapping(value ="/crear" , method = RequestMethod.POST)
	@ResponseBody
	public String crear(@ModelAttribute ClienteRequest cliente,
									 BindingResult bindingResult){

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
			service.insertar(cliente.construirCliente());
			result.setStatus(ResultStatus.ok);
			result.setMessage("Cliente agregado");
		}
		catch(Exception e)
		{
			result.setStatus(ResultStatus.error);
			result.setMessage("No se pudo insertar el cliente");
			System.out.println(e);
		}

		json = gson.toJson(result);
		return json;
	}


	@RequestMapping(value ="/modificar" , method = RequestMethod.POST)
	@ResponseBody
	public String modificarPost(@ModelAttribute ClienteRequest cliente,
									 BindingResult bindingResult){
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
			service.actualizar(cliente.construirCliente());
			result.setStatus(ResultStatus.ok);
			result.setMessage("Cliente actualizado");
		}
		catch(Exception e)
		{
			result.setStatus(ResultStatus.error);
			result.setMessage("Error al actualizar cliente");
			System.out.println(e);
		}

		json = gson.toJson(result);
		return json;
	}
	
     
	@RequestMapping(value ="/eliminar/{id}")
	@ResponseBody
	public ResponseEntity<String> eliminar(@PathVariable int id){
		try{
			service.eliminar(id);
			return new ResponseEntity<>("true", HttpStatus.OK);
		}
		catch(Exception e){
			System.out.println(e);
		}

		return new ResponseEntity<>("false", HttpStatus.OK);
	}

}
