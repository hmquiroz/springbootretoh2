package com.example.springbootretoh2.beans;

import java.io.Serializable;

public class Respuesta implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public String getCuota() {
        return cuota;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getPrimeraCuota() {
        return primeraCuota;
    }

    public void setPrimeraCuota(String primeraCuota) {
        this.primeraCuota = primeraCuota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private String cuota;
    private String moneda;
    private String primeraCuota;
    private String estado;


}
