package frgp.utn.edu.ar.tpintegrador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showLoginForm(@RequestParam(value="error",required=false) String error, Model model) {
        
    	if(error!=null) {
    		model.addAttribute("error","Los datos ingresados son incorrectos");
    		System.out.println("error de acceso");
    	}
    	return "Login"; // retornar el nombre de la vista del formulario de inicio de sesión
    }
}