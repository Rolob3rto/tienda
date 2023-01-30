package com.rolob3rto.springprojects.tienda.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rolob3rto.springprojects.tienda.model.Empleado;

public interface EmpleadosServices {
    
    public Page<Empleado> findAll(Pageable page);
    
    public List<Empleado> findAll();

    public Empleado findEmpleado(int codigo);

    public void save(Empleado empleado);

    public void update(Empleado empleado);

    public void delete(int codigo);
}
