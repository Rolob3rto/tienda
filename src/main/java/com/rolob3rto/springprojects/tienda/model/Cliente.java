package com.rolob3rto.springprojects.tienda.model;

import java.util.Date;

public class Cliente {
    private int codigo;
    private String nombre;
    private String apellidos;
    private String email;
    private String numero;
    private String direccion;
    private Date fechaNacimiento;
    private Boolean vip;
    
    public Cliente(int codigo, String nombre, String apellidos, String email, String numero, String direccion,
            Date fechaNacimiento, Boolean vip) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.numero = numero;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.vip = vip;
    }

    public Cliente() {}

    public Cliente(int codigo) {
        this.codigo = codigo;
    }

    public int getcodigo() {
        return codigo;
    }

    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
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
        Cliente other = (Cliente) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    

    
    
}


