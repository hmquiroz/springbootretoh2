package com.example.springbootretoh2.models.service;

import com.example.springbootretoh2.models.entity.Cuotas;
import com.example.springbootretoh2.models.entity.Tarjeta;

import java.util.List;

public interface ICuotaService {
    public List<Cuotas> findAll();
}
