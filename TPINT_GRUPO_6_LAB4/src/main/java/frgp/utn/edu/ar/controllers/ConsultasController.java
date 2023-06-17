package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/consultas")
public class ConsultasController {
	
	@RequestMapping("")
	public ModelAndView lista(){
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Consultas/HomeConsulta");
		return MV;
	}
}
