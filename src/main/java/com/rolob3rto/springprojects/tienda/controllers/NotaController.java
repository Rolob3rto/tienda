package com.rolob3rto.springprojects.tienda.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rolob3rto.springprojects.tienda.model.Nota;
import com.rolob3rto.springprojects.tienda.services.NotaServices;


@Controller
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    NotaServices notasService;


  
    @GetMapping(value = "/list")
    public ModelAndView listPage(Model model) {

        List<Nota> notas = notasService.findAll();

        ModelAndView modelAndView = new ModelAndView("notas/list");
        modelAndView.addObject("notas", notas);

        return modelAndView;
    }
    
    @RequestMapping(path = "/edit")
    public ModelAndView edit(@RequestParam(name = "id", required = true) int id ){

        ModelAndView modelAndView = new ModelAndView();

        Nota nota = notasService.findNota(id);
        modelAndView.addObject("nota", nota);
        modelAndView.setViewName("notas/edit");

        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create(){

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("nota", new Nota());
         modelAndView.setViewName("notas/new");

         return modelAndView;
    }

    @RequestMapping(path = "/save")
    public ModelAndView save(Nota nota) throws IOException{

        Nota notaAlta = notasService.save(nota);

         ModelAndView modelAndView = new ModelAndView();
        

         modelAndView.setViewName("redirect:edit?id=" + notaAlta.getId());

         return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView update(Nota nota) throws IOException{
        
        notasService.update(nota);
        
         
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("redirect:edit?id=" + nota.getId());

         return modelAndView;
    }

    @RequestMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable(name = "id", required = true) int id){

        notasService.delete(id);

         ModelAndView modelAndView = new ModelAndView();
         
         modelAndView.setViewName("redirect:/notas/list");

         return modelAndView;
    }

    @GetMapping(path = "/buscar")
    public ModelAndView buscar(@RequestParam("titulo") String titulo, @RequestParam("fecha") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fecha) throws IOException{
        
        List<Nota> listaNotas = notasService.buscar(titulo, fecha);
        
         
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.addObject("notas", listaNotas);
        modelAndView.setViewName("notas/list");

         return modelAndView;
    }


}
