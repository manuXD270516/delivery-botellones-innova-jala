package com.cainco.bootcamp.system.dao;
import com.cainco.bootcamp.system.entity.Zona;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IZonaDao extends CrudRepository<Zona, Long> {
    List<Zona> findAllByEstado(int estado);
}
