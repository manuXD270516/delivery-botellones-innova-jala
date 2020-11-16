package com.cainco.bootcamp.system.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente extends Persona {

    private String nit;

    @NotNull
    private Long latitud;

    @NotNull
    private Long longitud;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
