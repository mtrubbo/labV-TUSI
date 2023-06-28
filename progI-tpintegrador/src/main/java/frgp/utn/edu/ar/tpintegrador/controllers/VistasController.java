package frgp.utn.edu.ar.tpintegrador.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@SessionAttributes("userName")
public class VistasController {
    @GetMapping("/clientes")

    public String vistaClientes(HttpSession session) {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        System.out.println();
        System.out.println();

        if(principal.getClass().equals(DefaultOidcUser.class)){
            session.setAttribute("userName", ((DefaultOidcUser) principal).getAttributes().get("name"));
        }
        else { session.setAttribute("userName", ((User) principal).getUsername()); }
        return "Clientes";
    }

    @GetMapping("/prestamos")
    public String vistaPrestamos(HttpSession session) {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if(principal.getClass().equals(DefaultOidcUser.class)){
            session.setAttribute("userName", ((DefaultOidcUser) principal).getAttributes().get("name"));
        }
        else { session.setAttribute("userName", ((User) principal).getUsername()); }

        return "Prestamos";
    }
}
