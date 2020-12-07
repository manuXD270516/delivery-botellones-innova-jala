package com.cainco.bootcamp.system.controllers;

import com.cainco.bootcamp.system.services.IClienteService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/clientes"})
@CrossOrigin(origins = { "http://localhost:4200" })
public class ClienteRestController {
    @Autowired
    private IClienteService clienteService;

    public ClienteRestController() {
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        Map<String, Object> response = new HashMap();
        new ArrayList();

        List clientes;
        try {
            clientes = this.clienteService.listarClientes();
        } catch (DataAccessException var4) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", var4.getMessage().concat(": ").concat(var4.getMostSpecificCause().getMessage()));
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("clientes", clientes);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
