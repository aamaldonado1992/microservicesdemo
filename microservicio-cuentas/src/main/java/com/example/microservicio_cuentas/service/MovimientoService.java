package com.example.microservicio_cuentas.service;

import com.example.microservicio_cuentas.exception.ResourceNotFoundException;
import com.example.microservicio_cuentas.exception.SaldoInsuficienteException;
import com.example.microservicio_cuentas.model.Cuenta;
import com.example.microservicio_cuentas.model.Movimiento;
import com.example.microservicio_cuentas.repository.CuentaRepository;
import com.example.microservicio_cuentas.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    public Movimiento getMovimientoById(Long id) {
        return movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrado con ID: " + id));
    }

    public Movimiento registrarMovimiento(Long cuentaId, Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con ID: " + cuentaId));

        Double nuevoSaldo = cuenta.getSaldoInicial() + movimiento.getValor();
        if (nuevoSaldo < 0) {
            throw new SaldoInsuficienteException("Saldo no disponible para realizar el movimiento."+"saldo inicial"+cuenta.getSaldoInicial()+", valor"+movimiento.getValor()+", valor"+movimiento.getValor());
        }

        movimiento.setSaldo(cuenta.getSaldoInicial());
        movimiento.setCuenta(cuenta);
        movimiento.setFecha(LocalDate.now());


        Movimiento nuevoMovimiento = movimientoRepository.save(movimiento);

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        return nuevoMovimiento;

    }

    public Movimiento actualizarMovimiento(Long id, Movimiento movimiento) {
        return movimientoRepository.findById(id).map(m -> {
            m.setValor(movimiento.getValor());
            m.setTipoMovimiento(movimiento.getTipoMovimiento());
            m.setFecha(movimiento.getFecha());
            return movimientoRepository.save(m);
        }).orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrado con ID: " + id));
    }

    public void eliminarMovimiento(Long id) {
        if (!movimientoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Movimiento no encontrado con ID: " + id);
        }
        movimientoRepository.deleteById(id);
    }
}
