package com.example.springbootretoh2.models.dao;

import com.example.springbootretoh2.models.entity.Tarjeta;
import org.springframework.data.repository.CrudRepository;

public interface TarjetaDao extends CrudRepository<Tarjeta, Long> {
}
