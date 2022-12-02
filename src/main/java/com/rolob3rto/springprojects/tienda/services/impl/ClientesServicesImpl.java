package com.rolob3rto.springprojects.tienda.services.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rolob3rto.springprojects.tienda.dao.ClientesDAO;
import com.rolob3rto.springprojects.tienda.model.Cliente;
import com.rolob3rto.springprojects.tienda.services.ClientesServices;

@Service
public class ClientesServicesImpl implements ClientesServices {

    @Autowired
    ClientesDAO clientesDAO;

    @Override
    public Page<Cliente> findAll(Pageable page) {        
        
        return clientesDAO.findAll(page);
    }

    @Override
    public Cliente findCliente(int codigo) {        
        
        return clientesDAO.findCliente(codigo);
    }

    @Override
    public void insert(Cliente cliente) {
        clientesDAO.insert(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        clientesDAO.update(cliente);
    }

    @Override
    public void delete(int codigo) {
        clientesDAO.delete(codigo);
    }

}
