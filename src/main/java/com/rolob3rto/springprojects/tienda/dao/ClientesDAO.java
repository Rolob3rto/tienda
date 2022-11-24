package com.rolob3rto.springprojects.tienda.dao;

import java.util.List;

import com.rolob3rto.springprojects.tienda.model.Cliente;

public interface ClientesDAO {
    public List<Cliente> findAll();

    public Cliente findCliente(int codigo);

    public void insert(Cliente cliente);

    public void update(Cliente cliente);

    public void delete(int codigo);
}
