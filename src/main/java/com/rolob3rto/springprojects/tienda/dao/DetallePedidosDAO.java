package com.rolob3rto.springprojects.tienda.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rolob3rto.springprojects.tienda.model.DetallePedido;
import com.rolob3rto.springprojects.tienda.model.Pedido;

public interface DetallePedidosDAO {
    
    public void insert(Pedido pedido, DetallePedido detallePedido);

    public List<DetallePedido> findDetalle(Pedido pedido);

}