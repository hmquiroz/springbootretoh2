package com.example.springbootretoh2.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "cuotas")
public class Cuotas {

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Long getIdcuota() {
        return idcuota;
    }

    public void setIdcuota(Long idcuota) {
        this.idcuota = idcuota;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcuota;
    private int numero;
}
