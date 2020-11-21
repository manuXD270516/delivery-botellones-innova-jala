package com.cainco.bootcamp.system.services;
import com.cainco.bootcamp.system.dto.PedidoDTO;
import com.cainco.bootcamp.system.dto.ResponseDTO;

public interface IPedidoService {
    ResponseDTO addPedido(PedidoDTO pedido);
}
