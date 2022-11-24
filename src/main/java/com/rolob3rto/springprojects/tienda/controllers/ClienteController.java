package com.rolob3rto.springprojects.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rolob3rto.springprojects.tienda.model.Cliente;
import com.rolob3rto.springprojects.tienda.services.ClientesServices;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClientesServices clientesServices;
     
    @RequestMapping(path = "/list")
    public ModelAndView list(){

        List<Cliente> clientes = clientesServices.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");

        return modelAndView;
    }
    
    @RequestMapping(path = "/edit")
    public ModelAndView edit(@RequestParam(name = "codigo", required = true) int codigo ){

        ModelAndView modelAndView = new ModelAndView();

        Cliente cliente = clientesServices.findCliente(codigo);
        modelAndView.addObject("cliente", clientesServices.findCliente(codigo));
        modelAndView.setViewName("clientes/edit");

        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create(){

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("cliente", new Cliente());
         modelAndView.setViewName("clientes/new");

         return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Cliente cliente){

        clientesServices.insert(cliente);
        
        List<Cliente> clientes = clientesServices.findAll();

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("clientes", clientes);
         modelAndView.setViewName("clientes/list");

         return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView update(Cliente cliente){

        clientesServices.update(cliente);
        List<Cliente> clientes = clientesServices.findAll();
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");

         return modelAndView;
    }

    @RequestMapping(path = "/delete/{codigo}")
    public ModelAndView delete(@PathVariable(name = "codigo", required = true) int codigo){

        clientesServices.delete(codigo);
        List<Cliente> clientes = clientesServices.findAll();
        // clientes.remove(clientesServices.findCliente(codigo));

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("clientes", clientes);
         modelAndView.setViewName("clientes/list");

         return modelAndView;
    }


    private Cliente getCliente(int codigo) {
        List<Cliente> clientes = clientesServices.findAll();
       int indexof = clientes.indexOf(new Cliente(codigo));

       return clientes.get(indexof);
    }

    private List<Cliente> getClientes() {
        Cliente p1 = new Cliente(1, "nombre1", "apellidos1", "sdahf@gmail.com", "6287372823", "calle pepe", true);
        Cliente p2 = new Cliente(2, "nombre2", "apellidos2", "sdahf@gmail.com", "6287342823", "calle pepa", false);
        Cliente p3 = new Cliente(3, "nombre3", "apellidos3", "sdahf@gmail.com", "6287372813", "calle juan", false);
        Cliente p4 = new Cliente(4, "nombre4", "apellidos4", "sdahf@gmail.com", "6285372823", "calle oleo", false);

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        listaClientes.add(p1);
        listaClientes.add(p2);
        listaClientes.add(p3);
        listaClientes.add(p4); 

        return listaClientes;
    }


}
