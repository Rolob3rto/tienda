/* package com.rolob3rto.springprojects.tienda.services.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rolob3rto.springprojects.tienda.dao.PedidosDAO;
import com.rolob3rto.springprojects.tienda.model.Pedido;
import com.rolob3rto.springprojects.tienda.services.PedidosServices;

@Service
public class PedidosServicesImpl implements PedidosServices {

    @Autowired
    PedidosDAO pedidosDAO;

    @Override
    public Page<Pedido> findAll(Pageable page) {        
        
        return pedidosDAO.findAll(page);
    }

    @Override
    public Pedido findPedido(int codigo) {        
        
        return pedidosDAO.findPedido(codigo);
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

} */