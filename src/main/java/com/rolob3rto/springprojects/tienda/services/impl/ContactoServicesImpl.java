package com.rolob3rto.springprojects.tienda.services.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rolob3rto.springprojects.tienda.model.Contacto;
import com.rolob3rto.springprojects.tienda.services.ContactoServices;

@Service
public class ContactoServicesImpl implements ContactoServices{    


    @Value("${url.agenda.rest.service}")
    String urlAgenda;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Contacto> findAll(){
        
        Contacto[] arrayContactos = restTemplate.getForObject(urlAgenda + "contactos", Contacto[].class);

        List<Contacto> contactos = Arrays.asList(arrayContactos);
        
        return contactos;
    }

    @Override
    public Contacto findContacto(int codigo){
        Contacto[] arrayContactos = restTemplate.getForObject(urlAgenda + "contactos", Contacto[].class, codigo);        
        
        return arrayContactos[0];
    }

    @Override
    public void save(Contacto contacto){
        
    }

    @Override
    public void update(Contacto contacto){
        
    }

    @Override
    public void delete(int codigo){
        
    }
}
