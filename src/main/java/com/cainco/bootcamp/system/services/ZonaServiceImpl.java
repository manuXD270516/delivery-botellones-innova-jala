package com.cainco.bootcamp.system.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cainco.bootcamp.system.dao.IZonaDao;
import com.cainco.bootcamp.system.dto.ZonaDTO;
import com.cainco.bootcamp.system.entity.Zona;

@Service
public class ZonaServiceImpl implements IZonaService{
	
	@Autowired
	private IZonaDao zonaDao;

	@Override
	public List<ZonaDTO> listarZonas() {
		List<Zona> zonas=zonaDao.findByEstado(1);
		List<ZonaDTO> zonasDTO=new ArrayList<ZonaDTO>();
		for(Zona z:zonas) {
			ZonaDTO zonaDto=new ZonaDTO();
			zonaDto.setId(z.getId());
			zonaDto.setNombre(z.getNombre());
			zonasDTO.add(zonaDto);
		}
		return zonasDTO;
	}

}
