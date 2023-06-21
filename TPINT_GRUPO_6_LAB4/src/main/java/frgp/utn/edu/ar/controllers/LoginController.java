package frgp.utn.edu.ar.controllers;

import frgp.utn.edu.ar.dominio.Usuario;
import frgp.utn.edu.ar.dtos.LoginRequest;
import frgp.utn.edu.ar.servicio.LoginServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    public LoginServicio loginService;

    public void init(ServletConfig config) {
        ApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(config.getServletContext());

        this.loginService = (LoginServicio) ctx.getBean("loginService");
    }

    @RequestMapping("/login")
    public ModelAndView loginForm() {
        ModelAndView vw = new ModelAndView();
        vw.setViewName("Login");

        return vw;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute LoginRequest login,
                              BindingResult bindingresult, HttpSession session ) {
        ModelAndView view = new ModelAndView("Login");
        if(!bindingresult.hasErrors()){
            Usuario usuario = loginService.autenticar(login);

            if(usuario == null){
                view.addObject("MensajeError", "Credenciales incorrectas.");
                return view;
            }

            session.setAttribute("usuario", usuario.getNombrePublico());
            session.setAttribute("usuarioRol", usuario.getRol().getDescripcion());
            view.setViewName("redirect:/");
        }

        return view;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
