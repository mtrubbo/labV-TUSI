package frgp.utn.edu.ar.tpintegrador.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showLoginForm(@RequestParam(value="error",required=false) String error, Model model, Principal principal) {
        
    	if(error!=null) { //si no es nulo, hubo error de datos
    		model.addAttribute("error","Los datos ingresados son incorrectos");
    	}
    	
    	if(principal!=null) { //si no es nulo, hay una sesion activa
    		model.addAttribute("logueado","Usted ya ha iniciado sesion");
    		return "Clientes";
    	}
    	
    	return "Login"; // retornar el nombre de la vista del formulario de inicio de sesión
    }
}