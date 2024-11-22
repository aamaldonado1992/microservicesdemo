package com.example.microservicio_cuentas.controller;

import com.example.microservicio_cuentas.exception.ResourceNotFoundException;
import com.example.microservicio_cuentas.model.Cuenta;
import com.example.microservicio_cuentas.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    @PostMapping
    public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @PutMapping("/{id}")
    public Cuenta updateCliente(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        return cuentaRepository.findById(id).map(c -> {
            c.setNumeroCuenta(cuenta.getNumeroCuenta());
            return cuentaRepository.save(c);
        }).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deleteCuenta(@PathVariable Long id) {
        cuentaRepository.deleteById(id);
    }

}
