package com.rolob3rto.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolob3rto.springprojects.tienda.model.Vendedor;

public interface ProveedorRepository extends JpaRepository<Vendedor, Integer> {
    
}
