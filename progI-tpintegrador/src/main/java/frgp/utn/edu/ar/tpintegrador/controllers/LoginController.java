package frgp.utn.edu.ar.tpintegrador.controllers;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showLoginForm(@RequestParam(value="error",required=false) String error, 
    		Model model, Principal principal, @RequestParam(value="logout",required=false) String logout) {
        
    	if(error!=null) { //si no es nulo, hubo error de datos
    		model.addAttribute("error","Los datos ingresados son incorrectos");
    	}   	
    	if(principal!=null) { //si no es nulo, hay una sesion activa
    		model.addAttribute("logueado","Usted ya ha iniciado sesion");
    		return "Clientes";
    	}
    	if(logout!=null) { //si no es nulo, se clickeó el boton de logout
    		model.addAttribute("deslogueado","Usted ha cerrado sesion");
    	}
    	
    	return "Login"; // retornar el nombre de la vista del formulario de inicio de sesión
    }
    
    //Alternativa de deslogueo a la que hay en securityconfig .logout
    /* 
    @GetMapping("/logoutt")
    public String logout() {
    	System.out.println("DESLOGUEADO");
    	SecurityContextHolder.getContext().setAuthentication(null);
    	return "redirect:/Login";
    }
     */
}