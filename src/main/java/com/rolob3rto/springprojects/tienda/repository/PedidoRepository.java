package com.rolob3rto.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolob3rto.springprojects.tienda.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
}
