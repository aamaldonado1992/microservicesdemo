package com.example.microservicio_cuentas.model;

import com.example.microservicio_cuentas.model.Cliente;

import java.util.List;

public class ReporteEstadoCuenta {

    private Cliente cliente;
    private List<Cuenta> cuentas;
    private List<Movimiento> movimientos;

    public ReporteEstadoCuenta(Cliente cliente, List<Cuenta> cuentas, List<Movimiento> movimientos) {
        this.cliente = cliente;
        this.cuentas = cuentas;
        this.movimientos = movimientos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
// Getters y Setters
}

