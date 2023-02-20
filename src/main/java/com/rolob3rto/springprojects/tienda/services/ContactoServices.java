package com.rolob3rto.springprojects.tienda.services;

import java.util.List;

import com.rolob3rto.springprojects.tienda.model.Contacto;

public interface ContactoServices {    
    
    public List<Contacto> findAll();

    public Contacto findContacto(int codigo);

    public Contacto save(Contacto contacto);

    public void update(Contacto contacto);

    public void delete(int codigo);
}
