package com.example.springbootretoh2.util;

import java.text.DecimalFormat;

public class UtilCalculadora {
    public static String SimboloMoneda(String moneda){
        String simbolo="";
        if(moneda.toUpperCase().indexOf("SOLES")>-1 || moneda.toUpperCase().indexOf("PEN")>-1){
            simbolo="S/";
        }else if(moneda.toUpperCase().indexOf("DOLARES")>-1 || moneda.toUpperCase().indexOf("USD")>-1){
            simbolo="$";
        }
        return simbolo;
    }

    /*
    Calculo de la Cuota:
    - TEM = ((1+TEA) exp 30/360) - 1
    - FRC = (TEM * ((1+TEM) exp N)) / (((1+TEM) exp N) - 1)
    - CUOTA =  MP * FRC
    - IMPORTE A PAGAR = CUOTA + ITF

    Donde:
    ITF : 0.005%
    TEA : Tasa Efectiva Mensual
    TEM : Tasa Efectiva Mensual
    N   : Numero de Cuotas
    MP  : Monto a Pagar
     */
    public static String simularCuota(Long monto, Long tea, Long cuota){
        double cuotaMensual = 0.0;
        double tem, frc, cuotaResp, importe;

        DecimalFormat df = new DecimalFormat("#.00");
        //cuotaMensual =  (monto.doubleValue() * (tea.doubleValue() * Math.pow(1+tea.doubleValue(),cuota.doubleValue()))) / (Math.pow(1+tea.doubleValue(),cuota.doubleValue())-1);
        //cuotaMensual =  (((monto.doubleValue() * tea.doubleValue())/100)+ monto.doubleValue())/ cuota.doubleValue();
        tem = (Math.pow((1 + tea.doubleValue()/100),0.0833))-1;
        frc = (tem * Math.pow((1+tem),cuota.doubleValue()))/(Math.pow((1+tem),cuota.doubleValue())-1);
        cuotaResp =  monto.doubleValue() * frc;
        importe = cuotaResp + (monto.doubleValue() * 0.005);
        return df.format(importe);
    }

    public static String limpiarTea(String tea){
        return tea.replaceAll("%","");
    }
}
