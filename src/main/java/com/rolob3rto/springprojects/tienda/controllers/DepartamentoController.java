package com.rolob3rto.springprojects.tienda.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.rolob3rto.springprojects.tienda.model.Departamento;
import com.rolob3rto.springprojects.tienda.model.DetallePedido;
import com.rolob3rto.springprojects.tienda.model.Empleado;
import com.rolob3rto.springprojects.tienda.model.Pedido;
import com.rolob3rto.springprojects.tienda.repository.EmpleadoRepository;
import com.rolob3rto.springprojects.tienda.services.DepartamentosServices;
import com.rolob3rto.springprojects.tienda.services.EmpleadosServices;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    DepartamentosServices departamentosService;

    @Autowired
    EmpleadosServices empleadosServices;

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

        Page<Departamento> page = departamentosService.findAll(pageable);

        List<Departamento> departamentos = page.getContent();

        ModelAndView modelAndView = new ModelAndView("departamentos/list");
        modelAndView.addObject("departamentos", departamentos);


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
        List<Empleado> todosEmpleados = empleadosServices.findAll();
        

        Departamento departamento = departamentosService.findDepartamento(codigo);
        List<Empleado> empleadosDepartamento = departamento.getEmpleados();
        
        for (Empleado empleado : todosEmpleados) {
            if (empleadosDepartamento.contains(empleado)) {
                empleado.setCheck(true);
            }
        }

        modelAndView.addObject("departamento", departamento);
        modelAndView.addObject("empleados", todosEmpleados);
        
        modelAndView.setViewName("departamentos/edit");

        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create(){

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("departamento", new Departamento());
         modelAndView.setViewName("departamentos/new");

         return modelAndView;
    }

    @RequestMapping(path = "/save")
    public ModelAndView save(Departamento departamento) throws IOException{

        departamentosService.save(departamento);

         ModelAndView modelAndView = new ModelAndView();
        

         modelAndView.setViewName("redirect:edit?codigo=" + departamento.getCodigo());

         return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView update(Departamento departamento) throws IOException{
        
        departamentosService.update(departamento);
        
         
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("redirect:edit?codigo=" + departamento.getCodigo());

         return modelAndView;
    }

    @RequestMapping(path = "/delete/{codigo}")
    public ModelAndView delete(@PathVariable(name = "codigo", required = true) int codigo){

        departamentosService.delete(codigo);

         ModelAndView modelAndView = new ModelAndView();
         
         modelAndView.setViewName("redirect:/departamentos/list");

         return modelAndView;
    }

}
