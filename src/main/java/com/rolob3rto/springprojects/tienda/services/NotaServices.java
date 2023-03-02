package com.rolob3rto.springprojects.tienda.services;

import java.util.Date;
import java.util.List;

import com.rolob3rto.springprojects.tienda.model.Nota;

public interface NotaServices {    
    
    public List<Nota> findAll();

    public Nota findNota(int id);

    public Nota save(Nota nota);

    public void update(Nota nota);

    public void delete(int codigo);

    public List<Nota> buscar(String titulo, Date fecha);
}
