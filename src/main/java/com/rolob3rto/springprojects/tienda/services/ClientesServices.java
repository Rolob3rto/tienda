package com.rolob3rto.springprojects.tienda.services;

import java.util.List;

import com.rolob3rto.springprojects.tienda.model.Cliente;

public interface ClientesServices {
    
    public List<Cliente> findAll();

    public Cliente findCliente(int codigo);

    public void insert(Cliente cliente);

    public void update(Cliente cliente);
}
