package com.rolob3rto.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rolob3rto.springprojects.tienda.model.Producto;
import com.rolob3rto.springprojects.tienda.repository.ProductoRepository;
import com.rolob3rto.springprojects.tienda.services.ProductosServices;

@Service
public class ProductosServicesImpl implements ProductosServices {

    @Autowired
    ProductoRepository repository;

    @Override
    public Page<Producto> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Producto findProducto(int codigo) {
        Optional<Producto> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        } 
        return null;       
    }

    @Override
    public void save(Producto producto) {
        repository.save(producto);
    }

    @Override
    public void update(Producto producto) {

        Producto productoImagen = findProducto(producto.getCodigo());

        if (producto.getImg() == null || producto.getImg().length <= 0) {
          producto.setImg(productoImagen.getImg());  
        } 

        repository.save(producto);
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);        
    }

}
