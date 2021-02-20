package com.example.springbootretoh2.models.service;

import com.example.springbootretoh2.models.dao.CuotaDao;
import com.example.springbootretoh2.models.dao.TarjetaDao;
import com.example.springbootretoh2.models.entity.Cuotas;
import com.example.springbootretoh2.models.entity.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuotaServiceImpl implements ICuotaService{

    @Autowired
    CuotaDao cuotaDao;

    @Override
    public List<Cuotas> findAll() {
        return (List<Cuotas>)cuotaDao.findAll();
    }
}
