package frgp.utn.edu.ar.tpintegrador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView("prueba");
        return mv;
    }
}
