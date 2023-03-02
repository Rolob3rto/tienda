package com.rolob3rto.springprojects.tienda.services.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rolob3rto.springprojects.tienda.model.Nota;
import com.rolob3rto.springprojects.tienda.services.NotaServices;

@Service
public class NotaServicesImpl implements NotaServices{    


    @Value("${url.notas.rest.service}")
    String urlNotas;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Nota> findAll(){
        
        Nota[] arrayNotas = restTemplate.getForObject(urlNotas + "notas", Nota[].class);

        List<Nota> notas = Arrays.asList(arrayNotas);

        for (Nota nota : notas) {
                nota.getFecha();
            }
        
        return notas;
    }

    @Override
    public Nota findNota(int id){
        Nota nota = restTemplate.getForObject(urlNotas + "notas/" + id, Nota.class);        
                
        return nota;
    }

    @Override
    public Nota save(Nota nota){
        Nota notaAlta = restTemplate.postForObject(urlNotas + "notas", nota, Nota.class);

        

        return notaAlta;
    }

    @Override
    public void update(Nota nota){
        restTemplate.put(urlNotas + "notas", nota, nota.getId());        
    }

    @Override
    public void delete(int id){
        restTemplate.delete(urlNotas + "notas/" + id, id);        
    }

    @Override
    public List<Nota> buscar(String titulo, Date fecha){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String stringFecha = dateFormat.format(fecha);

        Map<String, String> parametros = new HashMap<String, String>();

        parametros.put("titulo", titulo);
        parametros.put("fecha", stringFecha);

        Nota[] notas = restTemplate.getForObject(urlNotas + "notas/buscar?titulo={titulo}&fecha={fecha}", Nota[].class, parametros);

        List<Nota> listaNotas = Arrays.asList(notas);

        return listaNotas;
    } 
}
