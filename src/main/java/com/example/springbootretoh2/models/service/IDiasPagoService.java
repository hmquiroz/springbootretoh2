package com.example.springbootretoh2.models.service;

import com.example.springbootretoh2.models.entity.Cuotas;
import com.example.springbootretoh2.models.entity.DiasPago;

import java.util.List;

public interface IDiasPagoService {
    public List<DiasPago> findAll();
}
