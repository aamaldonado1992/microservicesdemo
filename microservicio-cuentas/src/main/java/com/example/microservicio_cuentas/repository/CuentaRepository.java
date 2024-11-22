package com.example.microservicio_cuentas.repository;

import com.example.microservicio_cuentas.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    List<Cuenta> findByClienteId(Long clienteId);
}

