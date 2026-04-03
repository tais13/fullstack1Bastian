package com.example.fiestaapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fiestaapp.model.Fiesta;
import com.example.fiestaapp.service.FiestaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/fiestas")
public class FiestaController {

    private final FiestaService service;

    public FiestaController(FiestaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Fiesta> crear(@Valid @RequestBody Fiesta fiesta) {
        return ResponseEntity.ok(service.crearFiesta(fiesta));
    }

    @GetMapping
    public ResponseEntity<List<Fiesta>> listar() {
        return ResponseEntity.ok(service.listarFiestas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fiesta> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fiesta> actualizar(@PathVariable Long id,
                                             @Valid @RequestBody Fiesta fiesta) {
        return ResponseEntity.ok(service.actualizarFiesta(id, fiesta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarFiesta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Fiesta>> filtrarTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(service.filtrarPorTipo(tipo));
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Fiesta>> filtrarFecha(@PathVariable String fecha) {
        return ResponseEntity.ok(service.filtrarPorFecha(LocalDate.parse(fecha)));
    }

    @GetMapping("/ordenar")
    public ResponseEntity<List<Fiesta>> ordenar() {
        return ResponseEntity.ok(service.ordenarPorFecha());
    }
}