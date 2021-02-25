package com.example.springbootretoh2.beans;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;

public class Formulario implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Por favor ingrese un DNI.")
    @Size(min=8, max=8, message = "Ingresar un DNI correctamente con 8 digitos.")
    private String dni;

    //@NotNull(message = "Por favor ingrese una tarjeta credimás.")
    //@Size(min = 16, max = 16, message = "Ingresar una tarjeta de 16 digitos.")
    private String tarjeta;

    @NotNull(message = "Por favor ingrese un tipo de moneda.")
    @Size(min = 1, max = 2, message = "Ingresar una moneda S/ o $")
    private String moneda;

    @Min (value= 1,message = "Por favor ingrese un monto mayor a 0.")
    private Long monto;

    private Integer cuota;
    private String tea;

    @NotNull(message = "Por favor ingrese el dia de pago.")
    private String diaPago;

    @NotNull(message = "Por favor ingrese fecha de compra.")
    @Size(min = 10, max = 10, message = "Ingresar una fecha de compra correcta (yyyy/MM/dd).")
    private String fechacompra;
    private String tramacifrado;
    private String tramadescrifrado;

    public String getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(String fechacompra) {
        this.fechacompra = fechacompra;
    }
    public String getTramacifrado() {
        return tramacifrado;
    }

    public void setTramacifrado(String tramacifrado) {
        this.tramacifrado = tramacifrado;
    }

    public String getTramadescrifrado() {
        return tramadescrifrado;
    }

    public void setTramadescrifrado(String tramadescrifrado) {
        this.tramadescrifrado = tramadescrifrado;
    }


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
