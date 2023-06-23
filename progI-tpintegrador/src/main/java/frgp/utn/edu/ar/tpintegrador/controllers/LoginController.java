package frgp.utn.edu.ar.tpintegrador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showLoginForm() {
        return "Login"; // Aquí debes retornar el nombre de la vista del formulario de inicio de sesión
    }
}