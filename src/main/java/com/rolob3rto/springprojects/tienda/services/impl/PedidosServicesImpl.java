package com.rolob3rto.springprojects.tienda.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rolob3rto.springprojects.tienda.model.DetallePedido;
import com.rolob3rto.springprojects.tienda.model.DetallePedidoKey;
import com.rolob3rto.springprojects.tienda.model.Pedido;
import com.rolob3rto.springprojects.tienda.repository.DetallePedidosRepository;
import com.rolob3rto.springprojects.tienda.repository.PedidoRepository;
import com.rolob3rto.springprojects.tienda.services.PedidosServices;

@Service
public class PedidosServicesImpl implements PedidosServices {

    @Autowired
    PedidoRepository repositoryPedido;

    @Autowired
    DetallePedidosRepository repositoryDetallePedido;
    

    @Override
    public Page<Pedido> findAll(Pageable page) {        
        
        return repositoryPedido.findAll(page);
    }

    @Override
    public Pedido findPedido(int codigo) {        
        
        Optional<Pedido> findById = repositoryPedido.findById(codigo);
        if(findById != null){
            Pedido pedido = findById.get();
            
            pedido.setDetallePedidos(repositoryDetallePedido.findByPedidoCodigo(pedido.getCodigo()));

            return pedido;
        } 
        return null; 
    }

    @Override
    public void insert(Pedido pedido) {
        repositoryPedido.save(pedido);

       List<DetallePedido> listaDetalles = pedido.getDetallePedidos();
        for (DetallePedido detalle : listaDetalles) {
            
            DetallePedidoKey id = new DetallePedidoKey(pedido.getCodigo(), detalle.getProducto().getCodigo());
            detalle.setCodigo(id);
            repositoryDetallePedido.save(detalle);
        }
    }

    @Override
    public void update(Pedido pedido) {
        repositoryPedido.save(pedido);
    }

    @Override
    @Transactional
    public void delete(int codigo) {
        
        repositoryDetallePedido.deleteByPedidoCodigo(codigo);
        repositoryPedido.deleteById(codigo);
    }

}