package com.example.microservicio_cuentas.repository;

import com.example.microservicio_cuentas.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuentaClienteIdAndFechaBetween(Long clienteId, LocalDate parse, LocalDate parse1);
}
