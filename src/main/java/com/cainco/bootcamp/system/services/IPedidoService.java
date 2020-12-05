package com.cainco.bootcamp.system.services;
import com.cainco.bootcamp.system.dto.PedidoDTO;
import com.cainco.bootcamp.system.dto.ResponseDTO;

import java.util.List;

public interface IPedidoService {
    ResponseDTO addPedido(PedidoDTO pedido);

    List<PedidoDTO> listarPedidos();
}
