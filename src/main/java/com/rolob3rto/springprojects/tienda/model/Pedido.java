package com.rolob3rto.springprojects.tienda.model;

import java.sql.Date;
import java.util.List;

public class Pedido {
    
    private int codigo;

    private Cliente cliente;

    private List<DetallePedido> detallePedidos;

    private Date fecha;

    private float total;
}
