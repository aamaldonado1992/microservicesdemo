package com.example.microservicio_clientes.repository;

import com.example.microservicio_clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
