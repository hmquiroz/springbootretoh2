package com.example.springbootretoh2.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "dias")
public class DiasPago {

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Long getIddiapago() {
        return iddiapago;
    }

    public void setIddiapago(Long iddiapago) {
        this.iddiapago = iddiapago;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddiapago;
    private int dia;
}
