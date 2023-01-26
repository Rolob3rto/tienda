package com.rolob3rto.springprojects.tienda.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class DetallePedido {
    
    @EmbeddedId
    private DetallePedidoKey codigo = new DetallePedidoKey();

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @MapsId("pedido_codigo")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @MapsId("producto_codigo")
    private Producto producto;

    private int cantidad;

    private double subTotal;

    

    public DetallePedido(DetallePedidoKey codigo, Producto producto, int cantidad, double subTotal) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    
    public DetallePedido() {
    }
    
    public DetallePedido(Producto producto, int cantidad, double subTotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        
    }
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public DetallePedidoKey getCodigo() {
        return codigo;
    }

    public void setCodigo(DetallePedidoKey codigo) {
        this.codigo = codigo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
        public double getSubTotal() {
            return subTotal;
        }
    
        public void setSubTotal(double subTotal) {
            this.subTotal = subTotal;
        }


        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
            DetallePedido other = (DetallePedido) obj;
            if (codigo == null) {
                if (other.codigo != null)
                    return false;
            } else if (!codigo.equals(other.codigo))
                return false;
            return true;
        }

    
}
