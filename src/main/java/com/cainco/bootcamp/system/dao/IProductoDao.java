package com.cainco.bootcamp.system.dao;

import com.cainco.bootcamp.system.entity.Producto;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Long> {
    List<Producto> findByEstado(int estado);
}
