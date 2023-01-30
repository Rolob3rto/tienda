package com.rolob3rto.springprojects.tienda.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rolob3rto.springprojects.tienda.model.Empleado;
import com.rolob3rto.springprojects.tienda.services.EmpleadosServices;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    EmpleadosServices empleadosService;
     

    @Value("${pagination.size}")
    int sizePage;


    @GetMapping(value = "/list")
    public ModelAndView list(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list/1/codigo/asc");
        return modelAndView;
    }
  
    @GetMapping(value = "/list/{numPage}/{fieldSort}/{directionSort}")
    public ModelAndView listPage(Model model,
            @PathVariable("numPage") Integer numPage,
            @PathVariable("fieldSort") String fieldSort,
            @PathVariable("directionSort") String directionSort) {


        Pageable pageable = PageRequest.of(numPage - 1, sizePage,
            directionSort.equals("asc") ? Sort.by(fieldSort).ascending() : Sort.by(fieldSort).descending());

        Page<Empleado> page = empleadosService.findAll(pageable);

        List<Empleado> empleados = page.getContent();

        ModelAndView modelAndView = new ModelAndView("empleados/list");
        modelAndView.addObject("empleados", empleados);


        modelAndView.addObject("numPage", numPage);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalElements", page.getTotalElements());

        modelAndView.addObject("fieldSort", fieldSort);
        modelAndView.addObject("directionSort", directionSort.equals("asc") ? "asc" : "desc");

        return modelAndView;
    }
    
    @RequestMapping(path = "/edit")
    public ModelAndView edit(@RequestParam(name = "codigo", required = true) int codigo ){

        ModelAndView modelAndView = new ModelAndView();

        Empleado empleado = empleadosService.findEmpleado(codigo);
        modelAndView.addObject("empleado", empleado);
        modelAndView.setViewName("empleados/edit");

        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create(){

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("empleado", new Empleado());
         modelAndView.setViewName("empleados/new");

         return modelAndView;
    }

    @RequestMapping(path = "/save")
    public ModelAndView save(Empleado empleado) throws IOException{

        empleadosService.save(empleado);

         ModelAndView modelAndView = new ModelAndView();
        

         modelAndView.setViewName("redirect:edit?codigo=" + empleado.getCodigo());

         return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView update(Empleado empleado) throws IOException{
        
        empleadosService.update(empleado);
        
         
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("redirect:edit?codigo=" + empleado.getCodigo());

         return modelAndView;
    }

    @RequestMapping(path = "/delete/{codigo}")
    public ModelAndView delete(@PathVariable(name = "codigo", required = true) int codigo){

        empleadosService.delete(codigo);

         ModelAndView modelAndView = new ModelAndView();
         
         modelAndView.setViewName("redirect:/empleados/list");

         return modelAndView;
    }


}
