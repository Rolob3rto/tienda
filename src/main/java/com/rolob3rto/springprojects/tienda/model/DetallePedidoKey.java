package com.rolob3rto.springprojects.tienda.model;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class DetallePedidoKey implements Serializable{
        
    private int producto_codigo;

    private int pedido_codigo;


    public DetallePedidoKey() {
    }

    public DetallePedidoKey(int producto_codigo, int pedido_codigo) {
        this.producto_codigo = producto_codigo;
        this.pedido_codigo = pedido_codigo;
    }

    public int getCodigoProducto() {
        return producto_codigo;
    }

    public void setCodigoProducto(int producto_codigo) {
        this.producto_codigo = producto_codigo;
    }

    public int getCodigoPedido() {
        return pedido_codigo;
    }

    public void setCodigoPedido(int pedido_codigo) {
        this.pedido_codigo = pedido_codigo;
    }


}
