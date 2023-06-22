package frgp.utn.edu.ar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.initializer.DataInitializer;

@Controller
@RequestMapping("/")
public class IndexController {

	
    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView MV = new ModelAndView();
        
        MV.setViewName("Index");
        return MV;
    }
    
}
