package com.example.springbootretoh2.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "tea")
public class Tea {

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdtea() {
        return idtea;
    }

    public void setIdtea(Long idtea) {
        this.idtea = idtea;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtea;
    private String descripcion;
}
