package com.rolob3rto.springprojects.tienda.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.rolob3rto.springprojects.tienda.model.DetallePedido;
import com.rolob3rto.springprojects.tienda.model.Pedido;
import com.rolob3rto.springprojects.tienda.model.Producto;
import com.rolob3rto.springprojects.tienda.services.ProductosServices;

@Controller
@RequestMapping("/productos")
@PreAuthorize("hasAnyAuthority('ADMIN','PRODUCTOS')")
public class ProductoController {

    @Autowired
    ProductosServices productosService;

    /*
     * @RequestMapping(path = "/list")
     * public ModelAndView list(){
     * 
     * List<Producto> productos = productosServices.findAll();
     * 
     * ModelAndView modelAndView = new ModelAndView();
     * modelAndView.addObject("productos", productos);
     * modelAndView.setViewName("productos/list");
     * 
     * return modelAndView;
     * }
     */

    @Value("${pagination.size}")
    int sizePage;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {
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

        Page<Producto> page = productosService.findAll(pageable);

        List<Producto> productos = page.getContent();

        ModelAndView modelAndView = new ModelAndView("productos/list");
        modelAndView.addObject("productos", productos);

        modelAndView.addObject("numPage", numPage);
        modelAndView.addObject("totalPages", page.getTotalPages());
        modelAndView.addObject("totalElements", page.getTotalElements());

        modelAndView.addObject("fieldSort", fieldSort);
        modelAndView.addObject("directionSort", directionSort.equals("asc") ? "asc" : "desc");

        return modelAndView;
    }

    @RequestMapping(path = "/edit")
    public ModelAndView edit(@RequestParam(name = "codigo", required = true) int codigo) {

        ModelAndView modelAndView = new ModelAndView();

        Producto producto = productosService.findProducto(codigo);
        modelAndView.addObject("producto", producto);
        modelAndView.setViewName("productos/edit");

        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("producto", new Producto());
        modelAndView.setViewName("productos/new");

        return modelAndView;
    }

    @RequestMapping(path = "/save")
    public ModelAndView save(Producto producto, @RequestParam("imagen") MultipartFile multipartFile)
            throws IOException {

        byte[] file = multipartFile.getBytes();
        producto.setImg(file);

        productosService.save(producto);

        // List<Producto> productos = productosServices.findAll();

        ModelAndView modelAndView = new ModelAndView();
        // modelAndView.addObject("productos", productos);
        // modelAndView.setViewName("productos/list");

        modelAndView.setViewName("redirect:edit?codigo=" + producto.getCodigo());

        return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView update(Producto producto, @RequestParam("imagen") MultipartFile multipartFile)
            throws IOException {

        byte[] file = multipartFile.getBytes();
        producto.setImg(file);

        productosService.update(producto);
        // List<Producto> productos = productosServices.findAll();

        ModelAndView modelAndView = new ModelAndView();
        // modelAndView.addObject("productos", productos);
        // modelAndView.setViewName("productos/list");
        modelAndView.setViewName("redirect:edit?codigo=" + producto.getCodigo());

        return modelAndView;
    }

    @RequestMapping(path = "/delete/{codigo}")
    public ModelAndView delete(@PathVariable(name = "codigo", required = true) int codigo) {

        productosService.delete(codigo);
        // List<Producto> productos = productosService.findAll();
        // productos.remove(productosServices.findProducto(codigo));

        ModelAndView modelAndView = new ModelAndView();
        // modelAndView.addObject("productos", productos);
        modelAndView.setViewName("redirect:/productos/list");

        return modelAndView;
    }

    @RequestMapping(path = "/cantidad")
    public ModelAndView cantidad(@RequestParam(name = "codigo", required = true) int codigo) {

        ModelAndView modelAndView = new ModelAndView();

        Producto producto = productosService.findProducto(codigo);
        modelAndView.addObject("producto", producto);
        modelAndView.setViewName("productos/cantidad");

        return modelAndView;
    }

    @RequestMapping(value = "/anadir/{codigo}")
    public ModelAndView anadir(@PathVariable(name = "codigo", required = true) int codigo,
            @RequestParam(name = "cantidad", required = true) int cantidad, HttpSession session) {

        Producto producto = productosService.findProducto(codigo);

        Pedido cesta = (Pedido) session.getAttribute("cesta");

        List<DetallePedido> listaProductos = cesta.getDetallePedidos();

        double subtotal = producto.getPrecio() * cantidad;

        DetallePedido detallePedido = new DetallePedido(producto, cantidad, subtotal);

        detallePedido.setPedido(cesta);
        listaProductos.add(detallePedido);
        cesta.setDetallePedidos(listaProductos);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/productos/list");

        session.setAttribute("cesta", cesta);

        return modelAndView;
    }

}
