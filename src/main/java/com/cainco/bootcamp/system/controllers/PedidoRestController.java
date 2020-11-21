package com.cainco.bootcamp.system.controllers;

import com.cainco.bootcamp.system.dto.PedidoDTO;
import com.cainco.bootcamp.system.dto.ResponseDTO;
import com.cainco.bootcamp.system.services.IPedidoService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/pedidos"})
public class PedidoRestController {
    @Autowired
    private IPedidoService pedidoService;

    public PedidoRestController() {
    }

    @PostMapping
    public ResponseEntity<?> addPedido(@RequestBody PedidoDTO pedido) {
        Map<String, Object> response = new HashMap();
        new ResponseDTO();

        ResponseDTO responseDTO;
        try {
            responseDTO = this.pedidoService.addPedido(pedido);
        } catch (DataAccessException var5) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", var5.getMessage().concat(": ").concat(var5.getMostSpecificCause().getMessage()));
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("respuesta", responseDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
