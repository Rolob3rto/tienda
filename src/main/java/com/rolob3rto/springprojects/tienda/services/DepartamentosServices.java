package com.rolob3rto.springprojects.tienda.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rolob3rto.springprojects.tienda.model.Departamento;

public interface DepartamentosServices {
    
    public Page<Departamento> findAll(Pageable page);

    public Departamento findDepartamento(int codigo);

    public void save(Departamento departamento);

    public void update(Departamento departamento);

    public void delete(int codigo);
}
