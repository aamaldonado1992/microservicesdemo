package com.example.microservicio_clientes.service;

import com.example.microservicio_clientes.exceptions.ResourceNotFoundException;
import com.example.microservicio_clientes.model.Cliente;
import com.example.microservicio_clientes.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerTodosLosClientes() {
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan Pérez");

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Ana López");

        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        var clientes = clienteService.obtenerTodosLosClientes();

        assertEquals(2, clientes.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    public void testObtenerClientePorId_Exitoso() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Juan Pérez");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        var resultado = clienteService.obtenerClientePorId(1L);

        assertNotNull(resultado);
        assertEquals("Juan Pérez", resultado.getNombre());
        verify(clienteRepository, times(1)).findById(1L);
    }

}