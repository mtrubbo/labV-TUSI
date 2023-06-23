package frgp.utn.edu.ar.tpintegrador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientesController {
	
	@GetMapping("/clientes")
	private String clientes() {
		return "Clientes";
	}
}
