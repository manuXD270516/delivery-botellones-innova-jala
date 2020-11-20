package com.cainco.bootcamp.system.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cainco.bootcamp.system.entity.Zona;

public interface IZonaDao extends CrudRepository<Zona, Long>{

	List<Zona> findByEstado(int estado);
	
}
