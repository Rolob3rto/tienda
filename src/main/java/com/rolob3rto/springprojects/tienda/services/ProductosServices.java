package com.rolob3rto.springprojects.tienda.services;

import java.util.List;

import com.rolob3rto.springprojects.tienda.model.Producto;

public interface ProductosServices {
    
    public List<Producto> findAll();

    public Producto findProducto(int codigo);

    public void insert(Producto producto);

    public void update(Producto producto);

    public void delete(int codigo);
}
