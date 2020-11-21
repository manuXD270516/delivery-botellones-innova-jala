package com.cainco.bootcamp.system.services;

import com.cainco.bootcamp.system.dao.IRepartidorDao;
import com.cainco.bootcamp.system.entity.Repartidor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepartidorServiceImpl implements IRepartidorService {
    @Autowired
    private IRepartidorDao repartidorDao;

    public RepartidorServiceImpl() {
    }

    public List<Repartidor> listarRepartidores() {
        return (List)this.repartidorDao.findAll();
    }
}
