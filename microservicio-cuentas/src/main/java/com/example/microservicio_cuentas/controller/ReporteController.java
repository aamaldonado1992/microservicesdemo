package com.example.microservicio_cuentas.controller;

import com.example.microservicio_cuentas.model.ReporteEstadoCuenta;
import com.example.microservicio_cuentas.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ReporteEstadoCuenta generarReporte(
            @RequestParam Long clienteId,
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin) {

        return reporteService.generarReporteEstadoCuenta(clienteId, fechaInicio, fechaFin);
    }
}
