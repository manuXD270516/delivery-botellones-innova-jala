package com.cainco.bootcamp.system.dao;

import com.cainco.bootcamp.system.entity.DetallePedido;
import org.springframework.data.repository.CrudRepository;

public interface IDetallePedidoDao extends CrudRepository<DetallePedido, Long> {
}
