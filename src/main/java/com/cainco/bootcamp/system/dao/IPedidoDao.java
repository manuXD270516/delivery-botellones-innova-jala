package com.cainco.bootcamp.system.dao;

import com.cainco.bootcamp.system.entity.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface IPedidoDao extends CrudRepository<Pedido, Long> {

    Pedido findTopByOrderByIdDesc();
}
