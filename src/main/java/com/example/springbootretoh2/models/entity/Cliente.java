package com.example.springbootretoh2.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getDesctarjeta() {
        return desctarjeta;
    }

    public void setDesctarjeta(String desctarjeta) {
        this.desctarjeta = desctarjeta;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dni;
    private String desctarjeta;

    public Cliente(){

    }

    public Cliente(Long dni, String desctarjeta){
        this.dni = dni;
        this.desctarjeta = desctarjeta;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", desctarjeta='" + desctarjeta + '\'' +
                '}';
    }
}
