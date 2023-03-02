package com.rolob3rto.springprojects.tienda.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rolob3rto.springprojects.tienda.model.Contacto;
import com.rolob3rto.springprojects.tienda.services.ContactoServices;


@Controller
@RequestMapping("/contactos")
public class ContactoController {

    @Autowired
    ContactoServices contactosService;
  
    @GetMapping(value = "/list")
    public ModelAndView listPage(Model model) {

        List<Contacto> contactos = contactosService.findAll();

        ModelAndView modelAndView = new ModelAndView("contactos/list");
        modelAndView.addObject("contactos", contactos);

        return modelAndView;
    }
    
    @RequestMapping(path = "/edit")
    public ModelAndView edit(@RequestParam(name = "codigo", required = true) int codigo ){

        ModelAndView modelAndView = new ModelAndView();

        Contacto contacto = contactosService.findContacto(codigo);
        modelAndView.addObject("contacto", contacto);
        modelAndView.setViewName("contactos/edit");

        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create(){

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("contacto", new Contacto());
         modelAndView.setViewName("contactos/new");

         return modelAndView;
    }

    @RequestMapping(path = "/save")
    public ModelAndView save(Contacto contacto) throws IOException{

        Contacto contactoAlta = contactosService.save(contacto);

         ModelAndView modelAndView = new ModelAndView();
        

         modelAndView.setViewName("redirect:edit?codigo=" + contactoAlta.getCodigo());

         return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView update(Contacto contacto) throws IOException{
        
        contactosService.update(contacto);
        
         
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("redirect:edit?codigo=" + contacto.getCodigo());

         return modelAndView;
    }

    @RequestMapping(path = "/delete/{codigo}")
    public ModelAndView delete(@PathVariable(name = "codigo", required = true) int codigo){

        contactosService.delete(codigo);

         ModelAndView modelAndView = new ModelAndView();
         
         modelAndView.setViewName("redirect:/contactos/list");

         return modelAndView;
    }


}
