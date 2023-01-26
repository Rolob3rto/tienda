package com.rolob3rto.springprojects.tienda.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue
    private int codigo;

    @ManyToOne
    private Cliente cliente;

    @Transient
    private List<DetallePedido> detallePedidos;

    private Date fecha;

    private double total;
    
    public Pedido(int codigo, Cliente cliente, List<DetallePedido> detallePedidos, Date fecha, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.detallePedidos = detallePedidos;
        this.fecha = fecha;
        this.total = total;
    }

    public Pedido() {
    }

    public Pedido(Cliente cliente){
        this.cliente = cliente;
    }

    public Pedido(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public Pedido(List<DetallePedido> detallePedidos, Cliente cliente) {
        this.detallePedidos = detallePedidos;
        this.cliente = cliente;
    }

    public double getCalcularTotal() {
        
        total = 0;
        for (DetallePedido detallePedido : detallePedidos) {
            
            total += detallePedido.getSubTotal();
        }
        return total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date date) {
        this.fecha = date;
    }

    @PrePersist
    private void PrePersistFecha(){
        this.fecha = new Date();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        Pedido other = (Pedido) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    
    
}
