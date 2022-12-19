package com.rolob3rto.springprojects.tienda.model;

public class DetallePedido {
    
    private int codigo;

    private Producto producto;

    private int cantidad;

    private float subTotal;

    

    public DetallePedido(int codigo, Producto producto, int cantidad, float subTotal) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public DetallePedido() {
    }

    public DetallePedido(Producto producto, int cantidad, float subTotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subTotal = subTotal;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
    
        public float getSubTotal() {
            return subTotal;
        }
    
        public void setSubTotal(float subTotal) {
            this.subTotal = subTotal;
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
        DetallePedido other = (DetallePedido) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    
}
