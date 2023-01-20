package com.rolob3rto.springprojects.tienda.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rolob3rto.springprojects.tienda.model.Cliente;

public interface ClientesServices {
    
    public Page<Cliente> findAll(Pageable page);

    public Cliente findCliente(int codigo);

    public void save(Cliente cliente);

    public void update(Cliente cliente);

    public void delete(int codigo);
}
