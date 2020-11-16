package com.cainco.bootcamp.system.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Zona extends AbstractEntity {

    @NotNull
    private String nombre;

    @NotNull
    private int estado;

    @OneToMany(mappedBy = "zona")
    private List<Pedido> pedidos;

}
