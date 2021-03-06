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

    private double latitud;
    
    private double longitud;

    @OneToMany(mappedBy = "cliente")

    private List<Pedido> pedidos;

    public String getNombreCompleto(){
        return nombres + " " +apellidos;
    }

}
