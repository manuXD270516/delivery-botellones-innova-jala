package com.cainco.bootcamp.system.dto;

import java.time.LocalDateTime;

public class PedidoDTO {

    public String direccion;
    public long idRepartidor;
    public long idZona;
    public LocalDateTime fechaHora;
    public ClienteDTO cliente;
    public DetallePedidoDTO detalle;
}
