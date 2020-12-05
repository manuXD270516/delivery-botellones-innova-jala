package com.cainco.bootcamp.system.controllers;

import com.cainco.bootcamp.system.dto.PedidoDTO;
import com.cainco.bootcamp.system.dto.ResponseDTO;
import com.cainco.bootcamp.system.services.IPedidoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/pedidos"})
public class PedidoRestController {
    @Autowired
    private IPedidoService pedidoService;


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

    @GetMapping
    public ResponseEntity<?> findAll() {
        Map<String, Object> response = new HashMap();

        List<PedidoDTO> pedidos = new ArrayList<>();
        try {
            pedidos = pedidoService.listarPedidos(); // ordenados por ultima fecha de pedido
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("pedidos", pedidos);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
