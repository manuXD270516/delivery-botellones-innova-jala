package com.cainco.bootcamp.system.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * nombre varchar
 *    documento varchar
 *    telefono varchar
 */

@MappedSuperclass
@Data
public abstract class Persona extends AbstractEntity {


    @NotNull
    @NotEmpty
    protected String ci;

    @NotNull
    @NotEmpty
    protected String nombres;

    @NotNull
    @NotEmpty
    protected String apellidos;

    @NotNull
    @NotEmpty
    protected String telefono;




}
