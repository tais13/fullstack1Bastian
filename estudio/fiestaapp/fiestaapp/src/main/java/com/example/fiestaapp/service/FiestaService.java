package com.example.fiestaapp.service;

import org.springframework.stereotype.Service;
import com.example.fiestaapp.model.Fiesta;
import com.example.fiestaapp.repository.FiestaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiestaService {

    private final FiestaRepository repository;

    public FiestaService(FiestaRepository repository) {
        this.repository = repository;
    }

    public Fiesta crearFiesta(Fiesta fiesta) {
        return repository.guardar(fiesta);
    }

    public List<Fiesta> listarFiestas() {
        return repository.obtenerTodas();
    }

    public Fiesta obtenerPorId(Long id) {
        return repository.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Fiesta no encontrada"));
    }

    public Fiesta actualizarFiesta(Long id, Fiesta fiesta) {
        if (repository.obtenerPorId(id).isEmpty()) {
            throw new RuntimeException("Fiesta no existe");
        }
        return repository.actualizar(id, fiesta);
    }

    public void eliminarFiesta(Long id) {
        if (repository.obtenerPorId(id).isEmpty()) {
            throw new RuntimeException("Fiesta no existe");
        }
        repository.eliminar(id);
    }

    public List<Fiesta> filtrarPorTipo(String tipo) {
        return repository.obtenerTodas()
                .stream()
                .filter(f -> f.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    public List<Fiesta> filtrarPorFecha(LocalDate fecha) {
        return repository.obtenerTodas()
                .stream()
                .filter(f -> f.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    public List<Fiesta> ordenarPorFecha() {
        return repository.obtenerTodas()
                .stream()
                .sorted((f1, f2) -> f1.getFecha().compareTo(f2.getFecha()))
                .collect(Collectors.toList());
    }
}