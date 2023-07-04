package frgp.utn.edu.ar.tpintegrador.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientesControllers {

	@GetMapping("/clientes")
		public String hola(Model model, String logout) {
		
		    	if(logout!=null) { //si no es nulo, se clickeó el boton de logout
		    		model.addAttribute("deslogueado","Usted ha cerrado sesion");
		    	}
		    	
		    	return "Clientes"; // retornar el nombre de la vista del formulario de inicio de sesión
		}
}
