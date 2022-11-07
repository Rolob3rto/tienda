package com.rolob3rto.springprojects.tienda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rolob3rto.springprojects.tienda.model.Usuario;


@Controller
@RequestMapping("/login")
public class LoginController {
    
    @RequestMapping(value="/signin")
    public ModelAndView signin() {
        

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.setViewName("login/signin");

        return modelAndView;
    }

    @PostMapping(value="/login")
    public ModelAndView login(Usuario usuario) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", usuario);
        modelAndView.setViewName("login/login");

        return modelAndView;
    }
    
}
