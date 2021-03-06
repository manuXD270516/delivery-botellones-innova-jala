package com.cainco.bootcamp.system.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Pedido extends AbstractEntity {

    @NotNull
    private String direccion;

    @NotNull
    private int estado;

    @NotNull
    private LocalDateTime fecha_hora;

    @NotNull
    private String tipo;

    @NotNull
    private double importe_total;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_repartidor")
    private Repartidor repartidor;

    @ManyToOne
    @JoinColumn(name = "id_zona")
    @NotNull
    private Zona zona;

    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detallePedidos;

    public void addDetallePedido(DetallePedido detallePedido){
        detallePedidos.add(detallePedido);
    }

}
