package com.rolob3rto.springprojects.tienda.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rolob3rto.springprojects.tienda.model.Producto;

public interface ProductosDAO {
    // public List<Producto> findAll();

    public Page<Producto> findAll(Pageable page);

    public Producto findProducto(int codigo);

    public void insert(Producto producto);

    public void update(Producto producto);

    public void delete(int codigo);

    public void updateImg(Producto producto);
}
