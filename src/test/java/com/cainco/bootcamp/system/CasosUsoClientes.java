package com.cainco.bootcamp.system;

import com.cainco.bootcamp.system.dao.IClienteDao;
import com.cainco.bootcamp.system.entity.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CasosUsoClientes {

    private final IClienteDao clienteDao;

    public Cliente registrarCliente(Cliente cliente){
        return clienteDao.save(cliente);
    }
    public Cliente obtenerClientePorCI(String ci){
        return clienteDao.findByCi(ci);
    }

}
