package com.rolob3rto.springprojects.tienda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contacto {
    
    @Id
    @GeneratedValue
    private int codigo;

    private String nombre;
    private String numero;
    private String correo;

    

    public Contacto() {
    }

    
    public Contacto(int codigo) {
        this.codigo = codigo;
    }


    public Contacto(int codigo, String nombre, String numero, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numero = numero;
        this.correo = correo;
    }


    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int id) {
        this.codigo = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contacto other = (Contacto) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
    
    
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    
}
