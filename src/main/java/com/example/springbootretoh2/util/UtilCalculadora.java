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

    public static String simularCuota(Long monto, Long tea, Long cuota){
        double cuotaMensual;
        DecimalFormat df = new DecimalFormat("#.00");
        cuotaMensual =  (monto.doubleValue() * (tea.doubleValue() * Math.pow(1+tea.doubleValue(),cuota.doubleValue()))) / (Math.pow(1+tea.doubleValue(),cuota.doubleValue())-1);
        return df.format(cuotaMensual);
    }

    public static String limpiarTea(String tea){
        return tea.replaceAll("%","");
    }
}
