package com.example.springbootretoh2.controllers;

import com.example.springbootretoh2.beans.Formulario;
import com.example.springbootretoh2.models.entity.Tarjeta;
import com.example.springbootretoh2.models.service.ICuotaService;
import com.example.springbootretoh2.models.service.IDiasPagoService;
import com.example.springbootretoh2.models.service.ITarjetaService;
import com.example.springbootretoh2.models.service.ITeaService;
import com.example.springbootretoh2.util.UtilCalculadora;
import org.hibernate.mapping.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SimuladorController {
    @Autowired
    ITarjetaService tarjetaService;

    @Autowired
    ICuotaService cuotaService;

    @Autowired
    IDiasPagoService pagoService;

    @Autowired
    ITeaService teaService;

    @GetMapping("/listar")
    public Map listar(){

        Map result = new HashMap();
        result.put("tarjetas",tarjetaService.findAll());
        result.put("cuotas",cuotaService.findAll());
        result.put("diaspago",pagoService.findAll());
        result.put("tea",teaService.findAll());
        return result;
    }

    @PostMapping(path = "/simular",consumes = "application/json", produces = "application/json")
    //@RequestMapping(value = "/simular",method = RequestMethod.POST)
    public Map simularCompra(@RequestBody Formulario formulario){
        formulario.setTea(UtilCalculadora.limpiarTea(formulario.getTea()));
        String cuotaMensual = UtilCalculadora.simularCuota(formulario.getMonto(),Long.parseLong(formulario.getTea()),formulario.getCuota().longValue());
        Map result = new HashMap();
        result.put("cuota",cuotaMensual);
        result.put("moneda","S/");
        result.put("primeraCuota","12/12/2020");
        result.put("estado","exitoso");
        System.out.println("Cuota Mensual: " + cuotaMensual);
        return result;
    }
}
