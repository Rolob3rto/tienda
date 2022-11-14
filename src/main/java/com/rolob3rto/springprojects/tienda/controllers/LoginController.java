package com.rolob3rto.springprojects.tienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rolob3rto.springprojects.tienda.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private MessageSource messageSource;
    
    @RequestMapping(value="/signin")
    public ModelAndView signin() {
        

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", new Usuario());
        modelAndView.setViewName("login/signin");

        return modelAndView;
    }

    @PostMapping(value="/login")
    public ModelAndView login(Usuario usuario) {

        String message = messageSource.getMessage("saludar.usuario", new String[] {usuario.getNombre()}, LocaleContextHolder.getLocale());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("greetings", message);
        modelAndView.setViewName("welcome");

        return modelAndView;
    }

    @GetMapping(value="/logout")
    public ModelAndView logout() {
        
        ModelAndView modelAndView = new ModelAndView("login/signin");

        return modelAndView;
    }

    @GetMapping(value="/welcome")
    public String welcome() {
        return "welcome";
    }
    
    
}
