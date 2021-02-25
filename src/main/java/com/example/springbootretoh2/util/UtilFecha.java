package com.example.springbootretoh2.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilFecha {
    /**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy o yyyy/MM/dd
     * @return Objeto Date
     */
    public static Date parseFechaToDate(String fecha, String format)
    {
        SimpleDateFormat formato = new SimpleDateFormat(format);
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

    public static String parseFechaToString(Date fecha, String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String fechaString = "";
        fechaString = sdf.format(fecha);
        return fechaString;
    }


    public static Date sumarDias(Date fecha, int dias){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    public static Date sumarMeses(Date fecha, int meses){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.MONTH, meses);
        return calendar.getTime();
    }

    public static Date sumarAnios(Date fecha, int anios){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.YEAR, anios);
        return calendar.getTime();
    }
}
