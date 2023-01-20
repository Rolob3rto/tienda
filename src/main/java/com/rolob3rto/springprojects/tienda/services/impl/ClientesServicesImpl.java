package com.rolob3rto.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rolob3rto.springprojects.tienda.model.Cliente;
import com.rolob3rto.springprojects.tienda.repository.ClienteRepository;
import com.rolob3rto.springprojects.tienda.services.ClientesServices;

@Service
public class ClientesServicesImpl implements ClientesServices {

    @Autowired
    ClienteRepository repository;

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Cliente findCliente(int codigo) {
        Optional<Cliente> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        } 
        return null;       
    }

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        repository.save(cliente);        
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);        
    }

}
