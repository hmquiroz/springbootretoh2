package com.example.springbootretoh2.models.service;

import com.example.springbootretoh2.models.dao.ClienteDao;
import com.example.springbootretoh2.models.entity.Cliente;
import com.example.springbootretoh2.models.entity.Tea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceImp implements IClienteService{

    @Autowired
    ClienteDao clienteDao;

    @Override
    public Cliente findById(Long dni) {
        return clienteDao.findById(dni).isEmpty()?null:clienteDao.findById(dni).get();
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>)clienteDao.findAll();
    }
}
