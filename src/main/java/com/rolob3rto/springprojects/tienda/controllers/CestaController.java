package com.rolob3rto.springprojects.tienda.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rolob3rto.springprojects.tienda.model.DetallePedido;
import com.rolob3rto.springprojects.tienda.model.Pedido;

@Controller
@RequestMapping("/cesta")
@PreAuthorize("hasAnyAuthority('ADMIN','CESTA')")
public class CestaController {


    @GetMapping(value = "/list")
    public ModelAndView list(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cesta/list");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{codigo}")
    public ModelAndView anadir(@PathVariable(name = "codigo", required = true) int codigo,  HttpSession session) {

        Pedido cesta = (Pedido) session.getAttribute("cesta");

        List<DetallePedido> listaDetallePedidos = cesta.getDetallePedidos();

        int borrar = 0;

        for (int i = 0; i < listaDetallePedidos.size(); i++) {
            if (listaDetallePedidos.get(i).getProducto().getCodigo() == codigo) {
                

                borrar = i;
                break;
            }
            
        }

        listaDetallePedidos.remove(borrar);

        cesta.setDetallePedidos(listaDetallePedidos);
        

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cesta/list");

        session.setAttribute("cesta", cesta);

        return modelAndView;
    }
}