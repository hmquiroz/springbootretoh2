package com.example.springbootretoh2.beans;

import java.io.Serializable;

public class Formulario implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String dni;
    private String tarjeta;
    private String moneda;
    private Long monto;
    private Integer cuota;
    private String tea;
    private String diaPago;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }

    public String getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(String diaPago) {
        this.diaPago = diaPago;
    }
}
