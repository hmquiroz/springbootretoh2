package com.example.springbootretoh2.models.service;

import com.example.springbootretoh2.models.dao.DiasPagoDao;
import com.example.springbootretoh2.models.dao.TeaDao;
import com.example.springbootretoh2.models.entity.DiasPago;
import com.example.springbootretoh2.models.entity.Tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeaServiceImpl implements ITeaService{

    @Autowired
    TeaDao teaDao;

    @Override
    public List<Tea> findAll() {
        return (List<Tea>)teaDao.findAll();
    }
}
