package com.example.springbootretoh2.models.dao;

import com.example.springbootretoh2.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
}
