package com.example.microservicio_clientes.controller;

import com.example.microservicio_clientes.model.Cliente;
import com.example.microservicio_clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}

