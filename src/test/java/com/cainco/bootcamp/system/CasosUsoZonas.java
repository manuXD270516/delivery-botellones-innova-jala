package com.cainco.bootcamp.system;

import com.cainco.bootcamp.system.dao.IZonaDao;
import com.cainco.bootcamp.system.entity.Zona;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CasosUsoZonas {

    private final IZonaDao zonaDao;


    public Zona verificarZonaRegistrada(Zona zona){
        return zonaDao.save(zona);
    }
}
