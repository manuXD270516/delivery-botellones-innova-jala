package com.cainco.bootcamp.system.services;

import com.cainco.bootcamp.system.dao.IZonaDao;
import com.cainco.bootcamp.system.dto.ZonaDTO;
import com.cainco.bootcamp.system.entity.Zona;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZonaServiceImpl implements IZonaService {
    @Autowired
    private IZonaDao zonaDao;

    public ZonaServiceImpl() {
    }

    public List<ZonaDTO> listarZonas() {
        int activos = 1;
        List<Zona> zonas = this.zonaDao.findAllByEstado(activos);
        List<ZonaDTO> zonasDTO = new ArrayList();
        Iterator var4 = zonas.iterator();

        while(var4.hasNext()) {
            Zona z = (Zona)var4.next();
            ZonaDTO zonaDto = new ZonaDTO();
            zonaDto.setId(z.getId());
            zonaDto.setNombre(z.getNombre());
            zonasDTO.add(zonaDto);
        }

        return zonasDTO;
    }
}
