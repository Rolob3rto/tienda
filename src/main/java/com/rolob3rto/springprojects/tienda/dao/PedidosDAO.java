package com.rolob3rto.springprojects.tienda.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rolob3rto.springprojects.tienda.model.Pedido;

public interface PedidosDAO {
    
    public Page<Pedido> findAll(Pageable page);
    public Pedido findPedido(int codigo);
    public void insert(Pedido pedido);
    public void update(Pedido pedido);
    public void delete(int codigo);
}