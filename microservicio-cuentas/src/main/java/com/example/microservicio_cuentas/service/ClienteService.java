package com.example.microservicio_cuentas.service;

import com.example.microservicio_cuentas.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClienteService {

    @Autowired
    private RestTemplate restTemplate;

    public Cliente obtenerClientePorId(Long clienteId) {
        String url = "http://microservicio-clientes:8080/clientes/" + clienteId;
        return restTemplate.getForObject(url, Cliente.class);
    }
}
