package com.cainco.bootcamp.system.dao;

import com.cainco.bootcamp.system.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long> {
    Cliente findByTelefono(String telefono);
}
