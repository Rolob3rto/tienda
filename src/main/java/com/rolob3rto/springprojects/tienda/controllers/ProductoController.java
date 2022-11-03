package com.rolob3rto.springprojects.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rolob3rto.springprojects.tienda.model.Producto;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    
    @RequestMapping(path = "/list")
    public ModelAndView list(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productos", getProductos());
        modelAndView.setViewName("productos/list");

        return modelAndView;
    }
    
    @RequestMapping(path = "/edit")
    public ModelAndView edit(@RequestParam(name = "codigo", required = true) int codigo ){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("producto", getProducto(codigo));
        modelAndView.setViewName("productos/edit");

        return modelAndView;
    }


    private Producto getProducto(int codigo) {
       List <Producto> productos = getProductos();
       int indexof = productos.indexOf(new Producto(codigo));

       return productos.get(indexof);
    }

    private List<Producto> getProductos() {
        Producto p1 = new Producto(1, "nombre1", "descripcion1", "/img/coca.jpg", null);
        Producto p2 = new Producto(2, "nombre2", "descripcion2", "/img/fanta.jpg", null);
        Producto p3 = new Producto(3, "nombre3", "descripcion3", "/img/pepsi.png", null);
        Producto p4 = new Producto(4, "nombre4", "descripcion4", "/img/sprite.jpg", null);

        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4); 

        return listaProductos;
    }

}
