package com.rolob3rto.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rolob3rto.springprojects.tienda.model.Pedido;
import com.rolob3rto.springprojects.tienda.repository.PedidoRepository;
import com.rolob3rto.springprojects.tienda.services.PedidosServices;

@Service
public class PedidosServicesImpl implements PedidosServices {

    @Autowired
    PedidoRepository repository;

    @Override
    public Page<Pedido> findAll(Pageable page) {        
        
        return repository.findAll(page);
    }

    @Override
    public Pedido findPedido(int codigo) {        
        
        Optional<Pedido> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        } 
        return null; 
    }

    @Override
    public void insert(Pedido pedido) {
        repository.save(pedido);

       /*  List<DetallePedido> listaDetalles = pedido.getDetallePedidos();
        for (DetallePedido detalle : listaDetalles) {
            detallePedidoDAO.insert(pedido, detalle);
            
        } */
    }

    @Override
    public void update(Pedido pedido) {
        repository.save(pedido);
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);
    }

}