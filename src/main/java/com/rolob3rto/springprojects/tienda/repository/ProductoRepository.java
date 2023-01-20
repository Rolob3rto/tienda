package com.rolob3rto.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolob3rto.springprojects.tienda.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
}
