/* package com.rolob3rto.springprojects.tienda.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rolob3rto.springprojects.tienda.model.Pedido;

public interface PedidosDAO {
    // public List<Pedido> findAll();

    public Page<Pedido> findAll(Pageable page);

    public Pedido findPedido(int codigo);

    public void insert(Pedido pedido);

    public void update(Pedido pedido);

    public void delete(int codigo);

    public void updateImg(Pedido pedido);
}
 */