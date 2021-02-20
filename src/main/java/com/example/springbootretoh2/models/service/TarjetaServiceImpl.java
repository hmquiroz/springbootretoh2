package com.example.springbootretoh2.models.service;

import com.example.springbootretoh2.models.dao.TarjetaDao;
import com.example.springbootretoh2.models.entity.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaServiceImpl implements ITarjetaService{

    @Autowired
    TarjetaDao tarjetaDao;

    @Override
    public List<Tarjeta> findAll() {
        return (List<Tarjeta>)tarjetaDao.findAll();
    }
}
