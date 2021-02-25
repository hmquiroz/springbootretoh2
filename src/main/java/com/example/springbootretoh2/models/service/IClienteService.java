package com.example.springbootretoh2.models.service;

import com.example.springbootretoh2.models.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    Cliente findById(Long dni);
    List<Cliente> findAll();
}
