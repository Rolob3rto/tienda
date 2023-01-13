package com.rolob3rto.springprojects.tienda.services.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rolob3rto.springprojects.tienda.dao.ClientesDAO;
import com.rolob3rto.springprojects.tienda.dao.DetallePedidosDAO;
import com.rolob3rto.springprojects.tienda.dao.PedidosDAO;
import com.rolob3rto.springprojects.tienda.model.Cliente;
import com.rolob3rto.springprojects.tienda.model.DetallePedido;
import com.rolob3rto.springprojects.tienda.model.Pedido;
import com.rolob3rto.springprojects.tienda.services.PedidosServices;

@Service
public class PedidosServicesImpl implements PedidosServices {

    @Autowired
    PedidosDAO pedidosDAO;

    @Autowired
    DetallePedidosDAO detallePedidoDAO;

    @Autowired
    ClientesDAO clientesDAO;

    @Override
    public Page<Pedido> findAll(Pageable page) {        
        
        return pedidosDAO.findAll(page);
    }

    @Override
    public Pedido findPedido(int codigo) {        
        
        Pedido pedido = pedidosDAO.findPedido(codigo);

        Cliente cliente = clientesDAO.findCliente(pedido.getCliente().getCodigo());

        pedido.setCliente(cliente);

        List<DetallePedido> detalle = detallePedidoDAO.findDetalle(pedido);
        pedido.setDetallePedidos(detalle);
        
        return pedido;
    }

    @Override
    public void insert(Pedido pedido) {
        pedidosDAO.insert(pedido);
    }

    @Override
    public void update(Pedido pedido) {
        pedidosDAO.update(pedido);
    }

    @Override
    public void delete(int codigo) {
        pedidosDAO.delete(codigo);
    }

}