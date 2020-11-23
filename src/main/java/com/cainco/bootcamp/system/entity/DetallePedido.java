package com.cainco.bootcamp.system.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class DetallePedido extends AbstractEntity {

    @NotNull
    private int cantidad;

    @NotNull
    private double precio_venta;


    @NotNull
    private double importe;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

}
