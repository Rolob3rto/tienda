package com.rolob3rto.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolob3rto.springprojects.tienda.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    
}
