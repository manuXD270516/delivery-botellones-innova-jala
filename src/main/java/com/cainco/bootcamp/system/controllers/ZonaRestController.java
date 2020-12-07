package com.cainco.bootcamp.system.controllers;
import com.cainco.bootcamp.system.dto.ZonaDTO;
import com.cainco.bootcamp.system.services.IZonaService;
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
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping({"/zonas"})
public class ZonaRestController {

    @Autowired
    private IZonaService zonaService;

    public ZonaRestController() {
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        Map<String, Object> response = new HashMap<>();
        List<ZonaDTO> zonas = new ArrayList<ZonaDTO>();
        try {
            zonas = zonaService.listarZonas();
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("zonas", zonas);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
