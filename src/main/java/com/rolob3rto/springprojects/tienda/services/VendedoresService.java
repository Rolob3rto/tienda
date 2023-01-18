package com.rolob3rto.springprojects.tienda.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rolob3rto.springprojects.tienda.model.Vendedor;


public interface VendedoresService {
    public Page<Vendedor> findAll(Pageable page);
    public Vendedor find(int codigo);
    public void save(Vendedor producto);
    public void update(Vendedor producto);
    public void delete(int codigo);
}