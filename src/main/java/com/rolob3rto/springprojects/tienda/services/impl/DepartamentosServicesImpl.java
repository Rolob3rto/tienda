package com.rolob3rto.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rolob3rto.springprojects.tienda.model.Departamento;
import com.rolob3rto.springprojects.tienda.repository.DepartamentoRepository;
import com.rolob3rto.springprojects.tienda.services.DepartamentosServices;

@Service
public class DepartamentosServicesImpl implements DepartamentosServices {

    @Autowired
    DepartamentoRepository repository;

    @Override
    public Page<Departamento> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Departamento findDepartamento(int codigo) {
        Optional<Departamento> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        } 
        return null;       
    }

    @Override
    public void save(Departamento departamento) {
        repository.save(departamento);
    }

    @Override
    public void update(Departamento departamento) {
        repository.save(departamento);        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);        
    }

}
