package com.cainco.bootcamp.system.dto;

public class ZonaDTO {

    private Long id;
    private String nombre;

    public ZonaDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
}
