package com.cainco.bootcamp.system.dto;

import com.cainco.bootcamp.system.entity.Cliente;
import com.cainco.bootcamp.system.entity.Pedido;
import com.cainco.bootcamp.system.entity.Producto;

import java.time.LocalDateTime;

public class PedidoDTO {

    public String direccion;
    public long idRepartidor;
    public long idZona;
    public String nombreZona;
    public LocalDateTime fechaHora;
    public ClienteDTO cliente;
    public DetallePedidoDTO detalle;
    public String estado;

    public static PedidoDTO convertir(Pedido pedido){
        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.idRepartidor = pedido.getRepartidor().getId();
        pedidoDTO.idZona = pedido.getZona().getId();
        pedidoDTO.nombreZona = pedido.getZona().getNombre();
        pedidoDTO.direccion = pedido.getDireccion();
        // mejorar esta implementacion

        Cliente cliente = pedido.getCliente();
        pedidoDTO.cliente = new ClienteDTO();

        pedidoDTO.cliente.idCliente =  cliente.getId();
        pedidoDTO.cliente.ci =  cliente.getCi();
        pedidoDTO.cliente.nombres =  cliente.getNombres();
        pedidoDTO.cliente.apellidos =  cliente.getApellidos();
        pedidoDTO.cliente.telefono =  cliente.getTelefono();
        pedidoDTO.cliente.nit =  cliente.getNit();
        pedidoDTO.cliente.latitud =  cliente.getLatitud();
        pedidoDTO.cliente.longitud =  cliente.getLongitud();

        pedidoDTO.fechaHora = pedido.getFecha_hora();

        Producto producto =pedido.getDetallePedidos().get(0).getProducto();

        pedidoDTO.detalle = new DetallePedidoDTO();
        pedidoDTO.detalle.idProducto = producto.getId();
        pedidoDTO.detalle.precioProducto = producto.getPrecio_venta();
        pedidoDTO.detalle.cantidad = pedido.getDetallePedidos().get(0).getCantidad();

        pedidoDTO.estado = pedido.getEstado() == 1?"Entregado": "Pendiente";
        return pedidoDTO;

    }

}
