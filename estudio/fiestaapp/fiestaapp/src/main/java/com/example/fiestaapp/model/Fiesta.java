package com.example.fiestaapp.model;

import java.time.LocalDate;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Fiesta {

    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El tipo no puede estar vacío")
    private String tipo;

    @FutureOrPresent(message = "La fecha debe ser actual o futura")
    private LocalDate fecha;

    @NotBlank(message = "La ubicación no puede estar vacía")
    private String ubicacion;

    @Min(value = 1, message = "La capacidad debe ser al menos 1")
    private int capacidad;

    public Fiesta() {}

    public Fiesta(Long id, String nombre, String tipo, LocalDate fecha, String ubicacion, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
}