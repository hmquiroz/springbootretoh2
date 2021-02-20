package com.example.springbootretoh2.models.dao;

import com.example.springbootretoh2.models.entity.Tea;
import org.springframework.data.repository.CrudRepository;

public interface TeaDao extends CrudRepository<Tea, Long> {
}
