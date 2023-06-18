package frgp.utn.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import initializer.DataInitializer;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView MV = new ModelAndView();
        return MV;
    }
    
    @RequestMapping("/login")
    public ModelAndView login() {
    	ModelAndView vw = new ModelAndView();
    	vw.setViewName("Login");
    	
    	return vw;
    }
}
