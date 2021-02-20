package com.example.springbootretoh2.models.service;

import com.example.springbootretoh2.models.dao.DiasPagoDao;
import com.example.springbootretoh2.models.dao.TarjetaDao;
import com.example.springbootretoh2.models.entity.DiasPago;
import com.example.springbootretoh2.models.entity.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiasPagoServiceImpl implements IDiasPagoService{

    @Autowired
    DiasPagoDao diasPagoDao;

    @Override
    public List<DiasPago> findAll() {
        return (List<DiasPago>)diasPagoDao.findAll();
    }
}
