package com.cainco.bootcamp.system.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Producto extends AbstractEntity {

    @NotNull
    private String codigo;

    @NotNull
    private String nombre;

    @NotNull
    private float precio_venta;

    private String descripcion;

    @NotNull
    private int stock;

    @NotNull
    private int estado;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallePedidos;


}
