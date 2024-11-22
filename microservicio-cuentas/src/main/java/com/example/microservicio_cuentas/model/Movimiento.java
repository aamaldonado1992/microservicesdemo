package com.example.microservicio_cuentas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String tipoMovimiento; // Por ejemplo: "Depósito", "Retiro"

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Double saldo; // Saldo resultante después del movimiento

    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false) // Llave foránea hacia Cuenta
    private Cuenta cuenta;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
