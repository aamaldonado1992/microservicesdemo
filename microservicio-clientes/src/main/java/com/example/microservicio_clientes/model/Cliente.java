package com.example.microservicio_clientes.model;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Cliente") // Valor para distinguir esta subclase en la tabla
public class Cliente extends Persona {

    private String contrasena;
    private Boolean estado;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
