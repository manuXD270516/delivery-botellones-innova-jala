package com.cainco.bootcamp.system.services;

import com.cainco.bootcamp.system.dao.IClienteDao;
import com.cainco.bootcamp.system.dto.ClienteDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private IClienteDao clienteDao;

    public ClienteServiceImpl() {
    }

    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> clientes = new ArrayList();
        this.clienteDao.findAll().forEach((cl) -> {
            ClienteDTO c = new ClienteDTO();
            c.idCliente = cl.getId();
            c.ci = cl.getCi();
            c.nit = cl.getNit();
            c.nombres = cl.getNombres();
            c.telefono = cl.getTelefono();
            c.apellidos = cl.getApellidos();
            c.latitud = cl.getLatitud();
            c.longitud = cl.getLongitud();
            clientes.add(c);
        });
        return clientes;
    }
}
