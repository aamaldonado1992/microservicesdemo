package com.example.microservicio_cuentas.controller;

import com.example.microservicio_cuentas.model.Movimiento;
import com.example.microservicio_cuentas.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return movimientoService.getAllMovimientos();
    }

    @GetMapping("/{id}")
    public Movimiento getMovimientoById(@PathVariable Long id) {
        return movimientoService.getMovimientoById(id);
    }

    @PostMapping("/{cuentaId}")
    public Movimiento registrarMovimiento(@PathVariable Long cuentaId, @RequestBody Movimiento movimiento) {
        return movimientoService.registrarMovimiento(cuentaId, movimiento);
    }

    @PutMapping("/{id}")
    public Movimiento actualizarMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        return movimientoService.actualizarMovimiento(id, movimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminarMovimiento(@PathVariable Long id) {
        movimientoService.eliminarMovimiento(id);
    }
}

