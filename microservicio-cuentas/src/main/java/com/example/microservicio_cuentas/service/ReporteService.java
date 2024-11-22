package com.example.microservicio_cuentas.service;

import com.example.microservicio_cuentas.model.Cliente;
import com.example.microservicio_cuentas.model.Cuenta;
import com.example.microservicio_cuentas.model.Movimiento;
import com.example.microservicio_cuentas.model.ReporteEstadoCuenta;
import com.example.microservicio_cuentas.repository.CuentaRepository;
import com.example.microservicio_cuentas.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public ReporteEstadoCuenta generarReporteEstadoCuenta(Long clienteId, String fechaInicio, String fechaFin) {

        Cliente cliente = clienteService.obtenerClientePorId(clienteId);

        List<Cuenta> cuentas = cuentaRepository.findByClienteId(clienteId);

        List<Movimiento> movimientos = movimientoRepository.findByCuentaClienteIdAndFechaBetween(
                clienteId, LocalDate.parse(fechaInicio), LocalDate.parse(fechaFin));

        return new ReporteEstadoCuenta(cliente, cuentas, movimientos);
    }
}

