package com.cainco.bootcamp.system;

import com.cainco.bootcamp.system.dao.IPedidoDao;
import com.cainco.bootcamp.system.dto.PedidoDTO;
import com.cainco.bootcamp.system.dto.ResponseDTO;
import com.cainco.bootcamp.system.entity.Pedido;
import com.cainco.bootcamp.system.services.IPedidoService;
import com.cainco.bootcamp.system.services.PedidoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CasosUsoPedidos {

    private final IPedidoService pedidoService;
    private final IPedidoDao pedidoDao;

    public Pedido buscarUltimoPedido(){
        return pedidoDao.findTopByOrderByIdDesc();
    }

    public ResponseDTO registrarPedido(PedidoDTO pedidoDTO){
        return pedidoService.addPedido(pedidoDTO);
    }


}
