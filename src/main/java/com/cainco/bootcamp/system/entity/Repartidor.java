package com.cainco.bootcamp.system.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Repartidor extends Persona {

    @NotNull
    private String turnoHorario;

    @OneToMany(mappedBy = "repartidor")
    private List<Pedido> pedidos;
}
