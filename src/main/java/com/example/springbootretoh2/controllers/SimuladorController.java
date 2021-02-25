package com.example.springbootretoh2.controllers;

import com.example.springbootretoh2.beans.Formulario;
import com.example.springbootretoh2.beans.Respuesta;
import com.example.springbootretoh2.models.entity.Cliente;
import com.example.springbootretoh2.models.entity.Tarjeta;
import com.example.springbootretoh2.models.service.*;
import com.example.springbootretoh2.util.UtilCalculadora;
import com.example.springbootretoh2.util.UtilFecha;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
public class SimuladorController {

    private static final Logger LOGGER = LogManager.getLogger(SimuladorController.class.getName());

    @Autowired
    ITarjetaService tarjetaService;

    @Autowired
    ICuotaService cuotaService;

    @Autowired
    IDiasPagoService pagoService;

    @Autowired
    ITeaService teaService;

    @Autowired
    IClienteService clienteService;

    @GetMapping("/")
    public Map home(){
        LOGGER.info("[INI] Home");
        Map result = new HashMap();
        result.put("[GET]method listar","/listar");
        result.put("[POST]method simular","/simular");
        result.put("DNIs Validos","42498387 , 41768286 , 17822694");
        LOGGER.info("[FIN] Home");
        return result;

    }

    @GetMapping("/listar")
    public Map listar(){
        LOGGER.info("[INI] Listar Datos");
        String pText = "{\n" +
                "\"dni\": \"45654654\",\n" +
                "\"tarjeta\":\"CLASICA\",\n" +
                "\"moneda\":\"S/\",\n" +
                "\"monto\": 500,\n" +
                "\"cuota\": 5,\n" +
                "\"tea\":\"99%\",\n" +
                "\"diaPago\":\"5\"\n" +
                "}";
        Map result = new HashMap();
        result.put("tarjetas",tarjetaService.findAll());
        result.put("cuotas",cuotaService.findAll());
        result.put("diaspago",pagoService.findAll());
        result.put("tea",teaService.findAll());
        LOGGER.info("[FIN] Listar Datos");
        return result;
    }

    @GetMapping("/simular")
    public Map simularGet(){
        LOGGER.info("[INI] Home");
        Map result = new HashMap();
        result.put("Method","simular");
        result.put("Message","Metodo Simular debe ser llamado por POST");
        LOGGER.info("[FIN] Home");
        return result;
    }

    @PostMapping(path = "/simular",consumes = "application/json", produces = "application/json")
    //public Map simularCompra(@Valid @RequestBody Formulario formulario, BindingResult result, ModelMap map){
    public ResponseEntity<Object> simularCompra(@Valid @RequestBody Formulario formulario, BindingResult result){
        LOGGER.info("[INI] Simular Compra");
        //Map resultado = new HashMap();
        Respuesta resultado = null;
        Map errores = new HashMap();
        String cuotaMensual = "";
        Date primeracuota;
        Cliente cliente =  null;
        List<Cliente> clientes =  null;

        //Validar formato JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = StringUtils.EMPTY;
        try {
            json = mapper.writeValueAsString(formulario);
        } catch (IOException e) {
            LOGGER.info("Ha ocurrido un error el validar el formato JSON.");
        }catch(Exception e){
            LOGGER.info("Ha ocurrido un error el validar el formato JSON.");
        }

        //Validar Tipos de Datos en JSON
        if (result.hasErrors()) {
            LOGGER.info("Errores:" + result.getErrorCount());
            List<ObjectError> listaError = result.getAllErrors();
            for (ObjectError obj : listaError){
                errores.put(obj.getCodes(),obj.getDefaultMessage());
                //crear metodo Util para buscar en lista y devolver id
            }
            return new ResponseEntity<Object>(errores,HttpStatus.METHOD_NOT_ALLOWED);
        }else {
            //Validar si DNI y Tarjeta se encuentran en la BD
            cliente = clienteService.findById(Long.parseLong(formulario.getDni()));
            clientes = clienteService.findAll();

            if(cliente == null){
                errores.put("Validacion","Usted no es cliente del Banco.");
            }else {
                //Calcular la Cuota y Simulacion
                formulario.setTea(UtilCalculadora.limpiarTea(formulario.getTea()));
                cuotaMensual = UtilCalculadora.simularCuota(formulario.getMonto(), Long.parseLong(formulario.getTea()), formulario.getCuota().longValue());
                primeracuota = UtilFecha.sumarDias(UtilFecha.parseFechaToDate(formulario.getFechacompra(), "dd/MM/yyyy"), 30);

                resultado = new Respuesta();
                resultado.setCuota(cuotaMensual);
                resultado.setMoneda("S/");
                resultado.setPrimeraCuota(UtilFecha.parseFechaToString(primeracuota, "dd/MM/yyyy"));
                resultado.setEstado("exitoso");

                LOGGER.info("Cuota Mensual: " + cuotaMensual);
                LOGGER.info("[FIN] Simular Compra");
            }
        }
        return resultado!= null?ResponseEntity.ok(resultado):new ResponseEntity<Object>(errores,HttpStatus.METHOD_NOT_ALLOWED);
    }
}
